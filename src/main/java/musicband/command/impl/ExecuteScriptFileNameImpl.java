package musicband.command.impl;

import musicband.command.ExecuteScriptFileNameCommand;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Имплементированный класс, отвечающий за считывание скрипта из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class ExecuteScriptFileNameImpl implements ExecuteScriptFileNameCommand {
    String path;

    public ExecuteScriptFileNameImpl(String path) {
        this.path = path;
    }

    /**
     * Этот метод считывает все строки в файле
     *
     * @return Возвращает ArrayList строк
     */
    @Override
    public ArrayList<String> executeScrpitFileName() {
        try (FileReader fileReader = new FileReader(path);
             Scanner scanner = new Scanner(fileReader)) {
            ArrayList<String> commands = new ArrayList<>();
            while (scanner.hasNextLine()) {
                commands.add(scanner.nextLine());
            }
            return commands;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}