package parser;

public class Action {
    private ActionType action;
    private int number;

    public Action(ActionType action, int number) {
        this.action = action;
        this.number = number;
    }

    public String toString() {
        if (action != ActionType.accept) {
            return action.toString() + number;
        }
        return action.toString();
    }

    public ActionType getAction() {
        return action;
    }

    public int getNumber() {
        return number;
    }
}
