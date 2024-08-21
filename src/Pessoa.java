public class Pessoa {

    private long cpf;
    private String senha;
    private String nome;

    private Pet pet; // associação entre objetos, atributo de objeto.
    // o objeto pessoa pode ter referencia/estar associado a um pet,
    // pode ter um pet, chamar, executar ações do objeto pet

    public Pessoa(long cpf, String senha, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
    }

    public void limparPet(){
        if (this.pet != null) {
            this.pet.limpar();
        }
    }

    public  void  botarPetParaDormir(){
        if (this.pet != null) {
            this.pet.dormir();
        }

    }
    public  void  acordarPet(){
        if (this.pet != null) {
            this.pet.acordar();
        }
    }

    public void adotarPet(Pet pet){ //como se fosse o setter de pet

        this.pet = pet; // o pet dele se torna o pet do parametro
    }
    public  void  darAguaParaPet(){
        if (this.pet != null) {
            this.pet.beberAgua();
        }
    }

    public void brincarComPet (Brincadeira brincadeira){
        if (this.pet != null){
            this.pet.brincar(brincadeira);
        }
    }

    public  String  avaliarPet(){
        if (this.pet != null){
            return pet.toString();
        }
        return"Sem pet";
    }

    public  void  alimentarPet(Alimento alimento){
        if (this.pet != null) {
            this.pet.comer(alimento);
        }
    }

    public  void  levarPetParafazerNecessidades(){
        if (this.pet != null) {
            this.pet.fazerNecessidades();
        }
    }

    public long getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "CPF: " + this.cpf +"\nSenha: " + senha + "\nNome: " + nome + "\nPet: " + avaliarPet();
    }
}