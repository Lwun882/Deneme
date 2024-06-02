package tr.com.burak.core;

public class CoreFields {
	private String userName = "root";
	private String password = "";
	private String url = "jdbc:mysql://localhost/satisvestok?useUnicode=true&characterEncoding=UTF-8";
	//localhost:8080/phpmyadmin/index.php?route=/database/structure&db=satisvestok

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}
}
