package gui;

import java.awt.*;

public abstract class GameObject {
    protected Image image;
    protected int x;
    protected int y;
    protected int speed;
    protected int width;
    public GameObject(Image image, int x, int y, int speed,int width) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width=width;
    }

    public boolean CheckCollision(GameObject obj)
    {
        double len=Math.sqrt(Math.pow(obj.x-this.x,2)+Math.pow(obj.y-this.y,2));
        return len<width;

    }


    public int getWidth() {
        return width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public  void Move(int left , int top){
        x+=left*speed;
        y+=top*speed;
    }
    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setSpeed(int speed){
        this.speed=speed;
    }
    public int getSpeed() {
        return speed;
    }


}
