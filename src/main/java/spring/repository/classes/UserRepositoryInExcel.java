package spring.repository.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import spring.entities.UserDbE;
import spring.entities.UserDbE;
import spring.repository.interfaces.UserRepositoryI;

public class UserRepositoryInExcel implements UserRepositoryI {
	
	String m_filePath = "C:\\1\\SapirUsers.xlsx";
	static XSSFWorkbook m_workbook = new XSSFWorkbook(); 
	static String m_sheetName = "a";

	public UserDbE save(UserDbE user) {
		Map<String, Object[]> mapData = getData(user);
		try {
			prepareDataToExcel(m_workbook, mapData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writeWorkbookToFile(m_workbook, m_filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	private static Map<String, Object[]> getData(UserDbE user) {
		Map<String, Object[]> mapData = new TreeMap<String, Object[]>();
		Object[] a = new Object[] {user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(), user.getBirthday(), user.getWeddingDate()};
	    mapData.put("1", a);
		return mapData;
	}
	
	private void prepareDataToExcel(XSSFWorkbook workbook, Map<String, Object[]> mapData) throws Exception {
		InputStream fs = new FileInputStream(m_filePath);
		m_workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet1 = m_workbook.getSheet(m_sheetName);
		if (sheet1 != null){
			addDataToExistingSheet(sheet1, mapData);
		}else{
			XSSFSheet sheet2 = m_workbook.createSheet(m_sheetName);
			addDataToNewSheet(sheet2, mapData);
		}
	}
	
	private static void addDataToExistingSheet(XSSFSheet sheet1, Map<String, Object[]> mapData) {
		int lastRow = sheet1.getLastRowNum();
		int rownum = lastRow++;
		addNewRows (sheet1, mapData, rownum);
	}
        
    private static void addDataToNewSheet(XSSFSheet sheet1, Map<String, Object[]> mapData) {
    	int rownum = 0;
    	addNewRows (sheet1, mapData, rownum);
	}
    
	private static void addNewRows(XSSFSheet sheet1, Map<String, Object[]> mapData, int rownum) {
		Set<String> keyset = mapData.keySet();
		for (String key : keyset){
        	rownum++;
            Row row = sheet1.createRow(rownum);
            addNewRow(row, key, mapData);
	    }
	}

	private static void addNewRow(Row row, String key, Map<String, Object[]> mapData) {
		Object [] objArr = mapData.get(key);
        int cellnum = 0;
        for (Object obj : objArr){
           Cell cell = row.createCell(cellnum++);
           if(obj instanceof String)
                cell.setCellValue((String)obj);
            else if(obj instanceof Integer)
                cell.setCellValue((Integer)obj);
        }
	}


	private static void writeWorkbookToFile(XSSFWorkbook workbook, String filePath) throws Exception {
		
			FileOutputStream out = new FileOutputStream(new File(filePath));
		       workbook.write(out);
		       out.close();
		       System.out.println(filePath+" written successfully on disk.");
		
       
	}

		private  Row findRow (XSSFSheet sheet, String userName) {
	    for (Row row : sheet) {
	    	Cell cell = row.getCell(0);
	    	String cellUserName = cell.getStringCellValue();
	    	if (cellUserName.equals(userName)){
	    			return row;
	        }
	    }
	    return null;
	}
	
	private UserDbE convertRowToUser (Row row){
		
		try{
			String firstName = getStringFromCell(row.getCell(0)); //.getStringCellValue()+"";
			String lastName = getStringFromCell(row.getCell(1));
			String email = getStringFromCell(row.getCell(2));
			String phoneNumber = getStringFromCell(row.getCell(3));
			String birthday = getStringFromCell(row.getCell(4));
			String weddingDate = getStringFromCell(row.getCell(5));
			UserDbE user =new  UserDbE (firstName, lastName, email, phoneNumber, birthday,weddingDate);
			return user;
		}catch(Exception e){
			UserDbE user = new  UserDbE ();
			return user;
		}
		
	}
	
	

	private String getStringFromCell(Cell cell) {
		CellType cellType = cell.getCellTypeEnum(); //TODO: 
		switch(cellType){
			case STRING : return cell.getStringCellValue();
			case NUMERIC : return cell.getNumericCellValue()+"";
			case BOOLEAN : return cell.getBooleanCellValue()+"";
			case FORMULA : return cell.getCellFormula()+"";
		//	case DATE : return cell.getDateCellValue()+"";
			default: return "Unknown";
		}
	}

	public UserDbE get(String name) {
		try{
			InputStream fs = new FileInputStream(m_filePath);
			m_workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet1 = m_workbook.getSheet(m_sheetName);
			Row row = findRow(sheet1, name);
			UserDbE user = convertRowToUser(row);
			return user;
		}catch(Exception e){
			e.getMessage();
			return null;
		}
		
	}
	
	public Collection<UserDbE> getAll() {
		
		try {
			InputStream fs1 = new FileInputStream(m_filePath);
			m_workbook = new XSSFWorkbook(fs1);
			XSSFSheet sheet1 = m_workbook.getSheet(m_sheetName);
			ArrayList<UserDbE> lstUsers = new ArrayList<UserDbE>();
			for (int i = 1; i<=sheet1.getLastRowNum(); i++){
				Row row = sheet1.getRow(i);
				UserDbE user = convertRowToUser(row);
				lstUsers.add(user);
			}
			return lstUsers;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	


}
