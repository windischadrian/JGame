package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upButton, leftButton, downButton, rightButton, anyButton;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W -> {
                upButton = true;
                anyButton = true;
            }
            case KeyEvent.VK_A -> {
                leftButton = true;
                anyButton = true;
            }
            case KeyEvent.VK_S -> {
                downButton = true;
                anyButton = true;
            }
            case KeyEvent.VK_D -> {
                rightButton = true;
                anyButton = true;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W -> {
                upButton = false;
                anyButton = false;
            }
            case KeyEvent.VK_A -> {
                leftButton = false;
                anyButton = false;
            }
            case KeyEvent.VK_S -> {
                downButton = false;
                anyButton = false;
            }
            case KeyEvent.VK_D -> {
                rightButton = false;
                anyButton = false;
            }
        }
    }
}
