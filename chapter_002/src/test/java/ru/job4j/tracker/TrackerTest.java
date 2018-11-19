package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");//, 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription");//, 123L);
        tracker.add(item1);
        assertThat(tracker.findAll()[0], is(item));
        assertThat(tracker.findAll()[1], is(item1));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");//, 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(item1);
        // Создаем новую заявку.
        Item item2 = new Item("test2", "testDescription2");//, 1234L);
        // Проставляем старый id из item1, который был сгенерирован выше.
        item2.setId(item1.getId());
        assertThat(tracker.replace(item1.getId(), item2), is(true));
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(item1.getId()).getName(), is("test2"));
    }

    @Test
    public void deleteItemTwoThenCellShift() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");//, 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(item1);
        // Создаем новую заявку.
        Item item2 = new Item("test2", "testDescription2");//, 1234L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3");//, 12345L);
        tracker.add(item3);
        assertThat(tracker.delete(item2.getId()), is(true));
        assertThat(tracker.findAll()[1], is(item3));
    }

    @Test
    public void whenFindByNameThenReturnNewArryWhisName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");//, 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(item1);
        // Создаем новую заявку.
        Item item2 = new Item("test3", "testDescription2");//, 1234L);
        tracker.add(item2);
        Item item3 = new Item("test1", "testDescription3");//, 12345L);
        tracker.add(item3);
        Item item4 = new Item("test1", "testDescription3");//, 12345L);
        tracker.add(item4);
        assertThat(tracker.findByName("test1")[0], is(item1));
        assertThat(tracker.findByName("test1")[1], is(item3));
        assertThat(tracker.findByName("test1")[2], is(item4));
    }
}
