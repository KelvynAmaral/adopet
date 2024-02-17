package br.com.adopet.domain;

public class Pet {
    public Pet() { //construtor default - vazio
    }

    public Pet(String tipo, String nome, String raca, int idade, String cor, float peso) {
        this.tipo = tipo;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.cor = cor;
        this.peso = peso;
    }

    private long id;

    private String tipo;
    private String nome;
    private String raca;
    private int idade;
    private String cor;
    private Float peso;

    public long getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public String getNome() {
        return nome;
    }
    public String getRaca() {
        return raca;
    }
    public int getIdade() {
        return idade;
    }

    public Float getPeso() {
        return peso;
    }

    public String getCor() {
        return cor;
    }

    public void setId(long l) {
    }
}

