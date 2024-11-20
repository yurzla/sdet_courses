package lesson04;

import java.util.ArrayList;
import java.util.Collection;

public class Student
{
    private String name = "";
    private String groupName = "";
    private Integer course = 1;
    private ArrayList<Mark> marks = new ArrayList<Mark>();

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Collection<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Collection<Mark> marks) {
        marks.clear();
        marks.addAll(marks);
    }

    public double getAverageMark() {
        if (this.marks.size() > 0) {
            return Double.valueOf(this.marks
            .stream()
            .mapToInt(x -> x.getValue()).sum()) / Double
                                                .valueOf(this.marks.size());
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s, %d, %f}", getName(), getGroupName(), 
                                                getCourse(), getAverageMark());
    }

    public Student() {
    }

    public Student(String name, String groupName, 
                    Integer course, Collection<Mark> marks)
    {
        this.name = name;
        this.groupName = groupName;
        this.course = course;
        this.marks.addAll(marks);
    }
}
