package calculator;

public class NumberBTN extends Buttons {

    public NumberBTN(String text, int Y, int X) {
        super(text, Y, X);
    }
    @Override
    public void DoAction(){
            field.insertText(field.textProperty().get().length(), super.getText()); //När man trycker på knappen så skrivs det i textfield samma sak som det står på knappen
    }
}
