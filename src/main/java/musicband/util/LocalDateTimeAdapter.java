package musicband.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс-помощник для xml формата, отвечающий за обработку времени LocalDateTime
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Этот метод осуществляет анмаршаллинг
     *
     * @return Возвращает не xml формат
     */
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v, formatter);
    }

    /**
     * Этот метод осуществляет маршаллинг
     *
     * @return Возвращает xml формат
     */
    public String marshal(LocalDateTime v) throws Exception {
        return v.format(formatter);
    }
}