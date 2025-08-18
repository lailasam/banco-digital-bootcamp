package br.com.bancodigital.service;

import java.time.LocalDateTime;

import br.com.bancodigital.exceptions.CaracteresInvalidosException;
import br.com.bancodigital.exceptions.ContaNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.exceptions.RepositorioVazioException;
import br.com.bancodigital.exceptions.SaldoInsuficienteException;
import br.com.bancodigital.model.ContaPoupanca;
import br.com.bancodigital.model.Extrato;
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
    public void criarConta(double saldo, String cpfTitular)
            throws CaracteresInvalidosException, CpfInvalidoException {
                if(cpfTitular==null|| cpfTitular.matches("[0-9]+") || cpfTitular.length()!=11){
            throw new CpfInvalidoException("CPF deve se composto de 11 numeros.");
        }
        else if(saldo<0){
            throw new CaracteresInvalidosException("Osaldo inicial nao pode ser negativo.");
        }
        else{
            repositorioContaPoupanca.criar(new ContaPoupanca(saldo, cpfTitular, 2));
        }
    }
    public ContaPoupanca buscarConta(int numeroConta) throws CaracteresInvalidosException {
        if(numeroConta <= 0) {
            throw new CaracteresInvalidosException("Numero da conta deve ser maior que 0.");
        }
        return repositorioContaPoupanca.listar().stream()
            .filter(conta -> conta.getNumero() == numeroConta && conta.getTipoConta() == 2) // 2 para Conta Poupanca
            .findFirst()
            .orElse(null);
    }

    @Override
    public void excluirConta(int numeroConta) throws CaracteresInvalidosException, ContaNaoExisteException {
        ContaPoupanca conta = buscarConta(numeroConta);
        if(numeroConta<=0){
            throw new CaracteresInvalidosException("Numero da conta deve ser maior que 0.");
        }
        else if(conta==null){
            throw new ContaNaoExisteException ("Conta com numero " + numeroConta + " nao encontrada.");
        }
        else{
            repositorioContaPoupanca.remover(conta);
        }
    }

 
    public void listarContas() throws RepositorioVazioException {
        if(repositorioContaPoupanca.listar().isEmpty()){
            throw new RepositorioVazioException("Nenhuma conta cadastrada.");
        }
        else{
            repositorioContaPoupanca.listar().forEach(System.out::println);
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
        repositorioContaPoupanca.listar().stream()
            .filter(conta -> conta.getNumero() == numeroConta && conta.getTipoConta() == 2) // 2 para Conta Poupanca
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
        repositorioContaPoupanca.listar().stream()
            .filter(conta -> conta.getNumero() == numeroConta && conta.getTipoConta() == 2) // 2 para Conta Poupanca
            .findFirst()
            .ifPresent(conta -> {
                conta.setSaldo(conta.getSaldo() - valor);
                this.repositorioExtrato.criar(new Extrato(conta.getSaldo(),LocalDateTime.now(), 1, numeroConta));
            });
    }

    @Override
    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) throws CaracteresInvalidosException, ContaNaoExisteException, SaldoInsuficienteException {
        ContaPoupanca contaOrigem = buscarConta(numeroContaOrigem);
        ContaPoupanca contaDestino = buscarConta(numeroContaDestino);
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
        ContaPoupanca conta = buscarConta(numeroConta);
        if (conta == null) {
            throw new ContaNaoExisteException("Conta com numero " + numeroConta + " nao encontrada.");
        }
        return conta.getSaldo();
    }
    @Override
    public void exibirExtrato(int numeroConta) throws ContaNaoExisteException, RepositorioVazioException, CaracteresInvalidosException{
        ContaPoupanca conta = buscarConta(numeroConta);
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
   
    public void renderJuros() throws RepositorioVazioException{
        if(repositorioContaPoupanca.listar().isEmpty()){
            throw new RepositorioVazioException("Nenhuma conta poupanca cadastrada.");
        }
        repositorioContaPoupanca.listar().forEach(conta -> {
            double rendimento = conta.calcularRendimento();
            if (rendimento > 0) {
                conta.setSaldo(conta.getSaldo() + rendimento);
                this.repositorioExtrato.criar(new Extrato(conta.getSaldo(), LocalDateTime.now(), 4, conta.getNumero()));
            }
        });
    }
  
}
