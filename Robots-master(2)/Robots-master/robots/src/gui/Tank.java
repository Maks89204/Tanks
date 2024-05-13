package gui;

import java.awt.*;
public class Tank extends GameObject{
    private Bullet bullet;
    private boolean canShoot;
    public Tank(Image image, int x, int y, int speed, int width) {
        super(image, x, y, speed, width);
        canShoot=true;
        bullet=null;
    }
    public void Shoot()
    {
        if(canShoot)
            bullet=new Bullet (this,5);
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public boolean isCanShoot() {
        return canShoot;
    }
}
