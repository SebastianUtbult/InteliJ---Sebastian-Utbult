package calculator;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Buttons extends Button {

    public static TextField field;

    public Buttons(String text, int Y, int X){  //button preset settings. för alla knappar. Variablerna X, Y och text behöver man definera i calculator för att bestämma position och vad det ska stå på knappen
        setText(text);
        setMinHeight(30);
        setMinWidth(30);
        setVisible(true);
        setTranslateY(Y);
        setTranslateX(X);
        setOnAction(event -> {
            DoAction();
        });
    }
    public abstract void DoAction(); // ger knappen en funktion

}
