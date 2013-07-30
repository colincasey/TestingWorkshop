package basics;

public class Calculator {
    public int add(int leftOperand, int rightOperand) {
        return leftOperand + rightOperand;
    }

    public int subtract(int leftOperand, int rightOperand) {
        return leftOperand - rightOperand;
    }

    public int multiply(int leftOperand, int rightOperand) {
        return leftOperand * rightOperand;
    }

    public double divide(int leftOperand, int rightOperand) {
        return new Double(leftOperand) / new Double(rightOperand);
    }
}
