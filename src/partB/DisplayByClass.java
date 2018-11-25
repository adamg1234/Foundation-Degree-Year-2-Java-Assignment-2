package partB;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DisplayByClass extends JFrame implements ActionListener
{
	private JLabel lblTitle;
	private JTextArea txtArea;
	private JComboBox cmbClass;
	private JButton btnExit;
	private JScrollPane jsp;
	private Container cn;
	// Declare a private LinkedList of Room Bookings
	private LinkedList <GuitarBooking> bookings;
	// Declare a local LinkedList of Room Bookings in the brackets of the constructor
	
	public DisplayByClass(LinkedList bookings)
	{
		// assign the local Linked List to the private one
		this.bookings=bookings;
		cn = getContentPane();
		
		cn.setLayout(null); 		//Absolute Layout Manager
		
		lblTitle = new JLabel("Display Bookings");
		lblTitle.setFont(new Font("Arial",Font.BOLD,18));
		lblTitle.setBounds(10, 20, 300, 50);
		cn.add(lblTitle);

		String [] classes = {"---Select---"};
		cmbClass = new JComboBox(classes);
		cmbClass.setFont(new Font("Arial", Font.PLAIN,14));
		cmbClass.setBounds(250, 20, 150, 50);
		cmbClass.addActionListener(this);
		cn.add(cmbClass);
		
		String sClass="";
		try
		{
			BufferedReader classIn = new BufferedReader(new FileReader("lessons.txt"));
			boolean eof=false;
			
			while(eof!=true)
			{
				sClass=classIn.readLine();
				if(sClass!=null)
					cmbClass.addItem(sClass);
				else
					eof=true;
			}
		}
		catch (FileNotFoundException fEx)
		{
			JOptionPane.showMessageDialog(null, "The rooms file could not be found");
		}
		catch (IOException ioEx)
		{
			JOptionPane.showMessageDialog(null, "There was a problem with the file");
		}
		
		txtArea = new JTextArea(20,60);
		txtArea.setFont(new Font("Lucida Console",Font.PLAIN,12));
	
		jsp = new JScrollPane(txtArea);
		jsp.setBounds(10, 120, 785,270);
		
		cn.add(jsp);
		

		
		btnExit = new JButton ("Exit");
		btnExit.setFont(new Font("Arial", Font.BOLD,18));
		btnExit.setBounds(645,50,150,50);
		btnExit.addActionListener(this);
		cn.add(btnExit);	
	
	
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		
		
		if(ev.getSource()==cmbClass)
		{
			String s="";
			
			
			txtArea.setText("");
			s="Lesson Type          	Forename 	Surname  No in Party   Instructor Code \n";
			txtArea.append(s);
			s="--------------------------------------------------------------------------------\n";
			txtArea.append(s);
			
			// Declare and create an iterator for the Bookings LinkedList
			Iterator i = bookings.listIterator();
			
			while(i.hasNext())
			{
				GuitarBooking selectBooking = (GuitarBooking) i.next();
				
				if(selectBooking.getLessonType() == cmbClass.getSelectedItem().toString().charAt(0))
				{	
					s = selectBooking.toString();
					txtArea.append(s);
				}
					
			}
			
			
		}
		
		if(ev.getSource()==btnExit)
			this.setVisible(false);
	}

}
