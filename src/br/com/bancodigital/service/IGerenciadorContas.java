package br.com.bancodigital.service;
import br.com.bancodigital.model.Cliente;
import br.com.bancodigital.model.Conta;

public interface IGerenciadorContas {
    void criarConta(int numero, int agencia, double saldo, Cliente titular, int tipoConta);
    void excluirConta(int numeroConta);
    void atualizarConta(int numeroConta, double novoSaldo);
    Conta buscarConta(int numeroConta);
    void listarContas();
    void depositar(int numeroConta, double valor);
    void sacar(int numeroConta, double valor);
    void transferir(int numeroContaOrigem, int numeroContaDestino, double valor);
    void exibirSaldo(int numeroConta);
    void exibirExtrato(int numeroConta);
}
