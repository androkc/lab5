package musicband.util.execute;

import musicband.exceptions.WrongNameException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;

/**
 * Класс-помощник для класса ExecuteScriptFileName, отвечающий за проверку данных из файла
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */

public class CheckExecuteUtil {
    /**
     * Этот метод осуществляет обработку имени
     *
     * @param name - имя
     * @return Возвращает e имя или null в случае ошибки
     */
    public String addName(String name) {
        try {
            String e = readString(name);
            return e;
        } catch (WrongNameException e) {
            System.out.println("Uncorrected name. Only Latin,not an empty name or null. Check file. ");
            return null;
        }
    }

    /**
     * Этот метод осуществляет проверку строки
     *
     * @param name - имя
     * @return Возвращает name или выкидывает ошибку
     */
    public String readString(String name) throws WrongNameException {
        if (name.matches("^[a-zA-Z ]{0,50}$") && name != null && !name.trim().isEmpty()) {
            return name;
        } else {
            throw new WrongNameException("Uncorrected name. Only Latin,not an empty name or null.");
        }
    }

    /**
     * Этот метод осуществляет обработку Participants
     *
     * @param str - число Participants
     * @return Возвращает e Long или null или -1L в случае некорректного для условия числа
     */
    public Long addParticapents(String str) {
        Long e = readLongParticipants(str);
        if (e > 0) {
            return e;
        } else if (e == null) {
            return null;
        } else {
            System.out.println("Participants should be >0 or null! Check file. ");
            return -1L;
        }
    }

    /**
     * Этот метод осуществляет проверку Long для Participants
     *
     * @param str - число Participants
     * @return Возвращает i Long или -1L в случае некорректного числа
     */
    public Long readLongParticipants(String str) {
        try {
            Long i = Long.parseLong(str);
            return i;
        } catch (InputMismatchException y) {
            System.out.print("Неверный Long! Проверьте число в файле! ");
            return -1L;
        } catch (NumberFormatException y) {
            System.out.print("Неверный Long! Проверьте число в файле! ");
            return -1L;
        }
    }

    /**
     * Этот метод осуществляет обработку Coordinates
     *
     * @param xx - координата по x
     * @param yy - координата по y
     * @return Возвращает Long [] или Long [] {null, null} в случае некорректных для условия чисел
     */
    public Long[] addCoordinates(String xx, String yy) {
        Long x = readLong(xx);
        Long y = readLong(yy);
        if (x == null || y == null) {
            System.out.println("Некорректные значения координат!");
            Long[] coordinates2 = {null, null};
            return coordinates2;
        } else if ((x > 707) && (y > -776)) {
            Long[] coordinates = {x, y};
            return coordinates;
        } else {
            System.out.println("x>707 and y>-776! Проверьте значения в файле. ");
            Long[] coordinates2 = {null, null};
            return coordinates2;
        }
    }

    /**
     * Этот метод осуществляет проверку Long
     *
     * @param str - число Long
     * @return Возвращает i Long или null в случае некорректного числа
     */
    public Long readLong(String str) {
        try {
            Long i = Long.parseLong(str);
            return i;
        } catch (InputMismatchException y) {
            System.out.print("Неверный Long! Проверьте число в файле! ");
            return null;
        } catch (NumberFormatException y) {
            System.out.print("Неверный Long! Проверьте число в файле! ");
            return null;
        }
    }

    /**
     * Этот метод осуществляет обработку ZonedDateTime
     *
     * @param year1  - год
     * @param month1 - месяц
     * @param day1   - день
     * @return Возвращает ZonedDateTime или null в случае некорректных для условия чисел
     */
    public ZonedDateTime addZonedDateTime(String year1, String month1, String day1) {
        String mainlandAndTimeZone = "Europe/Moscow";
        try {
            int year = readInt(year1);
            int month = readInt(month1);
            int day = readInt(day1);
            if (year == 0) {
                return null;
            } else if (year > 1920) {
                return ZonedDateTime.of(year, month, day, 0, 0, 0, 0, ZoneId.of(mainlandAndTimeZone));
            } else {
                System.out.println("Uncorrected date. Check File. Year>1920! ");
                return null;
            }
        } catch (DateTimeException dateTimeException) {
            System.out.println("Uncorrected date. Check File.");
            return null;
        }
    }

    /**
     * Этот метод осуществляет обработку веса
     *
     * @param weight - вес
     * @return Возвращает int e или 0 в случае некорректного для условия числа
     */
    public int addWeight(String weight) {
        int e = readInt(weight);
        if (e > 0) {
            return e;
        } else {
            System.out.println("Weight должен быть больше 0. Проверьте файл!");
            return 0;
        }
    }

    /**
     * Этот метод осуществляет проверку int
     *
     * @param integer - число
     * @return Возвращает number или 0 в случае некорректного для условия числа или ошибки
     */
    public int readInt(String integer) {
        try {
            if (!integer.isEmpty()) {
                int number = Integer.parseInt(integer);
                return number;
            } else {
                System.out.print("Некорректное число! ");
                return 0;
            }
        } catch (InputMismatchException y) {
            System.out.print("Некорректное int! Проверьте число в файле. ");
            return 0;
        } catch (NumberFormatException y) {
            System.out.print("Некорректное int! Проверьте число в файле. ");
            return 0;
        }
    }

    /**
     * Этот метод осуществляет обработку строки для жанра
     *
     * @param genre - жанр
     * @return Возвращает е жанр или null в случае некорректной для условия строки
     */
    public String addGenre(String genre) {
        try {
            String e = readGenre(genre);
            return e;
        } catch (WrongNameException e) {
            System.out.println("Uncorrected genre. Only Latin,not an empty genre or null. Check file. ");
            return null;
        }
    }

    /**
     * Этот метод осуществляет проверку строки для жанра
     *
     * @param name - имя жанра
     * @return Возвращает name или выкидывает ошибку
     */
    public String readGenre(String name) throws WrongNameException {
        if (name != null && name.matches("^[a-zA-Z ]{0,50}$") && !name.trim().isEmpty()) {
            return name;
        } else {
            throw new WrongNameException("Uncorrected name. Only Latin,not an empty name or null.");
        }
    }

    /**
     * Этот метод осуществляет проверку пути
     *
     * @param name - путь
     * @return Возвращает name или выкидывает ошибку
     */
    public String readPath(String name) throws WrongNameException {
        Path path = Paths.get(name);
        if (name != null && Files.exists(path) && !name.trim().isEmpty()) {
            return name;
        } else {
            throw new WrongNameException("Uncorrected name. Only Latin,not an empty name or null.");
        }
    }

    /**
     * Этот метод осуществляет обработку пути
     *
     * @param name - путь
     * @return Возвращает е путь или null в случае некорректной для условия строки
     */
    public String addPath(String name) {
        try {
            String e = readPath(name);
            return e;
        } catch (WrongNameException e) {
            System.out.println("Uncorrected path. Use Latin. Check file. ");
            return null;
        }

    }
}