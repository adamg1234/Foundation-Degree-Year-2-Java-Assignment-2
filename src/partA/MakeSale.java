package partA;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MakeSale extends JFrame implements ActionListener
{

	private JLabel heading,lblProductId, lblManufacturer, lblName,lblCategory,lblNoInStock,lblCost, 
	padder1, padder2, lblQuantity, lblTotalCost, lblTotalPrice, lblManufacturer2, lblName2,lblCategory2,lblNoInStock2,lblCost2;
	private JTextField txtProductId,txtQuantity;
	private JButton btnSearch, btnPurchase, btnExit;
	private HashMap <String, Product> products;
	
	String findID="";
	
	Product foundItem = null;
	
	public MakeSale(HashMap products)
	{
		this.products=products;
		
		String[] categorys = {"Nutrition Bars", "Sports Supplements", "Vitamins", "Weight Loss", "Accessories"};
		
		heading = new JLabel("Make Sale",JLabel.CENTER);
		heading.setFont(new Font("Arial", Font.BOLD,14));
		
		lblProductId = new JLabel("Product ID: ");
		lblProductId.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblManufacturer = new JLabel("Manufacturer: ");
		lblManufacturer.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblCategory = new JLabel("Category: ");
		lblCategory.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblNoInStock = new JLabel("No In Stock: ");
		lblNoInStock.setFont(new Font("Arial", Font.PLAIN,12));
			
		lblCost = new JLabel("Selling Price of Item: ");
		lblCost.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblTotalCost = new JLabel("Total Cost: £");
		lblTotalCost.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblTotalPrice = new JLabel("");
		lblTotalPrice.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblManufacturer2 = new JLabel("");
		lblManufacturer2.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblName2 = new JLabel("");
		lblName2.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblCategory2 = new JLabel("");
		lblCategory2.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblNoInStock2 = new JLabel("");
		lblNoInStock2.setFont(new Font("Arial", Font.PLAIN,12));
			
		lblCost2 = new JLabel("");
		lblCost2.setFont(new Font("Arial", Font.PLAIN,12));
		
		
		txtProductId = new JTextField(10);
		txtQuantity = new JTextField(10);

		
		
		
		
		btnSearch = new JButton("Search Item");
		btnSearch.addActionListener(this);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(this); 
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this); 
		
		
		//Setting the layout of the content pane
		getContentPane().setLayout(new GridBagLayout());
		
		//1st Column
		getContentPane().setLayout(new GridBagLayout());
		
		addComp(heading,0,0,4,1,1,2);
		
		addComp(lblProductId,0,1,1,1,1,1);
		
		addComp(lblManufacturer,0,2,1,1,1,1);
		
		addComp(lblName,0,3,1,1,1,1);
		
		addComp(lblCategory,0,4,1,1,1,1);
				
		addComp(lblNoInStock,0,5,2,1,1,1);
		
		addComp(lblCost,0,6,1,1,1,1);
		
		addComp(lblQuantity,0,7,1,1,1,1);
		
		addComp(lblTotalCost,0,8,1,1,1,1);
			
		addComp(btnSearch,0,10,1,1,1,1);
		
		//2nd Column
		addComp(txtProductId,1,1,1,1,1,1);
		
		addComp(lblManufacturer2,1,2,1,1,1,1);
		
		addComp(lblName2,1,3,1,1,1,1);
		
		addComp(lblCategory2,1,4,1,1,1,1);
		
		addComp(lblNoInStock2,1,5,1,1,1,1);
		
		addComp(lblCost2,1,6,1,1,1,1);
		
		addComp(txtQuantity,1,7,1,1,1,1);
		
		addComp(lblTotalPrice,1,8,1,1,1,1);
		
		addComp(btnPurchase,1,10,1,1,1,1);
		
		//3rd Column
		addComp(btnExit,2,10,1,1,1,1);
		

		txtQuantity.setEnabled(false);
		btnPurchase.setEnabled(false);
	}
	
	
	private void addComp(Component c, int gridx, int gridy, int width, int height, int weightx, int weighty)
	{
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(5,5,5,5);
		gc.gridx = gridx;
		gc.gridy = gridy;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.weightx=weightx;
		gc.weighty=weighty;
		
		getContentPane().add(c,gc);
		
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource()==btnSearch)
		{
			boolean product = true;
			
			if(txtProductId.toString().length()<3)
			{
				product =false;
			}
			
			findID = txtProductId.getText().trim();
			foundItem = products.get(findID);
			 
			if(product=true)
			{
				 if(foundItem != null)
					{
						lblManufacturer2.setText(foundItem.getManufacturer());
						lblName2.setText(foundItem.getName());
						lblCategory2.setText(foundItem.getCategory());
						lblNoInStock2.setText(""+foundItem.getNoInStock());
						lblCost2.setText(""+foundItem.getSellingPrice());
						
						
						txtQuantity.setEnabled(true);
						btnPurchase.setEnabled(true);
					}
			}
			else
				JOptionPane.showMessageDialog(null, "Please enter a product ID more than 3");
		}
		
		if(ev.getSource()==btnPurchase)
		{
			double price= 0;
			
			price=foundItem.getSellingPrice()*Integer.parseInt(txtQuantity.getText());
			
			int qtySold=0;
			int noSold=foundItem.getNoSold();
			
			lblTotalPrice.setText(""+price);
			
			int n = JOptionPane.showConfirmDialog(this,"Are you sure you want to purchase this product?, The total price will be: " + price, "Record Purchase Prompt"
					, JOptionPane.YES_NO_OPTION);
					
			if(n==0)
			{
				int stockNo=foundItem.getNoInStock();
				
				
				foundItem.setNoSold(noSold+=(qtySold+=Integer.parseInt(txtQuantity.getText())));
				try
				{
				foundItem.setNoInStock(stockNo-Integer.parseInt(txtQuantity.getText()));
				}
				catch (ProductException ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
					
				}
				
				txtProductId.setText("");
				lblManufacturer2.setText("");
				lblName2.setText("");
				lblCategory2.setText("");;
				lblNoInStock2.setText("");
				lblCost2.setText("");
				lblTotalPrice.setText("");
				txtQuantity.setText("");
			}
		}
		if(ev.getSource()==btnExit)
			this.setVisible(false);
	}
	
	
	
	
}
