package week2;

public class TwoStackAlgorithm <Data>{

    public static double calculate(String expression) {

        Stack<Double> values = new Stack<>();
        Stack<String> operands = new Stack<>();

        String[] newExpression = expression.split(" ");


        for (String s : newExpression) {
            if (isNumeric(s)) {
                double value = Double.parseDouble(s);

                values.push(value);
            }

            else if (s.equals(")")) {
                String operand = operands.pop();

                double value1, value2;

                switch (operand) {
                    case "+":
                        value1 = values.pop();
                        value2 = values.pop();
                        values.push(value2 + value1);
                        break;

                    case "-":
                        value1 = values.pop();
                        value2 = values.pop();
                        values.push(value2 - value1);
                        break;

                    case "*":
                        value1 = values.pop();
                        value2 = values.pop();
                        values.push(value2 * value1);
                        break;

                    case "/":
                        value1 = values.pop();
                        value2 = values.pop();
                        values.push(value2 / value1);
                        break;

                    case "%":
                        value1 = values.pop();
                        value2 = values.pop();
                        values.push(value2 % value1);
                        break;

                    case "^":
                        value1 = values.pop();
                        value2 = values.pop();
                        values.push(Math.pow(value2, value1));
                        break;

                    case "√":
                        value1 = values.pop();
                        values.push(Math.sqrt(value1));
                        break;
                }

            }

            else if(s.equals("(")) {
                continue;
            }

            else {
                operands.push(s);
            }
        }

        return values.pop();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        }

        catch (NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(TwoStackAlgorithm.calculate("( ( ( 10 / 5 ) / 4 ) + ( 8 ^ 3 ) )"));
    }
}
