package br.com.bancodigital.repository;
import java.util.HashMap;
import java.util.Map;
import br.com.bancodigital.model.Cliente;

public class RepositorioClientes implements IRepositorioCliente {
// INSTANCIA UNICA DO REPOSITORIO
    private static RepositorioClientes instance;
    // METODO PARA OBTER A INSTANCIA DO REPOSITORIO
    public static RepositorioClientes getInstance() {
        if (instance == null) {
            synchronized (RepositorioClientes.class) { // Thread-safe
                if (instance == null) {
                    instance = new RepositorioClientes();
                }
            }
        }
        return instance;
    }
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

@Override
public void atualizar(Cliente cliente){
    if(clientes.containsKey(cliente.getCpf())){
        clientes.remove(cliente.getCpf());
        clientes.put(cliente.getCpf(), cliente);
    }
}

}
