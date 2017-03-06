package main.java.model;

public class Greetings {
    private final String content;

    public Greetings(String content) {
        this.content = content;
    }

    public Greetings(String content, String content2) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}