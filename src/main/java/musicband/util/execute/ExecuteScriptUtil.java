package musicband.util.execute;

import java.util.ArrayList;

/**
 * Класс-помощник для класса ExecuteScriptFileName, отвечающий за первоначальную обработку команды ExecuteScript
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class ExecuteScriptUtil {
    private ArrayList<String> addCollection;

    public ExecuteScriptUtil(ArrayList<String> addCollection) {
        this.addCollection = addCollection;
    }

    /**
     * Этот метод осуществляет поиск команды и её условия
     *
     * @return Возвращает path или null в случае ошибки
     */
    public String checkPath() {
        try {
            if (addCollection.indexOf("execute_script") > -1) {
                CheckExecuteUtil checkExecuteUtil = new CheckExecuteUtil();
                String path = checkExecuteUtil.addPath(addCollection.get(1 + addCollection.indexOf("execute_script")));
                if (path != null) {
                    return path;
                } else {
                    System.out.println("Переименуйте файл используя латиницу! Проверьте файл");
                    return null;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не хватает данных в файле!");
            return null;
        }
        return null;
    }
}