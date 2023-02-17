package musicband.util.execute;

import lombok.AllArgsConstructor;
import musicband.model.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * Класс-помощник для класса ExecuteScriptFileName, отвечающий за осуществление добавления нового элемента в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@AllArgsConstructor
public class AddIfMinExecuteUtil {
    private ArrayList<String> addCollection;

    /**
     * Этот метод осуществляет сохранение в Treeset<Musicband> , находящейся в классе Storage, минимального элемента
     *
     * @return Возвращает строку Succes
     */
    public MusicBand addExecute() {
        try {
            if (addCollection.indexOf("add_if_min") > -1) {
                CheckExecuteUtil checkExecuteUtil = new CheckExecuteUtil();
                String name = checkExecuteUtil.addName(addCollection.get(1 + (addCollection.indexOf("add_if_min"))));
                Long[] xy = checkExecuteUtil.addCoordinates(addCollection.get(2 + (addCollection.indexOf("add_if_min"))), addCollection.get(3 + (addCollection.indexOf("add_if_min"))));
                Coordinates coordinates = new Coordinates(xy[0], xy[1]);
                Long numberOfParticipants = checkExecuteUtil.addParticapents(addCollection.get(4 + (addCollection.indexOf("add_if_min"))));
                MusicGenre musicGenre = MusicGenre.checkAbbreviationGenre(addCollection.get(5 + (addCollection.indexOf("add_if_min"))));
                String name1 = checkExecuteUtil.addName(addCollection.get(6 + (addCollection.indexOf("add_if_min"))));
                ZonedDateTime zonedDateTime = checkExecuteUtil.addZonedDateTime(addCollection.get(7 + (addCollection.indexOf("add_if_min"))), addCollection.get(8 + (addCollection.indexOf("add_if_min"))), addCollection.get(9 + (addCollection.indexOf("add_if_min"))));
                int weight = checkExecuteUtil.addWeight(addCollection.get(10 + (addCollection.indexOf("add_if_min"))));
                Color color = Color.checkAbbreviationColor(addCollection.get(11 + (addCollection.indexOf("add_if_min"))));
                if (name != null && xy != null && numberOfParticipants != -1L && name1 != null && weight != 0 && zonedDateTime != null) {
                    MusicBand musicBand = new MusicBand(name, coordinates, LocalDateTime.now(), numberOfParticipants, musicGenre, new Person(name1, zonedDateTime, weight, color));
                    System.out.println(musicBand);
                    return musicBand;
                } else {
                    System.out.println("Ошибки данных в файле!");
                    return null;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не хватает данных в файле!");
            return null;
        }
        return null;
    }
}