package codeGenerator;

import scanner.token.Token;

public interface CodeGenerator {
    void printMemory();

    void semanticFunction(int semanticAction, Token lookAhead);
}
