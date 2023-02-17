package musicband.command.impl;

import lombok.AllArgsConstructor;
import musicband.Storage;
import musicband.command.AddIfMinCommand;
import musicband.model.MusicBand;

/**
 * Имплементированный класс, отвечающий за осуществление добавления нового элемента в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@AllArgsConstructor
public class AddIfMinImpl implements AddIfMinCommand {
    private int id;
    private MusicBand musicBand;

    public AddIfMinImpl(int id) {
        this.id = id;
    }

    /**
     * Этот метод осуществляет сохранение в Treeset<Musicband> , находящейся в классе Storage, минимального элемента
     *
     * @return Возвращает строку Succes
     */
    @Override
    public String addIfMin() {
        Storage.getStorage().add(musicBand);
        System.out.println("Min element added.");
        return "Succes";
    }

    /**
     * Этот метод осуществляет проверку элемента переданного через конструктор на min ID в Treeset<Musicband>, находящейся в классе Storage
     *
     * @return Возвращает строку Good или null, если элемент не минимальный
     */
    public String checkIDForMin() {
        if (Storage.getStorage().first().getId() > id) {
            return "Good";
        } else {
            return null;
        }
    }
}