package com.example.demo.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 自定义动态代理
 * 2个核心元素：1 Proxy.newInstance(...)
 *            2 实现java.lang.reflect.InvocationHandler，重写invoke()方法
 */
public class MyDynamicProxyHandler implements InvocationHandler {

    // 目标接口类
    private Object target;

    public MyDynamicProxyHandler(Object object){
        this.target = object;
    }

    // 创建实例
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    // 返回到是方法被执行后到结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
