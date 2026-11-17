package service;

import config.HibernateConfig;
import model.Autores;
import org.hibernate.Session;

import javax.xml.parsers.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import java.io.*;

public class ServicioFile {

    public static void toXML(String nombreAutor) {
        String ruta = "autor.xml";
        XMLOutputFactory xof = XMLOutputFactory.newInstance();

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Autores autor = session.createQuery("FROM Autores WHERE nome = :nombre", Autores.class)
                    .setParameter("nombre", nombreAutor)
                    .uniqueResult();

            if (autor == null) {
                System.out.println("Non se atopou o autor para exportar a XML.");
                return;
            }

            FileWriter fw = new FileWriter(ruta);
            XMLStreamWriter xsw = xof.createXMLStreamWriter(fw);

            // Empezamos a escribir o documento XML
            xsw.writeStartDocument("UTF-8", "1.0");
            xsw.writeCharacters("\n");

            xsw.writeStartElement("autor");
            xsw.writeCharacters("\n\t");

            xsw.writeStartElement("id");
            xsw.writeCharacters(String.valueOf(autor.getId()));
            xsw.writeEndElement();
            xsw.writeCharacters("\n\t");

            xsw.writeStartElement("nome");
            xsw.writeCharacters(autor.getNome());
            xsw.writeEndElement();
            xsw.writeCharacters("\n\t");

            xsw.writeStartElement("apelido");
            xsw.writeCharacters(autor.getApelido());
            xsw.writeEndElement();
            xsw.writeCharacters("\n\t");

            xsw.writeStartElement("nacionalidade");
            xsw.writeCharacters(autor.getNacionalidad() != null ? autor.getNacionalidad() : "");
            xsw.writeEndElement();
            xsw.writeCharacters("\n");

            xsw.writeEndElement(); // Fin de autor
            xsw.writeEndDocument();

            xsw.flush();
            xsw.close();
            fw.close();

            System.out.println("Autor exportado correctamente a " + ruta);

        } catch (Exception e) {
            System.out.println("Erro ao exportar a XML: " + e.getMessage());
        }
    }

    public static void updateFromTXT() {
        String ruta = "datos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String autorActual = br.readLine();
            String protagonistaActual = br.readLine();

            if (autorActual != null && !autorActual.isEmpty()) {
                ServicioAutor.updateAutor(autorActual.trim(), "Satan Leee");
            }

            if (protagonistaActual != null && !protagonistaActual.isEmpty()) {
                ServicioProtagonista.updateProtagonista(protagonistaActual.trim(), "Spooder-Mon");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al leer ficheiro " + ruta + e.getMessage(), e);
        }
    }
}