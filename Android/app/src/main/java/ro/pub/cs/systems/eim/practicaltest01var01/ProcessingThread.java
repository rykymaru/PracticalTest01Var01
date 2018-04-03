package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

/**
 * Created by student on 03.04.2018.
 */

public class ProcessingThread extends Thread{
    private Context context = null;
    private boolean isRunning = true;
    private String lista;

    public ProcessingThread(Context context, String lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public void run() {
        Log.d("th", "Thread has started!");
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d("th", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction("asd");
        intent.putExtra("asd",
                new Date(System.currentTimeMillis()) + " " + lista);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
