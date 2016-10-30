package com.example.project.common.data.model;

import com.example.project.common.data.model.enumeration.TaskStatus;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column
    @NotEmpty(message = "Title can't be empty")
    private String title;

    @Column
    @NotEmpty(message = "Description can't be empty")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column
    private long estimation;

    @Column(name = "task_status")
    private TaskStatus taskStatus;

    public Task() {
        taskStatus = TaskStatus.PENDING;
    }

    public Task(String title, String description, Date startDate, long estimation, TaskStatus taskStatus) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.estimation = estimation;
        this.taskStatus = taskStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public long getEstimation() {
        return estimation;
    }

    public void setEstimation(long estimation) {
        this.estimation = estimation;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (estimation != task.estimation) return false;
        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (userId != null ? !userId.equals(task.userId) : task.userId != null) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (startDate != null ? !startDate.equals(task.startDate) : task.startDate != null) return false;
        return taskStatus == task.taskStatus;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (int) (estimation ^ (estimation >>> 32));
        result = 31 * result + (taskStatus != null ? taskStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", estimation=" + estimation +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
