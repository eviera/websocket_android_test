package net.eviera.test.websocket_android_test;

import android.os.AsyncTask;
import android.util.Log;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketFactory;

import java.util.List;
import java.util.Map;

public class ConnectionTask extends AsyncTask<Void, Void, Void> {


    @Override
    protected Void doInBackground(Void... params) {
        try {
            WebSocket ws = new WebSocketFactory()
                    .createSocket("ws://10.0.2.2:8080/websocket_test/actions")
                    .addListener(new WebSocketAdapter() {

                        @Override
                        public void onConnected(WebSocket websocket, Map<String, List<String>> headers) throws Exception {
                            System.out.println("Connected");
                            Log.i("AA", "Connected");
                        }

                        @Override
                        public void onTextMessage(WebSocket websocket, String text) throws Exception {
                            System.out.println("text = " + text);
                            Log.i("AA", "text =" + text);
                        }

                    })
                    .connect();


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("2");
        return null;
    }
}
