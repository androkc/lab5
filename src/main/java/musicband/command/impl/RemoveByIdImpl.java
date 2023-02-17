package musicband.command.impl;

import lombok.AllArgsConstructor;
import musicband.Storage;
import musicband.command.RemoveByIdCommand;
import musicband.model.MusicBand;

/**
 * Имплементированный класс, отвечающий за удаление элемента из коллекции по его id
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@AllArgsConstructor
public class RemoveByIdImpl implements RemoveByIdCommand {
    private int id;

    /**
     * Этот метод осуществляет удаление элемента из коллекции по его id, переданного через конструктор
     *
     * @return Возвращает Success
     */
    @Override
    public String removeById() {
        for (MusicBand e : Storage.getStorage()) {
            if (e.getId() == id) {
                Storage.getStorage().remove(e);
                break;
            }
        }
        System.out.println("Удален");
        return "Success";
    }

    /**
     * Этот метод осуществляет проверку коллекции есть ли искомый id
     *
     * @return Возвращает Good или null, если id не существует в коллекции
     */
    public String checkIDForRemove() {
        for (MusicBand e : Storage.getStorage()) {
            if (e.getId() == id) {
                return "Good";
            }
        }
        return null;
    }
}