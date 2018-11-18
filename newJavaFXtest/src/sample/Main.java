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
    private Ball ball = new Ball(35,35,90,90,ballStyle);
    private Pillar pillar = new Pillar(30,100,1000,400,pillarStyle);
    private Pillar pillar2 = new Pillar(30,100,1600,400,pillarStyle);
    private Pillar pillar3 = new Pillar(30,100,2000,0,pillarStyle);
    private Pillar pillar4 = new Pillar(30,100,2300,400,pillarStyle);
    private Pillar pillar5 = new Pillar(30,100,2400,400,pillarStyle);
    private Pillar pillar6 = new Pillar(30,100,2800,0,pillarStyle);
    private Pillar pillar7 = new Pillar(30,100,3300,400,pillarStyle);
    private Pillar pillar8 = new Pillar(30,100,3400,0,pillarStyle);
    private Pillar pillar9 = new Pillar(30,100,3800,400,pillarStyle);
    private Pillar pillar10 = new Pillar(30,100,4000,0,pillarStyle);
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

        ballThread.start();
        /*----------障礙物---------*/
        pillarThread.start();
        pillarThread2.start();
        pillarThread3.start();
        pillarThread4.start();
        pillarThread5.start();
        pillarThread6.start();
        pillarThread7.start();
        pillarThread8.start();
        pillarThread9.start();
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

        System.out.println(Element.eleArr.size());
    }

    public void setKeyboardEvent(){

        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch (event.getCode()){

                    case UP:
                        ball.setCanJump(true);
                        break;
                    case LEFT:
//                        for (int i=1; i<Element.eleArr.size(); i++){
//                            Element.eleArr.get(i).setLayoutX(Element.eleArr.get(i).getLayoutX()+20);
//                        }
                        break;
                    case RIGHT:
//                        for (int i=1; i<Element.eleArr.size(); i++){
//                            Element.eleArr.get(i).setLayoutX(Element.eleArr.get(i).getLayoutX()-20);
//                        }
                        break;
                }

            }
        });
    }

    public static void main(String[] args) {
        launch(args);//啟動獨立JavaFX應用程式
    }

}



