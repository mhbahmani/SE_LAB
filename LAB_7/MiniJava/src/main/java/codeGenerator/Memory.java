package codeGenerator;

import java.io.PrintStream;
import java.util.ArrayList;

public class Memory {
    private final int stratTempMemoryAddress = 500;
    private final int stratDataMemoryAddress = 200;
    private final int dataSize = 4;
    private final int tempSize = 4;
    private final ArrayList<ThreeAddressCode> codeBlock;
    private int lastTempIndex;
    private int lastDataAddress;

    public Memory() {
        codeBlock = new ArrayList<>();
        lastTempIndex = stratTempMemoryAddress;
        lastDataAddress = stratDataMemoryAddress;
    }

    public int getTemp() {
        lastTempIndex += tempSize;
        return lastTempIndex - tempSize;
    }

    public int getDateAddress() {
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
