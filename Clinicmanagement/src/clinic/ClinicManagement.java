package clinic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import operations.AddDoctors;
import operations.AddPatients;
/**
 * 
 * @author  PanyamRamesh
 * purpose: Clinic management main class
 *
 */
public class ClinicManagement {
	Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		ClinicManagement cm=new ClinicManagement();
		File fp=new File("/home/bridgeit/Desktop/files/patients.json");
		File fp1=new File("/home/bridgeit/Desktop/files/doctors.json");
		cm.functions();
		
		
	 }
	public void functions() throws JsonParseException, JsonMappingException, IOException
	{
		AddDoctors ad=new AddDoctors();
		AddPatients ap=new AddPatients();
		
		
		System.out.println(" 1.take appointment        2.appointmentlistForDoctors         3.bestDoctors&ClinicSpecialization         4.exit");
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1:ad.takeAppointments();
		        break;
		case 2:ad.appointmentfordoctors();
		       break;
		case 3:ad.bestdoctor();
		       break;
		case 4:exit();
		      break;
		default: System.out.println("invalid input !");
		
		}
		
	}
	public void exit() throws JsonParseException, JsonMappingException, IOException
	{
		System.out.println("Are you sure want to exit(y\n) !");
		String c=scanner.next();
		if(c.compareToIgnoreCase("y")==0)
			System.exit(0);
		else
			functions();
		
	}


                              }
