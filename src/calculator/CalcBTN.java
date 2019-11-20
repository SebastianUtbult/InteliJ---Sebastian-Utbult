package calculator;

public class CalcBTN extends Buttons {

    public String temporary;
    public double sum = 0;
    public String answer;

    public CalcBTN(String text, int Y, int X) {
        super(text, Y, X);
    }

    @Override
    public void DoAction() {      //if statementet låter dig bara skriva ett tecken (t.ex +, -, %)
        if(!field.textProperty().get().contains("+") && !field.textProperty().get().contains("-") && !field.textProperty().get().contains("/") && !field.textProperty().get().contains("*") && !field.textProperty().get().contains("√") && !field.textProperty().get().contains("%")) {
            field.insertText(field.textProperty().get().length(), super.getText());
        }
    }
}
