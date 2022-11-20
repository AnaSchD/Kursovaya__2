import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskService {

    public static void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите заголовок задачи: ");
        String titleTask = scanner.nextLine();
        //String titleTask = "a";
        System.out.print("Введите описание задачи: ");
        String descriptionTask = scanner.nextLine();
        //String descriptionTask = "b";
        System.out.print("Задача личная? ");
        boolean personalTask = scanner.nextBoolean();
//        boolean personalTask = true;
        LocalDate date = addDate();
        System.out.println(date);
        System.out.println("Выбери повторяемость задачи: ");
        printRepeatability();
        int repeatability = scanner.nextInt();
        switch (repeatability) {
            case 1:
                System.out.println("Выбрана однократная задача");
                OneTimeTask oneTimeTask = new OneTimeTask(titleTask, descriptionTask, personalTask, date);
                break;
            case 2:
                System.out.println("Выбрана ежедневная задача");
                DailyTask dailyTask = new DailyTask(titleTask, descriptionTask, personalTask, date);
                break;
            case 3:
                System.out.println("Выбрана еженедельная задача");
                WeeklyTask weeklyTask = new WeeklyTask(titleTask, descriptionTask, personalTask, date);
                break;
            case 4:
                System.out.println("Выбрана ежемесячная задача");
                MonthlyTask monthlyTask = new MonthlyTask(titleTask, descriptionTask, personalTask, date);
                break;
            case 5:
                System.out.println("Выбрана ежегодная задача");
                AnnualTask annualTask = new AnnualTask(titleTask, descriptionTask, personalTask, date);
                break;
            default:
                System.out.println("Не выбрана повторяемость задачи");
        }
    }


    public static void printRepeatability() {
        System.out.println("1. Однократная");
        System.out.println("2. Ежедневная");
        System.out.println("3. Еженедельная");
        System.out.println("4. Ежемесячная");
        System.out.println("5. Ежегодная");
    }

    private static LocalDate addDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате dd.MM.yyyy");
        String date = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, dtf);
    }

    public static void giveTasksOnDay() {
        LocalDate date = addDate();
        List<Task> tasksOnDay = new ArrayList<>();

        for (Task taskCount : OneTimeTask.oneTimeTasks.values()) {
            if (taskCount.relevanceTask(date)) {
                tasksOnDay.add(taskCount);
            }
        }
        System.out.println(tasksOnDay);

        for (Task taskCount : DailyTask.dailyTasks.values()) {
            if (taskCount.relevanceTask(date)) {
                tasksOnDay.add(taskCount);
            }
        }
        for (Task taskCount : WeeklyTask.weeklyTasks.values()) {
            if (taskCount.relevanceTask(date)) {
                tasksOnDay.add(taskCount);
            }
        }
        for (Task taskCount : MonthlyTask.monthlyTasks.values()) {
            if (taskCount.relevanceTask(date)) {
                tasksOnDay.add(taskCount);
            }
        }
        for (Task taskCount : AnnualTask.annualTasks.values()) {
            if (taskCount.relevanceTask(date)) {
                tasksOnDay.add(taskCount);
            }
        }
        if (!tasksOnDay.isEmpty()) {
            System.out.println(tasksOnDay);
        } else {
            System.out.println("Нет задач");
        }
    }

    public static void deleteTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID задачи");
        int id = scanner.nextInt();
        if (OneTimeTask.oneTimeTasks.containsKey(id)) {
            OneTimeTask.oneTimeTasks.remove(id);
        } else if (DailyTask.dailyTasks.containsKey(id)) {
            DailyTask.dailyTasks.remove(id);
        } else if (WeeklyTask.weeklyTasks.containsKey(id)) {
            WeeklyTask.weeklyTasks.remove(id);
        } else if (MonthlyTask.monthlyTasks.containsKey(id)) {
            MonthlyTask.monthlyTasks.remove(id);
        } else if (AnnualTask.annualTasks.containsKey(id)) {
            AnnualTask.annualTasks.remove(id);
        }
    }


    private static Task searchById(int id) {
        if (OneTimeTask.oneTimeTasks.containsKey(id)) {
            return OneTimeTask.oneTimeTasks.get(id);
        } else if (DailyTask.dailyTasks.containsKey(id)) {
            return DailyTask.dailyTasks.get(id);
        } else if (WeeklyTask.weeklyTasks.containsKey(id)) {
            return WeeklyTask.weeklyTasks.get(id);
        } else if (MonthlyTask.monthlyTasks.containsKey(id)) {
            return MonthlyTask.monthlyTasks.get(id);
        } else if (AnnualTask.annualTasks.containsKey(id)) {
            return AnnualTask.annualTasks.get(id);
        } else {
            System.out.println("Нет такого ID");
            return null;
        }
    }
}
