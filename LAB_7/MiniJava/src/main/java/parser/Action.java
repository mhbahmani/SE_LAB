package parser;

public class Action {
    public ActionType action;
    public int number;

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
}
