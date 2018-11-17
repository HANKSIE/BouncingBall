package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends Element{

    /*----------上升用變數-----------*/
    private int count = jumpPower;
    /*----------延遲用Timer---------*/
    private Timer timerDelay;
    /*-----------------------------*/

    public Ball(int width,int height,String style){
        super(width,height,style);

        /*------------延遲用Timer-------------*/
        timerDelay = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count >= 0){
                    System.out.println("delay");
                    layoutY = layoutY - count;
                    setLayoutY(layoutY);
                    count--;
                }else {
                    timerDelay.stop();
                }
            }
        });
        /*------------上升用Timer------------*/
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("all");
                /*------自由落體------*/
                if (v <= maxV){
                    lawOfMotion();
                }else {
                    v = maxV;
                    setLayoutY(layoutY);
                }


            }
        });

    }

    /*=======================執行緒=======================*/
    @Override
    public void run() {
        timer.start();
    }
    /*====================================================*/

    /*======================跳躍&掉落======================*/
    public void lawOfMotion(){
        /*------如果可以跳------*/
        if (canJump){

//            System.out.println("isRaise");
            /*===============上升=============*/

            if (count >= 0){
                System.out.println("here");
                timerDelay.start();
            }

            /*-----上升完後將count設回原值-----*/
            count = jumpPower;
            /*------------------------------*/

            /*===============================*/

            /*--------回到剛掉落速度--------*/
            v = origV;
            /*----------------------------*/
            canJump = false;
            /*----------------------------*/

        } else {

            /*----------如果掉到地板上----------*/
            if (layoutY < floor-height){
                /*------------下降------------*/
                v += v*g;
                layoutY = layoutY + v;
                setLayoutY(layoutY);
                /*--------------------------*/
            }else {
                layoutY = floor-height;
                setLayoutY(floor-height);
            }

        }

//        System.out.println("Y:"+" "+getLayoutY());

    }
    /*====================================================*/


}