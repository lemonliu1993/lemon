package com.lemon.framework.proxy;

/**
 * 代理接口
 * Created by lemoon on 2020/4/2 3:32 PM
 */
public interface Proxy {

    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
