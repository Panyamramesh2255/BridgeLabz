package bridgelabz.ddl_xlxs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromXLXS {
	/**
	 * purpose: reading data from XLS file
	 * 
	 * @return
	 * @throws IOException
	 */
	public String[][] fileproperties() throws IOException {
		File fp = new File("/home/bridgeit/Desktop/LoginData.xlsx");
		FileInputStream file = new FileInputStream(fp);
		Workbook wekbk = new XSSFWorkbook(file);
		Sheet sht = wekbk.getSheet("Sheet1");
		int rowCount = sht.getLastRowNum();
		System.out.println("row count is " + rowCount);
		Row row1 = sht.getRow(0);
		int colCount = row1.getLastCellNum();
		System.out.println("col count is " + colCount);

		String[][] dataArray = new String[3][2];
		for (int i = 1; i < 4; i++) {
			Row row = sht.getRow(i);
			for (int j = 0; j < 2; j++) {
				System.out.println(row.getCell(j).getStringCellValue() + "||");
				dataArray[i - 1][j] = row.getCell(j).getStringCellValue();
			}
		}

		return dataArray;
	}

	/**
	 * purpose: Execution starts from this method
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ReadFromXLXS object = new ReadFromXLXS();
		object.fileproperties();

	}

}
