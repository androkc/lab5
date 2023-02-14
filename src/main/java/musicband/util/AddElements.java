package musicband.util;

import musicband.exceptions.WrongNameException;
import musicband.model.*;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс-помощник для класса addPerson and ReaderUtil, отвечающий за обработку вводимых данных
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class AddElements {
    /**
     * Этот метод осуществляет обработку строки
     *
     * @param scanner - строка
     * @return Возвращает e строка или рекурсия в случае ошибки
     */
    public String addString(Scanner scanner) {
        try {
            System.out.print("Введите строку: ");
            String e = readString(scanner);
            return e;
        } catch (WrongNameException e) {
            System.out.println("Uncorrected string. Only Latin,not an empty name or null. Try again. ");
            return addName(scanner);
        }
    }

    /**
     * Этот метод осуществляет обработку имени
     *
     * @param scanner - имя
     * @return Возвращает e имя или рекурсия в случае ошибки
     */
    public String addName(Scanner scanner) {
        try {
            System.out.print("Введите имя: ");
            String e = readString(scanner);
            return e;
        } catch (WrongNameException e) {
            System.out.println("Uncorrected name. Only Latin,not an empty name or null. Try again. ");
            return addName(scanner);
        }
    }

    /**
     * Этот метод осуществляет обработку цвета
     *
     * @param scanner - цвет
     * @return Возвращает color цвет
     */
    public Color addColor(Scanner scanner) {
        String col = scanner.nextLine();
        Color color = Color.checkAbbreviationColor(col);
        return color;
    }

    /**
     * Этот метод осуществляет обработку ZonedDateTime
     *
     * @param scanner- год,месяц,день
     * @return Возвращает ZonedDateTime или null, или рекурсия в случае ошибки
     */
    public ZonedDateTime addZonedDateTime(Scanner scanner) {
        String mainlandAndTimeZone = "Europe/Moscow";
        try {
            System.out.print("Year. ");
            int year = readInt(scanner);
            System.out.print("Month. ");
            int month = readInt(scanner);
            System.out.print("Day. ");
            int day = readInt(scanner);
            if (year == 0) {
                return null;
            } else if (year > 1920) {
                return ZonedDateTime.of(year, month, day, 0, 0, 0, 0, ZoneId.of(mainlandAndTimeZone));
            } else {
                System.out.println("Uncorrected date. Try again: ");
                return addZonedDateTime(scanner);
            }
        } catch (DateTimeException dateTimeException) {
            System.out.println("Uncorrected date. Try again.");
            return addZonedDateTime(scanner);
        }
    }

    /**
     * Этот метод осуществляет обработку веса
     *
     * @param scanner - вес
     * @return Возвращает int e или рекурсия в случае ошибки
     */
    public int addWeight(Scanner scanner) {
        System.out.print("Введите вес.");
        int e = readInt(scanner);
        if (e > 0) {
            return e;
        } else {
            System.out.println("Weight должен быть больше 0. Попробуйте заново: ");
            return addWeight(scanner);
        }
    }

    /**
     * Этот метод осуществляет обработку Person
     *
     * @param name          - имя
     * @param zonedDateTime - дата рождения
     * @param weight        - вес
     * @param color         - цвет
     * @return Возвращает person
     */
    public Person addPerson(String name, ZonedDateTime zonedDateTime, int weight, Color color) {
        Person person = new Person(name, zonedDateTime, weight, color);
        System.out.println("Создан person: " + person);
        return person;
    }

    /**
     * Этот метод осуществляет обработку Musicband
     *
     * @param name       - имя
     * @param x,y        - координаты
     * @param musicGenre - жанр
     * @param person     - человек
     * @return Возвращает musicBand
     */
    public MusicBand addMusicband(String name, Long x, Long y, Long particapents, MusicGenre musicGenre, Person person) {
        MusicBand musicBand = new MusicBand(name, new Coordinates(x, y), LocalDateTime.now(), particapents, musicGenre, person);
        System.out.println("Создан musicband: " + musicBand);
        return musicBand;
    }

    /**
     * Этот метод осуществляет обработку Coordinates
     *
     * @param scanner - координаты
     * @return Возвращает Long [] coordinates или рекурсия в случае ошибки
     */
    public Long[] addCoordinates(Scanner scanner) {
        System.out.println("Введите x.");
        Long x = readLong(scanner);
        System.out.println("Введите y.");
        Long y = readLong(scanner);
        if ((x > 707) && (y > -776)) {
            Long[] coordinates = {x, y};
            return coordinates;
        } else {
            System.out.println("x>707 and y>-776! Заново. ");
            return addCoordinates(scanner);
        }
    }

    /**
     * Этот метод осуществляет обработку Particapents
     *
     * @param scanner - участники, число
     * @return Возвращает е или рекурсия в случае ошибки
     */
    public Long addParticapents(Scanner scanner) {
        Long e = readLong(scanner);
        if (e > 0) {
            return e;
        } else if (e == 0) {
            return null;
        } else {
            System.out.println("Participants should be >0 or null! Заново. ");
            return addParticapents(scanner);
        }
    }

    /**
     * Этот метод осуществляет обработку жанра
     *
     * @param scanner - жанр
     * @return Возвращает musicGenre жанр
     */
    public MusicGenre addMusicGenre(Scanner scanner) {
        String musicgenre = scanner.nextLine();
        MusicGenre musicGenre = MusicGenre.checkAbbreviationGenre(musicgenre);
        return musicGenre;
    }

    /**
     * Этот метод осуществляет проверку int
     *
     * @param scanner - число
     * @return Возвращает number или рекурсия в случае ошибки
     */
    public int readInt(Scanner scanner) {
        try {
            System.out.print("Введите число: ");
            String i = scanner.nextLine();
            if (!i.isEmpty()) {
                int number = Integer.parseInt(i);
                return number;
            } else {
                System.out.print("Некорректное число! ");
                return readInt(scanner);
            }
        } catch (InputMismatchException y) {
            System.out.print("Введите число: ");
            return readInt(scanner);
        } catch (NumberFormatException y) {
            System.out.print("Некорректное число!");
            return readInt(scanner);
        }
    }

    /**
     * Этот метод осуществляет проверку Long
     *
     * @param scanner - число
     * @return Возвращает i или рекурсия в случае ошибки
     */
    public Long readLong(Scanner scanner) {
        try {
            System.out.print("Введите число: ");
            if (scanner.hasNextLine()) {
                Long i = Long.parseLong(scanner.nextLine());
                return i;
            } else {
                System.out.println("Введите число!");
                return readLong(scanner);
            }
        } catch (InputMismatchException y) {
            System.out.println("Введите число!");
            return readLong(scanner);
        } catch (NumberFormatException y) {
            System.out.print("Некорректное число!");
            return readLong(scanner);
        }
    }

    /**
     * Этот метод осуществляет проверку String
     *
     * @param scanner - строка
     * @return Возвращает name или выкидывает ошибку
     */
    public String readString(Scanner scanner) throws WrongNameException {
        String name = scanner.nextLine();
        if (name.matches("^[a-zA-Z]{0,19}$") && name != null && !name.trim().isEmpty()) {
            System.out.println("Correct name");
            return name;
        } else {
            throw new WrongNameException("Uncorrected name. Only Latin,not an empty name or null.");
        }
    }
}