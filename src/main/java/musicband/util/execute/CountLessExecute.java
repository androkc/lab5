package musicband.util.execute;


import lombok.AllArgsConstructor;

import java.util.ArrayList;

/**
 * Класс-помощник для класса ExecuteScriptFileName, отвечающий за первоначальную обработку команды CountLess
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@AllArgsConstructor
public class CountLessExecute {
    ArrayList<String> addCollection;

    /**
     * Этот метод осуществляет поиск команды и её условия
     *
     * @return Возвращает str или null в случае ошибки
     */
    public String countLess() {
        try {
            if (addCollection.indexOf("count_less_than_genre") > -1) {
                CheckExecuteUtil checkExecuteUtil = new CheckExecuteUtil();
                String str = checkExecuteUtil.addGenre(addCollection.get(1 + addCollection.indexOf("count_less_than_genre")));
                if (str != null) {
                    return str;
                } else {
                    System.out.println("Genre должен быть корректным! Проверьте файл");
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