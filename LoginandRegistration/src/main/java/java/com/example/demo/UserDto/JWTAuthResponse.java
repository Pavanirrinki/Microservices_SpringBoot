package java.com.example.demo.UserDto;

public class JWTAuthResponse {
	private String token;
	private String tokenType="Bearer ";
	
	public JWTAuthResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

}
