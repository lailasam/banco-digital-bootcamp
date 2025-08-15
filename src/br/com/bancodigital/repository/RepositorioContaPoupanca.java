package br.com.bancodigital.repository;
import br.com.bancodigital.model.ContaPoupanca;

public class RepositorioContaPoupanca extends RepositorioContas<ContaPoupanca> {
    public RepositorioContaPoupanca() {
        super();
    }
    public ContaPoupanca buscarConta(int numeroConta) {
    return super.listar().stream()
            .filter(conta -> conta.getNumero() == numeroConta && conta.getTipoConta() == 2) // 1 para Conta Corrente
            .findFirst()
            .orElse(null);
}
}
