package br.com.bancodigital.service;

import br.com.bancodigital.exceptions.CamposNulosException;
import br.com.bancodigital.exceptions.ClienteJaExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.model.Cliente;
import br.com.bancodigital.repository.IRepositorioCliente;
import br.com.bancodigital.repository.RepositorioClientes;

public class GerenciadorClientes {
private IRepositorioCliente repositorioCliente;

public GerenciadorClientes(){
    this.repositorioCliente = RepositorioClientes.getInstance();
}
public void cadastrarCliente(String cpf, String nome, String email, String telefone, String endereco) throws CamposNulosException, ClienteJaExisteException, CpfInvalidoException{
    if(cpf == null || nome == null || email == null || telefone == null || endereco == null) {
        throw new CamposNulosException("Nenhum campo pode ser nulo.");
    }
    else if (repositorioCliente.listarClientes().containsKey(cpf)) {
        throw new ClienteJaExisteException("Cliente com CPF " + cpf + " ja cadastrado.");
    }
    else{
       repositorioCliente.adicionar(new Cliente(cpf, nome, email, telefone, endereco)); 
    } 
}
}
