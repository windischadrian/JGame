package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upButton, leftButton, downButton, rightButton;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W -> upButton = true;
            case KeyEvent.VK_A -> leftButton = true;
            case KeyEvent.VK_S -> downButton = true;
            case KeyEvent.VK_D -> rightButton = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W -> upButton = false;
            case KeyEvent.VK_A -> leftButton = false;
            case KeyEvent.VK_S -> downButton = false;
            case KeyEvent.VK_D -> rightButton = false;
        }
    }
}
