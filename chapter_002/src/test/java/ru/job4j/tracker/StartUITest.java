package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", "0", item.getId(), "test replace", "1", item.getId(), "заменили заявку", "2", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
        assertThat(tracker.findById(item.getId()).getDescription(), is("заменили заявку"));
    }

    @Test
    public void whenDeleteItemThenUpdateTracker() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем три заявки
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name two", "desc2"));
        Item item3 = tracker.add(new Item("test name three", "desc3"));
        //создаём StubInput с последовательностью действий(производим удаление первой заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя второй, а не первой заявки.
        assertThat(tracker.findAll()[0], is(item2));
        assertThat(tracker.findAll()[1], is(item3));
    }
}