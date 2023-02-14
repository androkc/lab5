package musicband.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import musicband.util.LocalDateTimeAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

/**
 * Класс, с помощью которого создается Musicband
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBand implements Comparable<MusicBand> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long numberOfParticipants; //Поле может быть null, Значение поля должно быть больше 0
    private MusicGenre genre; //Поле может быть null
    private Person frontMan; //Поле может быть null

    public MusicBand(String name, Coordinates coordinates, LocalDateTime creationDate, Long numberOfParticipants, MusicGenre genre, Person frontMan) {
        this.id = Id.addId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.frontMan = frontMan;

    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Comparable по ID
     */
    @Override
    public int compareTo(MusicBand o1) {
        if (this.getId() > o1.getId())
            return 1;
        else if (this.getId() < o1.getId())
            return -1;
        else
            return 0;
    }
}
