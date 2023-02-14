package musicband.command.impl;

import musicband.command.InfoCommand;
import musicband.model.MusicBand;
import musicband.util.XmlUtil;

import java.io.File;
import java.util.Date;
import java.util.TreeSet;

/**
 * Имплементированный класс, отвечающий за вывод в стандартный поток информации о коллекции
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class Infoimpl implements InfoCommand {
    /**
     * Этот метод выводит справку о существующий вывод в стандартный поток информации о коллекции
     *
     * @return Возвращает строку string с информацией
     */
    @Override
    public String info(String path) {
        File fileMusicband = new File(path);
        String string2 = String.valueOf(XmlUtil.unconvert(path).getClass());
        TreeSet<MusicBand> e = XmlUtil.unconvert(path);
        String string = "Date last edited: " + new Date(fileMusicband.lastModified()) + ". Type: " + string2 + ". Amount of elements: " + e.size();
        System.out.println(string);
        return string;
    }
}