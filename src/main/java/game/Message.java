package game;

/**
 * Created by Radu on 22.11.2016.
 */
public enum Message {
    COLUMN_FULL("Column is full!"), RED_TURN("Red turn"), YELLOW_TURN("Yellow turn"), RED_WINS("Red Wins"), YELLOW_WINS("Yellow Wins");
    private String text;
    Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
