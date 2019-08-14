package model;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Ucgen extends Sekil {

    @Override
    public void Ciz(Graphics2D g) {
        g.setColor(getRenk());
        g.setStroke(getStil());
        g.draw(new Line2D.Double(getX(), getY(), getX() + getEn(), getY()));
        g.draw(new Line2D.Double(getX(), getY(), getX() + getY(), getBoy()));
        g.draw(new Line2D.Double(getX(), getY() + getBoy(), getX() + getEn(), getY()));
    }

}
