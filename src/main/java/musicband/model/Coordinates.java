package musicband.model;

import lombok.*;

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
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Coordinates {
    private Long x;
    private Long y;
}