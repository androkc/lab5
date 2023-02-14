package musicband.util;

import musicband.model.Color;
import musicband.model.Person;

import java.time.ZonedDateTime;
import java.util.Scanner;

/**
 * Класс-помощник для класса ReaderUtil, отвечающий за создание Person
 *
 * @author Petr Gurin
 * @version 1.0
 * @since 2023-02-13
 */
public class AddPerson {
    public AddPerson(AddElements addElements) {
    }

    /**
     * Этот метод осуществляет обработку Person
     *
     * @param scanner - данные
     * @return Возвращает person
     */
    public Person createPerson(Scanner scanner) {
        System.out.println("Add elements. ");
        System.out.println("Person. ");
        AddElements add = new AddElements();
        String name = add.addName(scanner);
        System.out.println("Введите дату рождения.");
        ZonedDateTime zonedDateTime = add.addZonedDateTime(scanner);
        int weight = add.addWeight(scanner);
        System.out.print("Color: ");
        Color colorAdd = add.addColor(scanner);
        Person person = add.addPerson(name, zonedDateTime, weight, colorAdd);
        return person;
    }
}