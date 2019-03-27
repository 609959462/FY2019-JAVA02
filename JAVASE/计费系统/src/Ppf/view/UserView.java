package Ppf.view;

import Ppf.Exception.LoginException;

public interface UserView {
	void login() throws LoginException;
    void register() throws LoginException;
}
