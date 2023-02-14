package musicband.command.impl;

import musicband.command.ExitCommand;

/**
 * Имплементированный класс, отвечающий за закрытие программы
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class ExitImpl implements ExitCommand {
    /**
     * Этот метод закрывает программу
     *
     * @return Возвращает строку Succes
     */
    @Override
    public String exitProgramm() {
        System.out.println("The program is closed.");
        System.exit(0);
        return "Succes";
    }
}