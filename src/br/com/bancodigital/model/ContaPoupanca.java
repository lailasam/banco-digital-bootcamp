package br.com.bancodigital.model;
import java.time.LocalDateTime;

public class ContaPoupanca extends Conta{
    private TipoConta tipoConta;
    private LocalDateTime dataCriacao;

    public ContaPoupanca(double saldo, String titular, int tipoConta) {
        super(saldo, titular);
        this.tipoConta = TipoConta.values()[tipoConta-1];
        this.dataCriacao = LocalDateTime.now();
    }
    public int getTipoConta() {
        return tipoConta.getTipo();
    }
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }    
    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public double calcularRendimento() {
        double taxaRendimento = 0.5*((LocalDateTime.now().getMonth().getValue()-1)-(dataCriacao.getMonth().getValue()-1)); 
        return getSaldo() * taxaRendimento / 100;
    }

}
