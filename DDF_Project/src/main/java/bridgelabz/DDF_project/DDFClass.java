package bridgelabz.DDF_project;

import java.io.IOException;

/**
 * 
 * @author PanyamRamesh purpose: DataDrivenFramework implementation
 *
 */

public class DDFClass {
	public static String pageTitle = "fundooPush Admin";

	public static void main(String[] args) throws IOException, InterruptedException {
		ReadJsonFile obj = new ReadJsonFile();
		obj.readJson();

	}

}
