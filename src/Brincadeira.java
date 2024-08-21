import java.util.ArrayList;

public class Brincadeira {
    private static int geradorCodigo = 0;
    private int codigo;
    private String nome;
    private int cansaco;
    private int fome;
    private int sede;
    private int sujeira;
    private int divertimento;
    public Brincadeira(String nome,
                       int cansaco,
                       int fome,
                       int sede,
                       int sujeira,
                       int divertimento){
        geradorCodigo++;
        this.codigo = geradorCodigo;
        this.nome = nome;
        this.cansaco = cansaco;
        this.divertimento = divertimento;
        this.sede = sede;
        this.fome = fome;
        this.sujeira = sujeira;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCansaco() {
        return cansaco;
    }

    public int getFome() {
        return fome;
    }

    public int getSede() {
        return sede;
    }

    public int getSujeira() {
        return sujeira;
    }

    public int getDivertimento() {
        return divertimento;
    }

}