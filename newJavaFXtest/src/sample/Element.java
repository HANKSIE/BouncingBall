package sample;

import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Element extends Label implements Runnable{

    /*----------地板---------*/
    public int floor = 350;
    /*-----移動用Timer-----*/
    protected Timer timer;
    /*----此元件y位置------*/
    protected double layoutY = this.getLayoutY();
    /*-------重力---------*/
    protected double g = 0.2;
    /*------原始速度------*/
    protected double origV = 1;
    /*-----將v速度初始化----*/
    protected double v = origV;
    /*------最大速率限制------*/
    protected double maxV = 30;
    /*----------寬 高--------*/
    protected int width,height;
    /*-------跳躍力-------*/
    protected int jumpPower = 15;
    /*---可不可跳躍布林值----*/
    protected boolean canJump = false;
    /*--------------------*/

    /*=======================建構元=======================*/
    public Element(int width, int height, String style){
        this.width = width;
        this.height = height;
        this.setStyle(style);
        this.setPrefSize(width,height);
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

    /*=====================取得canJump=====================*/
    public boolean getCanJump(){
        return canJump;
    }
    /*====================================================*/

}