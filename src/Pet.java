import java.lang.reflect.Field;

public class Pet {
    private static int geradorCodigo;
    private int sede;
    private int fome;
    private int codigo;
    private String nome;
    private int vontadeBanheiro;
    private int higiene;
    private boolean acordado;
    private int energia;
    private boolean vivo;
    private int diversao;
    public Pet(String nome){
        this.nome = nome; //Sempre que for passar alguma informação utilizar o this para diferenciar dele mesmo!
        //Sendo assim o nome de todos os pets não serão iguais
    }

    public void beberAgua(){
        aumentarIndiceSede(50);
        diminuirIndiceVontadeBanheiro(25);
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void limpar(){
        this.higiene = 100;
    }

    public void fazerNecessidades(){
        this.vontadeBanheiro = 100;
        diminuirIndiceHigiene(25);
    }

    public void brincar(Brincadeira brincadeira){

        aumentarIndice("diversao",
                brincadeira.getDivertimento());
        diminuirIndice("energia",
                brincadeira.getCansaco());
        diminuirIndice("fome",
                brincadeira.getFome());
        diminuirIndice("sede",
                brincadeira.getSede());
        diminuirIndice("higiene",
                brincadeira.getSujeira());
//        aumentarIndiceDiversao(
//                brincadeira.getDivertimento());
//        diminuirIndiceEnergia(
//                brincadeira.getCansaco());
//        diminuirIndiceFome(
//                brincadeira.getFome());
//        diminuirIndiceSede(
//                brincadeira.getSede());
//        diminuirIndiceHigiene(
//                brincadeira.getSujeira());
        morrer();
    }

    public void morrer(){
        if ((this.fome <= 0 || this.sede <= 0 || this.energia <= 0 )
                && this.vivo){
            this.vivo = false;
        }

    }

    public void acordar(){
        this.acordado= true;
        aumentarIndiceEnergia(25);
    }

    public void dormir(){
        this.acordado = false;
        aumentarIndiceEnergia(25);
    }

    public void comer(Alimento alimento){
        aumentarIndiceFome(
                alimento.getNutricao());
        diminuirIndiceVontadeBanheiro(
                alimento.getNutricao()/2);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "sede=" + sede +
                ", fome=" + fome +
                ", codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", vomtadeBanheiro=" + vontadeBanheiro +
                ", higiene=" + higiene +
                ", acordado=" + acordado +
                ", energia=" + energia +
                ", vivo=" + vivo +
                ", diversao=" + diversao +
                '}';
    }

    private void aumentarIndice(String nomeAtributo, int valor) {
        try {
            Field atributo = Pet.class.getField(nomeAtributo);
            atributo.setAccessible(true);
            int valorAtual = (int) atributo.get(this);
            if (100 < valorAtual + valor) {
                valorAtual = 100;
            } else {
                valorAtual += valor;
            }

            atributo.set(this, valorAtual);


        } catch (NoSuchFieldException |
                IllegalAccessException e) {
            System.out.println("Deu ruim!");
        }
    }

    private void diminuirIndice(String nomeAtributo, int valor) {
        try {
            Field atributo = Pet.class.getField(nomeAtributo);
            atributo.setAccessible(true);
            int valorAtual = (int) atributo.get(this);
            if (0 > valorAtual - valor) {
                valorAtual = 0;
            } else {
                valorAtual -= valor;
            }

            atributo.set(this, valorAtual);

            if (nomeAtributo.equals("vontadeBanheiro")){
                validaNecessidades();
            }

        } catch (NoSuchFieldException |
                 IllegalAccessException e) {
            System.out.println("Deu ruim!");
        }
    }

    private void aumentarIndiceSede (int sede) {
        if (100 < this.sede + sede){
            this.sede = 100;
        } else {
            this.sede+=sede;
        }
    }

    private void aumentarIndiceFome (int fome) {
        if (100 < this.fome + fome){
            this.fome = 100;
        } else {
            this.fome+=fome;
        }
    }


    private void aumentarIndiceEnergia (int energia) {
        if (100 < this.energia + energia){
            this.energia = 100;
        } else {
            this.energia+=energia;
        }
    }

    private void aumentarIndiceDiversao (int diversao) {
        if (100 < this.diversao + diversao){
            this.diversao = 100;
        } else {
            this.diversao+=diversao;
        }
    }

    private void diminuirIndiceVontadeBanheiro(int vontadeBanheiro){
        if (this.vontadeBanheiro - vontadeBanheiro < 0){
            this.vontadeBanheiro = 0;
        } else {
            this.vontadeBanheiro -= vontadeBanheiro;
        }
        validaNecessidades();
    }

    private void diminuirIndiceHigiene(int higiene){
        if (this.higiene - higiene < 0){
            this.higiene = 0;
        } else {
            this.higiene -= higiene;
        }
    }

    private void diminuirIndiceEnergia(int energia){
        if (this.energia - energia < 0){
            this.energia = 0;
        } else {
            this.energia -= energia;
        }
    }

    private void diminuirIndiceFome(int fome){
        if (this.fome - fome < 0){
            this.fome = 0;
        } else {
            this.fome -= fome;
        }
    }

    private void diminuirIndiceSede(int sede){
        if (this.sede - sede < 0){
            this.sede = 0;
        } else {
            this.sede -= sede;
        }
    }

    private void validaNecessidades (){
        if(this.vontadeBanheiro == 0){
            this.higiene = 0;
            this.vontadeBanheiro = 100;
        }
    }
}