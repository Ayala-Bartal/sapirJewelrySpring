package spring.services.classes;

import java.io.File;
import java.util.Collection;
import spring.entities.ShopDbE;
import spring.repository.classes.ShopRepositoryInExcel;
import spring.repository.interfaces.ShopRepositoryI;
import spring.services.interfaces.ShopServiseI;

public class ShopServiceImpl implements ShopServiseI {
	
	ShopRepositoryI m_shopRepository;
	
	public ShopServiceImpl (){
		m_shopRepository = new ShopRepositoryInExcel();
	}
	
	public ShopDbE add(ShopDbE shop) throws Exception {
		return m_shopRepository.save(shop);
	}

	public Collection <ShopDbE> getAll() throws Exception {
		Collection<ShopDbE> lstShops = m_shopRepository.getAll();
		return lstShops;
	}

	
	public ShopDbE get(String name) throws Exception {
		return (ShopDbE) m_shopRepository.get(name);
	}

	public File getImage(String name) throws Exception {
		ShopDbE current = get(name);
		String fullPath = current.getPicPath();  
        File downloadFile = new File(fullPath);
        return downloadFile;
	}
}
