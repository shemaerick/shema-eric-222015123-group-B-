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
import MyProjects.Payment;

public class PaymentForm implements ActionListener{
    JFrame frame;
   // Customer_id	Order_id	Payment_Amount	Payment_Date	Payment_Method
    JLabel cusid_lb=new JLabel("Customer_id");
	JLabel ordid_lb=new JLabel("Order_id");
	JLabel payamnt_lb=new JLabel("Payment_Amount");
	JLabel paydate_lb=new JLabel("Payment_Date");
	JLabel paymthd_lb=new JLabel("Payment_Method");
	
    JTextField cusid_txf=new JTextField();
	JTextField ordid_txf=new JTextField();
	JTextField payamnt_txf=new JTextField();
	JTextField paydate_txf=new JTextField();
	JTextField paymthd_txf=new JTextField();
	
	
    JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public PaymentForm(){
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
		frame.setTitle("PAYMENT FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		cusid_lb.setBounds(10,10,130,30);
		ordid_lb.setBounds(10,50,130,30);
		payamnt_lb.setBounds(10,90,190,30);
		paydate_lb.setBounds(10,130,200,30);
		paymthd_lb.setBounds(10,170,200,30);
		
		cusid_txf.setBounds(200,10,190,30);
		ordid_txf.setBounds(200,50,190,30);
		payamnt_txf.setBounds(200,90,190,30);
		paydate_txf.setBounds(200,130,190,30);
		paymthd_txf.setBounds(200,170,190,30);
		
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
		cusid_lb.setFont(font);
		ordid_lb.setFont(font);
		 payamnt_lb.setFont(font);
		 paydate_lb.setFont(font);
		 paymthd_lb.setFont(font);
		
		cusid_txf.setFont(font);
		ordid_txf.setFont(font);
		 payamnt_txf.setFont(font);
		 paydate_txf.setFont(font);
		 paymthd_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
	}
	private void addcomponentforFrame() {
		frame.add(cusid_lb);
		frame.add(ordid_lb);
		frame.add(payamnt_lb);
		frame.add(paydate_lb);
		frame.add(paymthd_lb);
		
		frame.add(cusid_txf);
		frame.add(ordid_txf);
		frame.add(payamnt_txf);
		frame.add(paydate_txf);
		frame.add(paymthd_txf);

		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
		}
    @Override
	public void actionPerformed(ActionEvent e) {
    	 Payment py=new Payment();
		if(e.getSource()==insert_btn) {
			py.setOrdid(ordid_txf.getText());
			py.setPayamnt(payamnt_txf.getText());
			py.setPaydate(paydate_txf.getText());
			py.setPaymthd(paymthd_txf.getText());
		    py.insertData();
			
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Customer_id");
            model.addColumn("Order_id");
            model.addColumn("Payment_Amount");
            model.addColumn("Payment_Date");
            model.addColumn("Payment_Method");
            
                ResultSet resultSet =Payment.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(cusid_txf.getText());
			py.setOrdid(ordid_txf.getText());
			py.setPayamnt(payamnt_txf.getText());
			py.setPaydate(paydate_txf.getText());
			py.setPaymthd(paymthd_txf.getText());
			py.update(id);
	    }
	  else {
			int id=Integer.parseInt(cusid_txf.getText());
			py.delete(id);}
         }	
	public static void main(String[] args) {
		PaymentForm pyf= new PaymentForm();
		System.out.println(pyf);

	}

}


