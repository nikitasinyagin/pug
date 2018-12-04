package ru.job4j.tracker;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private UserAction[] actions = new UserAction[6];

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = this.new ShowAll();
        this.actions[2] = this.new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Внутренний класс AddItem для добавления заявки.
     */
    public class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("Новая заявка с getId : " + item.getId() + "\n---");
        }

        @Override
        public String info() {
            return "0. Добавить новую заявку";
        }
    }

    /**
     * Внутренний класс ShowAll отображения всех заявок.
     */
    public class ShowAll implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

            System.out.println("------------ Показать все заявки --------------");
            if (tracker.findAll().length != 0) {
                for (Item item : tracker.findAll()) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("Заявок еще нет" + "\n---");
            }
        }

        @Override
        public String info() {
            return "1. Показать все заявки";
        }
    }

    /**
     * Внутренний класс для редактирования заявкт.
     */
    public class EditItem implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Изменение заявки --------------");
            String id = input.ask("Введите ID заявки: ");
            String name = input.ask("Введите новое имя заявки: ");
            String disc = input.ask("Введите новое описание заявки: ");
            Item item = new Item(name, disc);
            tracker.replace(id, item);
            System.out.println(item.toString());
        }

        @Override
        public String info() {
            return "2. Изменить заявку";
        }
    }

    /**
     * Внутренний клас DeletItem для удаления заявки.
     */
    public class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите ID заявки: ");
            if (tracker.delete(id)) {
                System.out.println("Заявка с ID: " + id + " удалена" + "\n---");
            } else {
                System.out.println("Заявка с ID: " + id + " не существует" + "\n---");
            }
        }

        @Override
        public String info() {
            return "3. Удалить заявку";
        }

    }

    /**
     * Внутренний клас для поиска заявки по ID
     */
    public class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID --------------");
            String id = input.ask("Введите ID заявки: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Заявка с ID: " + id + " не существует");
            } else {
                System.out.println(item.toString());
            }
        }

        @Override
        public String info() {
            return "4. Найти заявку по ID";
        }
    }

    /**
     * Внутренний класс для поиска заявок по имени
     */
    public class FindItemByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Имени --------------");
            String name = input.ask("Введите Имя заявки: ");
            Item[] result = tracker.findByName(name);
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

        @Override
        public String info() {
            return "5. Найти заявку по имени";
        }

    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        System.out.println("6. Выход из программы");
    }
}