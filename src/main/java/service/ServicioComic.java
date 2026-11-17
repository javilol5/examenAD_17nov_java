package service;

import config.HibernateConfig;
import model.Comics;
import org.hibernate.Session;

import java.util.ArrayList;

public class ServicioComic {

    //CREATE
    public static void createComic(Comics comics) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(comics);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al crear comic" + e.getMessage());
        }
    }

    //READ
    public static ArrayList<Comics> readComics() {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (ArrayList<Comics>) session.createQuery("from Comics", Comics.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error al leer comics" + e.getMessage());
            return null;
        }
    }

    //DELETE
    public static void deleteComic(Long id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Comics comics = session.get(Comics.class, id);
            if (comics != null) {
                session.delete(comics);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar comics" + e.getMessage());
        }
    }

}