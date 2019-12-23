package bridgelabz.ddl_xlxs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * \ purpose: FILE Writing
 * 
 * @author PanyamRamesh
 *
 */
public class FileWrite {

	public static void main(String[] args) throws IOException {
		FileWrite object = new FileWrite();
		ReadFromXLXS object1 = new ReadFromXLXS();
		String[][] dataArray = object1.fileproperties();
		object.writeFile("/home/bridgeit/Desktop/LoginDataWriting.xlsx", dataArray);

	}

	/**
	 * purpose: Writing data into file
	 * 
	 * @param filepath
	 * @param dataArray
	 * @throws IOException
	 */
	public void writeFile(String filepath, String[][] dataArray) throws IOException {
		for (int i = 0; i < dataArray.length; i++) {
			for (int j = 0; j < dataArray[i].length; j++) {
				System.out.println(dataArray[i][j]);
			}
		}
		File fp = new File(filepath);
		System.out.println("writung file is.. " + filepath);
		FileInputStream inputStream = new FileInputStream(fp);
		Workbook wrkbk = new XSSFWorkbook(inputStream);
		Sheet sht = wrkbk.getSheet("Sheet1");
		int rowCount = sht.getLastRowNum();
		// Row row=sht.getRow(0);
		for (int i = 0; i < rowCount - 1; i++) {
			Row row = sht.getRow(i);
			for (int j = 0; j < row.getLastCellNum() - 1; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(((dataArray[i][j])));
			}
		}
		inputStream.close();
		FileOutputStream ouputStream = new FileOutputStream(fp);
		wrkbk.write(ouputStream);
		ouputStream.close();
		System.out.println("file overrided..");

	}

}
