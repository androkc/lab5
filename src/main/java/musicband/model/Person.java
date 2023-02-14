package musicband.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import musicband.util.ZonedDateTimeAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;

/**
 * Класс создает Person используемый в Musicband
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    private java.time.ZonedDateTime birthday; //Поле может быть null
    private float weight; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null

    public Person(String name, ZonedDateTime birthday, float weight, Color eyeColor) {
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.eyeColor = eyeColor;
    }
}