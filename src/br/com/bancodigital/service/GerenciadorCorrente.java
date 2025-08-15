package br.com.bancodigital.service;

import br.com.bancodigital.exceptions.CamposNulosException;
import br.com.bancodigital.exceptions.CaracteresInvalidosException;
import br.com.bancodigital.exceptions.ClienteNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.model.Cliente;
import br.com.bancodigital.model.Conta;
import br.com.bancodigital.model.ContaCorrente;
import br.com.bancodigital.repository.RepositorioContaCorrente;

public class GerenciadorCorrente implements IGerenciadorContas {
    private RepositorioContaCorrente repositorioContaCorrente;
    private GerenciadorClientes gerenciadorClientes;
    public GerenciadorCorrente() {
        this.repositorioContaCorrente = new RepositorioContaCorrente();
        this.gerenciadorClientes = new GerenciadorClientes();
    }

    @Override
    public void criarConta(int numero, int agencia, double saldo, String cpfTitular, int tipoConta) throws CamposNulosException, CaracteresInvalidosException, ClienteNaoExisteException, CpfInvalidoException {
        if(cpfTitular==null){
            throw new CpfInvalidoException("CPF do titular da conta invalido.");
        }
        else if(numero<=0 || agencia<=0 || saldo<0 || (tipoConta!=1 && tipoConta!=2)){
            throw new CaracteresInvalidosException("Numero e agencia devem ser maiores que 0, o saldo inicial nao pode ser negativo\ne as contas sao do tipo 1 e 2.");
        }
        else if(gerenciadorClientes.buscarCliente(cpfTitular) == null){
                throw new ClienteNaoExisteException("Titular nao encontrado.");
        }
        else if(tipoConta == 1){
            Conta conta = new ContaPoupanca(numero, agencia, saldo, titular);
            repositorioContaCorrente.adicionar(conta);
        }
        else{
            Conta conta = new ContaCorrente(numero, agencia, saldo, titular);
            repositorioContaCorrente.adicionar(conta);

        }
    }
    @Override
    public void excluirConta(int numeroConta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluirConta'");
    }
    @Override
    public Conta buscarConta(int numeroConta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarConta'");
    }
    @Override
    public void listarContas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarContas'");
    }
    @Override
    public void depositar(int numeroConta, double valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depositar'");
    }
    @Override
    public void sacar(int numeroConta, double valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sacar'");
    }
    @Override
    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transferir'");
    }
    @Override
    public void exibirSaldo(int numeroConta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibirSaldo'");
    }
    @Override
    public void exibirExtrato(int numeroConta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibirExtrato'");
    }
    
   
}
