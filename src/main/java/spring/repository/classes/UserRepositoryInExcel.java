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
import spring.repository.interfaces.UserRepositoryI;

public class UserRepositoryInExcel extends AbstarctReposetoryInExcel<UserDbE> implements UserRepositoryI {

	public UserRepositoryInExcel() {
		super("users");
	}
	@Override
	protected Map<String, Object[]> getData(UserDbE user) {
		Map<String, Object[]> mapData = new TreeMap<String, Object[]>();
		Object[] a = new Object[] {user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(), user.getBirthday(), user.getWeddingDate(), user.getGender(), user.getCity()};
	    mapData.put("1", a);
		return mapData;
	}
	@Override
	protected UserDbE convertRowToEntity(Row row) throws Exception {
		try{
			String firstName = getStringFromCell(row.getCell(0)); //.getStringCellValue()+"";
			String lastName = getStringFromCell(row.getCell(1));
			String email = getStringFromCell(row.getCell(2));
			String phoneNumber = getStringFromCell(row.getCell(3));
			String birthday = getStringFromCell(row.getCell(4));
			String weddingDate = getStringFromCell(row.getCell(5));
			String city = getStringFromCell(row.getCell(6));
			String gender = getStringFromCell(row.getCell(7));
			UserDbE user =new  UserDbE (firstName, lastName, email, phoneNumber, birthday,weddingDate, city, gender);
			return user;
		}catch(Exception e){
			throw new Exception ("Faild to convert row to user : " + e.getMessage());
		}
	}
}
