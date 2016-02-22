package igs;

/**
 * Created by Christian on 2/22/2016.
 */
public class Answers {
    private String author, date, message;

    /**
     * each answer will have an object of this class
     * @param author the creator of the answer
     * @param date the date the answer was submitted
     * @param message the answer.
     */
    public Answers(String author, String date, String message) {
        this.author = author;
        this.date = date;
        this.message = message;
    }
}
