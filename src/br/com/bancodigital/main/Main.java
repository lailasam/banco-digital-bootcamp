package br.com.bancodigital.main;
import br.com.bancodigital.exceptions.CamposNulosException;
import br.com.bancodigital.exceptions.CaracteresInvalidosException;
import br.com.bancodigital.exceptions.ClienteJaExisteException;
import br.com.bancodigital.exceptions.ClienteNaoExisteException;
import br.com.bancodigital.exceptions.ContaNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.exceptions.RepositorioVazioException;
import br.com.bancodigital.exceptions.SaldoInsuficienteException;
import br.com.bancodigital.service.GerenciadorClientes;
import br.com.bancodigital.service.GerenciadorCorrente;
import br.com.bancodigital.service.GerenciadorPoupanca;


public class Main {
  public static void main(String[] args)  {    
   GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();
   GerenciadorCorrente gerenciadorCorrente = new GerenciadorCorrente();
   GerenciadorPoupanca gerenciadorPoupanca = new GerenciadorPoupanca();
   try {
    gerenciadorClientes.cadastrarCliente("12345678901", "joao", "joao@", "917488201", "rua ezequiel");
       gerenciadorClientes.listarClientes().forEach(System.out::println);
       gerenciadorClientes.atualizarCliente("12345678901", "joao silva", "joao@", "917488201", "rua ezequiel");
       gerenciadorClientes.listarClientes().forEach(System.out::println);
      /*  gerenciadorClientes.removerCliente("12345678901");
       gerenciadorClientes.listarClientes().forEach(System.out::println);
       gerenciadorClientes.cadastrarCliente("12345678901", "joao", "joao@", "917488201", "rua ezequiel");*/
       gerenciadorCorrente.criarConta(1000, "12345678901");
       System.out.println(gerenciadorCorrente.buscarContaPorCpf("12345678901"));
       gerenciadorCorrente.depositar(gerenciadorCorrente.buscarContaPorCpf("12345678901").getNumero(), 50.00);
       gerenciadorCorrente.exibirExtrato(gerenciadorCorrente.buscarContaPorCpf("12345678901").getNumero());

} catch (CamposNulosException | ClienteJaExisteException | CpfInvalidoException | RepositorioVazioException
        | ClienteNaoExisteException | CaracteresInvalidosException | ContaNaoExisteException e) {
    System.out.println(e.getMessage());
} 
}

}

