package br.com.bancodigital.service;

import br.com.bancodigital.repository.IRepositorioCliente;
import br.com.bancodigital.repository.RepositorioClientes;

public class GerenciadorClientes {
private IRepositorioCliente repositorioCliente;

public GerenciadorClientes(){
    this.repositorioCliente = RepositorioClientes.getInstance();
}
public void cadastrarCliente(String cpf, String nome, String email, String telefone, String endereco){
   repositorioCliente.adicionar(new Cliente(cpf, nome, email, telefone, endereco));
}
}
