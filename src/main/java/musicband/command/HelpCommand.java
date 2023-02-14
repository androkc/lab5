package musicband.command;

/**
 * Интерфейс, отвечающий за вывод справки по доступным командам
 */
public interface HelpCommand {
    /**
     * Этот метод выводит справку о существующих командах для использования пользователем
     */
    public String help();
}