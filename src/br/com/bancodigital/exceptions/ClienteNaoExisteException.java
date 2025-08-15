package br.com.bancodigital.exceptions;

public class ClienteNaoExisteException extends Exception {
    public ClienteNaoExisteException(String message) {
        super(message);
    }

}
