package musicband.control.enumcommands;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Класс ENUM, в котором созданы команды, используемые пользователем в интерактивном режиме
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@Getter
@AllArgsConstructor
public enum EnumCommands {
    SHOW("show", "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении."),
    INFO("info", "Вывести в стандартный поток вывода информацию о коллекции."),
    ADD("add", "Добавить новый элемент в коллекцию."),
    SAVE("save", "Сохранить коллекцию в файл."),
    UPDATE_ID("update_id", "Обновить значение элемента коллекции, id которого равен заданному."),
    REMOVE("remove", "Удалить элемент из коллекции по его id."),
    CLEAR("clear", "Очистить коллекцию."),
    EXIT("exit", "Завершить программу (без сохранения в файл)."),
    SUM_OF_NUMBER_OF_PARTICIPANTS("sum_of_number_of_participants", "Вывести сумму значений поля numberOfParticipants для всех элементов коллекции."),
    ADD_IF_MIN("add_if_min", "Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции."),
    REMOVE_GREATER("remove_greater", "Удалить из коллекции все элементы, превышающие заданный."),
    REMOVE_LOWER("remove_lower", "Удалить из коллекции все элементы, меньшие, чем заданный."),
    COUNT_LESS_THAN_GENRE("count_less_than_genre", "Вывести количество элементов, значение поля genre которых меньше заданного."),
    FILTER_LESS_THAN_NUMBER_OF_PARTICIPANTS("filter_less_than_number_of_participants", "Вывести элементы, значение поля numberOfParticipants которых меньше заданного."),
    HELP("help", "Вывести справку по доступным командам."),
    EXECUTE_SCRIPT("execute_script", "Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");

    private String abbreviation;
    private String info;

    /**
     * Этот метод сравнивает принимаемый в параметрах String с аббревиатурой команды класса EnumCommands
     *
     * @param e Это строка, которая должна совпадать с аббревиатурой команды
     * @return Возвращает EnumCommands b или null, если принимаемый String e не совпадает ни с одной аббревиатурой существующих команд
     */
    public static EnumCommands checkAbbreviation(String e) {
        for (EnumCommands b : EnumCommands.values()) {
            if (b.abbreviation.equalsIgnoreCase(e)) {
                return b;
            }
        }
        return null;
    }
}