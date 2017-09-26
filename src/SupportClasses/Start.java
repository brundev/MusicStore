package SupportClasses;

import Views.MainView;

import javax.swing.*;

public class Start {

    public static void main(String args[])
    {
        JFrame frame = new JFrame("Music Store App");
        frame.setContentPane(new MainView().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900,600);
        frame.setVisible(true);
    }

}
