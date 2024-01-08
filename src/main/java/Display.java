import graphics.Render;
import graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Display extends Canvas {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "My fist game :D";
    private BufferedImage img;
    private Render render;
    private Screen screen;
    private int[] pixels;

    public Display(){
        screen = new Screen(WIDTH, HEIGHT);
        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)img.getRaster().getDataBuffer();
    }

    private Thread thread;
    private boolean running = false;


    private void start(){
        if (running) return;
        running = true;
        thread = new Thread(this::start);
    }
    private void stop(){
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void run(){
        while (running){

        }

    }

    public static void main(String[] args) {
        Display game = new Display();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.pack();
        frame.setTitle(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
