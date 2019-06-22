package com.aiways.androidut.mockito;

import com.aiways.androidut.share.NetworkCallback;
import com.aiways.androidut.share.UserManager;

public class LoginPresenter {
    private UserManager userManager = new UserManager();
    private PasswordValidator passwordValidator = new PasswordValidator();

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        //假设我们对密码强度有一定要求，使用一个专门的validator来验证密码的有效性
        if (passwordValidator.verifyPassword(password)) return;

        userManager.performLogin(username, password);
    }

    public void loginCallbackVersion(String username, String password) {
        if (username == null || username.length() == 0) return;
        //假设我们对密码强度有一定要求，使用一个专门的validator来验证密码的有效性
        if (passwordValidator.verifyPassword(password)) return;

        userManager.performLogin(username, password, new NetworkCallback() {
            @Override
            public void onSuccess(Object data) {
                //update view with data
            }

            @Override
            public void onFailure(int code, String msg) {
                //show error msg
            }
        });
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public void setPasswordValidator(PasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }
}
