package cn.itcast.servlet;

import java.lang.reflect.Method;

public class TestAA {

    public static void main(String[] args) throws Exception {

        Class clazz = AA.class;

        Method md = clazz.getMethod("sum", int.class, int.class);

        md.invoke(new AA(), 2, 3);

    }

}
