package partB;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DisplayAllBooking extends JFrame implements ActionListener
{
	private JLabel lblTitle;
	private JTextArea txtArea;
	private JButton btnDisplay, btnExit;
	private JScrollPane jsp;
	private Container cn;
	
	// Declare a private LinkedList of Room Bookings
	private LinkedList <GuitarBooking> bookings;
	// Declare a local LinkedList of Room Bookings in the brackets of the constructor
	public DisplayAllBooking(LinkedList bookings)
	{
		// assign the local Linked List to the private one
		this.bookings=bookings;
		
		cn = getContentPane();
		
		cn.setLayout(null); 		//Absolute Layout Manager
		
		lblTitle = new JLabel("Display Bookings");
		lblTitle.setFont(new Font("Arial",Font.BOLD,18));
		lblTitle.setBounds(10, 20, 300, 50);
		cn.add(lblTitle);

		txtArea = new JTextArea(20,60);
		txtArea.setFont(new Font("Lucida Console",Font.PLAIN,12));
	
		jsp = new JScrollPane(txtArea);
		jsp.setBounds(10, 120, 785,270);
		
		cn.add(jsp);
		
		btnDisplay = new JButton ("Display");
		btnDisplay.setFont(new Font("Arial", Font.BOLD,18));
		btnDisplay.setBounds(475,50,150,50);
		btnDisplay.addActionListener(this);
		cn.add(btnDisplay);
		
		btnExit = new JButton ("Exit");
		btnExit.setFont(new Font("Arial", Font.BOLD,18));
		btnExit.setBounds(645,50,150,50);
		btnExit.addActionListener(this);
		cn.add(btnExit);
		
	}
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		if ( ev.getSource()==btnExit)
		{
			txtArea.setText("");
			this.setVisible(false);
		}
		
		if ( ev.getSource()==btnDisplay)
		{	
			// Declare a String variable
			String s="";
			GuitarBooking selectBooking = new GuitarBooking();
			
			txtArea.setText("");
			s="Lesson Type          	Forename 	Surname  No in Party   Instructor Code \n";
			txtArea.append(s);
			s="--------------------------------------------------------------------------------\n";
			txtArea.append(s);
			
			// Declare and create an iterator for the Bookings LinkedList
			Iterator i = bookings.listIterator();
			int listNum=0;
			
			
			// While the iterator's hasNext() method is true
			while(i.hasNext())
			{
				s = i.next().toString();
				txtArea.append(s.toString());
				listNum++;
			}
				// return the toString() value of the next item in the list to the string created above
				
				// append the string to the txtarea
			
	
		}
	}
}
