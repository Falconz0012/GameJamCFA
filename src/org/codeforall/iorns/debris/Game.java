package org.codeforall.iorns.debris;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Car car;
    private Scoreboard scoreboard;
    private Picture gameOver;
    private DebrisFactory debrisFactory;
    public Game (){
        this.car = new Car(this);
        this.scoreboard = new Scoreboard();
        this.debrisFactory = new DebrisFactory(this.car,scoreboard);
        this.gameOver = new Picture(0, 0, "resources/endScreen.jpeg");
    }

    public void init() throws InterruptedException {
        while (!car.collided) {
            car.init();
            car.carMovement();
            scoreboard.init();
            debrisFactory.randomGeneratedDebris();
            debrisFactory.moveDebris();
            debrisFactory.checkCollision();
            Thread.sleep(15);
        }
    }

}
