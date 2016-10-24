package spring.entities;

public class ShopDbE {
	protected String name;
	protected String picPath;
	protected String contant;
	
	
	public ShopDbE(String name, String picPath, String contant) {
		super();
		this.name = name;
		this.picPath = picPath;
		this.contant = contant;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String pic) {
		this.picPath = pic;
	}
	public String getContant() {
		return contant;
	}
	public void setContant(String contant) {
		this.contant = contant;
	}
	
	
}
