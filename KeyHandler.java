import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyHandler implements EventHandler<KeyEvent> {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void handle(KeyEvent event) {
        switch (event.getEventType().getName()) {
            case "KEY_PRESSED":
                keyPressed(event);
                break;
            case "KEY_RELEASED":
                keyReleased(event);
                break;
            default:
                break;
        }
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getCode()) {
            case W:
                upPressed = true;
                break;
            case S:
                downPressed = true;
                break;
            case A:
                leftPressed = true;
                break;
            case D:
                rightPressed = true;
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        switch (e.getCode()) {
            case W:
                upPressed = false;
                break;
            case S:
                downPressed = false;
                break;
            case A:
                leftPressed = false;
                break;
            case D:
                rightPressed = false;
                break;
            default:
                break;
        }
        
    }
    

    public boolean isPressed(String key) {
        switch (key) {
            case "UP":
                return upPressed;
            case "DOWN":
                return downPressed;
            case "LEFT":
                return leftPressed;
            case "RIGHT":
                return rightPressed;
            default:
                return false;
        }
    }
}
