package MyProjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Payment {//Customer_id	Order_id	Payment_Amount	Payment_Date	Payment_Method
	private int cusid;
	private String ordid;
	private String payamnt;
	private String paydate;
	private String paymthd;
	
	public Payment() {
	    // Default constructor
      }
	public Payment(int cusid, String ordid, String payamnt,String paydate,String paymthd) {
		super();
		this.cusid=cusid;
		this.ordid=ordid;
		this.payamnt=payamnt;
		this.paydate=paydate;
		this.paymthd=paymthd;
		}
    public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getOrdid() {
		return ordid;
	}
	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}
	public String getPayamnt() {
		return payamnt;
	}
	public void setPayamnt(String payamnt) {
		this.payamnt = payamnt;
	}
	public String getPaydate() {
		return paydate;
	}
	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}
	public String getPaymthd() {
		return paymthd;
	}
	public void setPaymthd(String paymthd) {
		this.paymthd = paymthd;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/bloom_hub_connecting";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO Payment (Order_id,	Payment_Amount,	Payment_Date,	Payment_Method) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.ordid);
	       preparedStatement.setString(2, this.payamnt);
	       preparedStatement.setString(3, this.paydate);
	       preparedStatement.setString(4, this.paymthd);
	      
	       
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

	        String sql = "SELECT * FROM Payment";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	public void update(int inputcusid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/bloom_hub_connecting";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE Payment SET Order_id=?,	Payment_Amount=?,	Payment_Date=?,	Payment_Method=? WHERE Customer_id	=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getOrdid());
	          stm.setString(2, this.getPayamnt());
	          stm.setString(3, this.getPaydate()); // Assuming there is a column named 'id' for the WHERE clause
	          stm.setString(3, this.getPaymthd());
	          
	          stm.setInt(4, inputcusid);
	         
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
	public void delete(int inputcusid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/bloom_hub_connecting";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Payment WHERE Customer_id	=?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputcusid); // Assuming there is a column named 'id' for the WHERE clause

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





