package musicband.command;

/**
 * Интерфейс, отвечающий за вывод количество элементов, значение поля genre которых меньше заданного
 */
public interface CountLessThanGenreCommand {
    /**
     * Этот метод осуществляет пересортировку коллекции Treeset<Musicband> в коллекцию HashMap по жанрам и вывода строки, где количество элементов, значение поля genre которых меньше заданного
     */
    public String countLessThanGenre();
}