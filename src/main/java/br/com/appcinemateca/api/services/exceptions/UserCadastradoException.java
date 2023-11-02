package br.com.appcinemateca.api.services.exceptions;

public class UserCadastradoException extends RuntimeException {

    public UserCadastradoException( String login ){
        super("Usuário já cadastrado para o login " + login);
    }

}
