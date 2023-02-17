package musicband.command.impl;

import lombok.AllArgsConstructor;
import musicband.Storage;
import musicband.command.FilterLessThanNumberOfParticipantsCommand;
import musicband.model.MusicBand;

/**
 * Имплементированный класс, отвечающий за вывод элементов, значение поля numberOfParticipants которых меньше заданного
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@AllArgsConstructor
public class FilterLessThanNumberOfParticipantsImpl implements FilterLessThanNumberOfParticipantsCommand {
    private Long numberOfParticipants;


    /**
     * Этот метод осуществляет подсчет элементов значение поля numberOfParticipants которых меньше заданного
     *
     * @return Возвращает строку Success
     */
    @Override
    public String filterLessThanNumberOfParticipants() {
        int indicator = 0;
        System.out.println("Элементы значение поля numberOfParticipants которых меньше " + numberOfParticipants + " : ");
        for (MusicBand e : Storage.getStorage()) {
            if (e.getNumberOfParticipants() == null) {
                if (0 < numberOfParticipants) {
                    indicator++;
                    System.out.println(e);
                }
            } else if (e.getNumberOfParticipants() < numberOfParticipants) {
                indicator++;
                System.out.println(e);
            }
        }
        if (indicator == 0) {
            System.out.println("Элементов меньше заданного числа не существует!");
        }
        return "Success";
    }
}