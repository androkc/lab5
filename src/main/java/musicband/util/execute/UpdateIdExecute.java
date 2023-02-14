package musicband.util.execute;

import musicband.model.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * Класс-помощник для класса ExecuteScriptFileName, отвечающий за первоначальную обработку команды UpdateId
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class UpdateIdExecute {
    ArrayList<String> addCollection;

    public UpdateIdExecute(ArrayList<String> addCollection) {
        this.addCollection = addCollection;
    }

    /**
     * Этот метод осуществляет поиск команды и её условия
     *
     * @return Возвращает id1 или 0 в случае ошибки
     */
    public int checkID() {
        try {
            if (addCollection.indexOf("update_id") > -1) {
                CheckExecuteUtil checkExecuteUtil = new CheckExecuteUtil();
                int id1 = checkExecuteUtil.readInt(addCollection.get(1 + addCollection.indexOf("update_id")));
                if (id1 > 0) {
                    return id1;
                } else {
                    System.out.println("ID должен быть корректным числом и больше 0! Проверьте файл");
                    return 0;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не хватает данных в файле!");
            return 0;
        }
        return 0;
    }

    /**
     * Этот метод осуществляет формирования Musicband
     *
     * @return Возвращает строку musicBand или null в случае ошибки
     */
    public MusicBand addExecute() {
        try {
            if (addCollection.indexOf("update_id") > -1) {
                CheckExecuteUtil checkExecuteUtil = new CheckExecuteUtil();
                String name = checkExecuteUtil.addName(addCollection.get(2 + (addCollection.indexOf("update_id"))));
                Long[] xy = checkExecuteUtil.addCoordinates(addCollection.get(3 + (addCollection.indexOf("update_id"))), addCollection.get(4 + (addCollection.indexOf("update_id"))));
                Coordinates coordinates = new Coordinates(xy[0], xy[1]);
                Long numberOfParticipants = checkExecuteUtil.addParticapents(addCollection.get(5 + (addCollection.indexOf("update_id"))));
                MusicGenre musicGenre = MusicGenre.checkAbbreviationGenre(addCollection.get(6 + (addCollection.indexOf("update_id"))));
                String name1 = checkExecuteUtil.addName(addCollection.get(7 + (addCollection.indexOf("update_id"))));
                ZonedDateTime zonedDateTime = checkExecuteUtil.addZonedDateTime(addCollection.get(8 + (addCollection.indexOf("update_id"))), addCollection.get(9 + (addCollection.indexOf("update_id"))), addCollection.get(10 + (addCollection.indexOf("update_id"))));
                int weight = checkExecuteUtil.addWeight(addCollection.get(11 + (addCollection.indexOf("update_id"))));
                Color color = Color.checkAbbreviationColor(addCollection.get(12 + (addCollection.indexOf("update_id"))));
                if (name != null && xy != null && numberOfParticipants != -1L && name1 != null && weight != 0 && zonedDateTime != null) {
                    MusicBand musicBand = new MusicBand(name, coordinates, LocalDateTime.now(), numberOfParticipants, musicGenre, new Person(name1, zonedDateTime, weight, color));
                    System.out.println(musicBand);
                    return musicBand;
                } else {
                    System.out.println("Ошибки данных в файле!");
                    return null;
                }
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не хватает данных в файле!");
            return null;
        }
    }
}