package MyProjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Order {//	Order_id	Customer_id	Flower_id	Farmer_id	Quantity	Total_Price	Order_Date	
	private int ordid;
	private String cusid;
	private String flwid;
	private String frmid;
	private String qty;
	private String totprorddat;
	private String orddate;
	
	public Order() {
	    // Default constructor
      }
	public Order(int ordid,String cusid, String flwid, String frmid,String qty, String totprorddat, String orddate) {
		super();
		this.ordid=ordid;
		this.cusid=cusid;
		this.flwid= flwid;
		this.frmid=frmid;
		this.qty= qty;
		this.totprorddat=totprorddat;
		this.orddate= orddate;
		}
   
	public int getOrdid() {
		return ordid;
	}
	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getFlwid() {
		return flwid;
	}
	public void setFlwid(String flwid) {
		this.flwid = flwid;
	}
	public String getFrmid() {
		return frmid;
	}
	public void setFrmid(String frmid) {
		this.frmid = frmid;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getTotprorddat() {
		return totprorddat;
	}
	public void setTotprorddat(String totprorddat) {
		this.totprorddat = totprorddat;
	}
	
	public String getOrddate() {
		return orddate;
	}
	public void setOrddate(String orddate) {
		this.orddate = orddate;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/bloom_hub_connecting";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO Orders (Customer_id,	Flower_id,	Farmer_id,	Quantity,	Total_Price,	Order_Date) VALUES (?,?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.cusid);
	       preparedStatement.setString(2, this.flwid);
	       preparedStatement.setString(3, this.frmid);
	       preparedStatement.setString(4, this.qty);
	       preparedStatement.setString(5, this.totprorddat);
	       preparedStatement.setString(6, this.orddate);
	   	
	    // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/bloom_hub_connecting";
	        String user = "root";
	        String password = "";

	        String sql = "SELECT * FROM Orders";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	public void update(int inputordid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/bloom_hub_connecting";
	    String user = "root";
	    String password = "";

	    // SQL query to update 
	    String sql = "UPDATE Orders SET Customer_id=?,	Flower_id=?,	Farmer_id=?,	Quantity=?,	Total_Price=?,	Order_Date=? WHERE Order_id=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getCusid());
	          stm.setString(2, this.getFlwid());
	          stm.setString(3, this.getFrmid()); // Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(4, this.getQty());
	          stm.setString(5, this.getTotprorddat());
	          stm.setString(6, this.getOrddate());
	          
	          stm.setInt(7, inputordid);
	     
	          // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputordid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/bloom_hub_connecting";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Orders WHERE Order_id=?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputordid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}


