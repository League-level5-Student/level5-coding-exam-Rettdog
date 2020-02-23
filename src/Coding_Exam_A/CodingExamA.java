package Coding_Exam_A;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		
		int numRobs = Integer.parseInt(JOptionPane.showInputDialog("How many robots?"));
		
		String color = JOptionPane.showInputDialog("What color? Red, Green, or Blue?");
		
		Color drawColor;
		
		if(color.equalsIgnoreCase("Red")) {
			drawColor = Color.red;
		}else if(color.equalsIgnoreCase("Blue")) {
			drawColor = Color.blue;
		}else if(color.equalsIgnoreCase("Green")) {
			drawColor = Color.green;
		}else {
			drawColor = Color.black;
		}
		
		int sides = Integer.parseInt(JOptionPane.showInputDialog("How many sides?"));
		
		ArrayList<Thread> threads = new ArrayList<Thread>(numRobs);
		
		System.out.println(numRobs);
		for(int i = 0;i<numRobs;i++) {
			int j = i;
			
			threads.add( new Thread(()-> drawShape(150*j+50,200,drawColor,new Robot(),sides)));
		}
		for(int i = 0;i<threads.size();i++) {
			
			threads.get(i).start();
		}
		//drawShape(100,100,Color.red,new Robot(),5);
	}
	
	public static void drawShape(int x, int y, Color color, Robot rob, int sides) {
		rob.setPenColor(color);
		rob.setX(x);
		rob.setY(y);
		rob.show();
		rob.setSpeed(100);
		rob.penDown();
		int angle = 360/sides;
		
		for(int i = 0;i<sides;i++) {
			rob.move(50);
			rob.turn(angle);
		}
		rob.hide();
		
	}
	
}
