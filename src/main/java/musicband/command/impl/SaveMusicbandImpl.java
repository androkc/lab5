package musicband.command.impl;

import musicband.Storage;
import musicband.command.SaveMusicbandCommand;
import musicband.util.XmlUtil;

/**
 * Имплементированный класс, отвечающий за сохранение Storage в файл
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class SaveMusicbandImpl implements SaveMusicbandCommand {
    private static final String STORAGE_MUSICBAND = System.getenv("STORAGE_MUSICBAND");

    /**
     * Этот метод осуществляет сохранение Treeset<Musicband> в файл путем конвертирования в xml формат
     *
     * @return Возвращает строку Saved
     */
    @Override
    public String saveMusicband() {
        XmlUtil.convertToXML(Storage.getStorage(), STORAGE_MUSICBAND);
        return "Saved";
    }
}