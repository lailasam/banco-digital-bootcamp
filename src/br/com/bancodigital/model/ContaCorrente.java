package br.com.bancodigital.model;

public class ContaCorrente extends Conta {
    private TipoConta tipoConta;

    public ContaCorrente(double saldo, String titular) {
        super(saldo, titular);
        this.tipoConta = TipoConta.CONTA_CORRENTE;
    }
    public int getTipoConta() {
        return tipoConta.getTipo();
    }
}
