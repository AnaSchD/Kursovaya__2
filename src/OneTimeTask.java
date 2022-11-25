import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OneTimeTask extends Task{

//    public static Map <Integer, Task> oneTimeTasks = new HashMap<>();

    public OneTimeTask(String title, String description, boolean personalTask, LocalDate date) {
        super(title, description, personalTask, date);

    }

    @Override
    public boolean relevanceTask(LocalDate date) {
//        System.out.println(oneTimeTasks);
        if (date.equals(getDate())) {
            return true;
        } else return false;
    }

//    public void addOneTimeTask(TaskService task) {
//        task.addTask();
//    }

}
