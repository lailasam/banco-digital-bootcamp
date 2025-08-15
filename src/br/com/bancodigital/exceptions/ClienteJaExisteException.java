package br.com.bancodigital.exceptions;

public class ClienteJaExisteException extends Exception {
    public ClienteJaExisteException(String message) {
        super(message);
    }
}
