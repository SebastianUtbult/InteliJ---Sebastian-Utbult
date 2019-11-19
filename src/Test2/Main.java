package Test2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    public Rectangle[][] Grid = new Rectangle[100][50];
    public Boolean[][] GridBol = new Boolean[100][50];

    public Group g = new Group();

    public int ch_X = 0;
    public int ch_Y = 0;
    public int ch_XX = 0;
    public int ch_YY = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ps) throws Exception {

        Scene sc = new Scene(g, 99*10, 70*10, Color.GREY);
        ps.setScene(sc);
        ps.show();

        Interface();
        control();

    }

    public void Interface(){


        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 100; j++) {
                Grid[j][i] = new Rectangle(10, 10);
                Grid[j][i].setFill(Color.WHITE);
                Grid[j][i].setTranslateY(i*10);
                Grid[j][i].setTranslateX(j*10);
                int finalJ = j;
                int finalI = i;
                Grid[j][i].setOnMouseClicked(event -> {
                    if(Grid[finalJ][finalI].getFill() == Color.BEIGE){
                        Grid[finalJ][finalI].setFill(Color.BLACK);
                        GridBol[finalJ][finalI] = Boolean.TRUE;
                        System.out.println(finalJ/2 + " " + finalI/2);
                    }else{
                        Grid[finalJ][finalI].setFill(Color.BEIGE);
                        GridBol[finalJ][finalI] = Boolean.FALSE;
                        System.out.println(finalJ/2 + " " + finalI/2);
                    };

                });
                if(j % 2 == 0 && i % 2 == 0){
                    Grid[j][i].setFill(Color.BEIGE);
                };
                if(j % 2 == 1 && i % 2 == 1){
                    Grid[j][i].setFill(Color.WHITE);
                };
                g.getChildren().addAll(Grid[j][i]);
            }
        }


    }
    public void control(){
        Rectangle Border = new rec(200, 990, 0, 500);
        Border.setFill(Color.GREY);


        Rectangle ch = new rec(10, 10, ch_X, ch_Y);
        ch.setFill(Color.LIGHTGREEN);

        Rectangle Up_btn = new rec(40, 40, 480, 530);
        Up_btn.setOnMouseClicked(event -> {
            ch_Y=ch_Y-20;
            ch_YY=-2;
            ch.setTranslateY(ch_Y);
            System.out.println(ch_X/20 + ", " + ch_Y/20);
        });
        Rectangle Down_btn = new rec(40, 40, 480, 620);
        Down_btn.setOnMouseClicked(event -> {
            ch_Y=ch_Y+20;
            ch_YY=+2;
            ch.setTranslateY(ch_Y);
            System.out.println(ch_X/20 + ", " + ch_Y/20);
        });
        Rectangle Left_btn = new rec(40, 40, 435, 575);
        Left_btn.setOnMousePressed(event -> {
            ch_X=ch_X-20;
            ch_XX=-2;
            ch.setTranslateX(ch_X);
            System.out.println(ch_X/20 + ", " + ch_Y/20);
        });
        Rectangle Right_btn = new rec(40, 40, 525, 575);
        Right_btn.setOnMouseClicked(event -> {
            if(GridBol[ch_XX+2][ch_YY] != Boolean.TRUE){
                ch_X=ch_X+20;
                ch_XX=+2;
                ch.setTranslateX(ch_X);
                System.out.println(ch_X/20 + ", " + ch_Y/20);
            }
        });

        g.getChildren().addAll(Border, Up_btn, Down_btn, Left_btn, Right_btn, ch);
    }
}
