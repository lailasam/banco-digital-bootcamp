package br.com.bancodigital.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Extrato {
   private double saldo;
   private LocalDateTime dataTransacao;
   private String operacao;

    public Extrato(double saldo, LocalDateTime dataTransacao, String operacao) {
     this.saldo = saldo;
     this.dataTransacao = dataTransacao;
     this.operacao = operacao;
    }

   public double getSaldo() {
    return saldo;
   }
   public void setSaldo(double saldo) {
    this.saldo = saldo;
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
   @Override
   public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
    return "Data da transacao:" 
    + dataTransacao.format(formatter) 
    + ", Operacao: " 
    + operacao 
    + ", Saldo: " 
    + saldo;
   }
   }
