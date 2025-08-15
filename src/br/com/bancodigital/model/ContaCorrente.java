package br.com.bancodigital.model;

public class ContaCorrente extends Conta {
    private TipoConta tipoConta;

    public ContaCorrente(int numero, int agencia, double saldo, Cliente titular) {
        super(numero, agencia, saldo, titular);
        this.tipoConta = TipoConta.CONTA_CORRENTE;
    }
    public int getTipoConta() {
        return tipoConta.getTipo();
    }
}
