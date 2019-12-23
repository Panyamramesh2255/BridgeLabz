package bridgelabz.ddl_xlxs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		File fp = new File("//home/bridgeit/Desktop/LoginData.xlsx");
		FileInputStream file = new FileInputStream(fp);
		Workbook wekbk = new XSSFWorkbook(file);
		Sheet sht = wekbk.getSheet("Sheet1");
		int rowCount = sht.getLastRowNum();
		for (int i = 0; i < rowCount - 1; i++) {
			Row row = sht.getRow(i);
			for (int j = 0; j < row.getLastCellNum() - 1; j++) {
				System.out.print(row.getCell(j).toString() + "||");
			}
			System.out.println();
		}
	}
}
