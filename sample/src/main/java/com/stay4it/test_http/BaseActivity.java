package com.stay4it.test_http;


import android.support.v7.app.AppCompatActivity;

import com.stay4it.http.RequestManager;
import com.stay4it.http.error.AppException;
import com.stay4it.http.itf.OnGlobalExceptionListener;

/**
 * Created by Stay on 12/7/15.
 * Powered by www.stay4it.com
 */
public class BaseActivity extends AppCompatActivity implements OnGlobalExceptionListener {
    @Override
    public boolean handleException(AppException e) {
        if (e.statusCode == 403) {
            if ("token invalid".equals(e.responseMessage)) {
//                        TODO relogin
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        RequestManager.getInstance().cancelRequest(toString(),true);
    }
}
