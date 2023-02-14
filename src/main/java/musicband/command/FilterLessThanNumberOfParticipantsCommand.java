package musicband.command;

/**
 * Интерфейс, отвечающий за вывод элементов, значение поля numberOfParticipants которых меньше заданного
 */
public interface FilterLessThanNumberOfParticipantsCommand {
    /**
     * Этот метод осуществляет подсчет элементов значение поля numberOfParticipants которых меньше заданного
     */
    String filterLessThanNumberOfParticipants();
}