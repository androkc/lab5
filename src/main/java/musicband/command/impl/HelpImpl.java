package musicband.command.impl;

import musicband.command.HelpCommand;
import musicband.control.enumcommands.EnumCommands;

/**
 * Имплементированный класс, отвечающий за вывод справки по доступным командам
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class HelpImpl implements HelpCommand {
    /**
     * Этот метод выводит справку о существующих командах для использования пользователем
     *
     * @return Возвращает строку Success
     */
    @Override
    public String help() {
        for (EnumCommands e : EnumCommands.values()) {
            System.out.println(e.getAbbreviation() + ": " + e.getInfo());
        }
        return "Success";
    }
}