package school.staff;

import java.util.Date;
import java.util.List;

public class Assignment {
    private final school.staff.assignmentType assignmentType;
    private String name;
    private String description;
    private Date dueDate;
    private List<String> submissions;

    public Assignment(String name, String description, Date dueDate, school.staff.assignmentType assignmentType) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.assignmentType = assignmentType;
    }

    public void saveSubmission(String submission){
        submissions.add(submission);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public school.staff.assignmentType getAssignmentType() {
        return assignmentType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentType=" + assignmentType +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
