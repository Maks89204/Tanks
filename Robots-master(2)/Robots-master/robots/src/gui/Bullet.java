package gui;
import javax.swing.*;
import java.awt.*;
public class Bullet extends GameObject{
    public Bullet(Tank tank,int speed){
        super(new ImageIcon("Bullet.png").getImage(), tank.getX(), tank.getY()+tank.getWidth()/2, speed,20);
    }


}
