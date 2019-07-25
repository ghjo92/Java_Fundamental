package java_20190723;

public class Admin {
	private String id;
	private String pwd;
	private String email;
	private int level;
	
	
	//디폴트 생성자 => alt + shift + s => c
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Admin(String id, String pwd, String email) {
		//4개짜리 생성자 이용.
		//this를 하면 super가 자동으로 나오지 않는다.
		this(id,pwd,email,0);
		//this 용법 2개
		//1. 자기자신객체 =>this.~
		//2. 다른생성자 호출 => this(~~)
	}
	
	
	//생성자 => alt + shift + s => o
	public Admin(String id, String pwd, String email, int level) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.level = level;
	}
	
	//alt + shift + s => r
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd() {
		return pwd;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
}
