import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class WeeklyTask extends Task  {

//    public static Map <Integer, WeeklyTask> weeklyTasks = new HashMap<>();

    public WeeklyTask(String title, String description, boolean personalTask, LocalDate date) {
        super(title, description, personalTask, date);

    }


    @Override
    public boolean relevanceTask(LocalDate date) {
        if (date.getDayOfWeek().equals(getDate().getDayOfWeek())) {
            return true;
        } else return false;
    }

//    public void addWeeklyTask(WeeklyTask task) {
//        weeklyTasks.put(task.getId(), task);
//    }

//    public Map<Integer, WeeklyTask> getWeeklyTask() {
//        return weeklyTasks;
//    }


}
