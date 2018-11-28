package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (answer.equals("1")) {
                this.showItem();
            } else if (answer.equals("2")) {
                this.replaceItem();
            } else if (answer.equals("3")) {
                this.deleteItem();
            } else if (answer.equals("4")) {
                this.searchItemById();
            } else if (answer.equals("5")) {
                this.searchItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("Новая заявка с getId : " + item.getId() + "\n---");
    }
    /**
     * Метод отображает все созданные заявки
     */
    private void showItem() {
        System.out.println("------------ Показать все заявки --------------");
        if (this.tracker.findAll().length != 0) {
            for (Item item : this.tracker.findAll()) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Заявок еще нет" + "\n---");
        }
    }
    /**
     * Метод для изменения заявки
     */
    private void replaceItem() {
        System.out.println("------------ Изменение заявки --------------");
        boolean exit = false;
        while (!exit) {
            this.menuReplace();
            String answer = this.input.ask("Введите пункт меню : ");
            if (answer.equals("0")) {
                String id = this.input.ask("Введите ID заявки: ");
                String name = this.input.ask("Введите новое имя заявки: ");
                Item item = new Item(name, tracker.findById(id).getDescription());
                this.tracker.replace(id, item);
                System.out.println(item.toString());
            } else if (answer.equals("1")) {
                String id = this.input.ask("Введите ID заявки: ");
                String disc = this.input.ask("Введите новое описание заявки: ");
                Item item = new Item(tracker.findById(id).getName(), disc);
                this.tracker.replace(id, item);
                System.out.println(item.toString());
            } else if (answer.equals("2")) {
                exit = true;
            }
        }
    }
    /**
     * Метод для удаления заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки: ");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка с ID: " + id + " удалена" + "\n---");
        } else {
            System.out.println("Заявка с ID: " + id + " не существует" + "\n---");
        }
    }
    /**
     * Метод для поиска заявки по id
     */
    private void searchItemById() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки: ");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с ID: " + id + " не существует");
        } else {
            System.out.println(item.toString());
        }
    }
    /**
     * Метод для поиска заявки по имени
     */
    private void searchItemByName() {
        System.out.println("------------ Поиск заявки по Имени --------------");
        String name = this.input.ask("Введите Имя заявки: ");
        Item[] result = this.tracker.findByName(name);
        if (result.length != 0) {
            System.out.println("Заявки c именем: " + name);
            for (Item item : result) {
                System.out.println("ID заявки: " + item.getId()
                        + "\nОписание заявки: " + item.getDescription() + "\n---");
            }
        } else {
            System.out.println("Заявок c именем " + name + " нет");
        }
    }
    /**
     * Метод выводит главное меню на эркан
     */
    private void showMenu() {
        System.out.println("Меню."
                + "\n" + "0. Добавить новую заявку"
                + "\n" + "1. Показать все заявки"
                + "\n" + "2. Изменить заявку"
                + "\n" + "3. Удалить заявку"
                + "\n" + "4. Найти заявку по ID"
                + "\n" + "5. Найти заявку по имени"
                + "\n" + "6. Выход из программы" + "\n");
    }
    /**
     * Метод выводит меню изменения заявки на экран
     */
    private void menuReplace() {
        System.out.println("Меню изменения заявки"
                + "\n" + "0. Изменить имя заявки"
                + "\n" + "1. Изменить описание заявки"
                + "\n" + "2. Выйти в главное меню" + "\n");
    }
    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}