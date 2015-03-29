package com.starbox.puzzlecar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main implements Pay {
	static Main m;
	JFrame frame;
	public static void main(String[] args) {	
		m = new Main();
		m.createGUI();	
	}
	
	public void createGUI(){
		frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		JPanel panel= new JPanel();	       
        final JTextField edit1 = new JTextField("1524",4);
        final JTextField edit2 = new JTextField("800",4);
       // final JCheckBox cb = new JCheckBox("premium",true);
        panel.add(edit1, BorderLayout.CENTER);
        panel.add(edit2, BorderLayout.CENTER);
      //  panel.add(cb, BorderLayout.CENTER);
        JButton startButton = new JButton("Start");
        panel.add(startButton, BorderLayout.SOUTH);
        startButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {            	
            	LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        		cfg.vSyncEnabled=true;
        		cfg.title = "Game";
        		
        		cfg.width = Integer.valueOf(edit1.getText());
        		cfg.height =Integer.valueOf(edit2.getText());
        		MainClass mc= new MainClass();
        		new LwjglApplication(mc, cfg);        		
        		mc.payFrame=m;
        		mc.setPremium(true/*cb.isSelected()*/);
            }
        });
        frame.getContentPane().add(panel);          
        frame.setSize(500, 150);
        
       // frame.pack();
      //  frame.set
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
	}

	@Override
	public void payClick() {


        JOptionPane.showMessageDialog(frame, "Денег давай");
	}

	public void rateClick() {


        JOptionPane.showMessageDialog(frame, "коментарий давай");
	}
	@Override
	public String getAId() {
		
		return "";
	}

	@Override
	public int getAccuracy() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void playToy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showToast(String exitText) {
		// TODO Auto-generated method stub
		
	}
}
