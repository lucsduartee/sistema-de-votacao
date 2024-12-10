package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * Classe GerenciamentoVotacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    Optional<PessoaCandidata> pessoaCandidata = pessoasCandidatas.stream()
        .filter(pessoasCandidata -> numero == pessoasCandidata.getNumero())
        .findAny();

    if (pessoaCandidata.isPresent()) {
      System.out.println("Número da pessoa candidata já utilizado!");
      return;
    }

    PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(novaPessoaCandidata);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    Optional<PessoaEleitora> pessoaEleitora = pessoasEleitoras.stream()
        .filter(pe -> pe.getCpf() == cpf)
        .findAny();

    if (pessoaEleitora.isPresent()) {
      System.out.println("Pessoa eleitora já cadastrada!");
      return;
    }

    PessoaEleitora novaPessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(novaPessoaEleitora);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean cpfJaComputado = cpfsComputados.contains(cpfPessoaEleitora);

    if (cpfJaComputado) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }
    Optional<PessoaCandidata> candidata = pessoasCandidatas.stream()
        .filter(pessoaCandidata -> pessoaCandidata.getNumero() == numeroPessoaCandidata)
        .findFirst();

    if (candidata.isPresent()) {
      candidata.get().receberVoto();
      cpfsComputados.add(cpfPessoaEleitora);
      return;
    }

    System.out.println("Candidato não encontrado!");
  }

  @Override
  public void mostrarResultado() {
    long quantidadeDeVotos = cpfsComputados.size();
    System.out.println(quantidadeDeVotos);

    if (quantidadeDeVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    for (PessoaCandidata pessoasCandidata : pessoasCandidatas) {
      String nome = pessoasCandidata.getNome();
      int votos = pessoasCandidata.getVotos();
      long razao = Math.round(((double) votos / quantidadeDeVotos) * 100);

      System.out.printf(
          "Nome: %s - %d votos ( %d%% ) %n",
          nome,
          votos,
          razao
      );
    }
    System.out.println("Total de votos: " + quantidadeDeVotos);
  }
}
