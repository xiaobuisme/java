package com.example.demo.designmode.proxy;

public class UserServiceImpl implements IUserService {

    @Override
    public void dateWith(String name) {
        System.out.println("和 " + name + " 约会中");
    }
}
