package musicband.command;

/**
 * Интерфейс, отвечающий за сохранение Storage в файл
 */
public interface SaveMusicbandCommand {
    /**
     * Этот метод осуществляет сохранение Treeset<Musicband> в файл путем конвертирования в xml формат
     */
    String saveMusicband();
}