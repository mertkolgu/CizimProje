package model;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Kare extends Sekil {

    @Override
    public void Ciz(Graphics2D g) {
        g.setColor(getRenk());
        g.setStroke(getStil());
        g.draw(new Rectangle2D.Double(getX(), getY(), getEn(), getBoy()));
    }
}
