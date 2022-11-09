import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task {

    private String titleTask;   //заголовок

    private String descriptionTask;  //описание

    private boolean personalTask;  //тип задачи

    private String signOfRepeatabilityTask;  //признак повторяемости ???

    private LocalDate date;

    private static int generator;
    private int id;

    public Task(String title, String description, boolean personalTask, String signOfRepeatability) {
        if (title.isEmpty() && title.isBlank()) {
            this.titleTask = title;
        } else {
            throw new IllegalArgumentException("Введи заголовок задачи");
        }
        if (description.isEmpty() && description.isBlank()) {
            this.descriptionTask = description;
        } else {
            throw new IllegalArgumentException("Введи описание задачи");
        }

        id = generator++;

        this.personalTask = personalTask;

        this.signOfRepeatabilityTask = signOfRepeatability;
    }

    public String getTitle() {
        return titleTask;
    }

    public void setTitle(String title) {
        this.titleTask = title;
    }

    public String getDescription() {
        return descriptionTask;
    }

    public void setDescription(String description) {
        this.descriptionTask = description;
    }

    public boolean getType() {
        return personalTask;
    }

    public void setType(boolean type) {
        this.personalTask = type;
    }

    public String getSignOfRepeatability() {
        return signOfRepeatabilityTask;
    }

    public void setSignOfRepeatability(String signOfRepeatability) {
        this.signOfRepeatabilityTask = signOfRepeatability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return personalTask == task.personalTask && id == task.id && Objects.equals(titleTask, task.titleTask) && Objects.equals(descriptionTask, task.descriptionTask) && Objects.equals(signOfRepeatabilityTask, task.signOfRepeatabilityTask) && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleTask, descriptionTask, personalTask, signOfRepeatabilityTask, date, id);
    }
}
