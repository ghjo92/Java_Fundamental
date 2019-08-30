package java_20190805;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelPractice {
	public static void main(String[] args) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("띠용");

		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("c:\\dev\\test\\test.txt");
			br = new BufferedReader(fr);

			String readline;
			int rowIdx = 0;

			while ((readline = br.readLine()) != null) {
				String[] strArray = readline.split("#");
				HSSFRow row = sheet.createRow(rowIdx++);
				for (int i = 0; i < strArray.length; i++) {
					HSSFCell cell = row.createCell(i);
					cell.setCellValue(strArray[i]);
				}
			}
			FileOutputStream fos = new FileOutputStream("c:\\dev\\test\\test.xls");
			workbook.write(fos);

			fos.close();
			workbook.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)fr.close();
				if (br != null)br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
