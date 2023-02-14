package musicband.exceptions;
/**
 * Класс Exception, в котором создана ошибка, используемая при вводе пользователем некорректного текстового формата строки
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class WrongNameException extends Exception{
    public WrongNameException(String message) {
        super(message);
    }
}
