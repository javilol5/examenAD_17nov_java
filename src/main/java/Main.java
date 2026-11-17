import service.ServicioAutor;

import model.Autores;
import model.Comics;
import model.Protagonista;
import service.ServicioAutor;
import service.ServicioProtagonista;
import service.ServicioComic;

import static service.ServicioAutor.*;
import static service.ServicioComic.*;
import static service.ServicioProtagonista.*;
import static service.ServicioFile.*;

public class Main {

    public static void main(String[] args) {

        //Insira os seguintes datos nas táboas: solo usando el creador de comics como objeto
        /*
        Autores:
        Stan, Lee, estadounidense.
        Alan, Moore, británica.
        Frank, Miller, estadounidense.
        Hergé, Remi, belga.

        Protagonistas:
        Spider-Man, superforza e axilidade.
        Batman, diñeiro.
        Superman, superforza e batSubvención.
        Wonder Woman, superforza e batSubvención.
        Tintín, intelixencia e capacidade de investigación.
        Daredevil, case tódo-los sentidos sobrehumanos.
        Comics:

        The Amazing Spider-Man, 1963, autor: Stan Lee, protagonista: Spider-Man.
        Batman: The Killing Joke, 1988, autor: Alan Moore, protagonista: Batman.
        Superman: The Man of Steel, 1986, autor: Frank Miller, protagonista: Superman.
        Wonder Woman: Gods and Mortals, 1987, autor: Alan Moore, protagonista: Wonder
        Woman.
        The Adventures of Tintin, 1929, autor: Hergé Remi, protagonista: Tintín.
        Daredevil: Born Again, 1986, autor: Stan Lee, protagonista: Daredevil.
        Batman: Year One, 1987, autor: Frank Miller, protagonista: Batman.
        Spider-Man: Blue, 2002, autor: Stan Lee, protagonista: Spider-Man.
        */

        createComic(new Comics("The Amazing Spider-Man", 1963, 1, 1));
        createComic(new Comics("Batman: The Killing Joke", 1988, 2, 2));
        createComic(new Comics("Superman: The Man of Steel", 1986, 3, 3));
        createComic(new Comics("Wonder Woman: Gods and Mortals", 1987, 2, 4));
        createComic(new Comics("The Adventures of Tintin", 1929, 4, 5));
        createComic(new Comics("Daredevil: Born Again", 1986, 1, 6));
        createComic(new Comics("Batman: Year One", 1987, 3, 2));
        createComic(new Comics("Spider-Man: Blue", 2002, 1, 1));

        //Liste os contidos das táboas seguindo o seguinte formato:
        /*
        Autor:
        nome + apelido
        Comics: (para cada comic do autor)
            nomeComic + (anoComic)
            Protagonista: nomeProtagonista + poder: poderProtagonista
        */

        readComics();

        //[Recu Ficheiros] Lee o nome do autor a actualizar do ficheiro “datos”
        //Actualice o autor “Stan Lee” para que se chame Satan Leee

        updateFromTXT();

        //[Recu xml] exporta a xml os datos do autor que actualizaches en DB


        toXML("Satan Leee");

        //[Recu Ficheiros] o nome do protagonista é a segunda liña do ficheiro “datos”
        //Actualice o protagonista “Spider-Man” para que se chame Spooder-Mon

        updateFromTXT();

        //Liste os contidos das táboas actualizadas seguindo o formato anteriormente definido

        readComics();

        //Borre o contido de tóda-las táboas

        deleteAutor(1L);
        deleteAutor(2L);
        deleteAutor(3L);
        deleteAutor(4L);

        deleteProtagonista(1L);
        deleteProtagonista(2L);
        deleteProtagonista(3L);
        deleteProtagonista(4L);
        deleteProtagonista(5L);
        deleteProtagonista(6L);

        deleteComic(1L);
        deleteComic(2L);
        deleteComic(3L);
        deleteComic(4L);
        deleteComic(5L);
        deleteComic(6L);
        deleteComic(7L);
        deleteComic(8L);

        //Liste o contido de tóda-las táboas (debería ser vacío)

        readComics();

    }

}











