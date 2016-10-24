package spring.repository.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import spring.entities.ShopDbE;
import spring.entities.UserDbE;
import spring.repository.interfaces.ShopRepositoryI;

public class ShopRepositoryInExcel implements ShopRepositoryI{
	
	String m_filePath = "C:\\1\\SapirUsers.xlsx";
	static XSSFWorkbook m_workbook = new XSSFWorkbook(); 
	static String m_sheetName = "Shop";
	
	public ShopDbE save(ShopDbE shop) throws Exception {
		Map<String, Object[]> mapData = getData(shop);
		prepareDataToExcel(m_workbook, mapData);
		writeWorkbookToFile(m_workbook, m_filePath);
		return shop;
	}
	private static Map<String, Object[]> getData(ShopDbE shop) {
		Map<String, Object[]> mapData = new TreeMap<String, Object[]>();
		Object[] a = new Object[] {shop.getName(), shop.getPic(), shop.getContant()};
	    mapData.put("1", a);
		return mapData;
	}
	
	private void prepareDataToExcel(XSSFWorkbook workbook, Map<String, Object[]> mapData) throws Exception {
		reloadData ();
		XSSFSheet sheet1 = m_workbook.getSheet(m_sheetName);
		if (sheet1 != null){
			addDataToExistingSheet(sheet1, mapData);
		}else{
			XSSFSheet sheet2 = m_workbook.createSheet(m_sheetName);
			addDataToNewSheet(sheet2, mapData);
		}
	}
	
	private void reloadData () throws Exception{
		InputStream fs = new FileInputStream(m_filePath);
		m_workbook = new XSSFWorkbook(fs);
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

	private  Row findRow (XSSFSheet sheet, String userName) throws Exception {
	    for (Row row : sheet) {
	    	Cell cell = row.getCell(0);
	    	String cellUserName = cell.getStringCellValue();
	    	if (cellUserName.equals(userName)){
	    			return row;
	        }
	    }
	    throw new Exception ("Not found user ("+userName+") in repository");
	}
	
	private ShopDbE  convertRowToShope (Row row) throws Exception{
		try{
			String name = getStringFromCell(row.getCell(0));
			String pic = getStringFromCell(row.getCell(1));
			String contant = getStringFromCell(row.getCell(2));
			ShopDbE shop  = new  ShopDbE (name, pic, contant);
			return shop;
		}catch(Exception e){
			throw new Exception ("Faild to convert row to shope : " + e.getMessage());
		}
	}

	private String getStringFromCell(Cell cell) {
		if (cell==null){
			return "NULL";
		}
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

	public Collection<ShopDbE> getAll() throws Exception {
		reloadData ();
		XSSFSheet sheet1 = m_workbook.getSheet(m_sheetName);
		ArrayList<ShopDbE> lstShop = new ArrayList<ShopDbE>();
		for (int i = 1; i<=sheet1.getLastRowNum(); i++){
			Row row = sheet1.getRow(i);
			ShopDbE shop = convertRowToShope(row);
			lstShop.add(shop);
		}
		return lstShop;
	}

	public ShopDbE get(String name) throws Exception {
		reloadData ();
		XSSFSheet sheet1 = m_workbook.getSheet(m_sheetName);
		Row row = findRow(sheet1, name);
		ShopDbE shop = convertRowToShope(row);
		return shop;
		
	}

}
