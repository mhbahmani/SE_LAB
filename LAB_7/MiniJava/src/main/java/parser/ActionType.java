package parser;

enum ActionType {
    shift("s"), reduce("r"), accept("acc");

    private final String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }

    ActionType(String stringValue) {
        this.stringValue = stringValue;
    }
}
