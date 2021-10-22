package com.yakut.springbootsecurity.exception;

public class ExceptionByUserName extends Exception{
    public ExceptionByUserName() {
        System.out.println("No name or user BD");
    }
}
