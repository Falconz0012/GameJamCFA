package org.codeforall.iorns.debris;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class DebrisFactory extends Picture {
    Picture background;
    Car car;
    Scoreboard scoreboard;
    Debris[] debris = new Debris[1000];
    int debrisCount = 0;

    public DebrisFactory(Car car, Scoreboard scoreboard) {
        this.background = new Picture(0, 0, "resources/Design sem nome.png");
        this.car = car;
        this.scoreboard = scoreboard;
    }

    public double generateXPosition(int xOffset) {
        int fieldWidth = background.getWidth();
        return (int) Math.ceil(Math.random() * (fieldWidth - 290)) + xOffset;
    }


    public void randomGeneratedDebris() {
        int randomDebri = (int) Math.ceil(Math.random() * 3);
        //System.out.println(randomDebri);
        if (scoreboard.getScoreCounter() % 40 != 0) {
            return;
        }
        int posY = -20;

        if (randomDebri == 1) {
            Debris cones = new Debris(generateXPosition(130), posY, "resources/oragecar.png");
            cones.draw();

           debris[debrisCount] = cones;
            debrisCount++;
            return;
        }
        if (randomDebri == 2) {
            Debris roadblockers = new Debris(generateXPosition(130), posY, "resources/redcar.png");
            roadblockers.draw();
            debris[debrisCount] = roadblockers;
            debrisCount++;

            return;
        } else {
            Debris oil = new Debris(generateXPosition(130), posY, "resources/blackcar.png");
            oil.draw();
            debris[debrisCount] = oil;
            debrisCount++;
            return;
        }
    }
    public void moveDebris(){
        for(Debris debri : debris){
            if(debri == null){
                return;
            }
            if(debri.getY()>background.getHeight()-110){
                debri.delete();

            }
            debri.translate(0,15);
        }
    }
    public void checkCollision() throws InterruptedException {
        for(Debris debri:debris){
            if(debri == null){
                return;
            }
            car.checkCollision(debri);

        }
    }
}

