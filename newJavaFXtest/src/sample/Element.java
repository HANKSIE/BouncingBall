package sample;

import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Element extends Label implements Runnable{

    protected static ArrayList<Element> eleArr = new ArrayList<Element>();
    /*----------地板---------*/
    protected int floor = 490;
    /*-----移動用Timer-----*/
    protected Timer timer;
    /*-------重力---------*/
    protected double g = 0.2;
    /*------原始速度------*/
    protected double origV = 1;
    /*-----將v速度初始化----*/
    protected double v = origV;
    /*------最大速率限制------*/
    protected double maxV = 30;
    /*-------跳躍力-------*/
    protected int jumpPower = 20;
    /*---可不可跳躍布林值----*/
    protected boolean canJump = false;
    /*--------------------*/

    /*=======================建構元=======================*/
    public Element(int width, int height, int layoutX,int layoutY,String style){
        this.setStyle(style);
        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
        this.setPrefSize(width,height);
        eleArr.add(this);
    }
    /*===================================================*/

    /*=======================執行緒=======================*/
    @Override
    public void run() {

    }
    /*====================================================*/

    /*=====================設定canJump=====================*/
    public void setCanJump(boolean flag){
        canJump = flag;
    }
    /*====================================================*/

}