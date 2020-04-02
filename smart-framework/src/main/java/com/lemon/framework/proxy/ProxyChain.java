package com.lemon.framework.proxy;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lemoon on 2020/4/2 3:34 PM
 *
 * 需要注意的是MethodProxy这个类，它是CGLib开源项目为我们提供的一个方法代理对象，在doProxyChain方法中被使用。
 * doProxyChain方法，在该方法中，我们通过proxyIndex来充当代理对象的计数器，若尚未达到proxyList的上限，则从proxyList中取出相应的Porxy对象，并调用其doProxy方法。
 * 在Proxy接口的实现中会提供相应的横切逻辑，并调用doProxyChain方法，随后将再次调用当前ProxyChain对象的doProxyChain方法，
 * 直到proxyIndex达到proxyList的上限为止，最后调用methodProxy的invokeSuper方法，执行目标对象的业务逻辑。
 */
public class ProxyChain {

    private final Class<?> targetClass;
    private final Object targetObject;
    private final Method targetMethod;
    private final MethodProxy methodProxy;
    private final Object[] methodParams;

    private List<Proxy> proxyList = new ArrayList<Proxy>();
    private int proxyIndex = 0;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targetMethod, MethodProxy methodProxy, Object[] methodParams, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.methodParams = methodParams;
        this.proxyList = proxyList;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public MethodProxy getMethodProxy() {
        return methodProxy;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }

    public List<Proxy> getProxyList() {
        return proxyList;
    }

    public int getProxyIndex() {
        return proxyIndex;
    }

    public Object doProxyChain() throws Throwable {
        Object methodResult;
        if (proxyIndex < proxyList.size()) {
            methodResult = proxyList.get(proxyIndex++).doProxy(this);
        } else {
            methodResult = methodProxy.invokeSuper(targetObject, methodParams);
        }
        return methodResult;
    }
}
