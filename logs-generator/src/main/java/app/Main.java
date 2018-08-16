package app;

import java.util.Timer;


public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new LogTask(), 0, 1000);
    }
}
