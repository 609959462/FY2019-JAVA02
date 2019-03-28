package Ppf.UesrView;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;

public interface UserView {
	
	void login() throws LoginException;
    void register() throws RegisterExpetion;
	void see();
	
}
