package modelo;

public class UsuarioDTO {
	
	private int documneto;
	private String nomusuario;
	private String clave;
	private String rol;
	private String estado;
	public UsuarioDTO(int documneto, String nomusuario, String clave, String rol, String estado) {
		super();
		this.documneto = documneto;
		this.nomusuario = nomusuario;
		this.clave = clave;
		this.rol = rol;
		this.estado = estado;
	}
	
	
	
	
	public UsuarioDTO(int documneto) {
		
		this.documneto = documneto;
	}




	public int getDocumneto() {
		return documneto;
	}
	public void setDocumneto(int documneto) {
		this.documneto = documneto;
	}
	public String getNomusuario() {
		return nomusuario;
	}
	public void setNomusuario(String nomusuario) {
		this.nomusuario = nomusuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}
