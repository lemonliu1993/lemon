package com.lemon.framework;

/**
 * 提供相关配置项常量
 * Created by lemoon on 20/2/24 上午9:40
 */
public interface ConfigConstant {

    String CONFIG_FILE="smart.properties";

    String JDBC_DRIVER="smart.framework.jdbc.driver";
    String JDBC_URL="smart.framework.jdbc.url";
    String JDBC_USERNAME="smart.framework.jdbc.username";
    String JDBC_PASSWORD="smart.framework.jdbc.password";

    String APP_BASE_PACKAGE="smart.framework.app.base_package";
    String APP_JSP_PATH="smart.framework.app.jsp_path";
    String APP_ASSET_PATH="smart.framework.app.asset_path";
}
