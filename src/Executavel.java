import java.util.Scanner;

public class Executavel {

    private static Scanner sc = new Scanner(System.in);
    private static Pessoa usuarioLogado;

    public static void main(String[] args) {
        cadastrarPets();
        cadastrarUsuarios();
        do {
            menuGerencial();
            int opcaoGerencial = sc.nextInt();
            executarAcaoGerencial(opcaoGerencial);
            while (usuarioLogado != null) {
                abrirMenuOpcoes();
                int opcao = sc.nextInt();
                executarAcao(opcao);
            }
        } while (true);
    }

    private static void executarAcaoGerencial (int opcao) {
        switch (opcao) {
            case 1 -> usuarioLogado = login();
            case 2 -> cadastroPet();
            case 3 -> cadastroPessoa();
            case 4 -> removerPet();
            case 5 -> removerPessoa();
            case 6 -> System.exit(0);
        }
    }

    private static void cadastroPet () {
        System.out.println("Nome: ");
        String nome = sc.next();
        Pet pet = new Pet (nome);
        Banco.cadastrarPet(pet);
    }

    private static void cadastroPessoa () {
        System.out.println("CPF: ");
        long cpf = sc.nextLong();
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        Pessoa pessoa = new Pessoa(cpf, nome, senha);
        Banco.cadastrarPessoa(pessoa);
    }

    private static void removerPet() {
        System.out.println(Banco.getPets());
        int petEscolhido = sc.nextInt();
        Pet pet = Banco.procurarPet(petEscolhido);
        Banco.removerPet(pet);
    }

    private static void removerPessoa() {
        System.out.println(Banco.getPessoas());
        int pessoaEscolhida = sc.nextInt();
        Pessoa pessoa = Banco.procurarPessoa(pessoaEscolhida);
        Banco.removerPessoa(pessoa);
    }

    private static void menuGerencial(){
        System.out.println("" +
                "1 - Login\n" +
                "2 - Cadastrar Pet\n" +
                "3 - Cadastrar Pessoa\n" +
                "4 - Remover Pet\n" +
                "5 - Remover Pessoa\n" +
                "6 - Fechar aplicação\n");
    }

    private static void executarAcao(int opcao) {
        switch (opcao){
            case 1: {
                if (usuarioLogado.avaliarPet().equals("Sem pet")) {
                    mostrarPets();
                    int petEscolhido = sc.nextInt();
                    Pet pet = Banco.procurarPet(petEscolhido);
                    usuarioLogado.adotarPet(pet);
                    return;
                } else {
                    usuarioLogado.botarPetParaDormir();
                    break;
                }
            }
            case 2: {
                if (usuarioLogado.avaliarPet().equals("Sem pet")) {
                    usuarioLogado = null;
                    return;
                } else {
                    usuarioLogado.acordarPet();
                    break;
                }
            }
            case 3: {
                usuarioLogado.darAguaParaPet();
                break;
            }
            case 4: {
                mostrarBrincadeiras();
                int brincadeiraEscolhida = sc.nextInt();
                Brincadeira brincadeira = Banco.procurarBrincadeira(brincadeiraEscolhida);
                usuarioLogado.brincarComPet(brincadeira);
                break;
            }
            case 5: {
                mostrarAlimentos();
                int alimentoEscolhido = sc.nextInt();
                Alimento alimento = Banco.procurarAlimento(alimentoEscolhido);
                usuarioLogado.alimentarPet(alimento);
                break;
            }
            case 6: {
                usuarioLogado.levarPetParafazerNecessidades();
                break;
            }
            case 7: {
                usuarioLogado.limparPet();
                break;
            }

            case 8 : {
                usuarioLogado = null;
                break;
            }
            default:
                System.out.println("Opção inválida!");
            }
    }

    private static void mostrarAlimentos () {
        System.out.println(Banco.getAlimentos());
    }

    private static void mostrarBrincadeiras () {
        System.out.println(Banco.getBrincadeiras());
    }

    private static void mostrarPets () {
        System.out.println(Banco.getPets());
    }

    private static void abrirMenuOpcoes () {
        if (usuarioLogado.avaliarPet().equals("Sem pet")) {
            System.out.println("" +
                    "1 - Adotar Pet\n" +
                    "2 - Logout.\n");
        } else {
            System.out.println("" +
                    "1 - Colocar para dormir\n" +
                    "2 - Acordar\n" +
                    "3 - Dar água\n" +
                    "4 - Brincar\n" +
                    "5 - Alimentar\n" +
                    "6 - Levar para fazer necessidades\n" +
                    "7 - Limpar\n" +
                    "8 - Logout.\n");
        }
    }
    private static void cadastrarUsuarios(){
        for (int i = 1; i <= 5; i++) {
            Pessoa pessoa = new Pessoa(i, "senha"+ i, "Pessoa"+i);
            Banco.cadastrarPessoa(pessoa);
        }
    }

    private static void cadastrarPets(){
        for (int i = 1; i <= 5; i++) {
            Pet pet = new Pet("Pet" + i);
            Banco.cadastrarPet(pet);
        }
    }

    private static Pessoa login(){
        System.out.println("Digite o seu CPF: ");
        long cpf = sc.nextLong();
        System.out.println("Digite sua senha: ");
        String senha = sc.next();
        return Banco.login(cpf, senha);
    }

}