package partA;

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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import partB.GuitarBooking;






public class ProductMenu extends JFrame implements ActionListener 
{
	
	private JMenuBar jmb;
	private JMenu productMenu,stock,report,systemMenu;
	private JMenuItem addItem, deleteItem, updateItem,dAll,dByName, makeSale,byCategory, eSystem;
	private Container cn;
	private JPanel imagePanel;
	
	private File productFile = new File("products.dat");
	
	private static HashMap<String, Product> products = new HashMap<String, Product> (50);
	
	AddProduct add;
	DisplayStock display;
	EditProduct edit;
	DeleteProduct delete;
	MakeSale makesale;
	
	public ProductMenu()
	{
			
		JPanel imagePanel  = new JPanel()
		{
		
		
	
		public void paint(Graphics g)
		{
			try
			{
				BufferedImage image = ImageIO.read(new File("supp.jpg"));
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
		
		cn= getContentPane();
		cn.setBackground(Color.LIGHT_GRAY);

		jmb = new JMenuBar();
				
		productMenu = new JMenu("Products");
		productMenu.setFont(new Font("Arial",Font.BOLD,16));
		
		addItem = new JMenuItem("Add Product");
		addItem.setFont(new Font("Arial",Font.PLAIN,14));
		addItem.addActionListener(this);
		productMenu.add(addItem);
		
		updateItem = new JMenuItem("Edit Product");
		updateItem.setFont(new Font("Arial",Font.PLAIN,14));
		updateItem.addActionListener(this);
		productMenu.add(updateItem);
		
		deleteItem = new JMenuItem("Delete Product");
		deleteItem.setFont(new Font("Arial",Font.PLAIN,14));
		deleteItem.addActionListener(this);
		productMenu.add(deleteItem);
		
		stock = new JMenu("Stock");
		stock.setFont(new Font("Arial",Font.BOLD,16));
		
		dAll = new JMenuItem("Display Stock");
		dAll.setFont(new Font("Arial",Font.PLAIN,14));
		dAll.addActionListener(this);
		stock.add(dAll);
		
		makeSale = new JMenuItem("Make Sale");
		makeSale.setFont(new Font("Arial",Font.PLAIN,14));
		makeSale.addActionListener(this);
		stock.add(makeSale);
		
		report = new JMenu("Report");
		report.setFont(new Font("Arial",Font.BOLD,16));
		
		byCategory = new JMenuItem("By Category");
		byCategory.setFont(new Font("Arial",Font.PLAIN,14));
		byCategory.addActionListener(this);
		report.add(byCategory);
		
		systemMenu = new JMenu("System");
		systemMenu.setFont(new Font("Arial",Font.BOLD,16));
		
		eSystem = new JMenuItem("Exit");
		eSystem.setFont(new Font("Arial",Font.PLAIN,14));
		eSystem.addActionListener(this);
		systemMenu.add(eSystem);
		
		jmb.add(productMenu);
		jmb.add(stock);
		jmb.add(report);
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
			FileInputStream fis = new FileInputStream(productFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			products = (HashMap<String, Product>) ois.readObject();
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
		
	}
	

	public static void main(String[] args)
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
		ProductMenu bMenu = new ProductMenu();
		bMenu.setTitle("Product Ordering System");
		bMenu.setSize(900, 599);
		bMenu.setLocation(350, 200);
		bMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bMenu.setVisible(true);


	}

	public void closing()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(productFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(products);
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
	
	@Override
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource()==addItem)
		{
			add = new AddProduct(products); 
			add.setTitle("Add Products");
			add.setSize(500,450);
			add.setLocation(100,100);
			add.setVisible(true);
		}
		if(ev.getSource()==dAll)
		{
			display = new DisplayStock(products); 
			display.setTitle("Display Stock");
			display.setSize(820,450);
			display.setLocation(100,100);
			display.setVisible(true);
		}
		if(ev.getSource()==updateItem)
		{
			edit = new EditProduct(products); 
			edit.setTitle("Edit Products");
			edit.setSize(500,450);
			edit.setLocation(100,100);
			edit.setVisible(true);
		}
		if(ev.getSource()==deleteItem)
		{
			delete = new DeleteProduct(products); 
			delete.setTitle("Delete Products");
			delete.setSize(500,450);
			delete.setLocation(100,100);
			delete.setVisible(true);
		}
		if(ev.getSource()==makeSale)
		{
			makesale = new MakeSale(products); 
			makesale.setTitle("Make Sale");
			makesale.setSize(500,450);
			makesale.setLocation(100,100);
			makesale.setVisible(true);
			
		}
		if(ev.getSource()==byCategory)
		{
			try
			{
				File inFile = new File("stock.txt");
				PrintWriter in = new PrintWriter(inFile);
				
				in.println("S T O C K");
				in.println("\n");
				in.println("----------------------------------");
				in.println("\n");
				in.println("ID:		Manufacturer:	Name:			Category:	    NoSold:		No In Stock:   Cost:   Selling Price:		");
				in.println("\n");
				in.println("----------------------------------------------------------------------------------------------------------------------------------------");
				in.println("\n");

				
				
				Iterator i = products.entrySet().iterator();
				
			    String nutrion ="",supplements ="",vitamins ="",weightLoss ="",acc ="";
				double nutrionPrice=0, supplementPrice=0,vitaminPrice=0,weightPrice=0,accPrice=0;
				
				while(i.hasNext())
				{
					 
					Map.Entry me = (Map.Entry)i.next();					
					Product productCategory = (Product)me.getValue();
					String newMe="";
					newMe = me.getValue().toString();
					in.println(newMe);
					if(productCategory.getCategory().compareTo("Nutrition Bars")==0)
					{
											
						nutrion += productCategory.toString();
						nutrionPrice+= (productCategory.getNoSold()*productCategory.getSellingPrice());
						
						
					}
					else if(productCategory.getCategory().compareTo("Sports Supplements")==0)
					{
						
								
						supplements += productCategory.toString();
						supplementPrice+= (productCategory.getNoSold()*productCategory.getSellingPrice());
						
					}
					else if(productCategory.getCategory().compareTo("Vitamins")==0)
					{
						
										
						vitamins += productCategory.toString();
						vitaminPrice+= (productCategory.getNoSold()*productCategory.getSellingPrice());
											
					}
					else if(productCategory.getCategory().compareTo("Weight Loss")==0)
					{
						
									
						weightLoss += productCategory.toString();
						weightLoss+="\n";
						weightPrice+= (productCategory.getNoSold()*productCategory.getSellingPrice());
											
					}
					else if(productCategory.getCategory().compareTo("Accessories")==0)
					{
						
					
						acc += productCategory.toString();
						accPrice+= (productCategory.getNoSold()*productCategory.getSellingPrice());
											
					}
					
				}
				
				
				in.println("\n");
				in.println("\n");
				in.println("\n");
				in.println("NUTRION");
				in.println("\n");
				in.println("ID:		Manufacturer:	Name:			Category:	    NoSold:		No In Stock:   Cost:   Selling Price:		");
				in.println("\n");
				in.println("----------------------------------------------------------------------------------------------------------------------------------------");
				in.println(nutrion);
				in.println("\n");
				in.println("\n");
				in.println("Total Price:  ");
				in.println("£"+nutrionPrice);
				in.println("\n");
				in.println("\n");
				
				
				in.println("\n\n");
				in.println("SUPPLEMENTS");
				in.println("\n");
				in.println("ID:		Manufacturer:	Name:			Category:	    NoSold:		No In Stock:   Cost:   Selling Price:		");
				in.println("\n");
				in.println("----------------------------------------------------------------------------------------------------------------------------------------");
				in.println(supplements);
				in.println("\n");
				in.println("\n");
				in.println("Total Price: ");
				in.println("£" + supplementPrice);
				in.println("\n");
				in.println("\n");
				
				in.println("\n\n");
				in.println("VITAMINS");
				in.println("\n");
				in.println("ID:		Manufacturer:	Name:			Category:	    NoSold:		No In Stock:   Cost:   Selling Price:		");
				in.println("\n");
				in.println("----------------------------------------------------------------------------------------------------------------------------------------");
				in.println(vitamins);
				in.println("\n");
				in.println("\n");
				in.println("Total Price: ");
				in.println("£"+ vitaminPrice);
				
				
				in.println("\n\n");
				in.println("WEIGHTLOSS");
				in.println("\n");
				in.println("ID:		Manufacturer:	Name:			Category:	    NoSold:		No In Stock:   Cost:   Selling Price:		");
				in.println("\n");
				in.println("----------------------------------------------------------------------------------------------------------------------------------------");
				in.println(weightLoss);
				in.println("\n");
				in.println("\n");
				in.println("Total Price:");
				in.println("£" + weightPrice);
				
				in.println("\n\n");
				in.println("ACCESSORIES");
				in.println("\n");
				in.println("ID:		Manufacturer:	Name:			Category:	    NoSold:		No In Stock:   Cost:   Selling Price:		");
				in.println("\n");
				in.println("----------------------------------------------------------------------------------------------------------------------------------------");			
				in.println(acc);
				in.println("\n");
				in.println("\n");
				in.println("Total Price: ");
				in.println("£"+accPrice);
				
				JOptionPane.showMessageDialog(null, "Printed");
				
				in.close();
			}
			catch(IOException ex2)
			{
				JOptionPane.showMessageDialog(null, "Cannot Open File");
			}
		}
		
		if(ev.getSource()==eSystem)
		{
			closing();
			System.exit(0);
		}
	}

}
