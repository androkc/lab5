package musicband.command.impl;

import musicband.Storage;
import musicband.command.NumberOfPerticipantsCommand;
import musicband.model.MusicBand;
import musicband.util.ReadLongParticipants;

/**
 * Имплементированный класс, отвечающий за вывод суммы значений поля numberOfParticipants для всех элементов коллекции
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class NumberOfparticipantsImpl implements NumberOfPerticipantsCommand {
    /**
     * Этот метод осуществляет вывод суммы значений поля numberOfParticipants для всех элементов коллекции
     *
     * @return Возвращает Success
     */
    @Override
    public String addNumberOfParticipants() {
        Long i = 0L;
        for (MusicBand e : Storage.getStorage()) {
            i = ReadLongParticipants.readLongParticipants(i) + ReadLongParticipants.readLongParticipants(e.getNumberOfParticipants());
        }
        System.out.println("Number of participants: " + i);
        return "Success";
    }
}