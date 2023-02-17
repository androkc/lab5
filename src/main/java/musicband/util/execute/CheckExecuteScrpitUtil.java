package musicband.util.execute;

import lombok.AllArgsConstructor;
import musicband.control.enumcommands.EnumCommands;

import java.util.ArrayList;

/**
 * Класс-помощник для класса ExecuteScriptFileName, отвечающий за проверку команд с переданными строками
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@AllArgsConstructor
public class CheckExecuteScrpitUtil {
    private ArrayList<String> commands;

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