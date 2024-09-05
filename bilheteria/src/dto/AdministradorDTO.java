package dto;

public class AdministradorDTO {
    private String nomeUsuario;
    private String senha;
    
  
    public AdministradorDTO(String nomeUsuario, String senha) {
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}
    public AdministradorDTO() {
    	
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