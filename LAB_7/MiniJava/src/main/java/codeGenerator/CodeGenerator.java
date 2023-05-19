package codeGenerator;

import scanner.token.Token;

import java.io.PrintStream;

public interface CodeGenerator {
    void printMemory(PrintStream printStream);

    void semanticFunction(int semanticAction, Token lookAhead);
}
