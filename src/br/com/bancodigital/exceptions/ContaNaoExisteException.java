package br.com.bancodigital.exceptions;

public class ContaNaoExisteException extends Exception {
    public ContaNaoExisteException(String message) {
        super(message);
    }

}
