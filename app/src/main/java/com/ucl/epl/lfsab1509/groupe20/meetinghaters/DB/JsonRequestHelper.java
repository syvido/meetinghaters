package com.ucl.epl.lfsab1509.groupe20.meetinghaters.DB;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class JsonRequestHelper extends JsonObjectRequest {

    private Priority priority;
    private String token;
    private String user;

    private JSONObject response;

    private static String refUser = "x-key";
    private static String refToken = "x-access-token";

    public JsonRequestHelper(int method,
                             String url,
                             JSONObject jsonRequest,
                             String token,
                             String user,
                             Response.Listener<JSONObject> listener,
                             Response.ErrorListener errorListener
                             ) {
        super(method, url, jsonRequest, listener, errorListener);
        this.token = token;
        this.user = user;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public Priority getPriority() {
        return priority == null ? Priority.NORMAL : priority;
    }

    @Override
    public Map getHeaders() throws AuthFailureError {
        Map headers = new HashMap();
        headers.put(refToken, token);
        headers.put(refUser, user);

        return headers;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            if (response.data.length == 0) {
                byte[] responseData = "{}".getBytes("UTF8");
                response = new NetworkResponse(response.statusCode, responseData, response.headers, response.notModified);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return super.parseNetworkResponse(response);
    }
}
