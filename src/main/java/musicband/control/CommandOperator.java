package musicband.control;

import musicband.command.impl.*;
import musicband.control.enumcommands.EnumCommands;
import musicband.model.MusicBand;
import musicband.util.*;
import musicband.util.execute.CheckExecuteScrpitUtil;
import musicband.util.execute.HelperCommanOperatorForExecuteMethod;

import java.util.*;

/**
 * Класс, в котором в общем виде представлена структура интерактивного использования программы
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class CommandOperator {
    /**
     * Метод, с помощью которого пользователь использует программу оперируя командами
     */
    public void startProgramm() {
        try (Scanner scanner = new Scanner(System.in)) {
            LoadingStorage loadingStorage = new LoadingStorage();
            loadingStorage.loadStorage();
            AddElements addElements = new AddElements();
            CommandOperatorUtil commandOperatorUtil = new CommandOperatorUtil();
            System.out.print("Введите команду: ");
            while (scanner.hasNextLine()) {
                String command = commandOperatorUtil.addCommand(scanner);
                EnumCommands enumCommands = EnumCommands.checkAbbreviation(command);
                if (enumCommands != null) {
                    switch (enumCommands.getAbbreviation()) {
                        case "show":
                            ShowCommandImpl showCommand = new ShowCommandImpl();
                            Handler.show(showCommand);
                            break;
                        case "info":
                            Infoimpl infoimpl = new Infoimpl();
                            Handler.info(infoimpl);
                            break;
                        case "add":
                            AddMusicbandImpl addmusicbandimpl = new AddMusicbandImpl(ReaderUtil.createMusicband(scanner));
                            Handler.add(addmusicbandimpl);
                            break;
                        case "save":
                            SaveMusicbandImpl saveMusicbandimpl = new SaveMusicbandImpl();
                            Handler.save(saveMusicbandimpl);
                            break;
                        case "update_id":
                            System.out.println("Введите ID. ");
                            int id = addElements.readInt(scanner);
                            UpdateIdImpl updateId1 = new UpdateIdImpl(id);
                            if (updateId1.checkID() != null) {
                                UpdateIdImpl updateId = new UpdateIdImpl(ReaderUtil.createMusicband(scanner), id);
                                Handler.update(updateId);
                            } else {
                                System.out.println("Musicband под таким ID не существует!");
                            }
                            break;
                        case "remove":
                            System.out.println("Введите ID, чтобы удалить необходимый элемент. ");
                            int id1 = addElements.readInt(scanner);
                            RemoveByIdImpl removeById = new RemoveByIdImpl(id1);
                            if (removeById.checkIDForRemove() != null) {
                                Handler.remove(removeById);
                            } else {
                                System.out.println("Musicband под таким ID не существует!");
                            }
                            break;
                        case "clear":
                            ClearImpl clearimpl = new ClearImpl();
                            Handler.clear(clearimpl);
                            break;
                        case "exit":
                            ExitImpl exitimpl = new ExitImpl();
                            Handler.exit(exitimpl);
                            break;
                        case "sum_of_number_of_participants":
                            NumberOfparticipantsImpl numberOfparticipants = new NumberOfparticipantsImpl();
                            Handler.numberOfParticipants(numberOfparticipants);
                            break;
                        case "add_if_min":
                            MusicBand musicBand = ReaderUtil.createMusicband(scanner);
                            AddIfMinImpl addIfMin = new AddIfMinImpl(musicBand.getId());
                            AddIfMinImpl addIfMin1 = new AddIfMinImpl(musicBand.getId(), musicBand);
                            if (addIfMin.checkIDForMin() != null) {
                                Handler.addMin(addIfMin1);
                            } else {
                                System.out.println("Musicband имеет ID выше, чем у min элемента!");
                            }
                            break;
                        case "remove_greater":
                            System.out.println("Введите id.");
                            int id2 = addElements.readInt(scanner);
                            RemoveGreaterImpl removeGreater = new RemoveGreaterImpl(id2);
                            if (removeGreater.checkIDForMin() != null) {
                                Handler.removeGreater(removeGreater);
                            } else {
                                System.out.println("Элемента не существует!");
                            }
                            break;
                        case "remove_lower":
                            System.out.println("Введите id.");
                            int id3 = addElements.readInt(scanner);
                            RemoveLowerImpl removeLower = new RemoveLowerImpl(id3);
                            if (removeLower.checkIDForMax() != null) {
                                Handler.removeLower(removeLower);
                            } else {
                                System.out.println("Элемента не существует!");
                            }
                            break;
                        case "count_less_than_genre":
                            CheckAbbreviationGenre checkAbbreviationGenre = new CheckAbbreviationGenre();
                            String genre = checkAbbreviationGenre.checkGenre(scanner);
                            if (genre != null) {
                                CountLessThanGenreImpl countLessThanGenre = new CountLessThanGenreImpl(genre);
                                Handler.countLessThanGenre(countLessThanGenre);
                            } else {
                                System.out.println("Такого жанра не существует!");
                            }
                            break;
                        case "filter_less_than_number_of_participants":
                            System.out.print("Введите numberOfParticipants. ");
                            Long numberOfParticipants = addElements.readLong(scanner);
                            FilterLessThanNumberOfParticipantsImpl filterLessThanNumberOfParticipants = new FilterLessThanNumberOfParticipantsImpl(numberOfParticipants);
                            Handler.filterLessThanNumberOfParticipants(filterLessThanNumberOfParticipants);
                            break;
                        case "help":
                            System.out.println("Существующие команды: ");
                            HelpImpl help = new HelpImpl();
                            Handler.help(help);
                            break;
                        case "execute_script":
                            System.out.print("Введите путь: ");
                            String path = scanner.nextLine();
                            ExecuteScriptFileNameImpl executeScriptFileName = new ExecuteScriptFileNameImpl(path);
                            ArrayList<String> commands = Handler.executeScript(executeScriptFileName);
                            System.out.println("Список строк в файле: " + commands);
                            if (commands != null && !commands.isEmpty()) {
                                CheckExecuteScrpitUtil checkExecuteScrpitUtil = new CheckExecuteScrpitUtil(commands);
                                ArrayList<String> newCommands = checkExecuteScrpitUtil.checkExecuteSrpit();
                                HelperCommanOperatorForExecuteMethod helperCommanOperatorForExecuteMethod = new HelperCommanOperatorForExecuteMethod(newCommands, commands);
                                if (newCommands != null && !newCommands.isEmpty()) {
                                    helperCommanOperatorForExecuteMethod.helperForExecute(scanner, addElements);
                                } else {
                                    System.out.println("Нету таких команд!");
                                }
                            } else {
                                System.out.println("В файле нету строковых объектов или отказано в доступе!");
                            }
                            break;
                    }
                    System.out.print("Введите команду: ");
                } else {
                    System.out.print("Введите заново: ");
                }
            }
        }
    }
}