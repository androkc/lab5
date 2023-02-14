package musicband.command.impl;

import musicband.Storage;
import musicband.command.UpdateIdCommand;
import musicband.model.MusicBand;

/**
 * Имплементированный класс, отвечающий обновление значения элемента коллекции, id которого равен заданному
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class UpdateIdImpl implements UpdateIdCommand {
    private MusicBand musicBand;
    private int id;

    public UpdateIdImpl(int id) {
        this.id = id;
    }

    public UpdateIdImpl(MusicBand musicBand, int id) {
        this.musicBand = musicBand;
        this.id = id;
    }

    /**
     * Этот метод осуществляет обновление значения элемента коллекции, id которого равен заданному в конструкторе
     *
     * @return Возвращает строку Success
     */
    @Override
    public String updateID() {
        for (MusicBand e : Storage.getStorage()) {
            if (e.getId() == id) {
                musicBand.setId(id);
                System.out.println(musicBand);
                Storage.getStorage().remove(e);
                break;
            }
        }
        Storage.getStorage().add(musicBand);
        System.out.println("Заменено");
        return "Success";
    }

    /**
     * Этот метод осуществляет проверку коллекции есть ли искомый id
     *
     * @return Возвращает Good или null, если id не существует в коллекции
     */
    public String checkID() {
        for (MusicBand e : Storage.getStorage()) {
            if (e.getId() == id) {
                return "Good";
            }
        }
        return null;
    }
}