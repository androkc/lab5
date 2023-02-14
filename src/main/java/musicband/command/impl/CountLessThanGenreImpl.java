package musicband.command.impl;

import lombok.Getter;
import musicband.Storage;
import musicband.command.CountLessThanGenreCommand;
import musicband.model.MusicBand;

import java.util.*;

/**
 * Имплементированный класс, отвечающий за вывод количество элементов, значение поля genre которых меньше заданного
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@Getter
public class CountLessThanGenreImpl implements Comparator<Integer>, CountLessThanGenreCommand {
    private String genre;
    private Integer i = 0;
    private Integer p = 0;
    private Integer g = 0;
    private Integer s = 0;

    public CountLessThanGenreImpl(String genre) {
        this.genre = genre;
    }

    /**
     * Этот метод осуществляет пересортировку коллекции Treeset<Musicband> в коллекцию HashMap по жанрам и вывода строки, где количество элементов, значение поля genre которых меньше заданного
     *
     * @return Возвращает строку Succes
     */
    public String countLessThanGenre() {
        for (MusicBand e : Storage.getStorage()) {
            if (e.getGenre() != null) {
                switch (e.getGenre().getAbbreviation()) {
                    case "pop":
                        p = p + 1;
                        break;
                    case "psychedelic rock":
                        i = i + 1;
                        break;
                    case "psychedelic cloud rap":
                        g = g + 1;
                        break;
                    case "soul":
                        s = s + 1;
                        break;
                }
            }
        }
        HashMap<String, Integer> sum = new HashMap<>();
        sum.put("pop", p);
        sum.put("psychedelic rock", i);
        sum.put("psychedelic cloud rap", g);
        sum.put("soul", s);
        System.out.println(sum);
        System.out.println("У " + headMy(sum, genre) + " элементов(-а) значение поля genre меньше, чем у " + genre);
        return "Succes";
    }

    /**
     * Этот метод осуществляет подсчет элементов, значение поля genre которых меньше заданного
     *
     * @return Возвращает int sum2
     */
    public int headMy(HashMap<String, Integer> map, String genre) {
        int genreValue = map.get(genre);
        int sum2 = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < genreValue) {
                sum2 = sum2 + entry.getValue();
            }
        }
        return sum2;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2)
            return 1;
        else if (o1 < o2)
            return -1;
        else
            return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}