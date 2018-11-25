package partB;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DisplayByName extends JFrame implements ActionListener
{
	private JLabel lblTitle, lblForename, lblSurname;
	private JTextArea txtArea;
	private JTextField txtSurname, txtForename;
	private JButton btnDisplay, btnExit;
	private JScrollPane jsp;
	private Container cn;
	
	// Declare a private LinkedList of Room Bookings
	private LinkedList <GuitarBooking> bookings;
	// Declare a local LinkedList of Room Bookings in the brackets of the constructor
	public DisplayByName(LinkedList bookings)
	{
		// assign the local Linked List to the private one
		this.bookings=bookings;
		
		cn = getContentPane();
		
		cn.setLayout(null); 		//Absolute Layout Manager
		
		lblTitle = new JLabel("Display Bookings");
		lblTitle.setFont(new Font("Arial",Font.BOLD,18));
		lblTitle.setBounds(10, 20, 300, 50);
		cn.add(lblTitle);

		lblForename = new JLabel("Forename:", JLabel.RIGHT);
		lblForename.setFont(new Font("Arial", Font.BOLD,14));
		lblForename.setBounds(100,20,150,50);
		cn.add(lblForename);
		
		
		lblSurname = new JLabel("Surname:", JLabel.RIGHT);
		lblSurname.setFont(new Font("Arial", Font.BOLD,14));
		lblSurname.setBounds(100,70,150,50);
		cn.add(lblSurname);
		
		txtForename= new JTextField(10);
		txtForename.setFont(new Font("Arial", Font.PLAIN,14));
		txtForename.setBounds(250,20,150,50);
		cn.add(txtForename);
		
		txtSurname= new JTextField(10);
		txtSurname.setFont(new Font("Arial", Font.PLAIN,14));
		txtSurname.setBounds(250,70,150,50);
		cn.add(txtSurname);
		
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
			String searchForename = txtForename.getText();
			String searchSurname = txtSurname.getText();
			
			String s="";
			
			
			txtArea.setText("");
			s="Lesson Type          	Forename 	Surname  No in Party   Instructor Code \n";
			txtArea.append(s);
			s="--------------------------------------------------------------------------------\n";
			txtArea.append(s);
			
			if(searchForename.length()<1 && searchSurname.length()<1)
			{
				JOptionPane.showMessageDialog(null, "The names must contain more than 1 character");
			}
			else
			{
				// find the contact:
				ListIterator i = bookings.listIterator();
				while(i.hasNext())
				{
					GuitarBooking selectBooking = (GuitarBooking) i.next();
					
					if(selectBooking.getClientForename().compareTo(searchForename)==0 && selectBooking.getClientSurname().compareTo(searchSurname)==0)
					{	
						s = selectBooking.toString();
						txtArea.append(s);
					}
						
				}
		}
	}
}
}
