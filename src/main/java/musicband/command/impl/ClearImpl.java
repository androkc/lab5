package musicband.command.impl;

import musicband.Storage;
import musicband.command.ClearCommand;

/**
 * Имплементированный класс, отвечающий за полную очистку коллекции
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class ClearImpl implements ClearCommand {
    /**
     * Этот метод осуществляет очистку коллекции Treeset<Musicband>, находящейся в классе Storage
     *
     * @return Возвращает строку Succes
     */
    @Override
    public String clearCollcetion() {
        Storage.getStorage().clear();
        System.out.println("Collection has been cleared.");
        return "Succes";
    }
}