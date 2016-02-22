package igs;

import java.util.ArrayList;

/**
 * Created by Christian on 2/22/2016.
 */
public class Tickets {

    private String title, creator, author, message, operator, status;
    private ArrayList<Answers> answers;

    /**
     *
     * @param title The given title of the ticket
     * @param creator the creator of the ticket
     * @param author the creator
     * @param message the message inside the ticket
     * @param operator operator that has the ticket
     * @param status status of the ticket
     * @param answers an arrayList of the ticket(lists of Answers objects.)
     */
    public Tickets(String title, String creator, String author, String message, String operator, String status, ArrayList<Answers> answers) {
        this.title = title;
        this.creator = creator;
        this.author = author;
        this.message = message;
        this.operator = operator;
        this.status = status;
        this.answers = answers;
    }

    /**
     * Getter and setter
     */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answers> answers) {
        this.answers = answers;
    }
}
