package parser;

public class Action {
    public act action;
    public int number;

    public Action(act action, int number) {
        this.action = action;
        this.number = number;
    }

    public String toString() {
        switch (action) {
            case accept:
                return "acc";
            case shift:
                return "s" + number;
            case reduce:
                return "r" + number;
        }
        return action.toString() + number;
    }
}

enum act {
    shift, reduce, accept
}
