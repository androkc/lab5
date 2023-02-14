package musicband.util;

import musicband.Storage;
import musicband.model.MusicBand;

import javax.xml.bind.*;
import java.io.*;
import java.util.TreeSet;

/**
 * Класс-помощник, отвечающий за создание конвертирование и разконвертирование xml формата
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class XmlUtil {
    /**
     * Этот метод осуществляет конвертирование TreeSet <MusicBand> в xml формат
     *
     * @param musicBandTreeset - коллекция
     * @param kuda             - путь
     * @return Возвращает xmlString
     */
    public static String convertToXML(TreeSet<MusicBand> musicBandTreeset, String kuda) {

        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(Storage.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
            StringWriter sw = new StringWriter();
            m.marshal(new Storage(musicBandTreeset), sw);
            xmlString = sw.toString();
            FileOutputStream file = new FileOutputStream(kuda);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(file);
            m.marshal(new Storage(musicBandTreeset), outputStreamWriter);

        } catch (JAXBException s) {
            s.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saved");
        return xmlString;
    }

    /**
     * Этот метод осуществляет разконвертирование TreeSet <MusicBand> из xml формат
     *
     * @param e - путь
     * @return Возвращает TreeSet<MusicBand>
     */
    public static TreeSet<MusicBand> unconvert(String e) {
        Storage storage = new Storage();
        try {
            JAXBContext context = JAXBContext.newInstance(Storage.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            storage = (Storage) unmarshaller.unmarshal(new FileReader(e));
        } catch (JAXBException s) {
            s.printStackTrace();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return storage.getStorage();
    }
}