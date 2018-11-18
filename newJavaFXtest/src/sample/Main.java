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
    /*--------------------物件Style-------------------*/
    private String ballStyle="-fx-background-image:url(images/ball.png);";
    private String pillarStyle = "-fx-background-color:white;";
    /*----------------------物件----------------------*/
    private Ball ball = new Ball(36,36,ballStyle);
    private Pillar pillar = new Pillar(30,100,pillarStyle);
    private Pillar pillar2 = new Pillar(30,100,pillarStyle);
    private Pillar pillar3 = new Pillar(30,100,pillarStyle);
    private Pillar pillar4 = new Pillar(30,100,pillarStyle);
    private Pillar pillar5 = new Pillar(30,100,pillarStyle);
    private Pillar pillar6 = new Pillar(30,100,pillarStyle);
    private Pillar pillar7 = new Pillar(30,100,pillarStyle);
    private Pillar pillar8 = new Pillar(30,100,pillarStyle);
    private Pillar pillar9 = new Pillar(30,100,pillarStyle);
    private Pillar pillar10 = new Pillar(30,100,pillarStyle);
    /*--------------------執行緒物件-------------------*/
    private Thread ballThread = new Thread(ball);
    private Thread pillarThread = new Thread(pillar);
    private Thread pillarThread2 = new Thread(pillar2);
    private Thread pillarThread3 = new Thread(pillar3);
    private Thread pillarThread4 = new Thread(pillar4);
    private Thread pillarThread5 = new Thread(pillar5);
    private Thread pillarThread6 = new Thread(pillar6);
    private Thread pillarThread7 = new Thread(pillar7);
    private Thread pillarThread8 = new Thread(pillar8);
    private Thread pillarThread9 = new Thread(pillar9);
    private Thread pillarThread10 = new Thread(pillar10);
    /*-----------------------------------------------*/

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
        ball.setLayoutX(90);
        ball.setLayoutY(90);
        ballThread.start();
        /*----------障礙物---------*/
        pillar.setLayoutX(1000);
        pillar.setLayoutY(400-pillar.getLayoutY());
        pillarThread.start();

        pillar2.setLayoutX(500);
        pillar2.setLayoutY(0);
        pillarThread2.start();

        pillar3.setLayoutX(1300);
        pillar3.setLayoutY(400-pillar3.getLayoutY());
        pillarThread3.start();

        pillar4.setLayoutX(1700);
        pillar4.setLayoutY(400-pillar4.getLayoutY());
        pillarThread4.start();

        pillar5.setLayoutX(2100);
        pillar5.setLayoutY(0);
        pillarThread5.start();

        pillar6.setLayoutX(2500);
        pillar6.setLayoutY(400-pillar6.getLayoutY());
        pillarThread6.start();

        pillar7.setLayoutX(2700);
        pillar7.setLayoutY(0);
        pillarThread7.start();

        pillar8.setLayoutX(2900);
        pillar8.setLayoutY(400-pillar8.getLayoutY());
        pillarThread8.start();

        pillar9.setLayoutX(1000);
        pillar9.setLayoutY(0);
        pillarThread9.start();

        pillar10.setLayoutX(1000);
        pillar10.setLayoutY(400-pillar.getLayoutY());
        pillarThread10.start();

        /*-------面板加入物件-------*/
        anchorPane.getChildren().add(ball);
        anchorPane.getChildren().add(pillar);
        anchorPane.getChildren().add(pillar2);
        anchorPane.getChildren().add(pillar3);
        anchorPane.getChildren().add(pillar4);
        anchorPane.getChildren().add(pillar5);
        anchorPane.getChildren().add(pillar6);
        anchorPane.getChildren().add(pillar7);
        anchorPane.getChildren().add(pillar8);
        anchorPane.getChildren().add(pillar9);
        anchorPane.getChildren().add(pillar10);
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



