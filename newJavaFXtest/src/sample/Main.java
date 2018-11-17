package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Application { //繼承javafx.application.Application抽象類別

    private AnchorPane anchorPane;
    private Scene gameScene;
    private String ballStyle="-fx-background-image:url(images/ball.png);";
    private Ball ball = new Ball(36,36,ballStyle);
    private Thread ballThread = new Thread(ball);

    @Override
    //JavaFX程式進入點
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));//載入fxml檔(UI介面)

        /*---------取得面板---------*/
        anchorPane = (AnchorPane) root.lookup("#anchorPane");
        /*----------scene----------*/
        gameScene = new Scene(root,500,500);
        setKeyboardEvent();
        /*----------ball----------*/
        anchorPane.getChildren().add(ball);
        ball.setLayoutX(90);
        ball.setLayoutY(90);
        ballThread.start();
        /*------------------------*/
        primaryStage.setTitle("game");//設定視窗標題
        primaryStage.setScene(gameScene);//設定Stage要使用的Scene，並且用Scene()建構視窗長寬
        primaryStage.show();

    }

    public void setKeyboardEvent(){

        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch (event.getCode()){

                    case UP:
                        ball.setCanJump(true);
                        break;

                }

            }
        });
    }

    public static void main(String[] args) {
        launch(args);//啟動獨立JavaFX應用程式
    }

}



