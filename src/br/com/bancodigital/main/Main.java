package br.com.bancodigital.main;

import java.util.Scanner;

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
    char opcao;
    /* Scanner */
    Scanner sc = new Scanner(System.in);

    /* MENU DE OPERACOES */
    System.out.println("*****\nBem-vindo ao Banco Digital!\n*****");
    System.out.println("\nPor favor, escolha uma opção:\n\n1.Ja sou cliente\n2.Novo cliente");
    opcao = sc.nextLine().charAt(0);
    while (opcao != '1' && opcao != '2') {
      System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
      opcao = sc.nextLine().charAt(0);
    }
    switch (opcao) {
        case '1':
            
            break;
    
        default:
            break;
    }
    System.out.println("Selecione uma opcao:\n1. Criar Conta\n2. Excluir Conta\n3. Depositar\n4. Sacar\n5. Transferir\n6. Exibir Saldo\n7. Exibir Extrato\n8. Sair");

  }
}
