package dto;

public class AdministradorDTO {
    private static AdministradorDTO instancia;
    private String nomeUsuario;
    private String senha;

    public static AdministradorDTO getInstancia(){
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
  
    public void setSenha(String senha) {
          this.senha = senha;
    }   
  }
