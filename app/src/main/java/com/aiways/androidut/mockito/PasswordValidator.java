package com.aiways.androidut.mockito;

import javax.inject.Inject;


public class PasswordValidator {
    @Inject
    public PasswordValidator() {
    }

    public boolean verifyPassword(String password) {
        //假设这个方法需要联网
        return "xiaochuang_is_handsome".equals(password);
    }
}
