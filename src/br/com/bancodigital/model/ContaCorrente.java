package br.com.bancodigital.model;

public class ContaCorrente extends Conta {
    private TipoConta tipoConta;

    public ContaCorrente(double saldo, String titular, int tipoConta) {
        super(saldo, titular);
        this.tipoConta = TipoConta.values()[tipoConta];
    }
    public int getTipoConta() {
        return tipoConta.getTipo();
    }
}
