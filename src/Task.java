import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task implements Repeatability {

    private String titleTask;

    private String descriptionTask;

    private boolean personalTask;

    private LocalDate date;

    private boolean isDelTask;

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
        this.personalTask = personalTask;
        this.isDelTask = false;
        id = generator++;

    }

    public String getTitle() {
        return titleTask;
    }

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
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

    public boolean isDelTask() {
        return isDelTask;
    }

    public void setDelTask() {
        this.isDelTask = !isDelTask;
    }

    @Override
    public abstract boolean relevanceTask(LocalDate date);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return titleTask.equals(task.titleTask) && date.equals(task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleTask, date);
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

