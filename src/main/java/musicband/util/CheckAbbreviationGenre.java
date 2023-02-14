package musicband.util;

import musicband.exceptions.WrongNameException;
import musicband.model.MusicGenre;

import java.util.Scanner;

/**
 * Класс-помощник для класса MusicGenre, отвечающий за создание проверку аббревиатуры с существующими жанрами
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class CheckAbbreviationGenre {
    /**
     * Этот метод осуществляет обработку и проверку жанра
     *
     * @param scanner - жанр
     * @return Возвращает genre или null, или рекурсия в случае ошибки
     */
    public String checkGenre(Scanner scanner) {
        try {
            System.out.print("Введите жанр: ");
            String genre = readGenre(scanner);
            MusicGenre musicGenre = MusicGenre.checkAbbreviationGenre(genre);
            if (musicGenre != null) {
                System.out.println("Correct genre");
                return genre;
            } else return null;
        } catch (WrongNameException e) {
            System.out.println("Only Latin,not an empty genre or null. Try again.");
            return checkGenre(scanner);
        }
    }

    /**
     * Этот метод осуществляет проверку строки для жанра
     *
     * @param scanner - жанр
     * @return Возвращает name или выкидывает ошибку
     */
    public String readGenre(Scanner scanner) throws WrongNameException {
        String name = scanner.nextLine();
        if (name.matches("^[a-zA-Z ]{0,50}$") && name != null && !name.trim().isEmpty()) {
            return name;
        } else {
            throw new WrongNameException("Uncorrected genre. Only Latin,not an empty genre or null.");
        }
    }

    /**
     * Этот метод осуществляет обработку и проверку жанра
     *
     * @param genre - жанр
     * @return Возвращает genre или null
     */
    public String checkGenreString(String genre) {
        MusicGenre musicGenre = MusicGenre.checkAbbreviationGenre(genre);
        if (musicGenre != null) {
            System.out.println("Correct genre");
            return genre;
        } else return null;
    }
}