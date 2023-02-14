package musicband.command;

/**
 * Интерфейс, отвечающий за удаление элемента из коллекции по его id
 */
public interface RemoveByIdCommand {
    /**
     * Этот метод осуществляет удаление элемента из коллекции по его id, переданного через конструктор
     */
    String removeById();
}