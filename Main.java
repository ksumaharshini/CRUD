package controller;
import java.sql.SQLException;
import java.util.Scanner;

import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		int choice,opt;
		Login l=new Login();
		LoginDAO ldao = new LoginDAO();
		Product p=new Product();
		ProductDAO pdao=new ProductDAO();
        do {
        System.out.println("1.Admin\n 2.Agent\n 3.Exit\n ****************************************************************\n Enter your choice\n");
        choice=sc.nextInt();
        switch(choice)
        {
        case 1:
        	System.out.println("Admin Login");
        	System.out.println("Enter the User Name");
        	String username=sc.next();
        	System.out.println("Enter the Password");
        	String password=sc.next();
        	l.setUsername(username);
        	l.setPassword(password);
        	if(ldao.checkCredential(l))
        	{
        		System.out.println("Login Successfull");
        		do {
        			System.out.println("1.Add Products\n 2.Display Products\n 3.Update Products\n 4.Delete Products\n 5.Logout\n ****************************************************************\n Enter your choice\n");
        			opt=sc.nextInt();
        			switch(opt)
        	        {
        			case 1:
        				System.out.println("Add products");
        				System.out.println("Enter the Product Id");
        				int productid=sc.nextInt();
        				sc.nextLine();
        				System.out.println("Enter the Product name");
        				String productname=sc.nextLine();
        				System.out.println("Enter the minimum sell quantity");
        				int minsellquantity=sc.nextInt();
        				System.out.println("Enter the price");
        				int price=sc.nextInt();
        				System.out.println("Enter the quantity");
        				int quantity=sc.nextInt();
        				p.setMinSellQuantity(minsellquantity);
        				p.setProdId(productid);
        				p.setProdName(productname);
        				p.setProdPrice(price);
        				p.setQuality(quantity);
        				pdao.addProduct(p);
        				break;
        			case 2:
        				System.out.println("Display Products");
        				pdao.display();
        				break;
        			case 3:
        			    System.out.println("Update Products");
        			    System.out.println("Enter the Product ID to update:");
        			    int updateProductId = sc.nextInt();
        			    // Set the prodId for the Product object
        			    p.setProdId(updateProductId);

        			    // Now you need to prompt for and set other attributes (prodName, minSellQuantity, prodPrice, quantity) here if needed
        			    System.out.println("Enter the updated Product name");
        			    String updatedProductName = sc.next();
        			    System.out.println("Enter the updated minimum sell quantity");
        			    int updatedMinSellQuantity = sc.nextInt();
        			    System.out.println("Enter the updated price");
        			    int updatedPrice = sc.nextInt();
        			    System.out.println("Enter the updated quantity");
        			    int updatedQuantity = sc.nextInt();

        			    // Set the updated values in the Product object
        			    p.setProdName(updatedProductName);
        			    p.setMinSellQuantity(updatedMinSellQuantity);
        			    p.setProdPrice(updatedPrice);
        			    p.setQuality(updatedQuantity);

        			    // Now call the update method
        			    pdao.updateProduct(p);
        			    break;

        			case 4:
        				System.out.println("Delete Products");
        			    System.out.println("Enter the Product ID to delete:");
        			    int deleteProductId = sc.nextInt();
        			    // Set the prodId for the Product object
        			    p.setProdId(deleteProductId);
        			    
        			    pdao.deleteProduct(p);
        			    break;
        			case 5:
        				System.out.println("LogOut");
        				break;
        				
        	        }
        		}while(opt!=5);
        	}
        	else {
        		System.out.println("Incorrect Username/password");
        	}
        	break;
        case 2:
        	System.out.println("Agent Login");
        	System.out.println("Enter the User Name");
        	String username1=sc.next();
        	System.out.println("Enter the Password");
        	String password1=sc.next();
        	l.setUsername(username1);
        	l.setPassword(password1);
        	if(ldao.checkCredential(l))
        	{
        		System.out.println("Login Successfull");
        		int ch;
        		do {
        			System.out.println("1.Display Products\n 2.Log Out\n ****************************************************************\n Enter your choice\n");
        			ch=sc.nextInt();
        			switch(ch){
        			case 1 :
        				System.out.println("Display products");
        				pdao.display();
        				break;
        			case 2:
        				System.out.println("Log Out");
        				break;
        			}
        		}while(ch!=2);
        	}
        	else {
        		System.out.println("Incorrect Username/password");
        	}	
        	break;
        case 3:
        	System.out.println("Exit");
        	break;
        }
        }while(choice!=3);
        sc.close();
        
	}

}
