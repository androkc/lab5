package musicband.command;

/**
 * Интерфейс, отвечающий удаление из коллекции всех элементов, меньшие, чем заданный
 */
public interface RemoveLowerCommand {
    /**
     * Этот метод осуществляет удаление из коллекции всех элементов, меньшие, чем заданный из конструктора
     */
    public String removeLower();
}