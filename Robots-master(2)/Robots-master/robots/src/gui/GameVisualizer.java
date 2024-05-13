package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class GameVisualizer extends JPanel {
    private final Timer m_timer = initTimer();
    TanksGame game;
    int moveTop=0,moveLeft=0;


    private static Timer initTimer() {
        Timer timer = new Timer("events generator", true);
        return timer;
    }

    public GameVisualizer() {
        game=new TanksGame(this,6);
        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode=e.getKeyCode();
                switch(keyCode)
                {
                    case KeyEvent.VK_UP: case KeyEvent.VK_W:moveTop=-1;break;
                    case KeyEvent.VK_DOWN: case KeyEvent.VK_S:moveTop=1;break;
                    case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:moveLeft=1;break;
                    case KeyEvent.VK_LEFT: case KeyEvent.VK_A:moveLeft=-1;break;
                }


            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode=e.getKeyCode();
                switch(keyCode)
                {
                    case KeyEvent.VK_UP: case KeyEvent.VK_W:moveTop=0;break;
                    case KeyEvent.VK_DOWN: case KeyEvent.VK_S:moveTop=0;break;
                    case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:moveLeft=0;break;
                    case KeyEvent.VK_LEFT: case KeyEvent.VK_A:moveLeft=0;break;
                    case KeyEvent.VK_SPACE:game.getPlayer().Shoot();game.getPlayer().setCanShoot(false);break;
                }


            }
        });
        m_timer.schedule(new TimerTask() {
            @Override
            public void run() {
                onRedrawEvent();
            }
        }, 0, 50);
        m_timer.schedule(new TimerTask() {
            @Override
            public void run() {
                onModelUpdateEvent();
            }
        }, 0, 10);

        setDoubleBuffered(true);

    }

    protected void onRedrawEvent() {
        EventQueue.invokeLater(this::repaint);
    }


    protected void onModelUpdateEvent() {
        if (game.isEndGame() == false) {
            game.MovePlayer(moveLeft, moveTop);
            game.Enemiesmove();
            game.BulletMove();

        } else {
            m_timer.cancel();
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Score:"+game.getScore(),getWidth()-100,20);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(game.getPlayer().getImage(), game.getPlayer().getX(), game.getPlayer().getY(), game.getPlayer().getWidth(), game.getPlayer().getWidth(), this);
        if(game.getPlayer().getBullet()!=null)

            g.drawImage(game.getPlayer().getBullet().getImage(),game.getPlayer().getBullet().getX(), game.getPlayer().getBullet().getY(), game.getPlayer().getBullet().getWidth(), game.getPlayer().getBullet().getWidth(), this);

        for(Tank enemy:game.getEnemies())
        {
            g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), enemy.getWidth(),enemy.getWidth(),this);
        }

    }
}