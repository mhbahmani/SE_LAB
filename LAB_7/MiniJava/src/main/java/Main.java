import java.util.Objects;
import java.util.Scanner;

import parser.Parser;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.startParse(
                new Scanner(
                        Objects.requireNonNull(
                                Main.class.getClassLoader().getResourceAsStream("code"))));
    }
}
