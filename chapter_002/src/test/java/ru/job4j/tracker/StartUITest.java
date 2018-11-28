package ru.job4j.tracker;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String ls = System.lineSeparator();
    private final StringBuilder menu = new StringBuilder()
            .append("Меню." + "\n")
            .append("0. Добавить новую заявку" + "\n")
            .append("1. Показать все заявки" + "\n")
            .append("2. Изменить заявку" + "\n")
            .append("3. Удалить заявку" + "\n")
            .append("4. Найти заявку по ID" + "\n")
            .append("5. Найти заявку по имени" + "\n")
            .append("6. Выход из программы" + "\n")
            .append(ls);

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

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

    @Test
    public void whenFindByIdThenItemTwo() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем три заявки
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name two", "desc2"));
        Item item3 = tracker.add(new Item("test name three", "desc3"));
        //создаём StubInput с последовательностью действий(найти заявку по ID)
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        // проверяем, что заявка с таким ID - это вторая завка.
        assertThat(tracker.findById(item2.getId()), is(item2));
    }

    @Test
    public void whenFindByIdThenItemNull() {
        Tracker tracker = new Tracker();
        //Напрямую добавляем три заявки
        Item item = null;
        Item item2 = tracker.add(new Item("test name two", "desc2"));
        Item item3 = tracker.add(new Item("test name three", "desc3"));
        //создаём StubInput с последовательностью действий(найти заявку по ID)
        Input input = new StubInput(new String[]{"4", "12345678", "6"});
        new StartUI(input, tracker).init();
        // проверяем, что заявка с таким ID не существует.
        assertThat(tracker.findById("12345678"), is(item));

    }

    @Test
    public void whenShowItemThenShowOneItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(this.menu)
                        .append("------------ Показать все заявки --------------").append(ls)
                        .append(item.toString()).append(ls)
                        .append(this.menu)
                        .toString()
                )
        );
        System.setOut(stdout);
    }

    @Test
    public void whenSerchItemByNameThenShowItemTwo() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name two", "desc2"));
        Item item3 = tracker.add(new Item("test name three", "desc3"));
        Input input = new StubInput(new String[]{"5", "test name two", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(this.menu)
                        .append("------------ Поиск заявки по Имени --------------").append(ls)
                        .append("Заявки c именем: ")
                        .append(item2.getName()).append(ls)
                        .append("ID заявки: ")
                        .append(item2.getId() + "\n")
                        .append("Описание заявки: ")
                        .append(item2.getDescription())
                        .append("\n---").append(ls)
                        .append(this.menu)
                        .toString()
                )
        );
        System.setOut(stdout);

    }
}