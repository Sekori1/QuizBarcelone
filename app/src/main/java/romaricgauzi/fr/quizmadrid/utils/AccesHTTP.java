package romaricgauzi.fr.quizmadrid.utils;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AccesHTTP extends AsyncTask<String, Integer, Long> {

    private ArrayList<NameValuePair> parameters;
    private String ret = null;
    private AsyncResponse delegate;

    public AccesHTTP(AsyncResponse delegate) {
        this.parameters = new ArrayList<>();
        this.delegate = delegate;
    }

    public void addParam(String name, String value){
        parameters.add(new BasicNameValuePair(name, value));
    }

    @Override
    protected Long doInBackground(String... strings) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(strings[0]);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(parameters));

            HttpResponse httpResponse = httpClient.execute(httpPost);

            ret = EntityUtils.toString(httpResponse.getEntity());

        } catch (UnsupportedEncodingException e) {
            Log.d("HTTP", e.toString());
        } catch (IOException e) {
            Log.d("HTTP", e.toString());
        }

        return null;
    }

    @Override
    protected void onPostExecute(Long aLong) {
        delegate.processFinish(ret.toString());
    }
}
