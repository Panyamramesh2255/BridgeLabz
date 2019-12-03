package functions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import classes.CompanyClass;
import classes.CustomerClass;
/**
 * 
 * @author PanyamRamesh
 * purpose: Clinic Management Operations
 *
 */
public class Operations {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		Operations op=new Operations();
		//
		Scanner scanner=new Scanner(System.in);
		try{
		System.out.println("1.Buy       2.Sell ");
		int choice=scanner.nextInt();
		if( choice==1)
		{
			op.buy();
		}
		else if(choice==2)
		{
		op.sell();	
		}
		else
		{
			System.out.println("Enter option eother 1 or 2 :");
		}
		
		
		
		}catch(Exception e)
		{
			System.out.println("Invalid Input !");
		}

	}
	public void buy() throws JsonParseException, JsonMappingException, IOException
	{ Scanner scanner=new Scanner(System.in);
		ObjectMapper mapper=new ObjectMapper();
	  File fp=new File("/home/bridgeit/Desktop/cdp/company.json");
	  File fp1=new File("/home/bridgeit/Desktop/cdp/customer.json");
	  List<CustomerClass>customer=new ArrayList<CustomerClass>(Arrays.asList(mapper.readValue(fp1, CustomerClass[].class)));
	  for(Object obj:customer)
	  {
		  System.out.println(obj);
	  }
	  System.out.println("Select id of the user to get login :");
	  int customerid=scanner.nextInt()-1;
	  List<CompanyClass>company=new ArrayList<CompanyClass>(Arrays.asList(mapper.readValue(fp,CompanyClass[].class)));  	
	  for(Object obj:company)
	  {
		System.out.println(obj);  
	  }
	  System.out.println("Enter the comapny id to purchase shares :");
	  int companyid=scanner.nextInt()-1;
	  System.out.println("Enter number of shares to purchase :");
	  int numberofshares=scanner.nextInt();
	  if((customer.get(customerid).getAmount())<(company.get(companyid).getSharevalue()*numberofshares))
	  {
		  System.out.println("you do not have suffiecient balence :");
	  }
	  else
	  {
		  int setcompanyshares=company.get(companyid).getNumberofshares()-numberofshares;
		  company.get(companyid).setNumberofshares(setcompanyshares);
		  int setcustomershares=customer.get(customerid).getNumberofshares()+numberofshares;
		  customer.get(customerid).setNumberofshares(setcustomershares);
		  int setamount=company.get(companyid).getSharevalue()*numberofshares;
		  int amountValue=customer.get(customerid).getAmount()-setamount;
		  customer.get(customerid).setAmount(amountValue);
		  System.out.println("Transaction done :");
		  System.out.println(customer.get(customerid).getName()+"buyyed"+numberofshares+"to"+company.get(companyid).getName());
		  System.out.println("at "+new Date());
		  mapper.writeValue(fp1, customer);
		  mapper.writeValue(fp, company);
		  
	  }
	
	}
	public void sell() throws JsonParseException, JsonMappingException, IOException
	{
		Scanner scanner=new Scanner(System.in);
		ObjectMapper mapper=new ObjectMapper();
	  File fp=new File("/home/bridgeit/Desktop/cdp/company.json");
	  File fp1=new File("/home/bridgeit/Desktop/cdp/customer.json");
	  List<CustomerClass>customer=new ArrayList<CustomerClass>(Arrays.asList(mapper.readValue(fp1, CustomerClass[].class)));
	  for(Object obj:customer)
	  {
		  System.out.println(obj);
	  }
	  System.out.println("Select id of the user to get login :");
	  int customerid=scanner.nextInt()-1;
	  List<CompanyClass>company=new ArrayList<CompanyClass>(Arrays.asList(mapper.readValue(fp,CompanyClass[].class)));  	
	  for(Object obj:company)
	  {
		System.out.println(obj);  
	  }
	  System.out.println("Enter the comapny id to sell shares :");
	  int companyid=scanner.nextInt()-1;
	  System.out.println("Enter number of shares to sell :");
	  int numberofshares=scanner.nextInt();
	  if(((customer.get(customerid).getAmount())<(company.get(companyid).getSharevalue()*numberofshares))&&(customer.get(customerid).getNumberofshares()>numberofshares))
	  {
		  System.out.println("you do not have suffiecient balence (or) sahres :");
	  }
	  else
	  {
		  int setcompanyshares=company.get(companyid).getNumberofshares()+numberofshares;
		  company.get(companyid).setNumberofshares(setcompanyshares);
		  int setcustomershares=customer.get(customerid).getNumberofshares()-numberofshares;
		  customer.get(customerid).setNumberofshares(setcustomershares);
		  int setamount=company.get(companyid).getSharevalue()*numberofshares;
		  int amountValue=customer.get(customerid).getAmount()+setamount;
		  customer.get(customerid).setAmount(amountValue);
		  System.out.println("Transaction done :");
		  System.out.println(customer.get(customerid).getName()+" selled "+numberofshares+"  to "+company.get(companyid).getName());
         System.out.println("at  "+new Date());
		  mapper.writeValue(fp1, customer);
		  mapper.writeValue(fp, company);
		  
	  }
	
		
	}



	}


