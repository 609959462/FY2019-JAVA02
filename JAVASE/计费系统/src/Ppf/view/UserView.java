package Ppf.view;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterException;

public interface UserView {
	void login() throws LoginException;
    void register() throws RegisterException;
}
