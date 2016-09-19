package com.garg.salsafest.restAPI;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shivam on 7/24/16.
 */

public class HttpClient {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private static String GET_USER_URL = "http://iamskg.com/LatinFestWebService/rest/user/get";
    private static String POST_REGISTER_USER_URL = "http://iamskg.com/LatinFestWebService/rest/user/register";
    private static String POST_APP_USER_FEEDBACK_URL = "http://iamskg.com/LatinFestWebService/rest/user/appfeedback";
    private static String POST_DJ_FEEDBACK_URL = "http://iamskg.com/LatinFestWebService/rest/user/djfeedback";
    private static String POST_WORKSHOP_FEEDBACK_URL = "http://iamskg.com/LatinFestWebService/rest/user/workshopfeedback";
    private static String POST_PERFORMANCE_FEEDBACK_URL = "http://iamskg.com/LatinFestWebService/rest/user/performancefeedback";
    private static String POST_DATABASE_URL = "http://iamskg.com/LatinFestWebService/rest/user/databaseinsert";

    OkHttpClient client = new OkHttpClient();

    public String getService(String URL) throws IOException {

        Request request = new Request.Builder()
                .url(URL)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String registerUser(String json) throws IOException {
        String url = POST_REGISTER_USER_URL;
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String createUserJson(String fb_id, String name, String email, String birthday, String gender, String feedback, String authenticator) {

        String userJson = "{\"fb_id\":" + "\"" + fb_id + "\",\"name\":" + "\"" + name + "\",\"email\":" + "\"" + email + "\",\"gender\":" + "\"" + gender + "\","
                + "\"birthday\":" + "\"" + birthday + "\",\"feedback\":" + "\"" + feedback + "\",\"authenticator\":" + "\"" + authenticator + "\"" + " }";
        return userJson;
    }

    public String postWorkshopFeedback(String json) throws IOException {
        String url = POST_WORKSHOP_FEEDBACK_URL;
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String postDjFeedback(String json) throws IOException {
        String url = POST_DJ_FEEDBACK_URL;
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String postPerformanceFeedback(String json) throws IOException {
        String url = POST_PERFORMANCE_FEEDBACK_URL;
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String postAppFeedback(String json) throws IOException {
        String url = POST_APP_USER_FEEDBACK_URL;
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();

    }

    public String postDataBaseEntries(String json) throws IOException {
        String url = POST_DATABASE_URL;

        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(30, TimeUnit.SECONDS);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();

    }

}