package br.com.bancodigital.service;
import java.util.ArrayList;
import java.util.List;

import br.com.bancodigital.exceptions.CamposNulosException;
import br.com.bancodigital.exceptions.ClienteJaExisteException;
import br.com.bancodigital.exceptions.ClienteNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.exceptions.RepositorioVazioException;
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
    else if(cpf.length()!=11 || !cpf.matches("[0-9]+")){
        throw new CpfInvalidoException("CPF invalido. Deve conter 11 digitos numericos.");
    }
    else{
       repositorioCliente.adicionar(new Cliente(cpf, nome, email, telefone, endereco)); 
    } 
}

public void removerCliente(String cpf) throws CpfInvalidoException, ClienteNaoExisteException {
    if(cpf.length()!=11 || !cpf.matches("[0-9]+")|| cpf == null){
        throw new CpfInvalidoException("CPF invalido. Deve conter 11 digitos numericos.");
    }
    else if(!repositorioCliente.listarClientes().containsKey(cpf)){
        throw new ClienteNaoExisteException("Cliente com CPF " + cpf + " nao encontrado.");
    }
    else{
        repositorioCliente.remover(cpf);
    }
}
    
public void atualizarCliente(String cpf, String nome, String email, String telefone, String endereco) throws CamposNulosException, CpfInvalidoException, ClienteNaoExisteException {
    if(cpf == null || nome == null || email == null || telefone == null || endereco == null) {
        throw new CamposNulosException("Nenhum campo pode ser nulo.");
    }
    else if(cpf.length()!=11 || !cpf.matches("[0-9]+")){
        throw new CpfInvalidoException("CPF invalido. Deve conter 11 digitos numericos.");
    }
    else if(!repositorioCliente.listarClientes().containsKey(cpf)){
        throw new ClienteNaoExisteException("Cliente com CPF " + cpf + " nao encontrado.");
    }
    else{
        repositorioCliente.atualizar(new Cliente(cpf, nome, email, telefone, endereco));
    }
}

public Cliente buscarCliente(String cpf)throws CpfInvalidoException, ClienteNaoExisteException {
    if(cpf.length()!=11 || !cpf.matches("[0-9]+") || cpf == null){
        throw new CpfInvalidoException("CPF invalido. Deve conter 11 digitos numericos.");
    }
    else if(!repositorioCliente.listarClientes().containsKey(cpf)){
        throw new ClienteNaoExisteException("Cliente com CPF " + cpf + " nao encontrado.");
    }
    else{
        return repositorioCliente.listarClientes().get(cpf);
    }
}
public List<Cliente> listarClientes() throws RepositorioVazioException{
    if(repositorioCliente.listarClientes().isEmpty()){
        throw new RepositorioVazioException("Nenhum cliente cadastrado.");
    }
    return new ArrayList<>(repositorioCliente.listarClientes().values());
}
}
