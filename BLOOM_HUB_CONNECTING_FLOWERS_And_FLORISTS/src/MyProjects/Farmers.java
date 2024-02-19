package MyProjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Farmers {//Farmer_id	Farmer_Name	Contact_Number	Location
    private int frmid;
	private String frmname;
	private String contnmbr;
	private String lction;
	
	public Farmers() {
	    // Default constructor
      }
	public Farmers(int frmid, String frmname, String contnmbr,String lction) {
		super();
		this.frmid=frmid;
		this.frmname=frmname;
		this.contnmbr=contnmbr;
		this.lction=lction;
		}
  
	
    public int getFrmid() {
		return frmid;
	}
	public void setFrmid(int frmid) {
		this.frmid = frmid;
	}
	public String getFrmname() {
		return frmname;
	}
	public void setFrmname(String frmname) {
		this.frmname = frmname;
	}
	public String getContnmbr() {
		return contnmbr;
	}
	public void setContnmbr(String contnmbr) {
		this.contnmbr = contnmbr;
	}
	public String getLction() {
		return lction;
	}
	public void setLction(String lction) {
		this.lction = lction;
	}
	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/bloom_hub_connecting";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO Farmers (Farmer_Name,	Contact_Number,	Location) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.frmname);
	       preparedStatement.setString(2, this.contnmbr);
	       preparedStatement.setString(3, this.lction);
	       
	   
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

	        String sql = "SELECT * FROM Farmers";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	public void update(int inputfrmid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/bloom_hub_connecting";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE Farmers SET Farmer_Name=?,	Contact_Number=?,	Location=? WHERE Farmer_id =?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getFrmname());
	          stm.setString(2, this.getContnmbr());
	          stm.setString(3, this.getLction()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputfrmid);
	     
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
	public void delete(int inputfrmid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/bloom_hub_connecting";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Farmers WHERE Farmer_id=?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputfrmid); // Assuming there is a column named 'id' for the WHERE clause

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
