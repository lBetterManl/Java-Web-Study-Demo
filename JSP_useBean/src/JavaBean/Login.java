package JavaBean;

public class Login {
	private String userName;
	private String password;
	//必须要有一个无参的构造函数
	public Login(){
		
	}
	
	public String getUserName() {
		//防止乱码
		try {
			byte[] b;
			b = userName.getBytes("ISO-8859-1");
			userName = new String(b, "UTF-8");
			return userName;
		} catch (Exception e) {		
			e.printStackTrace();
			return userName;
		}	
		
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
