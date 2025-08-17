package br.com.bancodigital.model;

public enum Operacao {
    DEPOSITO(1, "Depósito"),
    SAQUE(2, "Saque"),
    TRANSFERENCIA(3, "Transferência");

    private final int codigo;
    private final String descricao;

    Operacao(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
