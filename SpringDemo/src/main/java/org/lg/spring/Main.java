package org.lg.spring;

import org.lg.spring.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("D:\\Users\\lg\\ideaProject\\RookieOfJava\\SpringDemo\\src\\main\\resources\\application.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        User u1 = (User) context.getBean("user");
        User u2 = context.getBean("user",User.class);
        User u3 = context.getBean(User.class);
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
    }
}
