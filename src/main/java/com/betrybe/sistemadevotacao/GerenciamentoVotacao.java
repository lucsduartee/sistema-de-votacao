package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

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

    }

    @Override
    public void mostrarResultado() {

    }
}
