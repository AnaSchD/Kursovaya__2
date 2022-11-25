import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MonthlyTask extends Task {

//    public static Map <Integer, MonthlyTask> monthlyTasks = new HashMap<>();

    public MonthlyTask(String title, String description, boolean personalTask, LocalDate date) {
        super(title, description, personalTask, date);

    }

    @Override
    public boolean relevanceTask(LocalDate date) {
        if (date.getDayOfMonth() == getDate().getDayOfMonth() && (date.isAfter(getDate()) ||
        date.equals(getDate()))) {
            return true;
        } else return false;
    }


//    public void addMonthlyTask(MonthlyTask task) {
//        monthlyTasks.put(task.getId(), task);
//    }
//
//    public Map<Integer, MonthlyTask> getMonthlyTasks() {
//        return monthlyTasks;
//    }


}
