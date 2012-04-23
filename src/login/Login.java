package login;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Login {
	
	//fields
	private String username, password;
	
	//constructor
	public Login(String username, String password){
		this.username = username;
		this.password = makeMD5(password);
	}
	
	//methods
	public String getUsername(){	
		return username;
	}
	
	public String makeMD5(String input){
		String res = "";
		try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(input.getBytes());
            byte[] md5 = algorithm.digest();
            String tmp = "";
            for (int i = 0; i < md5.length; i++) {
                tmp = (Integer.toHexString(0xFF & md5[i]));
                if (tmp.length() == 1) {
                    res += "0" + tmp;
                } else {
                    res += tmp;
                }
            }
        } catch (NoSuchAlgorithmException ex) {}
        return res;
	}
	
	public boolean isValidUser(){
		
		String defUser = "";
		String defPassword = "";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/faktisk", "root", "root");
			PreparedStatement statement = con.prepareStatement("select * from login limit 1");
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				defUser = result.getString(2);
				defPassword = result.getString(3);
			}
		}
		
		catch(Exception e){
			
		}
		
		if(defUser.equals(username) && defPassword.equals(password)){
			return true;
		}
		
		else{
			return false;
		}
		
	}

}
