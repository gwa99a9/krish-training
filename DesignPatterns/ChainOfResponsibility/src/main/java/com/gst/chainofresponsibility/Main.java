/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gst.chainofresponsibility;

/**
 *
 * @author OBITO
 */
public class Main {

    public static void main(String[] args) {
        Middleware middleware = new JspCheckMiddleware();
        middleware.linkWith(new ParameterValidationMiddleware()).linkWith(new UserLoginMiddleware());

        String loginURL = "www.abc.com/a.jsp?username=abc&password=123";

        Server server = new Server(middleware);

        System.out.println("Checking URL : " + loginURL);
        boolean loginResponse = server.login(loginURL);
        System.out.println("User Login Status : " + loginResponse);

        System.out.println("");

        loginURL = "www.abc.com/a.jsp?username=abc&password=1243";
        System.out.println("Checking URL : " + loginURL);
        loginResponse = server.login(loginURL);
        System.out.println("User Login Status : " + loginResponse);

        System.out.println("");

        loginURL = "www.abc.com/a.jsp?user1name=abc&password=123";
        System.out.println("Checking URL : " + loginURL);
        loginResponse = server.login(loginURL);
        System.out.println("User Login Status : " + loginResponse);

        System.out.println("");

        loginURL = "www.abc.com/a.html?username=abc&password=123";
        System.out.println("Checking URL : " + loginURL);
        loginResponse = server.login(loginURL);
        System.out.println("User Login Status : " + loginResponse);
    }
}

class Server {

    private Middleware middleware;

    public Server(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean login(String url) {
        return middleware.check(url);
    }

}

abstract class Middleware {

    protected Middleware middleware;

    public Middleware linkWith(Middleware next) {
        this.middleware = next;
        return next;
    }

    public abstract boolean check(String url);

    protected boolean checkNext(String url) {
        if (middleware == null) {
            return true;
        }
        return middleware.check(url);
    }
}

class JspCheckMiddleware extends Middleware {

    @Override
    public boolean check(String url) {
        if (url.contains(".")) {
            String extension = url.substring(url.lastIndexOf("."));
            if (!extension.startsWith(".jsp")) {
                System.out.println("JspCheckMiddleware : page is not a jsp.");
                return false;
            }
        } else {
            System.out.println("JspCheckMiddleware : url doesn't contain.");
            return false;
        }
        return checkNext(url);
    }
}

class ParameterValidationMiddleware extends Middleware {

    @Override
    public boolean check(String url) {
        String[] split = url.substring(url.lastIndexOf(".")).split("\\?");
        String[] parameters = split[1].split("&");
        if (!(parameters[0].startsWith("username") && parameters[1].startsWith("password"))) {
            System.out.println("ParameterValidationMiddleware : invalid parameter mapping");
            return false;
        }
        return checkNext(url);
    }
}

class UserLoginMiddleware extends Middleware {

    @Override
    public boolean check(String url) {
        String[] split = url.substring(url.lastIndexOf(".")).split("\\?");
        String[] parameters = split[1].split("&");
        if (!(parameters[0].split("=")[1].equals("abc") && parameters[1].split("=")[1].equals("123"))) {
            System.out.println("UserLoginMiddleware : invalid user credentials");
            return false;
        }
        return checkNext(url);
    }
}
