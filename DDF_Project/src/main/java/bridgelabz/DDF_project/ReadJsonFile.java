package bridgelabz.DDF_project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReadJsonFile {
	/**
	 * 
	 * purpose: reading DATA from JSON file
	 * 
	 * @throws InterruptedException
	 */
	public void readJson() throws FileNotFoundException, InterruptedException {
		Login object = new Login();
		JsonParser parser = new JsonParser();
		FileReader file = new FileReader("UserCredentials.json");
		Object obj = parser.parse(file);
		JsonArray array = (JsonArray) obj;
		// String[][] dataArray=new String[3][2];
		for (int i = 0; i < array.size(); i++) {
			JsonObject users = (JsonObject) array.get(i);
			String username = users.get("UserName").toString().replace("\"", "");
			// System.out.println();
			// String user=users.get(username);
			String password = users.get("Password").toString().replace("\"", "");
			String testStatus = object.login(username, password);
			System.out.println("un:" + username);
			System.out.println("ps:" + password);

			users.addProperty("status", testStatus);
			try {

				FileWriter resultfile = new FileWriter("TestData.json");
				resultfile.append(array.toString());
				resultfile.flush();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
