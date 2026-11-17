package model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "comic")
public class Comics implements Serializable {

    public Comics(){
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "id autor", nullable = false)
    private Integer id_autor;

    @Column(name = "id protagonista", nullable = false)
    private Integer id_protagonista;

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public Integer getAno() {
        return ano;
    }
    public Integer getId_autor() {
        return id_autor;
    }
    public Integer getId_protagonista() {
        return id_protagonista;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public void setId_autor(Integer idAutor) {
        this.id_autor = id_autor;
    }
    public void setId_protagonista(Integer idProtagonista) {
        this.id_protagonista = id_protagonista;
    }


    public Comics(Long id, String titulo, Integer ano, Integer id_autor, Integer id_protagonista) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.id_autor = id_autor;
        this.id_protagonista = id_protagonista;
    }

    public Comics(String titulo, Integer ano, Integer id_autor, Integer id_protagonista) {
        this.titulo = titulo;
        this.ano = ano;
        this.id_autor = id_autor;
        this.id_protagonista = id_protagonista;
    }

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", ano=" + ano +
                ", id_autor=" + id_autor +
                ", id_protagonista=" + id_protagonista +
                '}';
    }

}
