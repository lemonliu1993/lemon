package com.lemon.framework;

import com.lemon.framework.bean.Data;
import com.lemon.framework.bean.Handler;
import com.lemon.framework.bean.Param;
import com.lemon.framework.bean.View;
import com.lemon.framework.helper.*;
import com.lemon.framework.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求转发器
 * Created by lemoon on 2020/3/16 5:39 PM
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //初始化相关helper类
        HelperLoader.init();
        //获取ServletContext对象(用于注册Servlet)
        ServletContext servletContext = servletConfig.getServletContext();
        //注册处理JSP的Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        //注册处理静态资源的默认Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");

        UploadHelper.init(servletContext);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletHelper.init(req, res);
        try {

            //获取请求方法与请求路径
            String requestMethod = req.getMethod().toLowerCase();
            String requestPath = req.getPathInfo();

            if (requestPath.equals("/favicon.ico")) {
                return;
            }
            //获取Action处理器
            Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
            if (handler != null) {
                //获取Controller类及其Bean实例
                Class<?> controllerClass = handler.getControllerClass();
                Object controllerBean = BeanHelper.getBean(controllerClass);

                Param param;
                if (UploadHelper.isMultipart(req)) {
                    param = UploadHelper.createParam(req);
                } else {
                    param = RequestHelper.createParam(req);
                }

//            //创建请求参数对象
//            Map<String, Object> paramMap = new HashMap<String, Object>();
//            Enumeration<String> paramNames = req.getParameterNames();
//            while (paramNames.hasMoreElements()) {
//                String paramName = paramNames.nextElement();
//                String paramValue = req.getParameter(paramName);
//                paramMap.put(paramName, paramValue);
//            }
//            String body = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
//            if (StringUtil.isNotEmpty(body)) {
//                String[] params = StringUtil.splitString(body, "&");
//                if (ArrayUtil.isNotEmpty(params)) {
//                    for (String param : params) {
//                        String[] array = StringUtil.splitString(param, "=");
//                        if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
//                            String paramName = array[0];
//                            String paramValue = array[1];
//                            paramMap.put(param, paramValue);
//                        }
//                    }
//                }
//            }
//            Param param = new Param(paramMap);
//            //调用Action方法
                Method actionMethod = handler.getActionMethod();
                Object result;
                if (param.isEmpty()) {
                    result = ReflectionUtil.invokeMethod(controllerBean, actionMethod);
                } else {
                    result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
                }
                //处理Action方法返回值
                if (result instanceof View) {
                    handleViewResult((View) result, req, res);
                } else if (result instanceof Data) {
                    handleDataResult((Data) result, res);
                }
            }
        } finally {
            ServletHelper.destroy();
        }
    }

    private void handleViewResult(View view, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = view.getPath();
        if (StringUtil.isNotEmpty(path)) {
            if (path.startsWith("/")) {
                response.sendRedirect(request.getContextPath() + path);
            } else {
                Map<String, Object> model = view.getModel();
                for (Map.Entry<String, Object> entry : model.entrySet()) {
                    request.setAttribute(entry.getKey(), entry.getValue());
                }
                request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request, response);
            }
        }
    }

    private void handleDataResult(Data data, HttpServletResponse response) throws IOException {
        Object model = data.getModel();
        if (model != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            String json = JsonUtil.toJson(model);
            writer.write(json);
            writer.flush();
            writer.close();
        }
    }
}
