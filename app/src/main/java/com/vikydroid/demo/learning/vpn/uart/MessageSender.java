package com.vikydroid.demo.learning.vpn.uart;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String, Void, Void> {
    Socket socket;
    DataOutputStream dos;
    PrintWriter pw;

    @Override
    protected Void doInBackground(String[] objects) {
        String message = objects[0];
        try {
//            socket = new Socket("192.168.1.9", 5011);
            socket = new Socket("192.168.10.2", 5011);
            pw = new PrintWriter(socket.getOutputStream());
            pw.write(message);
            pw.flush();
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
