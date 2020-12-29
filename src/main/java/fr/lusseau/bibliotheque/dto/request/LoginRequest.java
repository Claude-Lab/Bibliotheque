/**
 * 
 */
package fr.lusseau.bibliotheque.dto.request;

import javax.validation.constraints.NotBlank;

/**
 * Class in charge of defining .
 * @Version Bibliotheque -v1,0
 * @date  17 déc. 2020 - 10:54:13
 * @author Claude LUSSEAU
 *
 */
public class LoginRequest {
	
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;
    
    /**
	 * Constructor.
	 */
	public LoginRequest() {
		// TODO Auto-generated constructor stub
	}
    

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}