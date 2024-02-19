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

import MyProjects.Farmers;

public class FarmersForm implements ActionListener{
    JFrame frame;//Farmer_id	Farmer_Name	Contact_Number	Location
    JLabel frmid_lb=new JLabel("Farmer_id");
	JLabel frmname_lb=new JLabel("Farmer_Name");
	JLabel contnmbr_lb=new JLabel("Contact_Number");
	JLabel lction_lb=new JLabel("Location");
	
    JTextField frmid_txf=new JTextField();
	JTextField frmname_txf=new JTextField();
	JTextField contnmbr_txf=new JTextField();
	JTextField lction_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public FarmersForm(){
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
		frame.setTitle("FARMER FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.orange);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		frmid_lb.setBounds(10,10,130,30);
		frmname_lb.setBounds(10,50,200,30);
		contnmbr_lb.setBounds(10,90,200,30);
		lction_lb.setBounds(10,130,200,30);
		
		frmid_txf.setBounds(190,10,190,30);
		frmname_txf.setBounds(190,50,190,30);
		contnmbr_txf.setBounds(190,90,190,30);
		lction_txf.setBounds(190,130,190,30);
		
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
		frmid_lb.setFont(font);
		frmname_lb.setFont(font);
		contnmbr_lb.setFont(font);
		lction_lb.setFont(font);
		
		frmid_txf.setFont(font);
		frmname_txf.setFont(font);
		contnmbr_txf.setFont(font);
		lction_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(frmid_lb);
		frame.add(frmname_lb);
		frame.add(contnmbr_lb);
		frame.add(lction_lb);
		
		
		frame.add(frmid_txf);
		frame.add(frmname_txf);
		frame.add(contnmbr_txf);
		frame.add(lction_txf);
		

		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
		
		
		
	}
    @Override
	public void actionPerformed(ActionEvent e) {
    	 Farmers fr=new Farmers();
		if(e.getSource()==insert_btn) {
			fr.setFrmname(frmname_txf.getText());
			fr.setContnmbr(contnmbr_txf.getText());
			fr.setLction(lction_txf.getText());
		    fr.insertData();
			
		}else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Farmer_id");
            model.addColumn("Farmer_Name");
            model.addColumn("Contact_Number");
            model.addColumn("Location");
       
            ResultSet resultSet =Farmers.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(frmid_txf.getText());
			fr.setFrmname(frmname_txf.getText());
			fr.setContnmbr(contnmbr_txf.getText());
			fr.setLction(lction_txf.getText());
			fr.update(id);
	    }
	  else {
			int id=Integer.parseInt(frmid_txf.getText());
			fr.delete(id);}
         }	
	public static void main(String[] args) {
		FarmersForm frf= new FarmersForm();
		System.out.println(frf);

	}

}

