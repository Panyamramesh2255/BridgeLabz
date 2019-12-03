package classes;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author PanyamRamesh
 * purpose: Doctor Model Class
 *
 */
public class Doctors {
	@JsonProperty
	String name;
	@JsonProperty
	int id;
	@JsonProperty
	String specialization;
	@JsonProperty
	String avilability;
	public Doctors(String name,int id,String specialization,String avilability)
	{
		this.name=name;
		this.id=id;
		this.specialization=specialization;
		this.avilability=avilability;
	}
	public Doctors()
	{
		
	}
	
	

	@Override
	public String toString() {
		return "name=" + name + ", id=" + id + ", specialization=" + specialization + ", avilability="
				+ avilability ;
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



	public String getSpecialization() {
		return specialization;
	}



	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}



	public String getAvilability() {
		return avilability;
	}



	public void setAvilability(String avilability) {
		this.avilability = avilability;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}