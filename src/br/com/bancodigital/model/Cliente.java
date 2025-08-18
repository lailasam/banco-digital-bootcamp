package br.com.bancodigital.model;

public class Cliente {
    
private String cpf;
private String nome;
private String email;
private String telefone;
private String endereco;

public Cliente(String cpf, String nome, String email, String telefone, String endereco) {
    this.cpf = cpf;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.endereco = endereco;
}

public String getCpf() {
    return cpf;
}

public String getNome() {
    return nome;
}

public String getEmail() {
    return email;
}

public String getTelefone() {
    return telefone;
}

public String getEndereco() {
    return endereco;
}
@Override
public String toString() {
    return
            "cpf='" + cpf + '\'' +
            ", nome='" + nome + '\'' +
            ", email='" + email + '\'' +
            ", telefone='" + telefone + '\'' +
            ", endereco='" + endereco + '\'' ;
}
}
