package functions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import classes.CompanyClass;
/**
 * 
 * @author PanyamRamesh
 * purpose: Adding Company
 *
 */
public class AddingCompany {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter id :");
		String id=scanner.next();
		System.out.println("Enter company name :");
		String name=scanner.next();
		System.out.println("Enter Sharevalue");
		int sharename=scanner.nextInt();
		System.out.println("Enter NumberOfShares");
		int numberofshares=scanner.nextInt();
		CompanyClass cc=new CompanyClass(id, name, sharename, numberofshares);
		ObjectMapper mapper=new ObjectMapper();
		File fp=new File("/home/bridgeit/Desktop/cdp/company.json");
		if(fp.length()!=0)
		{
			List<CompanyClass> customer=new ArrayList(Arrays.asList(mapper.readValue(fp, CompanyClass[].class)));
	        customer.add(cc);
	        mapper.writeValue(fp, customer);
	        System.out.println("Added :");
		}
		else
		{
			List<CompanyClass> customer=new ArrayList<CompanyClass>();
			customer.add(cc);
			mapper.writeValue(fp, customer);
			System.out.println("Added :");
		}
		
	}

}


