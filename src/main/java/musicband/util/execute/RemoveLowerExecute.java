package musicband.util.execute;

import java.util.ArrayList;

/**
 * Класс-помощник для класса ExecuteScriptFileName, отвечающий за первоначальную обработку команды RemoveLower
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class RemoveLowerExecute {
    ArrayList<String> addCollection;

    public RemoveLowerExecute(ArrayList<String> addCollection) {
        this.addCollection = addCollection;
    }

    /**
     * Этот метод осуществляет поиск команды и её условия
     *
     * @return Возвращает id1 или 0 в случае ошибки
     */
    public int removeLowerID() {
        try {
            if (addCollection.indexOf("remove_lower") > -1) {
                CheckExecuteUtil checkExecuteUtil = new CheckExecuteUtil();
                int id1 = checkExecuteUtil.readInt(addCollection.get(1 + addCollection.indexOf("remove_lower")));
                if (id1 > 0) {
                    return id1;
                } else {
                    System.out.println("ID должен быть корректным числом и больше 0! Проверьте файл");
                    return 0;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не хватает данных в файле!");
            return 0;
        }
        return 0;
    }
}