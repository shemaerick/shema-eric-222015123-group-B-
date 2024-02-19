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
import MyProjects.Order;

public class OrderForm implements ActionListener{
    JFrame frame;//	Order_id	Customer_id	Flower_id	Farmer_id	Quantity	Total_Price	Order_Date
    JLabel ordid_lb=new JLabel("Order_id");
	JLabel cusid_lb=new JLabel("Customer_id");
	JLabel flwid_lb=new JLabel("Flower_id");
	JLabel frmid_lb=new JLabel("Farmer_id");
	JLabel qty_lb=new JLabel("Quantity");
	JLabel totprorddat_lb=new JLabel("Total_Price");
	JLabel orddate_lb=new JLabel("Order_Date");
	
	JTextField ordid_txf=new JTextField();
	JTextField cusid_txf=new JTextField();
	JTextField flwid_txf=new JTextField();
	JTextField frmid_txf=new JTextField();
	JTextField qty_txf=new JTextField();
	JTextField totprorddat_txf=new JTextField();
	JTextField orddate_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public OrderForm(){
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
		frame.setTitle("ORDERS FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		ordid_lb.setBounds(10,10,130,30);
		cusid_lb.setBounds(10,50,130,30);
		flwid_lb.setBounds(10,90,150,30);
		frmid_lb.setBounds(10,130,200,30);
		qty_lb.setBounds(10,170,200,30);
		totprorddat_lb.setBounds(10,210,200,30);
		orddate_lb.setBounds(10,250,200,30);
		
		ordid_txf.setBounds(150,10,190,30);
		cusid_txf.setBounds(150,50,190,30);
		flwid_txf.setBounds(150,90,190,30);
		frmid_txf.setBounds(150,130,190,30);
		qty_txf.setBounds(150,170,190,30);
		totprorddat_txf.setBounds(150,210,190,30);
		orddate_txf.setBounds(150,250,190,30);
		
		
        insert_btn.setBounds(10,300,85,30);
		read_btn.setBounds(110,300,85,30);
		update_btn.setBounds(210,300,85,30);
		delete_btn.setBounds(310,300,85,30);
		table.setBounds(500, 10, 600, 240);
		
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		ordid_lb.setFont(font);
		cusid_lb.setFont(font);
		flwid_lb.setFont(font);
		frmid_lb.setFont(font);
		qty_lb.setFont(font);
		totprorddat_lb.setFont(font);
		orddate_lb.setFont(font);
		
		ordid_txf.setFont(font);
		cusid_txf.setFont(font);
		flwid_txf.setFont(font);
		frmid_txf.setFont(font);
		qty_txf.setFont(font);
		totprorddat_txf.setFont(font);
		orddate_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}

	private void addcomponentforFrame() {
		frame.add(ordid_lb);
		frame.add(cusid_lb);
		frame.add(flwid_lb);
		frame.add(frmid_lb);
		frame.add(qty_lb);
		frame.add(totprorddat_lb);
		frame.add(orddate_lb);
		
		frame.add(ordid_txf);
		frame.add(cusid_txf);
		frame.add(flwid_txf);
		frame.add(frmid_txf);
		frame.add(qty_txf);
		frame.add(totprorddat_txf);
		frame.add(orddate_txf);
		

		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
		
		
		
	}
    @Override
	public void actionPerformed(ActionEvent e) {
    	Order or=new Order();
		if(e.getSource()==insert_btn) {
			or.setCusid(cusid_txf.getText());
			or.setFlwid(flwid_txf.getText());
			or.setFrmid(frmid_txf.getText());
			or.setQty(qty_txf.getText());
			or.setTotprorddat(totprorddat_txf.getText());
			or.setOrddate(orddate_txf.getText());
		    or.insertData();
			
		}else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Order_id");
            model.addColumn("Customer_id");
            model.addColumn("Flower_id");
            model.addColumn("Farmer_id");
            model.addColumn("Quantity");
            model.addColumn("Total_Price");
            model.addColumn("Order_Date");
            
           ResultSet resultSet =Order.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)
                                , resultSet.getString(7)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(ordid_txf.getText());
			or.setCusid(cusid_txf.getText());
			or.setFlwid(flwid_txf.getText());
			or.setFrmid(frmid_txf.getText());
			or.setQty(qty_txf.getText());
			or.setTotprorddat(totprorddat_txf.getText());
			or.setOrddate(orddate_txf.getText());
			or.update(id);
	    }
	  else {
			int id=Integer.parseInt(ordid_txf.getText());
			or.delete(id);}
         }	
	public static void main(String[] args) {
		OrderForm orf= new OrderForm();
		System.out.println(orf);

	}

}


