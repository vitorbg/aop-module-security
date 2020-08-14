package br.com.vitorbg.aop.exception;

public class AccessControlException extends RuntimeException {

    private String message;

    public AccessControlException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
