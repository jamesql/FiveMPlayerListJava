
public class config {

	final static String SERVER_IP = "95.216.104.84:30120";
	String username = "james";
	public String password = "9b69b4e5842f6706d44d4e8175ccff839730cf7497869ac4830ce66c0d7b98d7";
	private final String PIN_NUM = "secretword";
	public String errMsg = "No Perms!";
	
	
	public String getPassword(String pin) {
		if (pin == PIN_NUM)
		return password;
		else
		return errMsg;
	}
}
