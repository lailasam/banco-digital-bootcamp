package br.com.bancodigital.service;
import br.com.bancodigital.exceptions.CaracteresInvalidosException;
import br.com.bancodigital.exceptions.ContaNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.model.ContaCorrente;
import br.com.bancodigital.repository.RepositorioContaCorrente;

public class GerenciadorCorrente implements IGerenciadorContas {
    private RepositorioContaCorrente repositorioContaCorrente;
    public GerenciadorCorrente() {
        this.repositorioContaCorrente = new RepositorioContaCorrente();
    }

    @Override
    public void criarConta(int numero, int agencia, double saldo, String cpfTitular) throws CaracteresInvalidosException, CpfInvalidoException {
        if(cpfTitular==null|| cpfTitular.matches("[0-9]+") || cpfTitular.length()!=11){
            throw new CpfInvalidoException("CPF deve se composto de 11 numeros.");
        }
        else if(numero<=0 || agencia<=0 || saldo<0){
            throw new CaracteresInvalidosException("Numero e agencia devem ser maiores que 0, o saldo inicial nao pode ser negativo.");
        }
        else{
            repositorioContaCorrente.criar(new ContaCorrente(numero, agencia, saldo, cpfTitular));
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
