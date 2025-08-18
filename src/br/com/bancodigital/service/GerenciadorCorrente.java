package br.com.bancodigital.service;
import java.time.LocalDateTime;

import br.com.bancodigital.exceptions.CaracteresInvalidosException;
import br.com.bancodigital.exceptions.ContaNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.exceptions.RepositorioVazioException;
import br.com.bancodigital.exceptions.SaldoInsuficienteException;
import br.com.bancodigital.model.ContaCorrente;
import br.com.bancodigital.model.Extrato;
import br.com.bancodigital.repository.RepositorioContaCorrente;
import br.com.bancodigital.repository.RepositorioExtrato;

public class GerenciadorCorrente implements IGerenciadorContas {
    private RepositorioContaCorrente repositorioContaCorrente;
    private RepositorioExtrato repositorioExtrato;
    public GerenciadorCorrente() {
        this.repositorioContaCorrente = new RepositorioContaCorrente();
        this.repositorioExtrato = new RepositorioExtrato();
    }

    @Override
    public void criarConta(double saldo, String cpfTitular) throws CaracteresInvalidosException, CpfInvalidoException {
        if(cpfTitular==null|| cpfTitular.matches("[0-9]+") || cpfTitular.length()!=11){
            throw new CpfInvalidoException("CPF deve se composto de 11 numeros.");
        }
        else if(saldo<0){
            throw new CaracteresInvalidosException("O saldo inicial nao pode ser negativo.");
        }
        else{
            repositorioContaCorrente.criar(new ContaCorrente(saldo, cpfTitular, 1));
        }
    }

    public ContaCorrente buscarConta(int numeroConta) throws CaracteresInvalidosException {
        if(numeroConta <= 0) {
            throw new CaracteresInvalidosException("Numero da conta deve ser maior que 0.");
        }
        return repositorioContaCorrente.listar().stream()
            .filter(conta -> conta.getNumero() == numeroConta && conta.getTipoConta() == 1) // 1 para Conta Corrente
            .findFirst()
            .orElse(null);
    }

    public ContaCorrente buscarContaPorCpf(String cpfTitular) throws CaracteresInvalidosException {
        if(cpfTitular == null || cpfTitular.length() != 11 || !cpfTitular.matches("[0-9]+")) {
            throw new CaracteresInvalidosException("CPF deve se composto de 11 numeros.");
        }
        return repositorioContaCorrente.listar().stream()
            .filter(conta -> conta.getTitular().equals(cpfTitular) && conta.getTipoConta() == 1) // 1 para Conta Corrente
            .findFirst()
            .orElse(null);
    }

    @Override
    public void excluirConta(int numeroConta) throws CaracteresInvalidosException, ContaNaoExisteException {
        ContaCorrente conta = buscarConta(numeroConta);
        if(numeroConta<=0){
            throw new CaracteresInvalidosException("Numero da conta deve ser maior que 0.");
        }
        else if(conta==null){
            throw new ContaNaoExisteException ("Conta com numero " + numeroConta + " nao encontrada.");
        }
        else{
            repositorioContaCorrente.remover(conta);
        }
    }

 
    public void listarContas() throws RepositorioVazioException {
        if(repositorioContaCorrente.listar().isEmpty()){
            throw new RepositorioVazioException("Nenhuma conta cadastrada.");
        }
        else{
            repositorioContaCorrente.listar().forEach(System.out::println);
        }
    }

    @Override
    public void depositar(int numeroConta, double valor) throws CaracteresInvalidosException, ContaNaoExisteException {
            if(numeroConta<=0|| valor<=0){
                throw new CaracteresInvalidosException("Numero da conta deve ser maior que 0 e o valor do deposito deve ser positivo.");
            }
            if(buscarConta(numeroConta)==null){
                throw new ContaNaoExisteException("Conta nao encontrada.");
            }
        repositorioContaCorrente.listar().stream()
            .filter(conta -> conta.getNumero() == numeroConta && conta.getTipoConta() == 1) // 1 para Conta Corrente
            .findFirst()
            .ifPresent(conta -> {
                conta.setSaldo(conta.getSaldo() + valor);
                this.repositorioExtrato.criar(new Extrato(conta.getSaldo(),LocalDateTime.now(), 1, numeroConta));
            });
    }

    @Override
    public void sacar(int numeroConta, double valor) throws CaracteresInvalidosException, SaldoInsuficienteException, ContaNaoExisteException {
        if(numeroConta<=0|| valor<=0){
            throw new CaracteresInvalidosException("Numero da conta deve ser maior que 0 e o valor do deposito deve ser positivo.");
            }
        if(buscarConta(numeroConta).getSaldo()<valor||buscarConta(numeroConta).getSaldo()<=0){
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
        if(buscarConta(numeroConta)==null){
            throw new ContaNaoExisteException("Conta nao encontrada.");
        }
        repositorioContaCorrente.listar().stream()
            .filter(conta -> conta.getNumero() == numeroConta && conta.getTipoConta() == 1) // 1 para Conta Corrente
            .findFirst()
            .ifPresent(conta -> {
                conta.setSaldo(conta.getSaldo() - valor);
                this.repositorioExtrato.criar(new Extrato(conta.getSaldo(),LocalDateTime.now(), 1, numeroConta));
            });
    }

    @Override
    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) throws CaracteresInvalidosException, ContaNaoExisteException, SaldoInsuficienteException {
        ContaCorrente contaOrigem = buscarConta(numeroContaOrigem);
        ContaCorrente contaDestino = buscarConta(numeroContaDestino);
        if(numeroContaOrigem<=0|| numeroContaDestino<=0 || valor<=0){
            throw new CaracteresInvalidosException("Numero das contas deve ser maior que 0 e o valor da transferencia deve ser positivo.");
        }
        if(contaOrigem==null){
            throw new ContaNaoExisteException("Conta de origem nao encontrada.");
        }
        if(contaDestino==null){
            throw new ContaNaoExisteException("Conta de destino nao encontrada.");
        }
        if(contaOrigem.getSaldo()<valor||contaOrigem.getSaldo()<=0){
            throw new SaldoInsuficienteException("Saldo insuficiente para transferencia.");
        }
            contaOrigem.setSaldo(contaOrigem.getSaldo()-valor);
            contaDestino.setSaldo(contaDestino.getSaldo()+valor);
            this.repositorioExtrato.criar(new Extrato(contaOrigem.getSaldo(),LocalDateTime.now(), 3, numeroContaOrigem));
            this.repositorioExtrato.criar(new Extrato(contaDestino.getSaldo(),LocalDateTime.now(), 2, numeroContaDestino));
        
        
    }

    @Override
    public double exibirSaldo(int numeroConta) throws ContaNaoExisteException, CaracteresInvalidosException {
        ContaCorrente conta = buscarConta(numeroConta);
        if (conta == null) {
            throw new ContaNaoExisteException("Conta com numero " + numeroConta + " nao encontrada.");
        }
        return conta.getSaldo();
    }
    @Override
    public void exibirExtrato(int numeroConta) throws ContaNaoExisteException, RepositorioVazioException, CaracteresInvalidosException{
        ContaCorrente conta = buscarConta(numeroConta);
        if (conta == null) {
            throw new ContaNaoExisteException("Conta com numero " + numeroConta + " nao encontrada.");
        }
        if (repositorioExtrato.listar().isEmpty()) {
            throw new RepositorioVazioException("Nao ha extratos registrados");
        }
        repositorioExtrato.listar().stream()
            .filter(extrato -> extrato.getNumeroConta() == numeroConta)
            .forEach(System.out::println);
    }
   
}
