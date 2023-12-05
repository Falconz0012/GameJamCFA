package org.codeforall.iorns.debris;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Timer;
import java.util.TimerTask;

public class Scoreboard {


    public Scoreboard() {
        this.scoreCounter = 0;
    }

    public static int scoreCounter;
    public static String score = "Score : " + String.valueOf(scoreCounter);
    private static String finalScore;
    private static Text scoreBoard = new Text(140, 20, score);
    public int getScoreCounter() {
        return scoreCounter;
    }

    public static void updateScore() {
        String score = "Score : 00" + String.valueOf(scoreCounter);
        System.out.println(score);
        scoreBoard.delete();
        scoreBoard.setColor(Color.WHITE);
        scoreBoard.draw();

        scoreCounter++;
        scoreBoard.setText(score);
        finalScore = score;

    }

    public static void showFinalScore(){
        updateScore();
        scoreBoard.delete();
        Text finalScoreText = new Text(430,490,finalScore);
        finalScoreText.grow(50,20);
        finalScoreText.setColor(Color.BLACK);
        finalScoreText.draw();
    }

    public void init() {
        updateScore();
    }

}

