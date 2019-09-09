package com.example.demo.designmode.proxy;

public class DynamicProxyMainTest {

    public static void main(String[] args) {

        IUserService userService = new UserServiceImpl();
        // 将被代理到接口作为参数传入 handler中
        MyDynamicProxyHandler handler = new MyDynamicProxyHandler(userService);
        // 通过handler获取实例
        IUserService proxy = (IUserService) handler.getProxyInstance();
        proxy.dateWith("小布");

    }

}
