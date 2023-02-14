package musicband.util;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс-помощник для xml формата, отвечающий за обработку времени ZonedDateTime
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class ZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.of("+3"));

    /**
     * Этот метод осуществляет анмаршаллинг
     *
     * @return Возвращает не xml формат
     */
    public ZonedDateTime unmarshal(String v) throws Exception {
        return ZonedDateTime.parse(v, formatter);
    }

    /**
     * Этот метод осуществляет маршаллинг
     *
     * @return Возвращает xml формат
     */
    public String marshal(ZonedDateTime v) throws Exception {
        return v.format(formatter);
    }
}