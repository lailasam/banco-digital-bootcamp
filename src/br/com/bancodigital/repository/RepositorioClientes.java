package br.com.bancodigital.repository;
import java.util.HashMap;
import java.util.Map;

import br.com.bancodigital.model.Cliente;

public class RepositorioClientes implements IRepositorioCliente {
private Map<String, Cliente> clientes;
public RepositorioClientes() {
    this.clientes = new HashMap<>();
}
@Override
public void adicionar(Cliente cliente) {
    this.clientes.put(cliente.getCpf(), cliente);
}
@Override
public void remover(String cpf) {
    clientes.remove(cpf);
}

@Override
public Map<String, Cliente> listarClientes() {
    return this.clientes;
}

}
