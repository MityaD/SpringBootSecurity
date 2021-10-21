package com.yakut.springbootsecurity.exception;

public class ExceptionByIdUser extends Exception {
    public ExceptionByIdUser(Long id) {
        System.out.println("no user id");
    }
}
