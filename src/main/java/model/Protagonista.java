package model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "protagonista")
public class Protagonista implements Serializable {

    public Protagonista(){
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "poder", length = 200)
    private String poder;



    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getPoder() {
        return poder;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPoder(String poder) {
        this.poder = poder;
    }

    public Protagonista(Long id, String nome, String poder) {
        this.id = id;
        this.nome = nome;
        this.poder = poder;
    }

    public Protagonista(String nome, String poder) {
        this.nome = nome;
        this.poder = poder;
    }

    @Override
    public String toString() {
        return "Protagonista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", poder='" + poder + '\'' +
                '}';
    }


}
