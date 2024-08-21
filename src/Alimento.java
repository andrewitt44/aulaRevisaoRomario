public class Alimento {
    private static int geradorCodigo = 0;
    private String nome;
    private int codigo;
    private int nutricao;
    public Alimento(String nome, int nutricao){
        geradorCodigo++;
        this.codigo = geradorCodigo;
        this.nome = nome;
        this.nutricao = nutricao;

    }

    public int getCodigo() {
        return codigo;
    }

    public int getNutricao() {
        return nutricao;
    }
}