package musicband.util.execute;

import lombok.AllArgsConstructor;
import musicband.command.impl.*;
import musicband.control.Handler;
import musicband.model.MusicBand;
import musicband.util.AddElements;
import musicband.util.CheckAbbreviationGenre;

import java.util.*;

/**
 * Класс-помощник для класса ExecuteScriptFileName and CommandOperator, отвечающий за первоначальную обработку команды ExecuteScript
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
@AllArgsConstructor
public class HelperCommanOperatorForExecuteMethod {
    private ArrayList<String> commands;
    private ArrayList<String> forMethod;

    /**
     * Этот метод осуществляет поиск команды и обрабатывает их
     *
     */
    public String helperForExecute(Scanner scanner, AddElements addElements) {
        for (String e : commands) {
            System.out.println("-------------------------------------");
            switch (e) {
                case "show":
                    ShowCommandImpl showCommand = new ShowCommandImpl();
                    Handler.show(showCommand);
                    break;
                case "info":
                    Infoimpl infoimpl = new Infoimpl();
                    Handler.info(infoimpl);
                    break;
                case "add":
                    AddExecuteUtil addExecuteUtil = new AddExecuteUtil(forMethod);
                    addExecuteUtil.addExecute();
                    break;
                case "save":
                    SaveMusicbandImpl saveMusicbandimpl = new SaveMusicbandImpl();
                    Handler.save(saveMusicbandimpl);
                    break;
                case "update_id":
                    UpdateIdExecute updateIdExecute = new UpdateIdExecute(forMethod);
                    int id = updateIdExecute.checkID();
                    if (id != 0) {
                        UpdateIdImpl updateId1 = new UpdateIdImpl(id);
                        if (updateId1.checkID() != null) {
                            MusicBand musicBand = updateIdExecute.addExecute();
                            if (musicBand != null) {
                                UpdateIdImpl updateId = new UpdateIdImpl(musicBand, id);
                                Handler.update(updateId);
                            } else {
                                System.out.println("Musicband некорректен!");
                            }
                        } else {
                            System.out.println("Musicband под таким ID не существует!");
                        }
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case "remove":
                    RemoveExecute removeExecute = new RemoveExecute(forMethod);
                    int id1 = removeExecute.removeID();
                    if (id1 != 0) {
                        RemoveByIdImpl removeById = new RemoveByIdImpl(id1);
                        if (removeById.checkIDForRemove() != null) {
                            Handler.remove(removeById);
                        } else {
                            System.out.println("Musicband под таким ID не существует!");
                        }
                    } else {
                        System.out.println("Error");
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
                    AddIfMinExecuteUtil addIfMinExecuteUtil = new AddIfMinExecuteUtil(forMethod);
                    MusicBand musicBand = addIfMinExecuteUtil.addExecute();
                    if (musicBand != null) {
                        AddIfMinImpl addIfMin = new AddIfMinImpl(musicBand.getId());
                        AddIfMinImpl addIfMin1 = new AddIfMinImpl(musicBand.getId(), musicBand);
                        if (addIfMin.checkIDForMin() != null) {
                            Handler.addMin(addIfMin1);
                        } else {
                            System.out.println("Musicband имеет ID выше, чем у min элемента!");
                        }
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case "remove_greater":
                    RemoveGreaterExecute removeGreaterExecute = new RemoveGreaterExecute(forMethod);
                    int id2 = removeGreaterExecute.removeGreaterID();
                    if (id2 != 0) {
                        RemoveGreaterImpl removeGreater = new RemoveGreaterImpl(id2);
                        if (removeGreater.checkIDForMin() != null) {
                            Handler.removeGreater(removeGreater);
                        } else {
                            System.out.println("Элемента не существует!");
                        }
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case "remove_lower":
                    RemoveLowerExecute removeLowerExecute = new RemoveLowerExecute(forMethod);
                    int id3 = removeLowerExecute.removeLowerID();
                    if (id3 != 0) {
                        RemoveLowerImpl removeLower = new RemoveLowerImpl(id3);
                        if (removeLower.checkIDForMax() != null) {
                            Handler.removeLower(removeLower);
                        } else {
                            System.out.println("Элемента не существует!");
                        }
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case "count_less_than_genre":
                    CheckAbbreviationGenre checkAbbreviationGenre = new CheckAbbreviationGenre();
                    CountLessExecute countLessExecute = new CountLessExecute(forMethod);
                    String genreFile = countLessExecute.countLess();
                    if (genreFile != null) {
                        String genre = checkAbbreviationGenre.checkGenreString(genreFile);
                        if (genre != null) {
                            CountLessThanGenreImpl countLessThanGenre = new CountLessThanGenreImpl(genre);
                            Handler.countLessThanGenre(countLessThanGenre);
                        } else {
                            System.out.println("Такого жанра не существует! Проверьте файл.");
                        }
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case "filter_less_than_number_of_participants":
                    FilterLessExecute filterLessExecute = new FilterLessExecute(forMethod);

                    Long numberOfParticipants = filterLessExecute.filterLessExecute();
                    if (numberOfParticipants != -1L) {
                        FilterLessThanNumberOfParticipantsImpl filterLessThanNumberOfParticipants = new FilterLessThanNumberOfParticipantsImpl(numberOfParticipants);
                        Handler.filterLessThanNumberOfParticipants(filterLessThanNumberOfParticipants);
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case "help":
                    System.out.println("Существующие команды: ");
                    HelpImpl help = new HelpImpl();
                    Handler.help(help);
                    break;
                case "execute_script":
                    ExecuteScriptUtil executeScriptUtil = new ExecuteScriptUtil(forMethod);

                    String path = executeScriptUtil.checkPath();
                    if (path != null) {
                        ExecuteScriptFileNameImpl executeScriptFileName = new ExecuteScriptFileNameImpl(path);
                        ArrayList<String> commands = Handler.executeScript(executeScriptFileName);
                        System.out.println(commands);
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
                            System.out.println("В файле нету строковых объектов!");
                        }
                    } else {
                        System.out.println("Error");
                    }
                    break;
            }
        }
        System.out.println("-------------------------------------");
        System.out.println("Вывелось");
        return "Success";
    }
}