package musicband.util;

/**
 * Класс-помощник для класса NumberOfparticipantsImpl
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class ReadLongParticipants {
    /**
     * Этот метод осуществляет проверку Long
     *
     * @param e - число
     * @return Возвращает e или 0L
     */
    public static Long readLongParticipants(Long e) {
        if (e != null) {
            return e;
        } else {
            return 0L;
        }
    }
}