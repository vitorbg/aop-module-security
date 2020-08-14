package br.com.vitorbg.aop.config;

public class UserContext {

    private static String user;

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        UserContext.user = user;
    }
}
