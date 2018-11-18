package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends Element{

    private Ball thisRef = this;
    /*----------上升用變數-----------*/
    private int count = jumpPower;
    /*----------延遲用Timer---------*/
    private Timer timerDelay;
    /*-----------------------------*/

    public Ball(int width,int height,int layoutX,int layoutY,String style){
        super(width,height,layoutX,layoutY,style);

        /*------------延遲上升用Timer-------------*/
        timerDelay = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count > 3){
                    thisRef.setLayoutY(thisRef.getLayoutY()-count);
                    count--;
                }else {
                    timerDelay.stop();
                }
            }
        });
        /*------------移動用Timer------------*/
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*------自由落體------*/
                if (v <= maxV){
                    lawOfMotion();
                }else {
                    v = maxV;
                }

                collisionDetection();

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

            /*===============上升=============*/

            if (count >= 0){
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
            if (this.getLayoutY() < floor-this.getHeight()){
                /*------------下降------------*/
                v += v*g;
                this.setLayoutY(this.getLayoutY()+v);
                /*--------------------------*/
            }else {
                this.setLayoutY(floor-this.getHeight());
            }

        }

    }
    /*====================================================*/

    /*======================碰撞偵測=======================*/
    public void collisionDetection(){

        for (int i=1; i<eleArr.size(); i++){
            if ( (this.getLayoutY()+this.getHeight())>=(eleArr.get(i).getLayoutY()) &&
                    this.getLayoutY()<=(eleArr.get(i).getLayoutY()+eleArr.get(i).getHeight())&&
                    (this.getLayoutX()+this.getWidth())>=(eleArr.get(i).getLayoutX()) &&
                    this.getLayoutX()<=(eleArr.get(i).getLayoutX()+eleArr.get(i).getWidth())
                    ){

                eleArr.get(i).setStyle("-fx-background-color:red;");
                stopTimer();

            }else {
                startTimer();
            }
        }

    }
    /*====================================================*/

    /*======================timer停用======================*/
    public void stopTimer(){
        for (int j=1; j<eleArr.size(); j++){
            eleArr.get(j).timer.stop();
        }
    }
    /*====================================================*/

    /*======================timer啟用======================*/
    public void startTimer(){
        for (int j=1; j<eleArr.size(); j++){
            eleArr.get(j).timer.start();
        }
    }
    /*====================================================*/
}
