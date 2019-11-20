package calculator;

import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class calculator extends Application{

    Button Bt1, Bt2, Bt3, Bt4, Bt5, Bt6, Bt7, Bt8, Bt9, Bt0, BtEquals, BtAdd, BtSubb, BtMult, BtMod, BtSqrt, BtC, BtDiv, BtComma, smile;

    TextField Tf;

    public void start(Stage arg0) throws Exception{

        //TextField
        Tf = new TextField();  //här skrivs siffrer, symboler och svar in
        Tf.setMinHeight(30);
        Tf.setMaxWidth(180);
        Tf.setVisible(true);
        Tf.setEditable(false);
        Buttons.field = Tf; // skickar textfield infon till mina andra klasser

        Bt1 = new NumberBTN("1", 60, 0);  //implementerar knappar från mina Action preset klasser som är kopplade till min abstrakta function som bestämmer inställningarna för alla knappar
        Bt2 = new NumberBTN("2", 60, 30);
        Bt3 = new NumberBTN("3", 60, 60);
        Bt4 = new NumberBTN("4", 90, 0 );
        Bt5 = new NumberBTN("5", 90, 30);
        Bt6 = new NumberBTN("6", 90, 60);
        Bt7 = new NumberBTN("7", 120, 0 );
        Bt8 = new NumberBTN("8", 120, 30);
        Bt9 = new NumberBTN("9", 120, 60);
        Bt0 = new NumberBTN("0", 150, 30);
        BtAdd = new CalcBTN("+", 120, 90);
        BtSubb = new CalcBTN("-", 90, 90);
        BtMult = new CalcBTN("*", 60, 90);
        BtDiv = new CalcBTN("/", 30, 90);
        BtMod = new CalcBTN("%", 30, 30);
        BtSqrt = new CalcBTN("√", 30, 60);
        BtComma = new NumberBTN(".", 150, 60);
        BtEquals = new EqualsBTN("=", 150, 90) {
            @Override
            public void DoAction() {
                super.DoAction();
            }
        };
        smile = new NumberBTN("", 30, 0);
        smile.setOnAction(event -> {
            if(smile.getText() == ""){
                smile.setText(": )");
            }else{
                smile.setText("");
            }
        });



        BtC = new NumberBTN("C", 150, 0);
        BtC.setOnAction(event -> {
            Tf.deleteText(0, Tf.textProperty().get().length());
        });


        Group root = new Group();

        root.setTranslateX(0);

        root.getChildren().addAll(Bt1, Bt2, Bt3, Bt4, Bt5, Bt6, Bt7, Bt8, Bt9, Bt0, BtAdd, BtSubb, BtEquals, BtMult, BtC , BtDiv, BtMod, BtSqrt, BtComma, Tf, smile);

        Scene scene = new Scene(root, 40, 170, Color.ANTIQUEWHITE);
        arg0.setScene(scene);
        arg0.show();
        arg0.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
