package br.com.bancodigital.repository;
import java.util.Map;
import br.com.bancodigital.model.Cliente;

public interface IRepositorioCliente {
void adicionar(Cliente cliente); //ja atualiza com isso
void remover(String cpf);
Map<String, Cliente> listarClientes();
}
