package musicband.command;
/**
 * Интерфейс, отвечающий за добавление нового элемента в коллекцию
 */
public interface AddMusicbandCommand {
    /**
     * Этот метод осуществляет сохранение в Treeset<Musicband>, находящейся в классе Storage, элемента переданного через конструктор
     */
    String addMusicband();
}