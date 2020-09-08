package com.zg.study.gui;

import javafx.scene.layout.Pane;

import javax.swing.*;
import javax.xml.bind.Marshaller;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.Init();
    }


}

class MyFrame extends Frame{
    //属性
    private Color backgroundColor = Color.LIGHT_GRAY;

    //方法
    public void Init(){
        this.setTitle("MyFrame");
        this.setVisible(true);
        this.setBounds(200,200,400,300);
        this.setBackground(backgroundColor);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setLayout(new GridLayout(3,1));

        //建立3个面板，了解3种布局管理器
        Panel panel1 = new Panel();     //了解流式布局
        Panel panel2 = new Panel();     //了解东西南北中布局
        Panel panel3 = new Panel();     //了解表格布局

        Button btn = new Button("btn_FlowLayout");
        panel1.setLayout(new FlowLayout());
        panel1.add(btn,FlowLayout.LEFT);
        this.add(panel1);



        Button[] buttons = new Button[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new Button("btn_BorderLayout_"+i);
        }
        panel2.setLayout(new BorderLayout());
        panel2.add(buttons[0],BorderLayout.EAST);
        panel2.add(buttons[1],BorderLayout.SOUTH);
        panel2.add(buttons[2],BorderLayout.WEST);
        panel2.add(buttons[3],BorderLayout.NORTH);
        panel2.add(buttons[4],BorderLayout.CENTER);
        this.add(panel2);


        Button[] btns = new Button[6];
        panel3.setLayout(new GridLayout(2,3));
        for (int i = 0; i < 6; i++) {
            btns[i] = new Button("btn_Grid_"+i);
            panel3.add(btns[i]);
        }
        this.add(panel3);

    }

}
class MyFrame_J extends JFrame{
    public void Init(){
        this.setTitle("MyFrame_J");
        this.setBounds(200,200,400,300);
        this.setVisible(true);
        this.contains(0,0);
        this.setBackground(Color.red); //JFrame直接设置背景颜色无效，要先实例化容器，设置容器背景色

        //Swing默认关闭窗口方法
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //容器实例化,JFrame要改窗口背景色要先把容器实例化
        Container contentPane = this.getContentPane();  //获得一个容器
        contentPane.setBackground(Color.BLUE); //设置背景色






    }
}