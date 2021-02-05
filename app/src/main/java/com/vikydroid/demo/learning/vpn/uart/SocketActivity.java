package com.vikydroid.demo.learning.vpn.uart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vikydroid.demo.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);
        EditText etSocket = findViewById(R.id.etSocket);
        Button btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MessageSender().execute(etSocket.getText().toString());
            }
        });


        TextView tvOutput = (TextView) findViewById(R.id.tvOutput);
        tvOutput.setMovementMethod(new ScrollingMovementMethod());

        new Thread(new MyServerThread()).start();
    }

    class MyServerThread implements Runnable {
        Socket socket;
        ServerSocket serverSocket;
        InputStreamReader isr;
        String message;
        Handler handler = new Handler();

        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(5011);
                while (true) {
                    socket = serverSocket.accept();
                    isr = new InputStreamReader(socket.getInputStream());
                    message = new BufferedReader(isr).readLine();
//                    isr.fl
                    Log.e("TAG============", "run: "+message );
                    socket.close();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}