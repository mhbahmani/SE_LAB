package code_generator;

class ThreeAddressCode {
    public Operation operation;
    public Address operand1;
    public Address operand2;
    public Address operand3;

    public ThreeAddressCode() {

    }

    public ThreeAddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        operation = op;
        operand1 = opr1;
        operand2 = opr2;
        operand3 = opr3;
    }

    public String toString() {
        if (operation == null) return "";
        StringBuilder res = new StringBuilder("(");
        res.append(operation.toString()).append(",");
        if (operand1 != null) res.append(operand1);
        res.append(",");
        if (operand2 != null) res.append(operand2);
        res.append(",");
        if (operand3 != null) res.append(operand3);
        res.append(")");

        return res.toString();
    }
}
