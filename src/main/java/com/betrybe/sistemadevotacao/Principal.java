package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe Principal.
 */
public class Principal {

  /**
   * Main method.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciadorDeVotos = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    String option = "0";

    do {
      System.out.println(
          "Cadastrar pessoa candidata?\n"
          + "1 - Sim\n"
          + "2 - Não\n"
          + "Entre com o número correspondente à opção desejada:"
      );
      option = scanner.next();

      if (option.equals("1")) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scanner.nextInt();
        gerenciadorDeVotos.cadastrarPessoaCandidata(nome, numero);
      }
    } while (!option.equals("2"));

    do {
      System.out.println(
          "Cadastrar pessoa eleitora?\n"
          + "1 - Sim\n"
          + "2 - Não\n"
          + "Entre com o número correspondente à opção desejada:"
      );
      option = scanner.next();

      if (option.equals("1")) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scanner.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();
        gerenciadorDeVotos.cadastrarPessoaEleitora(nome, cpf);
      }
    } while (!option.equals("2"));

    do {
      System.out.println(
          "Entre com o número correspondente à opção desejada:\n"
          + "1 - Votar\n"
          + "2 - Resultado Parcial\n"
          + "3 - Finalizar Votação\n"
      );
      option = scanner.next();

      if (option.equals("1")) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int voto = scanner.nextInt();
        gerenciadorDeVotos.votar(cpf, voto);
      }

      if (option.equals("2")) {

        gerenciadorDeVotos.mostrarResultado();
      }
    } while (!option.equals("3"));
  }
}
