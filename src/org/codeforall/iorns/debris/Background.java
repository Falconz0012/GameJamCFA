package org.codeforall.iorns.debris;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background extends Picture {
    Picture raceTrack;

    public Background(){
        this.raceTrack = new Picture(0,0,"resources/Design sem nome.png");
        //this.raceTrack = new Picture(0,0,"InfiniteRunnerGamesWeek/resources/trackBackground.jpeg");

    }
}
