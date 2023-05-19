package parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

import Log.Log;
import codeGenerator.CodeGenerator;
import codeGenerator.CodeGeneratorImpl;
import codeGenerator.Memory;
import errorHandler.ErrorHandler;
import scanner.LexicalAnalyzer;
import scanner.token.Token;

public class Parser {
    private final ArrayList<Rule> rules;
    private final Stack<Integer> parsStack;
    private ParseTable parseTable;
    private final CodeGenerator codeGenerator;

    public Parser() {
        parsStack = new Stack<Integer>();
        parsStack.push(0);
        try {
            parseTable = new ParseTable(Files.readAllLines(Paths.get(Objects.requireNonNull(
                    getClass().getClassLoader().getResource("parseTable")).toURI())).get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        rules = new ArrayList<Rule>();
        try {
            for (String stringRule : Files.readAllLines(Paths.get(Objects.requireNonNull(
                    getClass().getClassLoader().getResource("Rules")).toURI()))) {
                rules.add(new Rule(stringRule));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        codeGenerator = new CodeGeneratorImpl(new Memory());
    }

    public void startParse(java.util.Scanner sc) {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(sc);
        Token lookAhead = lexicalAnalyzer.getNextToken();
        boolean finish = false;
        Action currentAction;
        while (!finish) {
            try {
                Log.print(lookAhead.toString() + "\t" + parsStack.peek());
                currentAction = parseTable.getActionTable(parsStack.peek(), lookAhead);
                Log.print(currentAction.toString());

                switch (currentAction.action) {
                    case shift:
                        parsStack.push(currentAction.number);
                        lookAhead = lexicalAnalyzer.getNextToken();

                        break;
                    case reduce:
                        Rule rule = rules.get(currentAction.number);
                        for (int i = 0; i < rule.RHS.size(); i++) {
                            parsStack.pop();
                        }

                        Log.print(parsStack.peek() + "\t" + rule.LHS);
                        parsStack.push(parseTable.getGotoTable(parsStack.peek(), rule.LHS));
                        Log.print(parsStack.peek() + "");
                        try {
                            codeGenerator.semanticFunction(rule.semanticAction, lookAhead);
                        } catch (Exception e) {
                            Log.print("Code Genetator Error");
                        }
                        break;
                    case accept:
                        finish = true;
                        break;
                }
                Log.print("");
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
        if (!ErrorHandler.hasError) codeGenerator.printMemory();
    }
}
