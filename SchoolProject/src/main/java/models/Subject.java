package models;

public class Subject {
    private String name;
    private String score;

    public Subject(){};

    public Subject(String name, String score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName(){
        return this.name;
    }

    public String getScore() {
        return score;
    }
    public void setScore(String newScore){
        System.out.println("ANTES: "+this.score+"NOTA NUEVA: "+ newScore);

        this.score = newScore;
        System.out.println("Despues: "+this.score);
    }
}
