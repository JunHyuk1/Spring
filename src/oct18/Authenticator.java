package oct18;

public interface Authenticator {

	void authenticate(LoginCommand loginCommand)
	throws AuthenticationException;
}
