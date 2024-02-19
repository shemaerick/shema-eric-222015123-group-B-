package MyForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import MyProjects.Customer;
import MyProjects.Farmers;

public class CustomerForm implements ActionListener{
    JFrame frame;//Customer_id	Customer_Name	Contact_Number	Email	Address

    JLabel cstid_lb=new JLabel("Customer_id");
	JLabel 	cstnme_lb=new JLabel("Customer_Name");
	JLabel contact_lb=new JLabel("Contact_Number");
	JLabel email_lb=new JLabel("Email");
	JLabel address_lb=new JLabel("Address");
	
    JTextField cstid_txf=new JTextField();
	JTextField cstnme_txf=new JTextField();
	JTextField contact_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField address_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public CustomerForm(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("CUSTOMER FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}

	private void setLocationandSize() {
		 cstid_lb.setBounds(10,10,130,30);
		 cstnme_lb.setBounds(10,50,170,30);
		 contact_lb.setBounds(10,90,190,30);
		 email_lb.setBounds(10,130,200,30);
		 address_lb.setBounds(10,170,200,30);
		
		 cstid_txf.setBounds(200,10,190,30);
		 cstnme_txf.setBounds(200,50,190,30);
		 contact_txf.setBounds(200,90,190,30);
		 email_txf.setBounds(200,130,190,30);
		 address_txf.setBounds(200,170,190,30);
		
		
         insert_btn.setBounds(10,220,85,30);
		 read_btn.setBounds(110,220,85,30);
		 update_btn.setBounds(210,220,85,30);
		 delete_btn.setBounds(310,220,85,30);
		 
		 table.setBounds(500, 10, 600, 240);
		

		setFontforall();
		addcomponentforFrame();

		}

	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		cstid_lb.setFont(font);
		cstnme_lb.setFont(font);
		contact_lb.setFont(font);
		email_lb.setFont(font);
		address_lb.setFont(font);
		
		cstid_txf.setFont(font);
		cstnme_txf.setFont(font);
		contact_txf.setFont(font);
		email_txf.setFont(font);
		address_txf.setFont(font);
		

		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(cstid_lb);
		frame.add(cstnme_lb);
		frame.add(contact_lb);
		frame.add(email_lb);
		frame.add(address_lb);
		
		frame.add(cstid_txf);
		frame.add(cstnme_txf);
		frame.add(contact_txf);
		frame.add(email_txf);
		frame.add(address_txf);

		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
		
		}
    @Override
	public void actionPerformed(ActionEvent e) {
    	 Customer cu=new  Customer();
		if(e.getSource()==insert_btn) {
			cu.setCstnme(cstnme_txf.getText());
			cu.setContact(contact_txf.getText());
			cu.setEmail(email_txf.getText());
			cu.setAddress(address_txf.getText());
		    cu.insertData();
			
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Customer_id");
            model.addColumn("Customer_Name");
            model.addColumn("Contact_Number");
            model.addColumn("Email");
            model.addColumn("Address");
            
           
            ResultSet resultSet =Customer.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(cstid_txf.getText());
			cu.setCstnme(cstnme_txf.getText());
			cu.setContact(contact_txf.getText());
			cu.setEmail(email_txf.getText());
			cu.setAddress(address_txf.getText());
			cu.update(id);
	    }
	  else {
			int id=Integer.parseInt(cstid_txf.getText());
			cu.delete(id);}
         }	
	public static void main(String[] args) {
		CustomerForm cusf= new CustomerForm();
		System.out.println(cusf);

	}

}

