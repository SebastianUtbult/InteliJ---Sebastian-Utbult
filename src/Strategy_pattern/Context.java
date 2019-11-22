package Strategy_pattern;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executiveStrategy(int num1, int num2, int num3){
        return strategy.doOperation(num1, num2, num3);
    }

}
