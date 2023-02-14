package musicband.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Класс координат Musicband'а
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Coordinates {
    private Long x;
    private Long y;

    public Coordinates(Long x, Long y) {
        this.x = x;
        this.y = y;
    }
}