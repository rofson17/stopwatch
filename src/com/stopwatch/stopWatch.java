package com.stopwatch;

import  java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class stopWatch implements ActionListener {

    JFrame frame=new JFrame();
    JButton startButton=new JButton();
    JButton resetButton=new JButton();
    JLabel timeLabel=new  JLabel();
    int elapsedTime=0;
    int secounds=0;
    int minutes=0;
    int hours=0;
    boolean started=false;
    String seconds_str=String.format("%02d",secounds);
    String minute_str=String.format("%02d",minutes);
    String hours_str=String.format("%02d",hours);

    //set the timer
    Timer timer=new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime+=1000;
            hours=(elapsedTime/3600000);
            minutes=(elapsedTime/60000)%60;
            secounds=(elapsedTime/1000)%60;
            String seconds_str=String.format("%02d",secounds);
            String minute_str=String.format("%02d",minutes);
            String hours_str=String.format("%02d",hours);
            timeLabel.setText(hours_str+":"+minute_str+":"+seconds_str);
        }
    });

    stopWatch(){
        //set time label
        timeLabel.setText(hours_str+":"+minute_str+":"+seconds_str);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Lucida Console", Font.PLAIN, 30));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        //set start button
        startButton.setBounds(100, 200,100,50);
        startButton.setFont(new Font("Courier New", Font.BOLD, 20));
        startButton.setFocusable(false);
        startButton.setText("Start");
        startButton.addActionListener(this);

        //set reset button
        resetButton.setBounds(200, 200,100,50);
        resetButton.setFont(new Font("Courier New", Font.BOLD, 20));
        resetButton.setFocusable(false);
        resetButton.setText("Reset");
        resetButton.addActionListener(this);

        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);

        //set the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setTitle("Stop watch");
        ImageIcon image=new ImageIcon("src/com/stopwatch/logo.png");
        frame.setIconImage(image.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==startButton) {
            if (started == false) {
                started = true;
                startButton.setText("STOP");
                start();
            } else {
                started = false;
                startButton.setText("START");
                stop();
            }
        }if (e.getSource()==resetButton){
            started=false;
            startButton.setText("START");
            reset();
        }
    }

    void start(){
        timer.start();
    }

    void stop(){
        timer.stop();
    }

    void reset(){
        timer.stop();
        elapsedTime=0;
        secounds=0;
        minutes=0;
        hours=0;

        String seconds_str=String.format("%02d",secounds);
        String minute_str=String.format("%02d",minutes);
        String hours_str=String.format("%02d",hours);
        timeLabel.setText(hours_str+":"+minute_str+":"+seconds_str);
    }
}
