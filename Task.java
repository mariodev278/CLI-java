public class Task {
    private String text;
    private boolean completed;
    private int id;

    public Task(String text, boolean completed, int id) {
        this.text= text;
        this.completed = completed;
        this.id = id;
    }
    public String getText() {
        return text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }
}