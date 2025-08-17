package br.com.bancodigital.repository;
import java.util.Map;
import br.com.bancodigital.model.Cliente;

public interface IRepositorioCliente {
void adicionar(Cliente cliente); 
void remover(String cpf);
Map<String, Cliente> listarClientes();
void atualizar(Cliente cliente); 
}
