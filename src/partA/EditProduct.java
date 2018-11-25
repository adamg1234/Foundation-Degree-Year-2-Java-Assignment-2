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




public class EditProduct extends JFrame implements ActionListener
{
	private JLabel heading,lblProductId, lblManufacturer, lblName,lblCategory,lblNoInStock,lblCost, lblSellingPrice, 
	padder1, padder2;
	private JComboBox cmbCategoryType;
	private JTextField txtProductId, txtManufacturer, txtName,txtNoInStock,txtCost,txtSellingPrice;
	private JButton btnSearch, btnUpdate, btnExit;
	private HashMap <String, Product> products;
	
	
	
	String findID="";
	
	Product foundItem = null;
	
	public EditProduct(HashMap products)
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
		
		
		
		btnSearch = new JButton("Search Item");
		btnSearch.addActionListener(this);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this); 
		
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
		
		addComp(btnSearch,0,9,1,1,1,1);
		
		//2nd Column
		addComp(txtProductId,1,1,1,1,1,1);
		
		addComp(txtManufacturer,1,2,1,1,1,1);
		
		addComp(txtName,1,3,1,1,1,1);
		
		addComp(cmbCategoryType,1,4,1,1,1,1);
		
		addComp(txtNoInStock,1,5,1,1,1,1);
		
		addComp(txtCost,1,6,1,1,1,1);
		
		addComp(txtSellingPrice,1,7,1,1,1,1);
		
		addComp(btnUpdate,1,9,1,1,1,1);
		
		//3rd Column
		addComp(btnExit,2,9,1,1,1,1);
		
		txtManufacturer.setEnabled(false);
		txtName.setEnabled(false);
		cmbCategoryType.setEnabled(false);
		txtNoInStock.setEnabled(false);
		txtCost.setEnabled(false);
		txtSellingPrice.setEnabled(false);
		btnUpdate.setEnabled(false);
		
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
			 findID = txtProductId.getText().trim();
			 foundItem = products.get(findID);
			 
			 if(foundItem != null)
				{
				 
					txtManufacturer.setText(foundItem.getManufacturer());
					txtName.setText(foundItem.getName());
					cmbCategoryType.setSelectedItem(foundItem.getCategory());
					txtNoInStock.setText(""+foundItem.getNoInStock());
					txtCost.setText(""+foundItem.getCost());
					txtSellingPrice.setText(""+foundItem.getSellingPrice());
					
					txtManufacturer.setEnabled(true);
					txtName.setEnabled(true);
					cmbCategoryType.setEnabled(true);
					txtNoInStock.setEnabled(true);
					txtCost.setEnabled(true);
					txtSellingPrice.setEnabled(true);
					btnUpdate.setEnabled(true);
				}
		}
		
		if(ev.getSource()==btnUpdate)
		{
			Product updateProduct = products.get(findID);
			
			try
			{
				updateProduct.setManufacturer(txtManufacturer.getText());
				updateProduct.setName(txtName.getText());
				updateProduct.setCategory(cmbCategoryType.getSelectedItem().toString());
				updateProduct.setNoInStock(Integer.parseInt(txtNoInStock.getText()));
				updateProduct.setCost(Double.parseDouble(txtCost.getText()));
				updateProduct.setSellingPrice(Double.parseDouble(txtSellingPrice.getText()));
			}
			catch (ProductException ex)
			{
				JOptionPane.showMessageDialog(null, ex);
			
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				
			}
		
			
			JOptionPane.showMessageDialog(null, "The details have been updated");
			
			txtProductId.setText("");
			txtManufacturer.setText("");
			txtName.setText("");
			cmbCategoryType.setSelectedIndex(0);
			txtNoInStock.setText("");
			txtCost.setText("");
			txtSellingPrice.setText("");
		}
		
		if(ev.getSource()==btnExit)
			this.setVisible(false);
	}
	
	
}
