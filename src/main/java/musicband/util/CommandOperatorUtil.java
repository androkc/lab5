package musicband.util;

import lombok.NoArgsConstructor;
import musicband.exceptions.WrongNameException;

import java.util.Scanner;

/**
 * Класс-помощник для класса CommandOperator, отвечающий за проверку команд
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@NoArgsConstructor
public class CommandOperatorUtil {

    /**
     * Этот метод осуществляет проверку строки для команды
     *
     * @param scanner - команда
     * @return Возвращает name или выкидывает ошибку
     */
    public String readCommand(Scanner scanner) throws WrongNameException {
        String name = scanner.nextLine();
        if (name.matches("^[a-zA-Z_]{0,50}$") && name != null && !name.trim().isEmpty()) {
            return name;
        } else {
            throw new WrongNameException("Uncorrected command. Only Latin,not an empty command or null. Try again. ");
        }
    }

    /**
     * Этот метод осуществляет обработку команды
     *
     * @param scanner - команда
     * @return Возвращает e или рекурсия в случае ошибки
     */
    public String addCommand(Scanner scanner) {
        try {
            String e = readCommand(scanner);
            return e;
        } catch (WrongNameException e) {
            System.out.print("Uncorrected command. Only Latin,not an empty command or null. Try again. Введите заново: ");
            return addCommand(scanner);
        }
    }
}