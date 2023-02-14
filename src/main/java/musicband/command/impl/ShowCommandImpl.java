package musicband.command.impl;

import musicband.Storage;
import musicband.command.ShowCommand;
import musicband.model.MusicBand;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Имплементированный класс, отвечающий вывод в стандартный поток вывода всех элементов коллекции в строковом представлении
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class ShowCommandImpl implements ShowCommand {
    /**
     * Этот метод осуществляет вывод в стандартный поток вывода всех элементов коллекции в строковом представлении
     *
     * @return Возвращает строку musicband
     */
    @Override
    public String show(TreeSet<MusicBand> e) {
        String musicband = "";
        String musibandSout = "";
        Iterator<MusicBand> itr = e.iterator();
        if (!Storage.getStorage().isEmpty()) {
            while (itr.hasNext()) {
                musibandSout = itr.next().toString();
                musicband = musicband + musibandSout;
                System.out.println(musibandSout);
            }
        } else {
            System.out.println("Collection is empty");
        }
        return musicband;
    }
}