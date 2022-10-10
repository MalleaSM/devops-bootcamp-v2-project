package models;

public class Subject {
    private String subject;
    private String score;

    public Subject(){};

    public Subject(String name, String score) {
        this.subject = name;
        this.score = score;
    }
    
    public String getName(){
        return this.subject;
    }

    public String getScore() {
        return score;
    }
    public void setScore(String newScore){
        this.score = newScore;
    }
}
