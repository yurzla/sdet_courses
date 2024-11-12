package lesson04;

public class Mark
{
    private String subject = "";
    private Integer value = 0;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String value) {
        subject = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Mark() {
    }

    public Mark(String subject, Integer value) {
        this.subject = subject;
        this.value = value;
    }
}
