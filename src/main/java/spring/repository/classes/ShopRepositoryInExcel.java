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
import spring.repository.interfaces.ShopRepositoryI;

public class ShopRepositoryInExcel extends AbstarctReposetoryInExcel<ShopDbE> implements ShopRepositoryI{

	public ShopRepositoryInExcel() {
		super("Shop");
	}
	@Override
	protected Map<String, Object[]> getData(ShopDbE shop) {
			Map<String, Object[]> mapData = new TreeMap<String, Object[]>();
			Object[] a = new Object[] {shop.getName(), shop.getPicPath(), shop.getContant()};
		    mapData.put("1", a);
			return mapData;
	}
	@Override
	protected ShopDbE convertRowToEntity(Row row) throws Exception {
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
	protected String getStringFromCell(Cell cell) {
		if (cell==null){
			return "NULL";
		}
		CellType cellType = cell.getCellTypeEnum(); //TODO: 
		switch(cellType){
			case STRING : return cell.getStringCellValue();
			case NUMERIC : return cell.getNumericCellValue()+"";
			case BOOLEAN : return cell.getBooleanCellValue()+"";
			case FORMULA : return cell.getCellFormula()+"";
			default: return "Unknown";
		}
	}
}
