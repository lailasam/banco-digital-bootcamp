package br.com.bancodigital.service;
import br.com.bancodigital.exceptions.CaracteresInvalidosException;
import br.com.bancodigital.exceptions.ContaNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;

public interface IGerenciadorContas {
    void criarConta(int numero, int agencia, double saldo, String cpfTitular) throws CaracteresInvalidosException, CpfInvalidoException;
    void excluirConta(int numeroConta) throws CaracteresInvalidosException, ContaNaoExisteException;
    void depositar(int numeroConta, double valor) throws CaracteresInvalidosException;
    void sacar(int numeroConta, double valor);
    void transferir(int numeroContaOrigem, int numeroContaDestino, double valor);
    double exibirSaldo(int numeroConta);
    void exibirExtrato(int numeroConta);
}
