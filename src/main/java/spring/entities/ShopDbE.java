package spring.entities;

public class ShopDbE {
	protected String name;
	protected String pic;
	protected String contant;
	
	
	public ShopDbE(String name, String pic, String contant) {
		super();
		this.name = name;
		this.pic = pic;
		this.contant = contant;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getContant() {
		return contant;
	}
	public void setContant(String contant) {
		this.contant = contant;
	}
	
	
}
