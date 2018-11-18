package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Pillar extends Element {

    private Pillar thisRef = this;

    public Pillar(int width, int height, int layoutX,int layoutY,String style) {
        super(width, height, layoutX, layoutY, style);
    }

    @Override
    public void run() {
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisRef.setLayoutX(thisRef.getLayoutX()-20);
            }
        });
        timer.start();
    }


}
