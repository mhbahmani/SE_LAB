package parser;

import log.Log;
import code_generator.CodeGenerator;
import code_generator.CodeGeneratorImpl;
import code_generator.Memory;
import errorHandler.ErrorHandler;
import resource_loader.ResourceLoader;
import scanner.LexicalAnalyzer;
import scanner.token.Token;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Parser {
    private final ArrayList<Rule> rules;
    private final Stack<Integer> parsStack;
    private final CodeGenerator codeGenerator;
    private ParseTable parseTable;

    public Parser() {
        parsStack = new Stack<>();
        parsStack.push(0);
        try {
            ResourceLoader parseTableLoader = new ResourceLoader("parseTable");
            parseTable = new ParseTable(parseTableLoader.getContent().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        rules = new ArrayList<>();
        try {
            ResourceLoader ruleLoader = new ResourceLoader("Rules");
            for (String stringRule : ruleLoader.getContent()) {
                this.rules.add(new Rule(stringRule));
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!ErrorHandler.hasError) codeGenerator.printMemory(System.out);
    }
}
