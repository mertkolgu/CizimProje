package model;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Daire extends Sekil {

    @Override
    public void Ciz(Graphics2D g) {
        g.setColor(getRenk());
        g.setStroke(getStil());
        g.draw(new Ellipse2D.Double(getX(), getY(), getEn(), getBoy()));
    }
}
