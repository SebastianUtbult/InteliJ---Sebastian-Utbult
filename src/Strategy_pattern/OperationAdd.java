package Strategy_pattern;

public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2, int num3) {
        return num1 + num2;
    }
}
