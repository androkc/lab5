package musicband.command;

import musicband.model.MusicBand;

import java.util.TreeSet;

/**
 * Интерфейс, отвечающий вывод в стандартный поток вывода всех элементов коллекции в строковом представлении
 */
public interface ShowCommand {
    /**
     * Этот метод осуществляет вывод в стандартный поток вывода всех элементов коллекции в строковом представлении
     */
    String show(TreeSet<MusicBand> e);
}