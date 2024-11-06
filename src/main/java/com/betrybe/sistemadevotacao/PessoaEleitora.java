package com.betrybe.sistemadevotacao;

/**
 * Classe PessoaEleitora.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public PessoaEleitora(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }
}
