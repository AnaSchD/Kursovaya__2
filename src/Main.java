import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            addTask();
                            break;
                        case 2:
                            // todo: обрабатываем пункт меню 2
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите заголовок задачи: ");
        String titleTask = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String descriptionTask = scanner.nextLine();
        System.out.print("Задача личная? ");
        boolean personalTask = scanner.nextBoolean();
        LocalDate date = addDate();
//        LocalDateTime time = addDateTime();
        repeatabilityTask();
    }

    private static void repeatabilityTask() {
        System.out.println("Выбери повторяемость задачи: ");
        printRepeatability();
        Scanner scanner = new Scanner(System.in);
        int repeatability = scanner.nextInt();
        switch (repeatability) {
            case 1:
                System.out.println("Выбрана однократная задача");
                break;
            case 2:
                System.out.println("Выбрана ежедневная задача");
                break;
            case 3:
                System.out.println("Выбрана еженедельная задача");
                break;
            case 4:
                System.out.println("Выбрана ежемесячная задача");
                break;
            case 5:
                System.out.println("Выбрана ежегодная задача");
                break;
            default:
                System.out.println("Не выбрана повторяемость задачи");
        }
    }

    private static void printRepeatability() {
        System.out.println("1. Однократная");
        System.out.println("2. Ежедневная");
        System.out.println("3. Еженедельная");
        System.out.println("4. Ежемесячная");
        System.out.println("5. Ежегодная");
    }

    private static void printMenu() {

        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Получить задачу на указанный день");
        System.out.println("0. Выход");

    }

    private static LocalDate addDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате dd.MM.yyyy");
        String date = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, dtf);
    }

//    private static LocalDateTime addDateTime() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите время в формате HH:mm");
//        String time = scanner.nextLine();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:m");
//        System.out.println(LocalDateTime.parse(time, dtf));
//        return LocalDateTime.parse(time, dtf);
//    }
}