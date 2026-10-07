public class Pessoa {
    int id;
    String nome;
    int idade;

    Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public String toString() {
        return id + " - " + nome + " (" + idade + " anos)";
    }
}