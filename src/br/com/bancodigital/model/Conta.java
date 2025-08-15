package br.com.bancodigital.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Conta {
private static final Set<Integer> usedNumeros = new HashSet<>();
private static final Set<Integer> usedAgencias = new HashSet<>();
private static final Random random = new Random();

private int numero;
private int agencia;
private double saldo;
private Cliente titular;

public Conta(int numero, int agencia, double saldo, Cliente titular) {
    this.numero = gerarNumeroUnico(100000, 999999, usedNumeros);
    this.agencia = gerarNumeroUnico(1000, 9999, usedAgencias);
    this.saldo = saldo;
    this.titular = titular;
}

 private static int gerarNumeroUnico(int min, int max, Set<Integer> usedSet) {
        int num;
        do {
            num = random.nextInt((max - min) + 1) + min;
        } while (!usedSet.add(num));
        return num;
    }

public int getNumero() {
    return numero;
}

public int getAgencia() {
    return agencia;
}

public double getSaldo() {
    return saldo;
}

public Cliente getTitular() {
    return titular;
}

public void setNumero(int numero) {
    this.numero = numero;
}

public void setAgencia(int agencia) {
    this.agencia = agencia;
}

public void setSaldo(double saldo) {
    this.saldo = saldo;
}

public void setTitular(Cliente titular) {
    this.titular = titular;
}

}
