package br.com.bancodigital.main;

import java.util.Scanner;

import br.com.bancodigital.exceptions.CamposNulosException;
import br.com.bancodigital.exceptions.CaracteresInvalidosException;
import br.com.bancodigital.exceptions.ClienteJaExisteException;
import br.com.bancodigital.exceptions.ClienteNaoExisteException;
import br.com.bancodigital.exceptions.CpfInvalidoException;
import br.com.bancodigital.exceptions.RepositorioVazioException;
import br.com.bancodigital.service.GerenciadorClientes;
import br.com.bancodigital.service.GerenciadorCorrente;
import br.com.bancodigital.service.GerenciadorPoupanca;

public class Main {
  public static void main(String[] args) {    
   GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();
   GerenciadorCorrente gerenciadorCorrente = new GerenciadorCorrente();
   GerenciadorPoupanca gerenciadorPoupanca = new GerenciadorPoupanca();
   try {
    gerenciadorClientes.cadastrarCliente("15355779409", "laila samara", "lailasamara", "81991963724", "escada");
    gerenciadorClientes.cadastrarCliente("12345678901", "joao silva", "joaosilva", "81991234567", "recife");
} catch (CamposNulosException | ClienteJaExisteException | CpfInvalidoException e) {
    System.out.println(e.getMessage());
}
try {
    gerenciadorCorrente.criarConta(50.00, "15355779409");
    gerenciadorPoupanca.criarConta(100.00, "12345678901");
} catch (CaracteresInvalidosException | CpfInvalidoException e) {
    System.out.println(e.getMessage());
}
try {
    gerenciadorClientes.listarClientes().forEach(System.out::println);
} catch (RepositorioVazioException e) {
    System.out.println(e.getMessage());
}
}
}
