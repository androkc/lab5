package musicband.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.TreeSet;

/**
 * Класс, в котором генерируется ID для каждого Musicband
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
public class Id {
    private static int id;
    private static TreeSet<Integer> idd = new TreeSet<>();

    /**
     * Этот метод генерирует уникальный ID
     *
     * @return Возвращает int id
     */
    public static int addId() {
        id = (int) (1 + (Math.random() * 100));
        if (idd.contains(id)) {
            return addId();
        } else {
            idd.add(id);
        }
        return id;
    }
}