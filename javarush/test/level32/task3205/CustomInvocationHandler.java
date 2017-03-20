package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Naatsms on 08.02.2017.
 */
public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods impl;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object result = method.invoke(impl, args);
        System.out.println(method.getName() + " out");
        return result;
    }

    public CustomInvocationHandler(SomeInterfaceWithMethods impl) {
        this.impl = impl;
    }
}
