package br.com.bancodigital.model;

public class ContaPoupanca extends Conta{
    private TipoConta tipoConta;
    public ContaPoupanca(int numero, int agencia, double saldo, String titular) {
        super(numero, agencia, saldo, titular);
        this.tipoConta = TipoConta.CONTA_POUPANÇA;
    }
    public int getTipoConta() {
        return tipoConta.getTipo();
    }
}
