import java.util.Objects;
import java.util.Scanner;

import parser.Parser;

public class Application {
    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.startParse(
                new Scanner(
                        Objects.requireNonNull(
                                Application.class.getClassLoader().getResourceAsStream("code"))));
    }
}