package parser;

import scanner.token.Token;

import java.util.ArrayList;

public class Rule {
    private final NonTerminal LHS;
    private final ArrayList<GrammarSymbol> RHS;
    private int semanticAction;

    public Rule(String stringRule) {
        int index = stringRule.indexOf("#");
        stringRule = getStringRule(stringRule, index);
        String[] splited = stringRule.split("->");
        LHS = NonTerminal.valueOf(splited[0]);
        RHS = new ArrayList<>();
        if (splited.length > 1) {
            splitGreat(splited);
        }
    }

    private void splitGreat(String[] splited) {
        String[] RHSs = splited[1].split(" ");
        for (String s : RHSs) {
            try {
                RHS.add(new GrammarSymbol(NonTerminal.valueOf(s)));
            } catch (Exception e) {
                RHS.add(new GrammarSymbol(new Token(Token.getTypeFormString(s), s)));
            }
        }
    }

    private String getStringRule(String stringRule, int index) {
        if (index != -1) {
            try {
                semanticAction = Integer.parseInt(stringRule.substring(index + 1));
            } catch (NumberFormatException ex) {
                semanticAction = 0;
            }
            stringRule = stringRule.substring(0, index);
        } else {
            semanticAction = 0;
        }
        return stringRule;
    }

    public NonTerminal getLHS() {
        return LHS;
    }

    public ArrayList<GrammarSymbol> getRHS() {
        return RHS;
    }

    public int getSemanticAction() {
        return semanticAction;
    }
}
