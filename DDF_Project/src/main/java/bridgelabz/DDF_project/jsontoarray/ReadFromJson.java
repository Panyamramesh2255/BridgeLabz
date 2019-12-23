package bridgelabz.DDF_project.jsontoarray;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.record.ObjRecord;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * purpose: Reading JSON File
 * 
 * @author PanyamRamesh
 *
 */
public class ReadFromJson {
	/**
	 * purpose: Reading data from JSON file
	 * 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void read_From_json() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File fp = new File("/home/bridgeit/eclipse-workspace/DDF_Project/UserCredentials.json");
		List<ModelClass> object = new ArrayList<ModelClass>(Arrays.asList(mapper.readValue(fp, ModelClass[].class)));
		for (Object obj : object) {
			System.out.println(obj);
		}

	}

}
