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

import MyProjects.Flowers;

public class FlowerForm implements ActionListener{
	JFrame frame;//Flower_id	Name	Description	Price_Per_Unit	
    JLabel flwid_lb=new JLabel("Flower_id");
	JLabel name_lb=new JLabel("Name");
	JLabel descrpt_lb=new JLabel("Description");
	JLabel prcprunt_lb=new JLabel("Price_Per_Unit");
	
    JTextField flwid_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField descrpt_txf=new JTextField();
	JTextField prcprunt_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public FlowerForm(){
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
		frame.setTitle("FLOWERS FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.blue);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		flwid_lb.setBounds(10,10,130,30);
		name_lb.setBounds(10,50,130,30);
		descrpt_lb.setBounds(10,90,150,30);
		prcprunt_lb.setBounds(10,130,210,30);
		
		flwid_txf.setBounds(200,10,190,30);
		name_txf.setBounds(200,50,190,30);
		descrpt_txf.setBounds(200,90,190,30);
		prcprunt_txf.setBounds(200,130,190,30);
		
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
		flwid_lb.setFont(font);
		name_lb.setFont(font);
		descrpt_lb.setFont(font);
		prcprunt_lb.setFont(font);
		
		flwid_txf.setFont(font);
		name_txf.setFont(font);
		descrpt_txf.setFont(font);
		prcprunt_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(flwid_lb);
		frame.add(name_lb);
		frame.add(descrpt_lb);
		frame.add(prcprunt_lb);
		
		
		frame.add(flwid_txf);
		frame.add(name_txf);
		frame.add(descrpt_txf);
		frame.add(prcprunt_txf);
		

		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}
    @Override
	public void actionPerformed(ActionEvent e) {
    	 Flowers fl=new Flowers();
		if(e.getSource()==insert_btn) {
			fl.setName(name_txf.getText());
			fl.setDescrpt(descrpt_txf.getText());
			fl.setPrcprunt(prcprunt_txf.getText());
		    fl.insertData();
			
		}else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Flower_id");
            model.addColumn("Name");
            model.addColumn("Description");
            model.addColumn("Price_Per_Unit");
            
           
            ResultSet resultSet =Flowers.viewData();
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
			int id=Integer.parseInt(flwid_txf.getText());
			fl.setName(name_txf.getText());
			fl.setDescrpt(descrpt_txf.getText());
			fl.setPrcprunt(prcprunt_txf.getText());
			fl.update(id);
	    }
	  else {
			int id=Integer.parseInt(flwid_txf.getText());
			fl.delete(id);}

	  }	
	public static void main(String[] args) {
		FlowerForm flf= new FlowerForm();
		System.out.println(flf);

	}

}
