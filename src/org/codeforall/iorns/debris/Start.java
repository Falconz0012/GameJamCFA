package org.codeforall.iorns.debris;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Start implements KeyboardHandler {
    private boolean gameStarted = false;
    private Picture startSign;
    private NewGameSounds menuSound;

    public Start() {
        startSign = new Picture(0, 0, "resources/startBackground.png");
        menuSound = new NewGameSounds("/resources/StartMenuSound.wav");
        menuSound.play();

    }

    public void displayStartSign() {
        startSign.draw();
    }

    public void waitForSpaceBar() {
        Keyboard kb = new Keyboard(this);

        KeyboardEvent spacebar = new KeyboardEvent();
        spacebar.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacebar.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(spacebar);

        while (!gameStarted) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        startSign.delete();
    }

    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            gameStarted = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
