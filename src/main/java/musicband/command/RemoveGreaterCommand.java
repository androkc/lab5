package musicband.command;

/**
 * Интерфейс, отвечающий удаление из коллекции всех элементов, превышающих заданный
 */
public interface RemoveGreaterCommand {
    /**
     * Этот метод осуществляет удаление из коллекции всех элементов, превышающих заданный из конструктора
     */
    String removeGreater();
}