package spring.services.classes;

import java.util.Collection;

import spring.entities.ShopDbE;
import spring.entities.UserDbE;
import spring.repository.classes.ShopRepositoryInExcel;
import spring.repository.classes.UserRepositoryInExcel;
import spring.repository.interfaces.ShopRepositoryI;
import spring.repository.interfaces.UserRepositoryI;
import spring.services.interfaces.ShopServiseI;
import spring.services.interfaces.UserServiseI;

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
		return m_shopRepository.get(name);
	}
}
