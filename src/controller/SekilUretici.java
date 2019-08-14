package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import model.Daire;
import model.Kare;
import model.Sekil;
import model.Ucgen;

public class SekilUretici {

    public String[] metinBol(String metin) {
        if ((metin.equalsIgnoreCase("")) | (metin.split(",").length < 3)) {
            return new String[]{"", "", ""};
        } else {
            return metin.split(",");
        }
    }

    public Color renkAyarla(String metin) {
        if (metin.trim().equalsIgnoreCase("kırmızı")) {
            return Color.RED;
        } else if (metin.trim().equalsIgnoreCase("yeşil")) {
            return Color.GREEN;
        } else if (metin.trim().equalsIgnoreCase("mavi")) {
            return Color.BLUE;
        } else {
            return Color.BLACK;
        }
    }

    public Stroke stilAyarla(String metin) {
        if (metin.trim().equalsIgnoreCase("kesik")) {
            float kesik[] = {10.0f};
            return new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, kesik, 0);
        } else {
            return new BasicStroke(1.5f);
        }
    }

    public Sekil sekilAyarla(String metin) {
        if (metin.trim().equalsIgnoreCase("daire")) {
            return new Daire();
        } else if (metin.trim().equalsIgnoreCase("üçgen")) {
            return new Ucgen();
        } else if (metin.trim().equalsIgnoreCase("kare")) {
            return new Kare();
        } else {
            return new Sekil();
        }
    }

    public Sekil sekilUret(String metin) {
        String[] ozellikler = metinBol(metin);
        Sekil sekil = sekilAyarla(ozellikler[2]);
        sekil.setRenk(renkAyarla(ozellikler[0]));
        sekil.setStil(stilAyarla(ozellikler[1]));
        return sekil;
    }
}
