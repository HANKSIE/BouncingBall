package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pillar extends Element {

    public Pillar(int width, int height, String style) {
        super(width, height, style);
    }

    @Override
    public void run() {
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLayoutX(getLayoutX()-20);
            }
        });
        timer.start();
    }

}
