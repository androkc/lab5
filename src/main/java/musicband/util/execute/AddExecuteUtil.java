package musicband.util.execute;

import musicband.Storage;
import musicband.model.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * Класс-помощник для класса ExecuteScriptFileName, отвечающий за добавление нового элемента в коллекцию
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class AddExecuteUtil {
    private ArrayList<String> addCollection;

    public AddExecuteUtil(ArrayList<String> addCollection) {
        this.addCollection = addCollection;
    }

    /**
     * Этот метод осуществляет сохранение в Treeset<Musicband>, находящейся в классе Storage, элемента переданного через конструктор
     *
     * @return Возвращает строку Succes
     */
    public String addExecute() {
        try {
            if (addCollection.indexOf("add") > -1) {
                CheckExecuteUtil checkExecuteUtil = new CheckExecuteUtil();

                String name = checkExecuteUtil.addName(addCollection.get(1 + (addCollection.indexOf("add"))));
                Long[] xy = checkExecuteUtil.addCoordinates(addCollection.get(2 + (addCollection.indexOf("add"))), addCollection.get(3 + (addCollection.indexOf("add"))));
                Coordinates coordinates = new Coordinates(xy[0], xy[1]);
                Long numberOfParticipants = checkExecuteUtil.addParticapents(addCollection.get(4 + (addCollection.indexOf("add"))));
                MusicGenre musicGenre = MusicGenre.checkAbbreviationGenre(addCollection.get(5 + (addCollection.indexOf("add"))));
                String name1 = checkExecuteUtil.addName(addCollection.get(6 + (addCollection.indexOf("add"))));
                ZonedDateTime zonedDateTime = checkExecuteUtil.addZonedDateTime(addCollection.get(7 + (addCollection.indexOf("add"))), addCollection.get(8 + (addCollection.indexOf("add"))), addCollection.get(9 + (addCollection.indexOf("add"))));
                int weight = checkExecuteUtil.addWeight(addCollection.get(10 + (addCollection.indexOf("add"))));
                Color color = Color.checkAbbreviationColor(addCollection.get(11 + (addCollection.indexOf("add"))));
                if (name != null && xy != null && numberOfParticipants != -1L && name1 != null && weight != 0 && zonedDateTime != null) {
                    MusicBand musicBand = new MusicBand(name, coordinates, LocalDateTime.now(), numberOfParticipants, musicGenre, new Person(name1, zonedDateTime, weight, color));
                    Storage.getStorage().add(musicBand);
                    System.out.println(musicBand);
                } else {
                    System.out.println("Ошибки данных в файле!");
                    return "Unsuccessful";
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не хватает данных в файле!");
            return "Unsuccessful";
        }
        return "Success";
    }
}