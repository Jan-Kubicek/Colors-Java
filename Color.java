package org.example;

import java.util.HexFormat;
import static org.example.CollectionofCollors.*;

public class Color {
    //Atributy
    public int red;
    public int green;
    public int blue;
    public String jmeno;
    public String hexCode;
    //Konstruktory
    public Color(String jmeno, int red, int green, int blue){
        this.hexCode = setHexcode(red,green,blue);
        this.jmeno = jmeno;
        this.red = red;
        this.blue = blue;
        this.green = green;
    }
    //Metody
    public String setHexcode(int red, int green, int blue){
        String code ;
        String sRed = Integer.toHexString(red);
        String sGreen = Integer.toHexString(green);
        String sBlue = Integer.toHexString(blue);
        return code = sRed+sGreen+sBlue;
    }
    public int getRed(){return red;}
    public int getGreen(){return green;}
    public int getBlue(){return blue;}
    public String getHexCode(){return hexCode;}
    public String getJmeno(){return jmeno;}
}
