import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                TaskService taskService = new TaskService();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            taskService.addTask();
                            break;
                        case 2:
                            taskService.deleteTask();
                            break;
                        case 3:
                            taskService.editTask();
                            break;
                        case 4:
                            taskService.giveTasksOnDay();
                            break;
                        case 5:
                            System.out.println(taskService.getDelTasks());
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

    private static void printMenu() {

        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Редактировать задачу");
        System.out.println("4. Получить задачу на указанный день");
        System.out.println("5. Получить удаленные задачи");
        System.out.println("0. Выход");

    }


}