package musicband.command;

import java.util.ArrayList;

/**
 * Интерфейс, отвечающий за считывание скрипта из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 */
public interface ExecuteScriptFileNameCommand {
    /**
     * Этот метод считывает все строки в файле
     */
    ArrayList<String> executeScrpitFileName();
}