package musicband.control;

import lombok.AllArgsConstructor;
import lombok.Getter;
import musicband.Storage;
import musicband.command.*;

import java.util.*;

/**
 * Класс, в котором обрабатываются команды с "сервера".
 * Описание к методам @see {link command}
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@AllArgsConstructor
@Getter
public class Handler {
    private Storage storage;

    public static String show(ShowCommand e) {
        return e.show(Storage.getStorage());
    }

    public static String info(InfoCommand e) {
        return e.info("C:\\got\\bot.txt");
    }

    public static String add(AddMusicbandCommand e) {
        return e.addMusicband();
    }

    public static String save(SaveMusicbandCommand e) {
        return e.saveMusicband();
    }

    public static String update(UpdateIdCommand e) {
        return e.updateID();
    }

    public static String remove(RemoveByIdCommand e) {
        return e.removeById();
    }

    public static String clear(ClearCommand e) {
        return e.clearCollcetion();
    }

    public static String exit(ExitCommand e) {
        return e.exitProgramm();
    }

    public static String numberOfParticipants(NumberOfPerticipantsCommand e) {
        return e.addNumberOfParticipants();
    }

    public static String addMin(AddIfMinCommand e) {
        return e.addIfMin();
    }

    public static String removeGreater(RemoveGreaterCommand e) {
        return e.removeGreater();
    }

    public static String removeLower(RemoveLowerCommand e) {
        return e.removeLower();
    }

    public static String countLessThanGenre(CountLessThanGenreCommand e) {
        return e.countLessThanGenre();
    }

    public static String filterLessThanNumberOfParticipants(FilterLessThanNumberOfParticipantsCommand e) {
        return e.filterLessThanNumberOfParticipants();
    }

    public static String help(HelpCommand e) {
        return e.help();
    }

    public static ArrayList<String> executeScript(ExecuteScriptFileNameCommand e) {
        return e.executeScrpitFileName();
    }
}
