package br.com.fiap.bean;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;

@Named
@RequestScoped 
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	
	public void cadastrar() {
		new UsuarioDAO().create(this.usuario);
		System.out.println(this.usuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Cadastrado!"));
		
	}

	
	public void remover(Long id) {
		new UsuarioDAO().delete(id);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Excluido!"));
		
	}
	
	
	
	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		boolean exist = new UsuarioDAO().exist(usuario);
		
		if (exist) {
			context.getExternalContext().getSessionMap().put("usuario", usuario);
			return "index?faces-redirect=true";
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login inválido","Erro"));

		return "login?faces-redirect=true";
	}
	
	public String logout() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.remove("usuario");
		return "login?faces-redirect=true";
		
	}
	
	
	public List<Usuario> getUsuarios(){
		return new UsuarioDAO().getAll();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
