import java.util.InputMismatchException;

public class AtributoNaoEncontradoOuSemAcessoException extends RuntimeException {


    public AtributoNaoEncontradoOuSemAcessoException() {
        super("Ocorreu um erro, ou na leitura do atributo ou na atribuição de valor ao atributo.");
    }
}
