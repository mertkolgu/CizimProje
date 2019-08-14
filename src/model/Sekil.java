package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Sekil {

    private double x;
    private double y;
    private double en;
    private double boy;
    private Color renk;
    private Stroke stil;

    public void Ciz(Graphics2D g) {
        g.setColor(getRenk());
        g.setStroke(getStil());
        g.drawLine(10, 20, 70, 20);
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the en
     */
    public double getEn() {
        return en;
    }

    /**
     * @param en the en to set
     */
    public void setEn(double en) {
        this.en = en;
    }

    /**
     * @return the boy
     */
    public double getBoy() {
        return boy;
    }

    /**
     * @param boy the boy to set
     */
    public void setBoy(double boy) {
        this.boy = boy;
    }

    /**
     * @return the renk
     */
    public Color getRenk() {
        return renk;
    }

    /**
     * @param renk the renk to set
     */
    public void setRenk(Color renk) {
        this.renk = renk;
    }

    /**
     * @return the stil
     */
    public Stroke getStil() {
        return stil;
    }

    /**
     * @param stil the stil to set
     */
    public void setStil(Stroke stil) {
        this.stil = stil;
    }
}
