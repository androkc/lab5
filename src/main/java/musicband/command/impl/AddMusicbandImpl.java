package musicband.command.impl;

import musicband.Storage;
import musicband.command.AddMusicbandCommand;
import musicband.model.MusicBand;

/**
 * Имплементированный класс, отвечающий за добавление нового элемента в коллекцию
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class AddMusicbandImpl implements AddMusicbandCommand {
    private MusicBand musicBand;

    public AddMusicbandImpl(MusicBand musicBand) {
        this.musicBand = musicBand;
    }

    /**
     * Этот метод осуществляет добавление в Treeset<Musicband>, находящейся в классе Storage, элемента переданного через конструктор
     *
     * @return Возвращает строку Succes
     */
    @Override
    public String addMusicband() {
        Storage.addStorage(musicBand);
        return "Success";
    }
}