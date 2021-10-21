package com.yakut.springbootsecurity.exception;

public class NoUserTableException extends Exception{
    public NoUserTableException(Long id) {
        System.out.println("Нет пользователя с ID: " + id );
    }
}