package br.com.bancodigital.service;

import br.com.bancodigital.exceptions.CaracteresInvalidosException;
import br.com.bancodigital.exceptions.ContaNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.exceptions.RepositorioVazioException;
import br.com.bancodigital.exceptions.SaldoInsuficienteException;
import br.com.bancodigital.repository.RepositorioContaPoupanca;
import br.com.bancodigital.repository.RepositorioExtrato;

public class GerenciadorPoupanca implements IGerenciadorContas {
    private RepositorioContaPoupanca repositorioContaPoupanca;
    private RepositorioExtrato repositorioExtrato;
    public GerenciadorPoupanca() {
        this.repositorioContaPoupanca = new RepositorioContaPoupanca();
        this.repositorioExtrato = new RepositorioExtrato();
    }
    @Override
    public void criarConta(int numero, int agencia, double saldo, String cpfTitular)
            throws CaracteresInvalidosException, CpfInvalidoException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarConta'");
    }

    @Override
    public void excluirConta(int numeroConta) throws CaracteresInvalidosException, ContaNaoExisteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluirConta'");
    }

    @Override
    public void depositar(int numeroConta, double valor) throws CaracteresInvalidosException, ContaNaoExisteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depositar'");
    }

    @Override
    public void sacar(int numeroConta, double valor)
            throws CaracteresInvalidosException, SaldoInsuficienteException, ContaNaoExisteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sacar'");
    }

    @Override
    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor)
            throws CaracteresInvalidosException, ContaNaoExisteException, SaldoInsuficienteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transferir'");
    }

    @Override
    public double exibirSaldo(int numeroConta) throws ContaNaoExisteException, CaracteresInvalidosException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibirSaldo'");
    }

    @Override
    public void exibirExtrato(int numeroConta)
            throws ContaNaoExisteException, RepositorioVazioException, CaracteresInvalidosException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibirExtrato'");
    }

}
