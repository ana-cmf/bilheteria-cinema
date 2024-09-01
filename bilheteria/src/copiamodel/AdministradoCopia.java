package copiamodel;

public class AdministradoCopia {
private static AdministradoCopia instancia;
    private String nomeUsuario;
    private String senha;

    public static AdministradoCopia getInstancia(){
      if(instancia ==null){
        instancia = new AdministradoCopia();
        }
        return instancia;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws SenhaInvalidaException{
        if(senha.length()<6){
            throw new SenhaInvalidaException();
        }
        this.senha = senha;
        }
}
