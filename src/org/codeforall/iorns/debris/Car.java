package org.codeforall.iorns.debris;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Timer;
import java.util.TimerTask;

public class Car implements KeyboardHandler {


    Picture carPicture;

    Picture background;
    private boolean carMovingDown;
    private boolean carMovingUp;
    private boolean carMovingLeft;
    private boolean carMovingRight;
    public boolean collided;
    Game game;

    Car(Game game) {
        this.game = game;
        this.carPicture = new Picture(430, 550, "resources/blueCar.png");

        carPicture.draw();
        this.background = new Picture(0, 0, "resources/Design sem nome.png");
        this.collided = false;
    }


    public void init() {

        Keyboard kb = new Keyboard(this);
        KeyboardEvent rightPressed = new KeyboardEvent();
        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightReleased.setKey(KeyboardEvent.KEY_D);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPressed.setKey(KeyboardEvent.KEY_D);

        kb.addEventListener(rightPressed);
        kb.addEventListener(rightReleased);

        KeyboardEvent leftPressed = new KeyboardEvent();
        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        leftReleased.setKey(KeyboardEvent.KEY_A);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftPressed.setKey(KeyboardEvent.KEY_A);

        kb.addEventListener(leftPressed);
        kb.addEventListener(leftReleased);


        KeyboardEvent upPressed = new KeyboardEvent();
        KeyboardEvent upReleased = new KeyboardEvent();

        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upPressed.setKey(KeyboardEvent.KEY_W);
        upReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        upReleased.setKey(KeyboardEvent.KEY_W);

        kb.addEventListener(upPressed);
        kb.addEventListener(upReleased);

        KeyboardEvent downPressed = new KeyboardEvent();
        KeyboardEvent downReleased = new KeyboardEvent();

        downReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        downReleased.setKey(KeyboardEvent.KEY_S);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downPressed.setKey(KeyboardEvent.KEY_S);

        kb.addEventListener(downPressed);
        kb.addEventListener(downReleased);

        KeyboardEvent restartEvent = new KeyboardEvent();
        restartEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        restartEvent.setKey(KeyboardEvent.KEY_R);
        kb.addEventListener(restartEvent);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_D:
                if (carPicture.getX() >= background.getWidth() - 60) {
                    return;
                }
                this.carMovingRight = true;
                break;
            case KeyboardEvent.KEY_A:
                if (carPicture.getX() <= background.getX() + 20) {
                    return;
                }
                this.carMovingLeft = true;
                break;
            case KeyboardEvent.KEY_S:
                if (carPicture.getHeight() > background.getHeight()) {
                    return;
                }
                this.carMovingDown = true;
                break;
            case KeyboardEvent.KEY_W:
                if (carPicture.getY() <= background.getY()) {
                    return;
                }
                this.carMovingUp = true;
                break;
            case KeyboardEvent.KEY_R:
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                this.carMovingLeft = false;
                break;

            case KeyboardEvent.KEY_D:
                this.carMovingRight = false;
                break;

            case KeyboardEvent.KEY_S:
                this.carMovingDown = false;
                break;
            case KeyboardEvent.KEY_W:
                this.carMovingUp = false;
                break;
        }

    }

    public void checkCollision(Picture obstacle) throws InterruptedException {
        java.awt.Rectangle carBoundingBox = new java.awt.Rectangle(carPicture.getX(), carPicture.getY(), carPicture.getWidth(), carPicture.getHeight());
        java.awt.Rectangle recBoundingBox = new java.awt.Rectangle(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());


        if (carBoundingBox.intersects(recBoundingBox)) {
            this.collided = true;
            background.delete();
            carPicture.delete();


            Picture gameOver = new Picture(0, 0, "resources/endScreen.jpeg");
            gameOver.draw();
            Scoreboard.showFinalScore();
            };
        }


    public void carMovement() {
        if (carMovingUp) {
            if (carPicture.getY() < 0) {
                return;
            }


            carPicture.translate(0, -12);
            return;

        }
        if (carMovingRight) {
            if (carPicture.getX() >= background.getWidth() - 220) {
                return;
            }
            carPicture.translate(12, 0);
            return;

        }
        if (carMovingLeft) {
            if(carPicture.getX()<150){
                return;
            }
            carPicture.translate(-12, 0);
            return;
        }
        if (carMovingDown) {
            if (carPicture.getY() > background.getHeight()-150) {
                return;
            }

            carPicture.translate(0, 12);
            return;
        }
    }
}




