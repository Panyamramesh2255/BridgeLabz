package classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author  PanyamRamesh
 * purpose: Patient Model Class
 *
 */
public class Patients {
	@JsonProperty
	String name;
	@JsonProperty
	int id;
	@JsonProperty
	long mobilenumber;
	@JsonProperty
	int age;
	public  Patients(String name,int id,long mobilenumber,int age)
	{
		this.name=name;
		this.id=id;
		this.mobilenumber=mobilenumber;
		this.age=age;
	}
	
	  public Patients() {
	  
	  }
	 
	

	@Override
	public String toString() {
		return " name=" + name + ", id=" + id + ", mobilenumber=" + mobilenumber + ", age=" + age ;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public static void main(String[] args) {
		

	}

}
