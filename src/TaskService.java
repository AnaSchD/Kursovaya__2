import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskService {

    public static Map<Integer, Task> tasks = new HashMap<>();
    public static List<Task> deleteTask = new ArrayList<>();

//    public List<Task> getDeleteTask() {
//        return deleteTask;
//    }

    public List<Task> getDelTasks() {
        if (!deleteTask.isEmpty()) {
            return deleteTask;
        }
        else{
            System.out.println("-");
        return null;
    }}

    public void addTask() {
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
                tasks.put(oneTimeTask.getId(), oneTimeTask);
                break;
            case 2:
                System.out.println("Выбрана ежедневная задача");
                DailyTask dailyTask = new DailyTask(titleTask, descriptionTask, personalTask, date);
                tasks.put(dailyTask.getId(), dailyTask);
                break;
            case 3:
                System.out.println("Выбрана еженедельная задача");
                WeeklyTask weeklyTask = new WeeklyTask(titleTask, descriptionTask, personalTask, date);
                tasks.put(weeklyTask.getId(), weeklyTask);
                break;
            case 4:
                System.out.println("Выбрана ежемесячная задача");
                MonthlyTask monthlyTask = new MonthlyTask(titleTask, descriptionTask, personalTask, date);
                tasks.put(monthlyTask.getId(), monthlyTask);
                break;
            case 5:
                System.out.println("Выбрана ежегодная задача");
                AnnualTask annualTask = new AnnualTask(titleTask, descriptionTask, personalTask, date);
                tasks.put(annualTask.getId(), annualTask);
                break;
            default:
                System.out.println("Не выбрана повторяемость задачи");
        }
    }


    public void printRepeatability() {
        System.out.println("1. Однократная");
        System.out.println("2. Ежедневная");
        System.out.println("3. Еженедельная");
        System.out.println("4. Ежемесячная");
        System.out.println("5. Ежегодная");
    }

    private LocalDate addDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате dd.MM.yyyy");
        String date = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, dtf);
    }

    public void giveTasksOnDay() {
        LocalDate date = addDate();
        List<Task> tasksOnDay = new ArrayList<>();

        for (Task taskCount : tasks.values()) {
            if (taskCount.relevanceTask(date) && !taskCount.isDelTask()) {
                tasksOnDay.add(taskCount);
            }
        }
        if (!tasksOnDay.isEmpty()) {
            System.out.println(tasksOnDay);
        } else {
            System.out.println("Нет задач");
        }
    }

    public void deleteTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID задачи");
        int id = scanner.nextInt();
        Task delTask = searchById(id);
        delTask.setDelTask();
        deleteTask.add(delTask);
        System.out.println("Задача удалена: " + deleteTask);
    }

    public void editTask() {
        Scanner scanner = new Scanner(System.in);
//        scanner.useDelimiter("\n");
        System.out.println("Введите id задачи");
        int id = 0;
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
        } else editTask();

        Task editTask = searchById(id);

        if (editTask != null) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите новый заголовок задачи");
            String newTittle = scanner1.nextLine();
            editTask.setTitleTask(newTittle);

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Введите новое описание задачи");
            String newDescription = scanner2.nextLine();
            editTask.setDescriptionTask(newDescription);
        } else {
            editTask();
        }

    }

    private Task searchById(int id) {

        if (tasks.containsKey(id)) {
            return tasks.get(id);
        } else {
            System.out.println("Нет такого ID");
            return null;
        }
    }
}
