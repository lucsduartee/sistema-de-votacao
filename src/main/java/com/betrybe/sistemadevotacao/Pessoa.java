package com.betrybe.sistemadevotacao;

public abstract class Pessoa {
    protected String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
// No projeto já existe um arquivo com a classe `com.betrybe.sistemadevotacao.Pessoa`. Nessa classe, você deve garantir que:
//        1. Ela é uma classe abstrata, de forma que ela será utilizada como base para implementação de outras classes, mas não será instanciada por si.
//        2. Ela possui o atributo protegido `nome` do tipo String.
//        3. Ela possui os _getters_ e _setters_ correspondentes ao atributo.
//  - Note que estes métodos não são abstratos, mesmo que a classe seja.