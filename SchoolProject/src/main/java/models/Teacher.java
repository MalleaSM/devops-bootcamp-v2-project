package models;

public class Teacher {
    private String code;
    private String name;
    private String subject;
    public Teacher(String code, String name,String subject) {
        //this.code = "TE-" + (int)(Math.random() * 100 + 1) +"-"+ name;
        this.code = code;
        this.name = name;
        this.subject = subject;
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getSubject() {
        return subject;
    }
}
