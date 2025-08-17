package br.com.bancodigital.main;

import java.util.Scanner;

import br.com.bancodigital.exceptions.CamposNulosException;
import br.com.bancodigital.exceptions.ClienteJaExisteException;
import br.com.bancodigital.exceptions.ClienteNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.service.GerenciadorClientes;
import br.com.bancodigital.service.GerenciadorCorrente;
import br.com.bancodigital.service.GerenciadorPoupanca;

public class Main {
  public static void main(String[] args) {    
    /* Gerenciadores - service */
    GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();
    GerenciadorCorrente gerenciadorCorrente = new GerenciadorCorrente();
    GerenciadorPoupanca gerenciadorPoupanca = new GerenciadorPoupanca();
    /* char opcao */
    char opcaoCliente;
    char opcaoConta = '0';
    /* Scanner */
    Scanner sc = new Scanner(System.in);
    /* Dados */
    String cpf; 

    /***************************************************/
    /* MENU DE OPERACOES CLIENTE*/
    System.out.println("*****\nBem-vindo ao Banco Digital!\n*****");
    System.out.println("\nPor favor, escolha uma opção:\n\n1.Ja sou cliente\n2.Novo cliente");
    opcaoCliente = sc.nextLine().charAt(0);
    switch (opcaoCliente) {
        case '1':
            System.out.println("Digite seu CPF:");
             cpf = sc.nextLine();
            try {
                if (gerenciadorClientes.buscarCliente(cpf) != null) {
                  System.out.println("Cliente encontrado. Você pode acessar suas contas."); 
                  System.out.println("Selecione uma opcao:\na. Criar Conta\nb. Excluir Conta\nc. Depositar\nd. Sacar\ne. Transferir\nf. Exibir Saldo\ng. Exibir Extrato\nh. Sair");
                  opcaoConta = sc.nextLine().charAt(0);
               } 
            } catch (CpfInvalidoException | ClienteNaoExisteException e) {
                System.out.println("Erro ao buscar cliente: " + e.getMessage());
                System.out.println("Digite 1 se deseja tentar novamente ou 2 para cadastro:");
                opcaoCliente = sc.nextLine().charAt(0);
            }
            break;
        case '2':
            System.out.println("Realizar cadastro\nDigite nessa ordem:\nCPF\nNome\nEmail\nTelefone\nEndereço");
            try {
                gerenciadorClientes.cadastrarCliente(
                    sc.nextLine(), // CPF
                    sc.nextLine(), // Nome
                    sc.nextLine(), // Email
                    sc.nextLine(), // Telefone
                    sc.nextLine()  // Endereço
                    );
                    System.out.println("Cliente cadastrado com sucesso!");
                    System.out.println("Selecione uma opcao:\na. Criar Conta\nb. Excluir Conta\nc. Depositar\nd. Sacar\ne. Transferir\nf. Exibir Saldo\ng. Exibir Extrato\nh. Sair");
                    opcaoConta = sc.nextLine().charAt(0);
            } catch (CamposNulosException | ClienteJaExisteException | CpfInvalidoException e) {
                System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
            }
        default:
            System.out.println("Opção inválida. Por favor, reinicie o programa.");
    }

    /*******************************************************************************/

    /* MENU DE OPERACOES CONTA */
    switch(opcaoConta){
      case 'a':
        System.out.println("Criar Conta:");

    }
  }
}
