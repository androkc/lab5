package musicband.model;

import lombok.*;
import musicband.util.ZonedDateTimeAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Класс создает Person используемый в Musicband
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    private java.time.ZonedDateTime birthday; //Поле может быть null
    private float weight; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null
}