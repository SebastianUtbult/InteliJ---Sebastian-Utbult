package Test3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.WhileNode;

public class Main extends Application {

    public static Rectangle[][] Grid = new Rectangle[30][30];
    public static int[][] Wall = new int[30][30];
    public static Group root = new Group();

    public static int ch_X = 0;
    public static int ch_Y = 14;
    public static int X = 10*ch_X;
    public static int Y = 10*ch_Y;

    public static Rectangle ch;
    public static int Compass = 1;

    public static void Draw_rectangles(){
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                int finalI = i;
                int finalJ = j;
                Grid[i][j] = new rec(10,10,i*10,j*10);
                Grid[i][j].setFill(Color.BLACK);
                Grid[i][j].setOnMouseClicked(event -> {
                    if(Grid[finalI][finalJ].getFill() == Color.BLACK){
                        Grid[finalI][finalJ].setFill(Color.RED);
                        Wall[finalI][finalJ] = 1;
                        System.out.println(Wall[finalI][finalJ]);
                    }else{
                        Grid[finalI][finalJ].setFill(Color.BLACK);
                        Wall[finalI][finalJ] = 0;
                        System.out.println(Wall[finalI][finalJ]);
                    }
                });
                root.getChildren().addAll(Grid[i][j]);
            }
        }
    }

    public static void Draw_interface(){
        ch = new rec(10,10,X,Y);
        ch.setFill(Color.GREENYELLOW);
        Rectangle BG = new rec(100, 300, 0, 300);
        BG.setFill(Color.GREENYELLOW);
        BG.setOnMouseClicked(event -> {
            System.out.println("XY: " + ch.getTranslateX() + " " + ch.getTranslateY());
            System.out.println("Compass: " + Compass);
            Check_Surroundings(Compass);
            ch.setTranslateY(ch_Y*10);
            ch.setTranslateX(ch_X*10);
        });
        root.getChildren().addAll(BG,ch);
    }

    public static void Check_Surroundings(int check){

        if(ch_X + 1 >= 30) {
            ch_X = 0;
            ch_Y++;
            return;
        }

        switch (check){
            case 1:
                if(Wall[ch_X][ch_Y+1]!=1){
                    ch_Y++;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                    Compass=2;
                }else if(Wall[ch_X+1][ch_Y]!=1){
                    ch_X=ch_X+1;
                    X = 10*ch_X;
                    Y = 10*ch_Y;
                }else if(Wall[ch_X][ch_Y-1]!=1){
                    ch_Y--;
                    Compass=4;
                }else{
                    ch_X=ch_X-1;
                    X = 10*ch_X;
                    Y = 10*ch_Y;
                    Compass=3;
                }
                break;
            case 2:
                if(Wall[ch_X-1][ch_Y]!=1){
                    ch_X--;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                    Compass=3;
                }else if(Wall[ch_X][ch_Y+1]!=1){
                    ch_Y++;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                }else if(Wall[ch_X+1][ch_Y]!=1){
                    ch_X++;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                    Compass=1;
                }else{
                    ch_Y--;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                    Compass=4;
                }
                break;
            case 3:
                if(Wall[ch_X][ch_Y-1]!=1){
                    ch_Y--;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                    Compass=4;
                }else if(Wall[ch_X-1][ch_Y]!=1){
                    ch_X--;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                }else {
                    ch_Y++;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                    Compass=2;
                }
                break;
            case 4:
                if(Wall[ch_X+1][ch_Y]!=1){
                    ch_X++;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                    Compass=1;
                }else if(Wall[ch_X][ch_Y-1]!=1){
                    ch_Y--;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                }else if(Wall[ch_X-1][ch_Y]!=1){
                    ch_X--;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                    Compass=2;
                }else{
                    ch_Y++;
                    Y = 10*ch_Y;
                    X = 10*ch_X;
                    Compass=2;
                }
                break;
        }
    }

    @Override
    public void start(Stage arg0) throws Exception {
        Scene sc = new Scene(root, 300, 400);
        arg0.setScene(sc);
        arg0.show();
    }

    public static void main(String[] args) {
        System.out.println(ch_X + " " + ch_Y);
        Draw_rectangles();
        Draw_interface();
        launch(args);
    }
}
