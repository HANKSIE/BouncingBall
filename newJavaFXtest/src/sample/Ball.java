package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends Element{

    public Ball(int width,int height,String style){
        super(width,height,style);
    }

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


}