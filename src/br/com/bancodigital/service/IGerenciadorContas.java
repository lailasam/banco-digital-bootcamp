package br.com.bancodigital.service;
import br.com.bancodigital.exceptions.CaracteresInvalidosException;
import br.com.bancodigital.exceptions.ContaNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.exceptions.RepositorioVazioException;
import br.com.bancodigital.exceptions.SaldoInsuficienteException;

public interface IGerenciadorContas {
    void criarConta(double saldo, String cpfTitular) throws CaracteresInvalidosException, CpfInvalidoException;
    void excluirConta(int numeroConta) throws CaracteresInvalidosException, ContaNaoExisteException;
    void depositar(int numeroConta, double valor) throws CaracteresInvalidosException, ContaNaoExisteException;
    void sacar(int numeroConta, double valor) throws CaracteresInvalidosException, SaldoInsuficienteException, ContaNaoExisteException;
    void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) throws CaracteresInvalidosException, ContaNaoExisteException, SaldoInsuficienteException;
    double exibirSaldo(int numeroConta) throws ContaNaoExisteException, CaracteresInvalidosException;
    void exibirExtrato(int numeroConta) throws ContaNaoExisteException, RepositorioVazioException, CaracteresInvalidosException;
}
