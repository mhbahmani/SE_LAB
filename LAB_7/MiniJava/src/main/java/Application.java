import parser.Parser;
import resource_loader.ResourceLoader;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Parser parser = new Parser();
        ResourceLoader codeLoader = new ResourceLoader("code");
        parser.startParse(new Scanner(codeLoader.getAsInputStream()));
    }
}
