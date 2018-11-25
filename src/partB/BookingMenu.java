package partB;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class BookingMenu extends JFrame implements ActionListener {

	private JMenuBar jmb;
	private JMenu bookingMenu,display,systemMenu;
	private JMenuItem addItem, deleteItem, updateItem,dAll,dByName, dByClass, eSystem;
	private Container cn;
	private JPanel imagePanel;
	private AddBooking add;
	private UpdateBooking update;
	private DisplayAllBooking displayAll;
	private DeleteBooking delete;
	private DisplayByClass displayByClass;
	private DisplayByName displayByName;

	// Declare and create a new Linked List of Room Bookings
	LinkedList<GuitarBooking> bookings = new LinkedList<GuitarBooking>();
	                    
	private File bookingFile;
	
	public BookingMenu() throws IOException
	{
		JPanel imagePanel  = new JPanel()
		{
		
		
	
		public void paint(Graphics g)
		{
			try
			{
				BufferedImage image = ImageIO.read(new File("guitar2.jpg"));
				g.drawImage(image, 1, 1,null);
			}
			
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			
		}
	
		
	};
		imagePanel.setPreferredSize(new Dimension(990,660));
		getContentPane().add(imagePanel);
		String s = (String)JOptionPane.showInputDialog(this,"Please enter the booking date: eg. 9-8-16 or 10-8-16","Customized Dialog",
				JOptionPane.PLAIN_MESSAGE);
		
		
		boolean valid = true;
		
		while(valid==true)
		{
			
			if(s.compareTo("9-8-16")==0)
			{
				bookingFile = new File(s + ".dat");
				valid=false;
			}
			else if(s.compareTo("10-8-16")==0)
			{
				bookingFile = new File(s + ".dat");
				valid=false;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "There is no lessons avaliable on this date.");
				 s = (String)JOptionPane.showInputDialog(this,"Please enter the booking date: eg. 9-8-16 or 10-8-16","Customized Dialog",
							JOptionPane.PLAIN_MESSAGE,null,null,"9-8-16" );
			}
		}
		
		cn= getContentPane();
		cn.setBackground(Color.LIGHT_GRAY);

		

		
		
		jmb = new JMenuBar();
				
		bookingMenu = new JMenu("Booking");
		bookingMenu.setFont(new Font("Arial",Font.BOLD,16));
		
		addItem = new JMenuItem("Add Booking");
		addItem.setFont(new Font("Arial",Font.PLAIN,14));
		addItem.addActionListener(this);
		bookingMenu.add(addItem);
		
		updateItem = new JMenuItem("Update Booking");
		updateItem.setFont(new Font("Arial",Font.PLAIN,14));
		updateItem.addActionListener(this);
		bookingMenu.add(updateItem);
		
		deleteItem = new JMenuItem("Delete Booking");
		deleteItem.setFont(new Font("Arial",Font.PLAIN,14));
		deleteItem.addActionListener(this);
		bookingMenu.add(deleteItem);
		
		display = new JMenu("Display");
		display.setFont(new Font("Arial",Font.BOLD,16));
		
		dAll = new JMenuItem("All");
		dAll.setFont(new Font("Arial",Font.PLAIN,14));
		dAll.addActionListener(this);
		display.add(dAll);
		
		dByName = new JMenuItem("By Name");
		dByName.setFont(new Font("Arial",Font.PLAIN,14));
		dByName.addActionListener(this);
		display.add(dByName);
		
		dByClass = new JMenuItem("By Class");
		dByClass.setFont(new Font("Arial",Font.PLAIN,14));
		dByClass.addActionListener(this);
		display.add(dByClass);
		
		systemMenu = new JMenu("System");
		systemMenu.setFont(new Font("Arial",Font.BOLD,16));
		
		eSystem = new JMenuItem("Exit");
		eSystem.setFont(new Font("Arial",Font.PLAIN,14));
		eSystem.addActionListener(this);
		systemMenu.add(eSystem);
		
		jmb.add(bookingMenu);
		jmb.add(display);
		jmb.add(systemMenu);
		
		setJMenuBar(jmb);
		
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent ev)
			{
				closing();
			}
		});


		
		
		try
		{
			FileInputStream fis = new FileInputStream(bookingFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			bookings = (LinkedList<GuitarBooking>) ois.readObject();
			ois.close();
			fis.close();
			
		}
		
		catch (ClassNotFoundException cEx)
		{
			JOptionPane.showMessageDialog(null, "The contents can not be read");
		}
		catch (FileNotFoundException fEx)
		{
			JOptionPane.showMessageDialog(null, "No File Found");
		}
		catch(IOException ioEx)
		{
			JOptionPane.showMessageDialog(null, "No File Found");
		}

		
		update = new UpdateBooking(bookings); 	
		delete = new DeleteBooking(bookings); 
	}
	
	
	
	
	public static void main(String[] args) throws IOException
	{
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		BookingMenu bMenu = new BookingMenu();
		bMenu.setTitle("Room Booking System");
		bMenu.setSize(900, 600);
		bMenu.setLocation(350, 200);
		bMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bMenu.setVisible(true);

		
		
		
	}






	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getSource() == addItem)
		{
			add = new AddBooking(bookings); 
			add.setTitle("Add Booking");
			add.setSize(500,450);
			add.setLocation(100,100);
			add.setVisible(true);
		}
		if(e.getSource() == eSystem)
		{
		
			closing();
			System.exit(0);
		}
		if(e.getSource()==dAll)
		{
			displayAll = new DisplayAllBooking(bookings); 	
			displayAll.setTitle("Display All Booking");
			displayAll.setSize(820,450);
			displayAll.setLocation(100,100);
			displayAll.setVisible(true);
			
		}
		if(e.getSource()==updateItem)
		{
			
			update.setTitle("Update Booking");
			update.setSize(500,450);
			update.setLocation(100,100);
			update.setVisible(true);
		}
		if(e.getSource()==deleteItem)
		{
				
			delete.setTitle("Update Booking");
			delete.setSize(500,450);
			delete.setLocation(100,100);
			delete.setVisible(true);
			
		}
		if(e.getSource()==dByClass)
		{ 
			displayByClass = new DisplayByClass(bookings); 	
			displayByClass.setTitle("Display By Class");
			displayByClass.setSize(820,450);
			displayByClass.setLocation(100,100);
			displayByClass.setVisible(true);
		}
		if(e.getSource()==dByName)
		{ 
			displayByName = new DisplayByName(bookings); 	
			displayByName.setTitle("Display By Name");
			displayByName.setSize(820,450);
			displayByName.setLocation(100,100);
			displayByName.setVisible(true);
		}
		
	}
	
	public void closing()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(bookingFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bookings);
			oos.close();
			fos.close();
			
		}
		catch (FileNotFoundException fEx)
		{
			JOptionPane.showMessageDialog(null, "No File Found");
		}
		catch(IOException ioEx)
		{
			JOptionPane.showMessageDialog(null, "Could not write to file");
		}
		
	}

}
