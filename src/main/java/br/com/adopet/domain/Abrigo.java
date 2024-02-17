package br.com.adopet.domain;

public class Abrigo {

    public Abrigo() { //construtor default - vazio
    }

    //substitui o jsonObject do client criando um objeto Abrigo
    public Abrigo(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    private long id;
    private String nome;
    private String telefone;
    private String email;
    private Pet[] pets;
    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }

    public Pet[] getPets() {
        return pets;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return """
                "id": %d,
                "nome": "%s",
                "telefone": "%s",
                "email": "%s"
                """.formatted(this.id, this.nome, this.telefone, this.email);
                
    }
}
