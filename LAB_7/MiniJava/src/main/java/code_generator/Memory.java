package code_generator;

import java.io.PrintStream;
import java.util.ArrayList;

public class Memory {
    private final ArrayList<ThreeAddressCode> codeBlock;
    private int lastTempIndex;
    private int lastDataAddress;

    public Memory() {
        codeBlock = new ArrayList<>();
        lastTempIndex = 500;
        lastDataAddress = 200;
    }

    public int getTemp() {
        int tempSize = 4;
        lastTempIndex += tempSize;
        return lastTempIndex - tempSize;
    }

    public int getDateAddress() {
        int dataSize = 4;
        lastDataAddress += dataSize;
        return lastDataAddress - dataSize;
    }

    public int saveMemory() {
        codeBlock.add(new ThreeAddressCode());
        return codeBlock.size() - 1;
    }

    public void add3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        codeBlock.add(new ThreeAddressCode(op, opr1, opr2, opr3));
    }

    public void add3AddressCode(int i, Operation op, Address opr1, Address opr2, Address opr3) {
        codeBlock.remove(i);
        codeBlock.add(i, new ThreeAddressCode(op, opr1, opr2, opr3));
    }

    public int getCurrentCodeBlockAddress() {
        return codeBlock.size();
    }

    public void pintCodeBlock(PrintStream printStream) {
        printStream.println("Code Block");
        for (int i = 0; i < codeBlock.size(); i++) {
            printStream.println(i + " : " + codeBlock.get(i).toString());
        }
    }
}
