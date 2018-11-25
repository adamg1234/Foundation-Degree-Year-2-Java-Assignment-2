package partA;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class DisplayStock extends JFrame implements ActionListener
{

	private JLabel lblTitle;
	private JTextArea txtArea;
	private JButton btnDisplay, btnExit;
	private JScrollPane jsp;
	private Container cn;
	
	private HashMap <String, Product> products;
	
	public DisplayStock(HashMap products)
	{
		this.products=products;
		
		cn = getContentPane();
		
		cn.setLayout(null); 		//Absolute Layout Manager
		
		lblTitle = new JLabel("Display Stock");
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
		if(ev.getSource()==btnDisplay)
		{
			Iterator i = products.entrySet().iterator();
			String newMe="";
			
			txtArea.setText("ProductId\t" + " Manufacturer\t\t" + "Name\t" + "             Category\t" + "       No Sold\t" + "No In Stock" + "       Cost" + "     Selling Price\n"
					+ "_____________________________________________________________________________________________________________________________________________________________\n");
					
			while(i.hasNext())
			{
				Map.Entry me = (Map.Entry)i.next();
				newMe = me.getValue().toString();
				txtArea.append(newMe.toString());
			}
			
		}
		if(ev.getSource()==btnExit)
			this.setVisible(false);
	}

}
