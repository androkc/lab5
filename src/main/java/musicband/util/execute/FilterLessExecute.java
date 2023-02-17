package musicband.util.execute;

import lombok.AllArgsConstructor;

import java.util.ArrayList;

/**
 * Класс-помощник для класса ExecuteScriptFileName, отвечающий за первоначальную обработку команды FilterLess
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@AllArgsConstructor
public class FilterLessExecute {
    private ArrayList<String> addCollection;

    /**
     * Этот метод осуществляет поиск команды и её условия
     *
     * @return Возвращает numberOfParticipants или -1L в случае ошибки
     */
    public Long filterLessExecute() {
        try {
            if (addCollection.indexOf("filter_less_than_number_of_participants") > -1) {
                CheckExecuteUtil checkExecuteUtil = new CheckExecuteUtil();
                Long numberOfParticipants = checkExecuteUtil.readLongParticipants(addCollection.get(1 + addCollection.indexOf("filter_less_than_number_of_participants")));
                if (numberOfParticipants > 0) {
                    return numberOfParticipants;
                } else {
                    System.out.println("numberOfParticipants всегда > 0 или null");
                    return -1L;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не хватает данных в файле! NumberOfParticipants всегда > null");
            return -1L;
        }
        return null;
    }
}