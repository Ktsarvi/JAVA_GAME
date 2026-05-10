package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {

    public boolean up, down, left, right;
    public boolean attack;
    public boolean interact;
    public boolean inventory;
    public boolean pause;
    public boolean enter;
    public int numberPressed = -1;  // 1-9 for item slot selection

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP)    up = true;
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)  down = true;
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)  left = true;
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) right = true;
        if (code == KeyEvent.VK_SPACE) attack = true;
        if (code == KeyEvent.VK_E)     interact = true;
        if (code == KeyEvent.VK_I)     inventory = true;
        if (code == KeyEvent.VK_ESCAPE) pause = true;
        if (code == KeyEvent.VK_ENTER) enter = true;

        if (code >= KeyEvent.VK_1 && code <= KeyEvent.VK_9) {
            numberPressed = code - KeyEvent.VK_0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP)    up = false;
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)  down = false;
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)  left = false;
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) right = false;
        if (code == KeyEvent.VK_SPACE) attack = false;
        if (code == KeyEvent.VK_E)     interact = false;
        if (code == KeyEvent.VK_I)     inventory = false;
        if (code == KeyEvent.VK_ESCAPE) pause = false;
        if (code == KeyEvent.VK_ENTER) enter = false;
        if (code >= KeyEvent.VK_1 && code <= KeyEvent.VK_9) numberPressed = -1;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }
}
