package br.com.adryannfelix.gestaovagas.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException() {
       super("Usuario ja existe");
    }
}
