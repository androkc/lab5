package musicband.util;

/**
 * Класс-помощник для класса CommandOperator, отвечающий за подгрузку Storage
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class LoadingStorage {
    private static final String STORAGE_MUSICBAND = System.getenv("STORAGE_MUSICBAND");

    /**
     * Этот метод осуществляет расконвертирование TreeSet<MusicBand> из файла
     *
     * @return Возвращает Success
     */
    public String loadStorage() {
        XmlUtil.unconvert(STORAGE_MUSICBAND);
        return "Success";
    }
}