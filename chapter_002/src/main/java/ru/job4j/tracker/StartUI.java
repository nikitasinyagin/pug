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
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (answer.equals("1")) {
                //метод для вывода всех заявок
                //  this.tracker.findAll();
            } else if (answer.equals("2")) {
                //метод для изменения заявки
            } else if (answer.equals("3")) {
                //метод для удаления заявки
            } else if (answer.equals("4")) {
                //метод для поиска заявки по id
            } else if (answer.equals("5")) {
                //метод для поиска заявки по имени
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
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод выводит на эркан меню.
     */
    private void showMenu() {
        System.out.println("Меню."
                + "\n" + "0. Добавить новую заявку"
                + "\n" + "1. Показать все заявки"
                + "\n" + "2. Изменить заявку"
                + "\n" + "3. Удалить заявку"
                + "\n" + "4. Найти заявку по ID"
                + "\n" + "5. Найти заявку по имени"
                + "\n" + "6. Выход из программы)" + "\n");
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
