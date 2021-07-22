package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
	JFrame window = new JFrame();
	JPanel titlePanel = new JPanel();
	JLabel title = new JLabel();
	JPanel buttonPanel = new JPanel();
	JButton[] boxes = new JButton[9];
	Random random = new Random();
	Boolean playerTurn=true;
	
	TicTacToe(){

		
		window.setSize(800,800);
		window.setBackground(new Color(50,50,50));
		window.setVisible(true);
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		title.setFont(new Font("Ink Free",Font.BOLD,75));
		title.setBackground(new Color(25,25,25));
		title.setForeground(new Color(0,255,0));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setText("TicTacToe");
		title.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,800,100);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(Color.black);
		
		for(int i=0;i<9;i++) {
			boxes[i]=new JButton();
			buttonPanel.add(boxes[i]);
			boxes[i].setFont(new Font("Ink Free",Font.BOLD,75));
			boxes[i].setBackground(Color.DARK_GRAY);
			boxes[i].setFocusable(false);
			boxes[i].addActionListener(this);
		
		}
		titlePanel.add(title);
		window.add(titlePanel,BorderLayout.NORTH);
		window.add(buttonPanel);
	
		
		firstTurn();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
    	for(int i=0;i<9;i++) {
    		
    		if(e.getSource()==boxes[i]) {
    			if(playerTurn) {
    				if(boxes[i].getText()=="") {
    					boxes[i].setForeground(new Color(255,0,0));
    					boxes[i].setText("X");
    					playerTurn=false;
    					title.setText("O turn");
    					check();
    				}
    				
    			}
    			
    		else {
    			if(e.getSource()==boxes[i]) {
    				if(playerTurn==false) {
    					if (boxes[i].getText()=="") {
    						boxes[i].setForeground(new Color(0,0,255));
    						boxes[i].setText("O");
    						playerTurn=true;
    						title.setText("X Turn");
    						check();
    						}
    					}
    				}
    			}
    		}		
    	}	
    	
    	
    }
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (random.nextInt(2)==0) {
			title.setText("X Turn");
			playerTurn=true;
		}
		else {
			title.setText("O Turn");
			playerTurn=false;
		}
		
		
		
	}
	
	public void check() {
		
		if (
				(boxes[1].getText() == "X") &&
				(boxes[2].getText() == "X")&&
				(boxes[3].getText() == "X")) {
			xWinner(1,2,3);
		}if(
				(boxes[3].getText()=="X") &&
				(boxes[4].getText()=="X") &&
				(boxes[5].getText()=="X")
				) {
			xWinner(3,4,5);
		}
		if(
				(boxes[6].getText()=="X") &&
				(boxes[7].getText()=="X") &&
				(boxes[8].getText()=="X")
				) {
			xWinner(6,7,8);
		}
		if(
				(boxes[0].getText()=="X") &&
				(boxes[3].getText()=="X") &&
				(boxes[6].getText()=="X")
				) {
			xWinner(0,3,6);
		}
		if(
				(boxes[1].getText()=="X") &&
				(boxes[4].getText()=="X") &&
				(boxes[7].getText()=="X")
				) {
			xWinner(1,4,7);
		}
		if(
				(boxes[2].getText()=="X") &&
				(boxes[5].getText()=="X") &&
				(boxes[8].getText()=="X")
				) {
			xWinner(2,5,8);
		}
		if(
				(boxes[0].getText()=="X") &&
				(boxes[4].getText()=="X") &&
				(boxes[8].getText()=="X")
				) {
			xWinner(0,4,8);
		}
		if(
				(boxes[2].getText()=="X") &&
				(boxes[4].getText()=="X") &&
				(boxes[6].getText()=="X")
				) {
			xWinner(2,4,6);
		}
		//check O win conditions
		if(
				(boxes[0].getText()=="O") &&
				(boxes[1].getText()=="O") &&
				(boxes[2].getText()=="O")
				) {
			oWinner(0,1,2);
		}
		if(
				(boxes[3].getText()=="O") &&
				(boxes[4].getText()=="O") &&
				(boxes[5].getText()=="O")
				) {
			oWinner(3,4,5);
		}
		if(
				(boxes[6].getText()=="O") &&
				(boxes[7].getText()=="O") &&
				(boxes[8].getText()=="O")
				) {
			oWinner(6,7,8);
		}
		if(
				(boxes[0].getText()=="O") &&
				(boxes[3].getText()=="O") &&
				(boxes[6].getText()=="O")
				) {
			oWinner(0,3,6);
		}
		if(
				(boxes[1].getText()=="O") &&
				(boxes[4].getText()=="O") &&
				(boxes[7].getText()=="O")
				) {
			oWinner(1,4,7);
		}
		if(
				(boxes[2].getText()=="O") &&
				(boxes[5].getText()=="O") &&
				(boxes[8].getText()=="O")
				) {
			oWinner(2,5,8);
		}
		if(
				(boxes[0].getText()=="O") &&
				(boxes[4].getText()=="O") &&
				(boxes[8].getText()=="O")
				) {
			oWinner(0,4,8);
		}
		if(
				(boxes[2].getText()=="O") &&
				(boxes[4].getText()=="O") &&
				(boxes[6].getText()=="O")
				) {
			oWinner(2,4,6);
		}
		
	}
	public void xWinner(int a, int b, int c) {
		
		boxes[a].setBackground(Color.green);
		boxes[b].setBackground(Color.green);	
		boxes[c].setBackground(Color.green);	
		title.setText("X Won");
		
		for(int i = 0; i<9; i++) {
			boxes[i].setEnabled(false);
			
		}
		
	}
	public void oWinner(int a, int b, int c) {
		boxes[a].setBackground(Color.green);
		boxes[b].setBackground(Color.green);	
		boxes[c].setBackground(Color.green);	
		title.setText("O Won");
		
		for(int i = 0; i<9; i++) {
			boxes[i].setEnabled(false);
			
		}
		
	}
	
}

