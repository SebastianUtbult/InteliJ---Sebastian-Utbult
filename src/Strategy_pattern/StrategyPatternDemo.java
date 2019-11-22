package Strategy_pattern;

public class StrategyPatternDemo {

    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executiveStrategy(10,5, 0));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executiveStrategy(10, 5, 0));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executiveStrategy(10, 5, 0));

        context = new Context(new OperationMulitplyDivide());
        System.out.println("10 * 5 / 3 = " + context.executiveStrategy(10, 5, 3));

    }

}
