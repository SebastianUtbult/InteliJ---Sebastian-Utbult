package calculator;

public abstract class EqualsBTN extends Buttons{

    public String temporary;
    public double sum = 0;
    public String answer;

    public EqualsBTN(String text, int Y, int X) {
        super(text, Y, X);
    }

    @Override
    public void DoAction(){                                              //läser av vad som står i textfield
        temporary = field.textProperty().get();                          //och konverterar det till siffror.
        field.deleteText(0, field.textProperty().get().length());        //med hjälp av metoden calc() så
        calc();                                                          //så checkar progra mmet vilket räkne
        answer = Double.toString(sum);                                   //-sätt som finns i textfield o splittar
        field.insertText(field.textProperty().get().length(), answer);   //texten o shohoppfallasvejsan så räknar
    }                                                                    //den ut svaret och printar det i textfield

    public void calc(){
        if(temporary.contains("+")) {
            String[] operator = temporary.split("[+]");
            Double operator1 = Double.parseDouble(operator[0]);
            Double operator2 = Double.parseDouble(operator[1]);
            sum = operator1 + operator2;
        }
        else if(temporary.contains("-")) {
            String[] operator = temporary.split("[-]");
            Double operator1 = Double.parseDouble(operator[0]);
            Double operator2 = Double.parseDouble(operator[1]);
            sum = operator1 - operator2;
        }
        else if(temporary.contains("/")) {
            String[] operator = temporary.split("[/]");
            Double operator1 = Double.parseDouble(operator[0]);
            Double operator2 = Double.parseDouble(operator[1]);
            sum = operator1 / operator2;
        }
        else if(temporary.contains("*")) {
            String[] operator = temporary.split("[*]");
            Double operator1 = Double.parseDouble(operator[0]);
            Double operator2 = Double.parseDouble(operator[1]);
            sum = operator1 * operator2;
        }
        else if(temporary.contains("%")) {
            String[] operator = temporary.split("[%]");
            Double operator1 = Double.parseDouble(operator[0]);
            Double operator2 = Double.parseDouble(operator[1]);
            sum = operator1 % operator2;
        }
        else if(temporary.contains("√")) {
            String[] operator = temporary.split("[√]");
            Double operator1 = Double.parseDouble(operator[0]);
            sum = Math.sqrt(operator1);
        }
    }
}
