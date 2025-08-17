package br.com.bancodigital.model;
import java.time.LocalDateTime;

public class Extrato {
   private int numeroConta;
   private int agencia;
   private double saldo;
   private String titular;
   private String tipoConta;
   private LocalDateTime dataTransacao;
   private String operacao;

   public int getNumeroConta() {
    return numeroConta;
   }
   public void setNumeroConta(int numeroConta) {
    this.numeroConta = numeroConta;
   }
   public int getAgencia() {
    return agencia;
   }
   public void setAgencia(int agencia) {
    this.agencia = agencia;
   }
   public double getSaldo() {
    return saldo;
   }
   public void setSaldo(double saldo) {
    this.saldo = saldo;
   }
   public String getTitular() {
    return titular;
   }
   public void setTitular(String titular) {
    this.titular = titular;
   }
   public String getTipoConta() {
    return tipoConta;
   }
   public void setTipoConta(String tipoConta) {
    this.tipoConta = tipoConta;
   }
   public LocalDateTime getDataTransacao() {
    return dataTransacao;
   }
   public void setDataTransacao(LocalDateTime dataTransacao) {
    this.dataTransacao = dataTransacao;
   }
   public String getOperacao() {
    return operacao;
   }
   public void setOperacao(String operacao) {
    this.operacao = operacao;
   }

}
