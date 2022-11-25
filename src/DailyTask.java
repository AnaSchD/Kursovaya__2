import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DailyTask extends Task {

//    public static Map<Integer, DailyTask> dailyTasks = new HashMap<>();

    public DailyTask(String title, String description, boolean personalTask, LocalDate date) {
        super(title, description, personalTask, date);
    }

    @Override
    public boolean relevanceTask(LocalDate date) {
        return true;
    }

//    public void addDailyTask(DailyTask task) {
//        dailyTasks.put(task.getId(), task);
//    }

////    public Map<Integer, DailyTask> getDailyTasks() {
//        return dailyTasks;
//    }


}
