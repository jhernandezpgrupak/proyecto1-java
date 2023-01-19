package view;

import controllers.UsuarioController;

public class UsuarioView {

	public static void main(String[] args) {
		//Se llama el metodo que necesitmos...
		// TODO Auto-generated method stub
		//String usuario  = new UsuarioController().createUsuario("Toluca", "jhernandezp@grupak.com.mx", "Alberto Hernández");
		//String usuario  = new UsuarioController().updateUsuario(3,"Ciudad de México", "N/A", "Alberto");
		//String usuario  = new UsuarioController().deleteUsuario(2);
		String usuario  = new UsuarioController().getUsuario(3);
		System.out.println(usuario);
	}

}
