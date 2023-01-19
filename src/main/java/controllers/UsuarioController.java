package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Usuario;

public class UsuarioController {

	public String createUsuario(String direccion, String email, String nombre) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			Usuario usuario = new Usuario(direccion, email, nombre);
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
			session.close();
			return "Usuario creado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar crear el usuario";
	}

	public String updateUsuario(int id, String direccion, String email, String nombre) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			Usuario usuario = session.get(Usuario.class, id);
			usuario.setDireccion(direccion);
			usuario.setEmail(email);
			usuario.setNombre(nombre);
			session.beginTransaction();
			session.update(usuario);
			session.getTransaction().commit();
			session.close();
			return "Usuario actualizado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar actualizar el usuario";
	}

	public String deleteUsuario(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			Usuario usuario = session.get(Usuario.class, id);
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();
			session.close();
			return "Usuario eliminado correctamente";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar eliminar el usuario";
	}

	public String getUsuario(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, id);
			session.getTransaction().commit();
			session.close();
			return usuario.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "No se encontró el usuario";
	}
}
