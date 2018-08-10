package edu.zju.liuz.quickhttp;

import com.fcibook.quick.http.QuickHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Demo {
    public static void main(String... a) throws Exception{
        //quick http dont support PUT DELETE method
        String res = new QuickHttp()
                .url("http://www.csdn.net/")
                .get()
                .addParame("c", "iphone")
                .text();

        System.out.println(run("http://www.gtarsc.com/SingleTable/DataBaseInfo?nodeid=15267"));

    }

    public static String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
