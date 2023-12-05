package org.codeforall.iorns.debris;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;



public class Debris extends Picture{


    public Debris(double generateXPosition, int posY, String imagePath) {
        super(generateXPosition,posY,imagePath);
    }



    public  void moveDown() {

        int canvasHeight = 400;

        if (this.getY() < canvasHeight) {
            translate(0, 1);
        } else {
            delete();
        }
    }
}