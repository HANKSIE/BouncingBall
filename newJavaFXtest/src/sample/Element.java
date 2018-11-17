package sample;

import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Element extends Label implements Runnable{

    /*----------地板---------*/
    public int floor = 400;
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
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*------自由落體------*/
                if (v <= maxV){
                    lawOfMotion();
                }else {
                    v = maxV;
                    setLayoutY(layoutY);
                }


            }
        });

        timer.start();
    }
    /*====================================================*/

    /*======================跳躍&掉落======================*/
    public void lawOfMotion(){
        /*------如果可以跳------*/
        if (canJump){

            System.out.println("isRaise");
            /*===============上升=============*/

            for (int i = jumpPower; i>=0; i--){
                layoutY = layoutY - i;
                /*--------------delay--------------*/
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                /*--------------設y座標--------------*/
                setLayoutY(layoutY);
            }

            /*===============================*/

            /*--------回到剛掉落速度--------*/
            v = origV;
            /*----------------------------*/
            canJump = !canJump;
            /*----------------------------*/

        } else {
            System.out.println("Down");
            /*----------如果掉到地板上----------*/
            if (layoutY <= floor-height){
                /*------------下降------------*/
                v += v*g;
                layoutY = layoutY + v;
                setLayoutY(layoutY);
                /*--------------------------*/
            }
        }
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