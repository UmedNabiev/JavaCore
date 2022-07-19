package Lesson6.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExampleMain {
    public static void main(String[] args) throws IOException {
        //   OkHttpClient client = new OkHttpClient();
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();


        // ��������� ������ Request ��������� ����� Builder (��. ������� �������������� "���������")
        Request request = new Request.Builder()
                .url("https://developer.accuweather.com/user/me/apps")
                .build();

        // ��������� ������� ������ �� �������
        Response response = client.newCall(request).execute();

        // ���� ��������� ������������ ������� body ������� Response
        String body = response.body().string();
        System.out.println(body);
        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.isRedirect());
        System.out.println(response.isSuccessful());
        System.out.println(response.protocol());
        System.out.println(response.receivedResponseAtMillis());
    }
}
