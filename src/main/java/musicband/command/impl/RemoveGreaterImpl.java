package musicband.command.impl;

import lombok.AllArgsConstructor;
import musicband.Storage;
import musicband.command.RemoveGreaterCommand;
import musicband.model.MusicBand;

import java.util.*;

/**
 * Имплементированный класс, отвечающий удаление из коллекции всех элементов, превышающих заданный
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@AllArgsConstructor
public class RemoveGreaterImpl implements RemoveGreaterCommand {
    private int id;

    /**
     * Этот метод осуществляет удаление из коллекции всех элементов, превышающих заданный из конструктора
     *
     * @return Возвращает Success
     */
    @Override
    public String removeGreater() {
        for (Iterator iterator = Storage.getStorage().iterator(); iterator.hasNext(); ) {
            MusicBand n = (MusicBand) iterator.next();
            if (n.getId() > id) {
                iterator.remove();
            }
        }
        System.out.println("Новая коллекция: " + Storage.getStorage());
        return "Success";
    }

    /**
     * Этот метод осуществляет проверку коллекции есть ли искомый id
     *
     * @return Возвращает Good или null, если id не существует в коллекции
     */
    public String checkIDForMin() {
        for (MusicBand e : Storage.getStorage()) {
            if (e.getId() == id) {
                return "Good";
            }
        }
        return null;
    }
}