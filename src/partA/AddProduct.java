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

import partB.BookingException;



public class AddProduct extends JFrame implements ActionListener
{
	
	private JLabel heading,lblProductId, lblManufacturer, lblName,lblCategory,lblNoInStock,lblCost, lblSellingPrice, 
	padder1, padder2;
	private JComboBox cmbCategoryType;
	private JTextField txtProductId, txtManufacturer, txtName,txtNoInStock,txtCost,txtSellingPrice;
	private JButton btnAdd, btnReset, btnExit;
	private HashMap <String, Product> products;
	
	public AddProduct(HashMap products)
	{
		this.products=products;
		
		String[] categorys = {"Nutrition Bars", "Sports Supplements", "Vitamins", "Weight Loss", "Accessories"};
		
		heading = new JLabel("Add Product",JLabel.CENTER);
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
		
		lblSellingPrice = new JLabel("Selling Price: ");
		lblSellingPrice.setFont(new Font("Arial", Font.PLAIN,12));
		
		lblCost = new JLabel("Cost: ");
		lblCost.setFont(new Font("Arial", Font.PLAIN,12));
		
		
		
		txtProductId = new JTextField(10);
		txtManufacturer = new JTextField(10);
		txtName = new JTextField(10);
		txtNoInStock = new JTextField(10);
		txtManufacturer = new JTextField(10);
		txtCost = new JTextField(10);
		txtSellingPrice = new JTextField(10);
		
		cmbCategoryType = new JComboBox(categorys);
		
		
		
		btnAdd = new JButton("Add Item");
		btnAdd.addActionListener(this);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(this); 
		
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
		
		addComp(lblSellingPrice,0,7,1,1,1,1);
		
		addComp(btnAdd,0,9,1,1,1,1);
		
		//2nd Column
		addComp(txtProductId,1,1,1,1,1,1);
		
		addComp(txtManufacturer,1,2,1,1,1,1);
		
		addComp(txtName,1,3,1,1,1,1);
		
		addComp(cmbCategoryType,1,4,1,1,1,1);
		
		addComp(txtNoInStock,1,5,1,1,1,1);
		
		addComp(txtCost,1,6,1,1,1,1);
		
		addComp(txtSellingPrice,1,7,1,1,1,1);
		
		addComp(btnReset,1,9,1,1,1,1);
		
		//3rd Column
		addComp(btnExit,2,9,1,1,1,1);
		
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

	

	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		if(ev.getSource()==btnAdd)
		{
			
			
			
			Product newProduct = new Product();
			
			boolean blValid = true;
			
			try
			{
				newProduct.setProductID(txtProductId.getText());
				newProduct.setManufacturer(txtManufacturer.getText());
				newProduct.setName(txtName.getText());
				newProduct.setCategory(cmbCategoryType.getSelectedItem().toString());
				newProduct.setNoInStock(Integer.parseInt(txtNoInStock.getText()));
				newProduct.setCost(Double.parseDouble(txtCost.getText()));
				newProduct.setSellingPrice(Double.parseDouble(txtSellingPrice.getText()));
			}
			catch (ProductException ex)
			{
				JOptionPane.showMessageDialog(null, ex);
				blValid = false;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				blValid = false;
			}
			
			if(blValid == true) 
			{
				products.put(newProduct.getProductID(), newProduct);
				reset();
				JOptionPane.showMessageDialog(null, "The details have been added");
			}
			
			
		
			
			
			
		}
		
		if(ev.getSource()==btnReset)
			reset();
		if(ev.getSource()==btnExit)
			this.setVisible(false);
	}
	
	public void reset()
	{
		txtProductId.setText("");
		txtManufacturer.setText("");
		txtName.setText("");
		cmbCategoryType.setSelectedIndex(0);
		txtNoInStock.setText("");
		txtCost.setText("");
		txtSellingPrice.setText("");
	}
	
}
