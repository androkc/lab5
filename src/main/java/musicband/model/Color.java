package musicband.model;

import lombok.Getter;

/**
 * Класс ENUM, в котором созданы цвета для класса Musicband, используемые пользователем в интерактивном режиме
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@Getter
public enum Color {
    BLUE("blue"),
    YELLOW("yellow"),
    BROWN("brown");

    private String abbreviation;

    Color(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Этот метод сравнивает принимаемый в параметрах String с аббревиатурой команды класса Color
     *
     * @param e Это строка, которая должна совпадать с аббревиатурой команды
     * @return Возвращает Color b или null, если принимаемый String e не совпадает ни с одной аббревиатурой существующих цветов
     */
    public static Color checkAbbreviationColor(String e) {
        for (Color b : Color.values()) {
            if (b.abbreviation.equalsIgnoreCase(e)) {
                return b;
            }
        }
        return null;
    }
}