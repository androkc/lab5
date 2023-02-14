package musicband.util.execute;

import musicband.control.enumcommands.EnumCommands;

import java.util.ArrayList;

/**
 * Класс-помощник для класса ExecuteScriptFileName, отвечающий за проверку команд с переданными строками
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class CheckExecuteScrpitUtil {
    private ArrayList<String> commands;

    public CheckExecuteScrpitUtil(ArrayList<String> commands) {
        this.commands = commands;
    }

    /**
     * Этот метод осуществляет проверку переданных в ArrayList строк с существующими командами в EnumCommands
     *
     * @return Возвращает ArrayList команд
     */
    public ArrayList<String> checkExecuteSrpit() {
        ArrayList<String> commandsChecked = new ArrayList<>();
        for (String e : commands) {
            EnumCommands enumCommands = EnumCommands.checkAbbreviation(e);
            if (enumCommands != null) {
                commandsChecked.add(e);
            }
        }
        return commandsChecked;
    }
}