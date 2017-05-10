package com.stay4it.test_http;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.stay4it.http.Request;
import com.stay4it.http.RequestManager;
import com.stay4it.http.callback.FileCallback;
import com.stay4it.http.callback.JsonArrayReaderCallback;
import com.stay4it.http.callback.JsonCallback;
import com.stay4it.http.callback.JsonReaderCallback;
import com.stay4it.http.callback.StringCallback;
import com.stay4it.http.entities.FileEntity;
import com.stay4it.http.error.AppException;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private static final String TAG = "MainActivity";
    private Button mRunOnSubThreadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRunOnSubThreadBtn = (Button) findViewById(R.id.mRunOnSubThreadBtn);
        mRunOnSubThreadBtn.setOnClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mRunOnSubThreadBtn:
//                testHttpPostOnSubThread();
//                testHttpPostOnSubThreadForGeneric();
//                testHttpPostOnSubThreadForDownload();
//                testHttpPostOnSubThreadForDownloadProgress();
//                testHttpPostOnSubThreadForGenericLoadMore();
//                testHttpForJsonReaderArray();
//                testUploadProgressUpdated();
//                testHttpPostOnSubThreadForOKHTTP();
//                textHttpweatherReq();

                String url = "http://guolin.tech/api/weather?cityid=shenzhen&key=3799d79d735340ac9accef410a7f5316";
                Request request = new Request(url, Request.RequestMethod.GET);
                request.setCallback(new StringCallback() {
                                        @Override
                                        public void onSuccess(String result) {
                                            Log.i(TAG, "结果onSuccess：" + result);
                                            //callback.onSucceed(new Gson().fromJson(json, mHttpBody.getJavaBean()));
                                            Weather weather = new Gson().fromJson(result, Weather.class);
                                            Log.i(TAG, weather.getHeWeather().get(0).getBasic().getCity());
                                        }

                                        @Override
                                        public void onFailure(AppException e) {
                                            Log.i(TAG, "结果onFailure：" + e.toString());
                                        }
                                    }

                );
                request.maxRetryCount = 0;
                RequestManager.getInstance().performRequest(request);

                break;


        }
    }

    private void textHttpweatherReq() {
        String url = "http://guolin.tech/api/weather?cityid=shenzhen&key=3799d79d735340ac9accef410a7f5316";
        Request request = new Request(url, Request.RequestMethod.GET);
        request.setCallback(new StringCallback() {

            @Override
            public void onSuccess(String result) {
                Log.i(TAG, "结果：" + result);
            }

            @Override
            public void onFailure(AppException e) {

            }
        });
        request.maxRetryCount = 0;
        RequestManager.getInstance().performRequest(request);
    }

    public void testHttpPostOnSubThreadForOKHTTP() {

        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";
        String content = "account=stay4it&password=123456";
        Request request = new Request(url, Request.RequestMethod.POST, Request.RequestTool.OKHTTP);
        String path = Environment.getExternalStorageDirectory() + File.separator + "json.tmp";
        request.setCallback(new JsonReaderCallback<User>() {

            @Override
            public void onSuccess(User result) {
//                TODO insert into db
//                ArrayList<User>
                Log.e("stay", "testHttpGet return:" + result.toString());
            }

            @Override
            public void onFailure(AppException e) {
                e.printStackTrace();
            }


        }.setCachePath(path));
        request.content = content;
        request.maxRetryCount = 0;
        RequestManager.getInstance().performRequest(request);

    }


    public void testHttpPostOnSubThread() {

        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";
        String content = "account=stay4it&password=123456";
        Request request = new Request(url, Request.RequestMethod.POST);
        request.setCallback(new JsonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("stay", "testHttpGet return:" + result);
            }

            @Override
            public void onFailure(AppException e) {
                if (e.statusCode == 403) {
                    if ("password incorrect".equals(e.responseMessage)) {
//                        TODO
                    } else if ("token invalid".equals(e.responseMessage)) {
//                        TODO relogin
                    }
                }
                e.printStackTrace();
            }
        });
//      global exception handler
        request.setGlobalExceptionListener(this);
        request.content = content;
        RequestManager.getInstance().performRequest(request);
    }

    public void testHttpPostOnSubThreadForGeneric() {

        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";
        String content = "account=stay4it&password=123456";
        Request request = new Request(url, Request.RequestMethod.POST);
        String path = Environment.getExternalStorageDirectory() + File.separator + "json.tmp";
        request.setCallback(new JsonReaderCallback<User>() {

            @Override
            public void onSuccess(User result) {
//                TODO insert into db
//                ArrayList<User>
                Log.e("stay", "testHttpGet return:" + result.toString());
            }

            @Override
            public void onFailure(AppException e) {
                e.printStackTrace();
            }


        }.setCachePath(path));
        request.content = content;
        request.maxRetryCount = 0;
        RequestManager.getInstance().performRequest(request);

    }

    public void testHttpPostOnSubThreadForGenericPostRequest() {

        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";

        String content = "account=stay4it&password=123456";
        Request request = new Request(url, Request.RequestMethod.POST);
        request.setCallback(new JsonReaderCallback<User>() {
            @Override
            public User postRequest(User user) {
                //                TODO insert into db
//                TODO edit user
                Log.e("stay", "postRequest return:" + user.toString());
                user.email = "xxxx@xxx.com";
                return user;
            }

            @Override
            public void onSuccess(User result) {

//                ArrayList<User>
                Log.e("stay", "onSuccess return:" + result.toString());
            }

            @Override
            public void onFailure(AppException e) {
                e.printStackTrace();
            }


        });
        request.content = content;
        request.maxRetryCount = 0;
        RequestManager.getInstance().performRequest(request);

    }


    public void testHttpPostOnSubThreadForGenericLoadMore() {

        String url = "http://api.stay4it.com/v1/public/core/?service=user.getAll";
        url += "&timestamp=" + System.currentTimeMillis() + "&count=30";
        Request request = new Request(url, Request.RequestMethod.GET);
        request.setCallback(new JsonCallback<ArrayList<Module>>() {

            @Override
            public ArrayList<Module> preRequest() {
//                TODO fetch data
                return null;
            }

            @Override
            public ArrayList<Module> postRequest(ArrayList<Module> modules) {
//                TODO insert into db
                return modules;
            }

            @Override
            public void onSuccess(ArrayList<Module> result) {
                Log.e("stay", "result" + result.size());


            }

            @Override
            public void onFailure(AppException e) {
                e.printStackTrace();
            }
        });
        RequestManager.getInstance().performRequest(request);

    }

    public void testHttpForJsonReaderArray() {

        String url = "http://api.stay4it.com/v1/public/core/?service=user.getAll";
        url += "&timestamp=" + System.currentTimeMillis() + "&count=30";
        Request request = new Request(url, Request.RequestMethod.GET);
        String path = Environment.getExternalStorageDirectory() + File.separator + "jsonarray.tmp";
        request.setCallback(new JsonArrayReaderCallback<Module>() {

            @Override
            public ArrayList<Module> preRequest() {
//                TODO fetch data
                return null;
            }

            @Override
            public ArrayList<Module> postRequest(ArrayList<Module> modules) {
//                TODO insert into db
                return modules;
            }

            @Override
            public void onSuccess(ArrayList<Module> result) {
                Log.e("stay", "result" + result.size());


            }

            @Override
            public void onFailure(AppException e) {
                e.printStackTrace();
            }
        }.setCachePath(path));
        RequestManager.getInstance().performRequest(request);

    }

    public void testHttpPostOnSubThreadForDownload() {

        String url = "http://api.stay4it.com/v1/public/core/?service=user.login";
        String content = "account=stay4it&password=123456";
        Request request = new Request(url, Request.RequestMethod.POST);
        String path = Environment.getExternalStorageDirectory() + File.separator + "demo.txt";
        request.setCallback(new FileCallback() {
            @Override
            public void onSuccess(String path) {
                Log.e("stay", path);
            }

            @Override
            public void onFailure(AppException e) {
            }
        }.setCachePath(path));
        request.content = content;
        RequestManager.getInstance().performRequest(request);
    }

    public void testHttpPostOnSubThreadForDownloadProgress() {

        String url = "http://api.stay4it.com/uploads/test.jpg";
        Request request = new Request(url, Request.RequestMethod.GET);
        String path = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
        request.setCallback(new FileCallback() {
            @Override
            public void onProgressUpdated(int state, int curLen, int totalLen) {
                Log.e("stay", "download:" + curLen + "/" + totalLen);
            }

            @Override
            public void onSuccess(String path) {
                Log.e("stay", path);
            }

            @Override
            public void onFailure(AppException e) {
            }
        }.setCachePath(path));
        request.enableProgressUpdated(true);
        RequestManager.getInstance().performRequest(request);
    }


    public void testHttpPostOnSubThreadForDownloadProgressCancelTest() {
        String url = "http://api.stay4it.com/uploads/test.jpg";
        final Request request = new Request(url, Request.RequestMethod.GET);
//        final RequestTask task = new RequestTask(request);
        String path = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
        request.setCallback(new FileCallback() {
            @Override
            public void onProgressUpdated(int state, int curLen, int totalLen) {
                Log.e("stay", "download:" + curLen + "/" + totalLen);
                if (curLen * 100l / totalLen > 50) {
//                    task.cancel(true);
//                    request.cancel();
                }
            }

            @Override
            public void onSuccess(String path) {

                Log.e("stay", path);
            }

            @Override
            public void onFailure(AppException e) {
                if (e.type == AppException.ErrorType.CANCEL) {

                }
                e.printStackTrace();
            }
        }.setCachePath(path));
        request.enableProgressUpdated(true);
        request.setTag(toString());
        RequestManager.getInstance().performRequest(request);
    }

    public void testUploadProgressUpdated() {
        String url = "http://api.stay4it.com/v1/public/core/?service=user.updateAvatar";
        final Request request = new Request(url, Request.RequestMethod.POST);

        request.addHeader("Connection", "Keep-Alive");
        request.addHeader("Charset", "UTF-8");
        request.addHeader("Content-Type", "multipart/form-data;boundary=7d4a6d158c9");

        String path = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";

        ArrayList<FileEntity> entities = new ArrayList<FileEntity>();
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(path.substring(path.lastIndexOf("/") + 1));
        fileEntity.setFilePath(path);
        fileEntity.setFileType("image/png");
        entities.add(fileEntity);

        request.content = "stay4it";
        request.fileEntities = entities;
//        UploadUtil.upload(out, "stay4it", entities);


        request.setCallback(new StringCallback() {

            @Override
            public void onProgressUpdated(int state, int curLen, int totalLen) {
                Log.e("stay", "state=" + state + " onprogressUpdated:" + curLen + "/" + totalLen);
            }

            @Override
            public void onSuccess(String result) {
                Log.e("stay", result);
            }

            @Override
            public void onFailure(AppException e) {

            }
        });
        request.enableProgressUpdated(true);
        request.setTag(toString());
        RequestManager.getInstance().performRequest(request);
    }


}
