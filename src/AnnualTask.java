import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AnnualTask extends Task {

    public static Map <Integer, AnnualTask> annualTasks = new HashMap<>();

    public AnnualTask(String title, String description, boolean personalTask, LocalDate date) {
        super(title, description, personalTask, date);
        addAnnualTask(this);
    }


    @Override
    public boolean relevanceTask(LocalDate date) {
        LocalDate yesterday = LocalDate.now();
        while (getDate().isBefore(date)) {
            if (yesterday.equals(date)) {
                return true;
            }
            yesterday.plusYears(1);
        } return false;
    }

    public void addAnnualTask(AnnualTask task) {
        annualTasks.put(task.getId(), task);
        System.out.println(annualTasks);
    }



}
