package musicband;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import musicband.model.Id;
import musicband.model.MusicBand;

import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.*;

/**
 * Класс в котором хранится TreeSet<MusicBand>
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@Getter
@Setter
@XmlRootElement
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(MusicBand.class)
public class Storage {
    @XmlElement(name = "Musicband", type = MusicBand.class)
    private static TreeSet<MusicBand> storage = new TreeSet<>();

    public Storage() {
    }

    public Storage(TreeSet<MusicBand> storage) {
        this.storage = storage;
    }

    public Storage(String path) {
        try (FileReader fileReader = new FileReader(path);
             Scanner scanner = new Scanner(fileReader);) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }
    /**
     * Этот метод осуществляет добавление в TreeSet<MusicBand> элемента MusicBand
     *
     * @param e - массив MusicBand или MusicBand
     * @return Возвращает storage
     */
    public static TreeSet<MusicBand> addStorage(MusicBand... e) {
        for (MusicBand t : e) {
            storage.add(t);
            Id.addId();
        }
        System.out.println("Added");
        return storage;
    }

    /**
     * Этот метод осуществляет получение TreeSet<MusicBand>
     *
     * @return Возвращает storage
     */
    public static TreeSet<MusicBand> getStorage() {
        return storage;
    }
}
