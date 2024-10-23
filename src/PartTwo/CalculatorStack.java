package PartTwo;

import java.util.Scanner;
import java.util.Stack;

public class CalculatorStack {
    private Stack<Double> operands;
    private Stack<Character> operators;

    public CalculatorStack() {
        operands = new Stack<>();
        operators = new Stack<>();
    }

    public void pushOperand(double operand) {
        operands.push(operand);
        System.out.println(operand + " pushed onto the stack.");
    }

    public void pushOperator(char operator) {
        operators.push(operator);
        System.out.println(operator + " pushed onto the stack.");
    }

    public double performOperation() {
        if (operands.size() < 2 || operators.isEmpty()) {
            System.out.println("Insufficient operands or no operator.");
            return 0;
        }
        double b = operands.pop();
        double a = operands.pop();
        char operator = operators.pop();

        double result = 0;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                } else {
                    System.out.println("Cannot divide by zero.");
                    return 0;
                }
                break;
            default:
                System.out.println("Unknown operator.");
                return 0;
        }
        operands.push(result);
        System.out.println("Performed operation: " + a + " " + operator + " " + b + " = " + result);
        return result;
    }

    public void displayStacks() {
        System.out.println("Operands Stack: " + operands);
        System.out.println("Operators Stack: " + operators);
    }

    public static void main(String[] args) {
        CalculatorStack calculator = new CalculatorStack();
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("\nCommands: pushOperand, pushOperator, performOperation, display, exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "pushoperand":
                    System.out.print("Enter operand: ");
                    double operand = scanner.nextDouble();
                    calculator.pushOperand(operand);
                    break;
                case "pushoperator":
                    System.out.print("Enter operator (+, -, *, /): ");
                    char operator = scanner.next().charAt(0);
                    calculator.pushOperator(operator);
                    break;
                case "performoperation":
                    calculator.performOperation();
                    break;
                case "display":
                    calculator.displayStacks();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
            scanner.nextLine();
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
