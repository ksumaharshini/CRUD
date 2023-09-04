package dao;

import java.sql.*;

import connectionmanager.ConnectionManager;
import model.Product;

public class ProductDAO {
	public void addProduct(Product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="insert into product(prodId,prodName,minSellQuantity,prodPrice,quantity) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1,p.getProdId());
		ps.setString(2,p.getProdName());
		ps.setInt(3,p.getMinSellQuantity());
		ps.setInt(4,p.getProdPrice());
		ps.setInt(5,p.getQuality());
		ps.executeLargeUpdate();
		cm.closeConnection();
	}
	public void updateProduct(Product p) throws ClassNotFoundException, SQLException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.establishConnection();
        String que = "UPDATE product SET prodName=?, minSellQuantity=?, prodPrice=?, quantity=? WHERE prodId=?";
        PreparedStatement ps = con.prepareStatement(que);
        ps.setString(1, p.getProdName());
        ps.setInt(2, p.getMinSellQuantity());
        ps.setInt(3, p.getProdPrice());
        ps.setInt(4, p.getQuality());
        ps.setInt(5, p.getProdId());
        ps.executeUpdate(); // Use executeUpdate() for UPDATE
        cm.closeConnection();
    }
	public void deleteProduct(Product p) throws ClassNotFoundException, SQLException
	{
		try {
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		String que="delete from product where prodId=?";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1,p.getProdId());
		ps.executeUpdate();
		cm.closeConnection();
		}
		catch (SQLException e) {
	        e.printStackTrace();
	    }

	}
	public void display() throws ClassNotFoundException, SQLException
	{
		//1.jdbc connection
				ConnectionManager cm=new ConnectionManager();
				Connection con = cm.establishConnection();
				
				//3.create the statement
				Statement st = con.createStatement();
				
				//4.write and execute the query
				ResultSet rt = st.executeQuery("select * from product");
				
				//5.print
				while(rt.next())
				{
					System.out.println(rt.getInt("prodId")+" | "+rt.getString("prodName")+" | "+rt.getInt("minSellQuantity")+" | "+rt.getInt("prodPrice")+" | "+rt.getInt("quantity"));
				}
	}
}
