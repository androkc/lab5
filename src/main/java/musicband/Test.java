package musicband;

import musicband.control.CommandOperator;

/**
 * Класс-тетс для запуска программы
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class Test {
    public static void main(String[] args) {
//Storage storage = new Storage("C:\\got\\bot.txt");
//        Person kuchera = new Person("Kuchera", ZonedDateTime.now(), 165.5F, Color.BROWN);
//        Person tupik = new Person("Tupik", ZonedDateTime.of(1998, 10, 3, 0, 0, 0, 0, ZoneId.of("Europe/Moscow")), 80, Color.YELLOW);
//        Person gulik = new Person("Gulik", ZonedDateTime.of(1990, 9, 3, 0, 0, 0, 0, ZoneId.of("Europe/Moscow")), 90, Color.YELLOW);
//        MusicBand band = new MusicBand("Kuchera", new Coordinates(4L, 5L), LocalDateTime.now(), null, MusicGenre.POP, kuchera);
//        MusicBand band1 = new MusicBand("Tupik", new Coordinates(6L, 80L), LocalDateTime.now(), 10L, MusicGenre.SOUL, tupik);
//        MusicBand band2 = new MusicBand("Gulik", new Coordinates(8L, 10L), LocalDateTime.now(), 55L, MusicGenre.POP, gulik);
//        MusicBand band3 = new MusicBand("GGGG", new Coordinates(8L, 10L), LocalDateTime.now(), 77L, MusicGenre.PSYCHEDELIC_ROCK, gulik);
//        MusicBand band4 = new MusicBand("ffffffffff", new Coordinates(8L, 10L), LocalDateTime.now(), 58L, MusicGenre.POP, gulik);
//        MusicBand band5 = new MusicBand("lllllllll", new Coordinates(8L, 10L), LocalDateTime.now(), 566L, MusicGenre.POP, gulik);
//        MusicBand band6 = new MusicBand("bvvvvvvn", new Coordinates(8L, 10L), LocalDateTime.now(), 786L, MusicGenre.PSYCHEDELIC_ROCK, gulik);
//        MusicBand band7 = new MusicBand("bbbbbbbbb", new Coordinates(8L, 10L), LocalDateTime.now(), 100L, MusicGenre.POP, gulik);
//        Storage.addStorage(band, band1, band2, band3, band4, band5, band6, band7);
//
//        System.out.println(XmlUtil.convertToXML(Storage.getStorage(), "C:\\got\\bot.txt"));
//        System.out.println("--------------------------");
//        System.out.println(" -------------------");
//
//        TreeSet<MusicBand> musicBands = XmlUtil.unconvert("C:\\got\\info.txt");


        CommandOperator commandOperator = new CommandOperator();
        commandOperator.startProgramm();
    }
}
