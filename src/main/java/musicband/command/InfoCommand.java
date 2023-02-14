package musicband.command;

/**
 * Интерфейс, отвечающий за вывод в стандартный поток информации о коллекции
 */
public interface InfoCommand {
    /**
     * Этот метод выводит справку о существующий вывод в стандартный поток информации о коллекции
     */
    String info(String path);
}