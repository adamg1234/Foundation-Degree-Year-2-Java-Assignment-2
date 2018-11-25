package partB;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateBooking extends JFrame implements ActionListener
{
	
	private JLabel heading, lblForename, lblSurname,lbllessonType,lblInstructor,lblPartyNo, 
	padder1, padder2;
	private JComboBox cmblessonType,cmbParty,cmbInstructor;
	private JTextField txtForename, txtSurname, txtParty;
	private JButton btnSearch,btnUpdate,  btnExit;
	
	
	private GridBagLayout gbLayout;
	private GridBagConstraints gbConstraints;
	
	private int bkIndex = 0;
	private GuitarBooking upBk = new GuitarBooking();
	private LinkedList <GuitarBooking> bookings;

	private void addComp(Component c, GridBagLayout gbLayout, 
			GridBagConstraints gbConstraints,
			int row, int column, int numRows,
			int numColumns, int weightx, int weighty)
	{
		//set parameters
		gbConstraints.gridx = column;
		gbConstraints.gridy = row;
		gbConstraints.gridwidth = numColumns;
		gbConstraints.gridheight = numRows;
		gbConstraints.weightx = weightx;
		gbConstraints.weighty = weighty;
		gbConstraints.insets = new Insets(5,5,5,5);
		
		//set constraints in the GridBag Layout
		gbLayout.setConstraints(c, gbConstraints);
		
		//add component to the container
		getContentPane().add(c);	
	}
	
	public UpdateBooking(LinkedList bookings) throws IOException 
	{
		
		this.bookings=bookings;
		
		
		heading = new JLabel("Guitar Bookings", JLabel.CENTER);
		heading.setFont(new Font("Arial", Font.BOLD,20));
		
		lbllessonType = new JLabel("Lesson Type:", JLabel.RIGHT);
		lbllessonType.setFont(new Font("Arial", Font.BOLD,14));
		
		lblForename = new JLabel("Forename:", JLabel.RIGHT);
		lblForename.setFont(new Font("Arial", Font.BOLD,14));
		
		lblSurname = new JLabel("Surname:", JLabel.RIGHT);
		lblSurname.setFont(new Font("Arial", Font.BOLD,14));
		
		lblPartyNo = new JLabel("Party No:", JLabel.RIGHT);
		lblPartyNo.setFont(new Font("Arial", Font.BOLD,14));
		
		lblInstructor = new JLabel("Instructor:", JLabel.RIGHT);
		lblInstructor.setFont(new Font("Arial", Font.BOLD,14));
		

		// String array to store items for the combo box
		String [] lesson = {"---Select---"};
		cmblessonType = new JComboBox(lesson);
		cmblessonType.setFont(new Font("Arial", Font.PLAIN,14));
		cmblessonType.addActionListener(this);
		
		String [] party = {"---Select---"};
		cmbParty = new JComboBox(party);
		cmbParty.setFont(new Font("Arial", Font.PLAIN,14));
		cmbParty.addActionListener(this);
		
	
		cmbInstructor = new JComboBox();
		cmbInstructor.setFont(new Font("Arial", Font.PLAIN,14));
		cmbInstructor.addActionListener(this);
		
		
		// read rooms from file
		String sLesson="";
		try
		{
			BufferedReader lessonIn = new BufferedReader(new FileReader("lessons.txt"));
			boolean eof=false;
			
			while(eof!=true)
			{
				sLesson=lessonIn.readLine();
				if(sLesson!=null)
					cmblessonType.addItem(sLesson);
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
		
		
		
		
		txtForename= new JTextField(10);
		txtForename.setFont(new Font("Arial", Font.PLAIN,14));
		
		txtSurname= new JTextField(10);
		txtSurname.setFont(new Font("Arial", Font.PLAIN,14));
		
		txtParty= new JTextField(20);
		txtParty.setFont(new Font("Arial", Font.PLAIN,14));
		
	
		
		//add buttons
		btnSearch = new JButton ("Search Item");
		btnSearch.setFont(new Font("Arial", Font.BOLD,18));
		btnSearch.addActionListener(this);
		
		btnUpdate = new JButton ("Update Item");
		btnUpdate.setFont(new Font("Arial", Font.BOLD,18));
		btnUpdate.addActionListener(this);
		
		
		btnExit = new JButton ("Exit");
		btnExit.setFont(new Font("Arial", Font.BOLD,18));
		btnExit.addActionListener(this);
		
		//Create GridBagLayout and GridBag Constraints object
		gbLayout = new GridBagLayout();
		gbConstraints = new GridBagConstraints();
		getContentPane().setLayout(gbLayout);
		
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.anchor = GridBagConstraints.CENTER;
		
		addComp(heading, gbLayout, gbConstraints, 0, 0, 1, 3, 2, 2);
		
		addComp(lbllessonType, gbLayout, gbConstraints, 1, 0, 1, 1, 1, 1);
		
		addComp(lblInstructor, gbLayout, gbConstraints, 2, 0, 1, 1, 1, 1);
		
		addComp(lblForename, gbLayout, gbConstraints, 3, 0, 1, 1, 1, 1);
		
		addComp(lblSurname, gbLayout, gbConstraints, 4, 0, 1, 1, 1, 1);

		addComp(lblPartyNo, gbLayout, gbConstraints, 5, 0, 1, 1, 1, 1);

		addComp(cmblessonType, gbLayout, gbConstraints, 1, 1, 1, 2, 1, 1);
		
		addComp(cmbInstructor, gbLayout, gbConstraints, 2, 1, 1, 1, 1, 1);

		addComp(txtForename, gbLayout, gbConstraints, 3, 1, 1, 1, 1, 1);

		addComp(txtSurname, gbLayout, gbConstraints, 4, 1, 1, 1, 1, 1);

		addComp(cmbParty, gbLayout, gbConstraints, 5, 1, 1, 2, 1, 1);

		addComp(btnSearch, gbLayout, gbConstraints, 7, 0, 1, 1, 1, 1);
		
		addComp(btnUpdate, gbLayout, gbConstraints, 7, 1, 1, 1, 1, 1);

		addComp(btnExit, gbLayout, gbConstraints, 7, 2, 1, 1, 1, 1);

		
		cmblessonType.setEnabled(false);
		cmbInstructor.setEnabled(false);
		cmbParty.setEnabled(false);
		btnUpdate.setEnabled(false);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent ev)
	{	
		if(ev.getSource()==cmblessonType)
		{
			if(cmblessonType.getSelectedItem().toString().compareTo("Jazz")==0)
			{
				cmbInstructor.removeAllItems();
				String jInstructor="";
				try
				{
					BufferedReader jInstructorIn = new BufferedReader(new FileReader("jazz.txt"));
					boolean eof=false;
					
					while(eof!=true)
					{
						jInstructor=jInstructorIn.readLine();
						if(jInstructor!=null)							
							cmbInstructor.addItem(jInstructor);
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
				
				cmbParty.removeAllItems();
				String sParty="";
				try
				{
					BufferedReader partyIn = new BufferedReader(new FileReader("party2.txt"));
					boolean eof=false;
					
					while(eof!=true)
					{
						sParty=partyIn.readLine();
						if(sParty!=null)
							cmbParty.addItem(sParty);
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
				
				
			}
			else if(cmblessonType.getSelectedItem().toString().compareTo("Classical")==0)
			{
				cmbInstructor.removeAllItems();
				String cInstructor="";
				try
				{
					BufferedReader cInstructorIn = new BufferedReader(new FileReader("classical.txt"));
					boolean eof=false;
					
					while(eof!=true)
					{
						cInstructor=cInstructorIn.readLine();
						if(cInstructor!=null)
							cmbInstructor.addItem(cInstructor);
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
				cmbParty.removeAllItems();
				String sParty="";
				
				
				try
				{
					BufferedReader partyIn = new BufferedReader(new FileReader("party.txt"));
					boolean eof=false;
					
					while(eof!=true)
					{
						sParty=partyIn.readLine();
						if(sParty!=null)
							cmbParty.addItem(sParty);
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
				
			}
			else if(cmblessonType.getSelectedItem().toString().compareTo("Rock")==0)
			{
				cmbInstructor.removeAllItems();
				String rInstructor="";
				try
				{
					BufferedReader rInstructorIn = new BufferedReader(new FileReader("rock.txt"));
					boolean eof=false;
					
					while(eof!=true)
					{
						rInstructor=rInstructorIn.readLine();
						if(rInstructor!=null)
							cmbInstructor.addItem(rInstructor);
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
				
				
				cmbParty.removeAllItems();
				String sParty="";
				try
				{
					BufferedReader partyIn = new BufferedReader(new FileReader("party.txt"));
					boolean eof=false;
					
					while(eof!=true)
					{
						sParty=partyIn.readLine();
						if(sParty!=null)
							cmbParty.addItem(sParty);
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
				
			}
			
		}
		if(ev.getSource() == btnSearch)
		{
			String searchForename = txtForename.getText();
			String searchSurname = txtSurname.getText();
			
			if(searchForename.length()<1 && searchSurname.length()<1)
			{
				JOptionPane.showMessageDialog(null, "The names must contain more than 1 character");
			}
			else
			{
				// find the contact:
				ListIterator i = bookings.listIterator();
				Boolean found=false;
				while(i.hasNext() && found==false)
				{
					upBk = (GuitarBooking)i.next();
					
					if(searchForename.compareTo(upBk.getClientForename())==0 && searchSurname.compareTo(upBk.getClientSurname())==0 )
					{
						// Use the nextIndex() method of the iterator to assign the previous index to bkIndex
						boolean inVal =false;
						
						try
						{
							upBk.setClientForename(txtForename.getText());
							upBk.setClientSurname(txtSurname.getText());
						}
						catch (BookingException ex)
						{
							JOptionPane.showMessageDialog(null, ex);
							inVal=true;
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, e);
							inVal=true;
						}
						cmblessonType.setSelectedItem(upBk.getLessonType());
						
						if(cmblessonType.getSelectedItem().toString().charAt(0)=='J')
						{
							cmbInstructor.removeAllItems();
							String jInstructor="";
							try
							{
								BufferedReader jInstructorIn = new BufferedReader(new FileReader("jazz.txt"));
								boolean eof=false;
								
								while(eof!=true)
								{
									jInstructor=jInstructorIn.readLine();
									if(jInstructor!=null)							
										cmbInstructor.addItem(jInstructor);
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
							
							cmbInstructor.setSelectedItem(upBk.getInstructorCode());
							
							cmbParty.removeAllItems();
							String sParty="";
							try
							{
								BufferedReader partyIn = new BufferedReader(new FileReader("party.txt"));
								boolean eof=false;
								
								while(eof!=true)
								{
									sParty=partyIn.readLine();
									if(sParty!=null)
										cmbParty.addItem(sParty);
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
							
							cmbParty.setSelectedItem(upBk.getNoinParty());
						}
						
						if(cmblessonType.getSelectedItem().toString().charAt(0)=='R')
						{
							cmbInstructor.removeAllItems();
							String jInstructor="";
							try
							{
								BufferedReader jInstructorIn = new BufferedReader(new FileReader("rock.txt"));
								boolean eof=false;
								
								while(eof!=true)
								{
									jInstructor=jInstructorIn.readLine();
									if(jInstructor!=null)							
										cmbInstructor.addItem(jInstructor);
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
							
							cmbInstructor.setSelectedItem(upBk.getInstructorCode());
							
							cmbParty.removeAllItems();
							String sParty="";
							try
							{
								BufferedReader partyIn = new BufferedReader(new FileReader("party.txt"));
								boolean eof=false;
								
								while(eof!=true)
								{
									sParty=partyIn.readLine();
									if(sParty!=null)
										cmbParty.addItem(sParty);
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
							
							cmbParty.setSelectedItem(upBk.getNoinParty());
				
						}
				
						if(cmblessonType.getSelectedItem().toString().charAt(0)=='C')
						{
							cmbInstructor.removeAllItems();
							String jInstructor="";
							try
							{
								BufferedReader jInstructorIn = new BufferedReader(new FileReader("classical.txt"));
								boolean eof=false;
								
								while(eof!=true)
								{
									jInstructor=jInstructorIn.readLine();
									if(jInstructor!=null)							
										cmbInstructor.addItem(jInstructor);
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
							
							cmbInstructor.setSelectedItem(upBk.getInstructorCode());
							
							cmbParty.removeAllItems();
							String sParty="";
							try
							{
								BufferedReader partyIn = new BufferedReader(new FileReader("party2.txt"));
								boolean eof=false;
								
								while(eof!=true)
								{
									sParty=partyIn.readLine();
									if(sParty!=null)
										cmbParty.addItem(sParty);
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
							
							cmbParty.setSelectedItem(upBk.getNoinParty());
						}
						

						
						cmbParty.setEnabled(true);
						cmblessonType.setEnabled(true);
						cmbInstructor.setEnabled(true);
						
						btnSearch.setEnabled(false);
						btnUpdate.setEnabled(true);
						found=true;
					}
				}
				if(found==true)
					JOptionPane.showMessageDialog(null, "Details can now be updated");
				else
					JOptionPane.showMessageDialog(null, "There is no booking for this contact");
			
			}
		}
		
		if(ev.getSource()==btnUpdate)
		{
			upBk.setLessonType(cmblessonType.getSelectedItem().toString().charAt(0));
			
			
			try
			{
				upBk.setClientForename(txtForename.getText());
				upBk.setClientSurname(txtSurname.getText());
			}
			catch (BookingException ex)
			{
				JOptionPane.showMessageDialog(null, ex);
			}
			
			upBk.setNoinParty(Integer.parseInt(cmbParty.getSelectedItem().toString()));
			upBk.setInstructorCode(cmbInstructor.getSelectedItem().toString());
			
			reset();
			
		}
		if(ev.getSource()==btnExit)
			this.setVisible(false);
	}
	private void reset()
	{
		cmblessonType.setSelectedIndex(0);
		cmbInstructor.setSelectedIndex(0);
		txtForename.setText("");
		txtSurname.setText("");
		cmbParty.setSelectedIndex(0);
		
		
	}
}
