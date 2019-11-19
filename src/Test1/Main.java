package Test1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {


    int GridSize = 20;
    int Move = +20;
    int WindowHeight = GridSize*10+ 25;
    int WindowWidth = GridSize*10;

    Rectangle rec;
    Button move;
    int RoboPos = 10;
    Rectangle[] recArray = new Rectangle[1000];
    Group layout = new Group();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        arg0.setTitle("Grid");

        CreateBoxes();

        recArray[RoboPos].setFill(Color.GREEN);
        Scene scene = new Scene(layout, WindowWidth, WindowHeight);
        arg0.setScene(scene);
        arg0.show();

        Button move = new Button("move");
        move.setMaxHeight(30);
        move.setMaxWidth(50);
        move.setTranslateX(WindowWidth/2-24);
        move.setTranslateY(WindowHeight-25);
        move.setOnMouseClicked(event -> {
            if(recArray[RoboPos+Move].getFill() == Color.BLACK){
                
            }
        });

        layout.getChildren().addAll(move);
    }
    public void CreateBoxes(){
        for(int i=0; i < 1000; i++){
            int finalI = i;
            recArray[i] = new Rectangle(10, 10);
            recArray[i].setOnMouseClicked(event -> {
                if(recArray[finalI].getFill() == Color.RED){
                    recArray[finalI].setFill(Color.BLACK);
                }
                else{
                    recArray[finalI].setFill(Color.RED);
                }
            });
        }
        int index = 1;
        for(int i = 0; GridSize > i; i++){
            for(int y = 0; GridSize> y; y++) {
                recArray[index].setTranslateY(i*11);
                recArray[index].setTranslateX(y*11);
                index++;
            }
        }
        for(int i=0; i <1000; i++){
            layout.getChildren().add(recArray[i]);
        }
    }
}





















