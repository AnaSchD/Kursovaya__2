import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task implements Repeatability {

    private String titleTask;

    private String descriptionTask;

    private boolean personalTask;

    private LocalDate date;

    private static int generator;
    private int id;

    public Task(String title, String description, boolean personalTask, LocalDate date) {
        if (!title.isEmpty() && !title.isBlank()) {
            this.titleTask = title;
        } else {
            throw new IllegalArgumentException("Введи заголовок задачи");
        }
        if (!description.isEmpty() && !description.isBlank()) {
            this.descriptionTask = description;
        } else {
            throw new IllegalArgumentException("Введи описание задачи");
        }

        this.date = date;

        id = generator++;

        this.personalTask = personalTask;

    }

    public String getTitle() {
        return titleTask;
    }

    public String getDescription() {
        return descriptionTask;
    }

    public boolean getType() {
        return personalTask;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public abstract boolean relevanceTask(LocalDate date);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return personalTask == task.personalTask && id == task.id && Objects.equals(titleTask, task.titleTask)
                && Objects.equals(descriptionTask, task.descriptionTask) && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleTask, descriptionTask, personalTask, date, id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "titleTask='" + titleTask + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", personalTask=" + personalTask +
                ", date=" + date +
                ", id=" + id +
                '}';
    }

}

