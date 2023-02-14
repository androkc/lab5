package musicband.util;

import musicband.model.*;

import java.util.Scanner;

/**
 * Класс-помощник, отвечающий за создание Musicband
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class ReaderUtil {
    /**
     * Этот метод осуществляет обработку Musicband
     *
     * @param scanner - данные
     * @return Возвращает Musicband
     */
    public static MusicBand createMusicband(Scanner scanner) {
        AddElements add = new AddElements();
        AddPerson addPerson = new AddPerson(add);
        Person person = addPerson.createPerson(scanner);
        System.out.println("Musicband. ");
        String name1 = add.addName(scanner);
        Long[] xy = add.addCoordinates(scanner);
        System.out.println("Введите количество участников.");
        Long particapents = add.addParticapents(scanner);
        System.out.print("Music Genre: ");
        MusicGenre musicgenreadd = add.addMusicGenre(scanner);
        MusicBand musicBand = add.addMusicband(name1, xy[0], xy[1], particapents, musicgenreadd, person);
        return musicBand;
    }
}