package service;

import config.HibernateConfig;
import model.Autores;
import org.hibernate.Session;

public class ServicioAutor {

    //UPDATE
    public static void updateAutor(String nombreActual, String nuevoNombre) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();

            Autores autor = session.createQuery("FROM Autores WHERE nome = :nombre", Autores.class)
                    .setParameter("nombre", nombreActual)
                    .uniqueResult();

            if (autor != null) {
                autor.setNome(nuevoNombre);
                session.update(autor);
                session.getTransaction().commit();
                System.out.println("Autor actualizado correctamente.");
            } else {
                System.out.println("No se encontro el autor: " + nombreActual);
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el autor: " + e.getMessage());
        }
    }



    //DELETE
    public static void deleteAutor(Long id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Autores autores = session.get(Autores.class, id);
            if (autores != null) {
                session.delete(autores);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar autores" + e.getMessage());
        }
    }

}
