package model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "autores")
public class Autores implements Serializable {

    public Autores(){
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "apelidos", nullable = false, length = 100)
    private String apelido;

    @Column(name = "nacionalidade", length = 50)
    private String nacionalidad;


    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getApelido() {
        return apelido;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Autores(Long id, String nome, String apelido, String nacionalidad) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.nacionalidad = nacionalidad;
    }

    public Autores(String nome, String apelido, String nacionalidad) {
        this.nome = nome;
        this.apelido = apelido;
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }


}

