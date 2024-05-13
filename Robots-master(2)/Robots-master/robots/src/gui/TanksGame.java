package gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class TanksGame {
    private JPanel panel;
    private Tank player;
    private ArrayList<Tank> enemies;
    private int score;
    private boolean endGame;

    public int getScore() {
        return score;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public TanksGame(JPanel panel, int enemiesCount){
        score=0;
        endGame=false;

        this.panel=panel;
        enemies=new ArrayList<>();
        player = new Tank(new ImageIcon("MainTank.png").getImage(), 100, 108, 2,50) {
        };
        enemies=new ArrayList<>();
        for(int i=0;i<enemiesCount;i++)
        {
            enemies.add(new Tank(new ImageIcon("EnemyTank.png").getImage(),500,120*(i),(int)(Math.random()*4+1),50));
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public Tank getPlayer() {
        return player;
    }

    public ArrayList<Tank> getEnemies() {
        return enemies;
    }

    private void killEnemy(Tank enemy){

        enemy.setX(panel.getWidth()+100);
        enemy.setY((int)(Math.random()*(panel.getHeight()-enemy.getWidth())));
        enemy.setSpeed((int)(Math.random()*4+1));

    }
    public void BulletMove()
    {

        if(player.getBullet()!=null)
            player.getBullet().Move(1,0);
        if(player.getBullet()!=null&&player.getBullet().getX()>panel.getWidth())
        {
            player.setCanShoot(true);
            player.setBullet(null);
        }
    }
    public void MovePlayer(int left,int right)
    {
        player.Move(left,right);
        if(player.getX()<0) player.setX(0);
        if(player.getY()<0) player.setY(0);
        if(player.getX()>panel.getWidth()- player.getWidth()) player.setX(panel.getWidth()- player.getWidth());
        if(player.getY()>panel.getHeight()- player.getWidth()) player.setY(panel.getHeight()- player.getWidth());

    }

    public void Enemiesmove() {
        for (Tank enemy : enemies) {
            if(enemy.CheckCollision(player))
                endGame=true;
            if (player.getBullet() != null && enemy.CheckCollision(player.getBullet())) {
                score++;
                killEnemy(enemy);
                player.setCanShoot(true);
                player.setBullet(null);
            }
            enemy.Move(-1, 0);
            if(enemy.getX()<-enemy.getWidth()){
                killEnemy(enemy);
            }

        }
    }
}

