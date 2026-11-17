package service;

import config.HibernateConfig;
import model.Protagonista;
import org.hibernate.Session;

public class ServicioProtagonista {

    //UPDATE
    public static void updateProtagonista(String nombreActual, String nuevoNombre) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();

            Protagonista protagonista = session.createQuery("FROM Protagonista WHERE nome = :nombre", Protagonista.class)
                    .setParameter("nombre", nombreActual)
                    .uniqueResult();

            if (protagonista != null) {
                protagonista.setNome(nuevoNombre);
                session.update(protagonista);
                session.getTransaction().commit();
                System.out.println("Protagonista actualizado correctamente");
            } else {
                System.out.println("No se encuentra el protagonsita" + nombreActual);
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar protagonista" + e.getMessage());
        }
    }

    //DELETE
    public static void deleteProtagonista(Long id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Protagonista protagonista = session.get(Protagonista.class, id);
            if (protagonista != null) {
                session.delete(protagonista);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar protagonistas" + e.getMessage());
        }
    }


}
