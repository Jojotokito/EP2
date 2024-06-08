package usp.mac321.ep2;

public class Usuario {
	private String nickName;
	private String name;
	
	public Usuario (String nickName, String name) {
		this.nickName = nickName;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNickName() {
		return nickName;
	}
}
