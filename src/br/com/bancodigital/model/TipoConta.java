package br.com.bancodigital.model;

public enum TipoConta {
    
CONTA_CORRENTE(1), 
CONTA_POUPANÇA(2);

private final int tipo;

TipoConta(int tipo) {
    this.tipo = tipo;
}

public int getTipo(){
    return this.tipo;
}
}