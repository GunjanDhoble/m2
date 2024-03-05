package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtils {
	public String getDataFromExel(String Sheetname, int Rownum,int Cellnum) throws EncryptedDocumentException, IOException {

    FileInputStream fis = new FileInputStream("src\\test\\resources\\Data1.xlsx");
   
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sht = wb.getSheet("Organizations");
	Row rw = sht.getRow(Rownum);
	Cell c1 = rw.getCell(Cellnum);
    String value = c1.getStringCellValue();
	return value;
	}
	}

