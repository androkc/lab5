package musicband.model;

import lombok.Getter;

/**
 * Класс ENUM, в котором созданы жанры, используемые пользователем в интерактивном режиме
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@Getter
public enum MusicGenre {
    PSYCHEDELIC_ROCK("psychedelic rock", 1),
    PSYCHEDELIC_CLOUD_RAP("psychedelic cloud rap", 2),
    SOUL("soul", 3),
    POP("pop", 4);
    private String abbreviation;
    private Integer idMusicGenre;


    MusicGenre(String abbreviation, int idMusicGenre) {
        this.abbreviation = abbreviation;
        this.idMusicGenre = idMusicGenre;
    }

    /**
     * Этот метод сравнивает принимаемый в параметрах String с аббревиатурой команды класса MusicGenre
     *
     * @param e Это строка, которая должна совпадать с аббревиатурой команды
     * @return Возвращает MusicGenre b или null, если принимаемый String e не совпадает ни с одной аббревиатурой существующих жанров
     */
    public static MusicGenre checkAbbreviationGenre(String e) {
        for (MusicGenre b : MusicGenre.values()) {
            if (b.abbreviation.equalsIgnoreCase(e)) {
                return b;
            }
        }
        return null;
    }
}