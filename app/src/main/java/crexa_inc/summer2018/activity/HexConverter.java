package crexa_inc.summer2018.activity;

import android.graphics.Color;

public class HexConverter {

    private String Hex;
    private Color color = new Color();



    public String getHex() {
        return Hex;
    }

    public void setHex(String hex) {
        Hex = hex;
    }

    public Color getColor() {
        return color;
    }

    //ARGB representation(#AARRGGBB)
    public void Color(){
        String hex = Hex;
        int alpha = Integer.parseInt( hex.substring(0,1), 16);
        int red =  Integer.parseInt( hex.substring(2,3), 16);
        int green =  Integer.parseInt( hex.substring(4,5), 16);
        int blue =  Integer.parseInt( hex.substring(6,7), 16);
        color.argb(alpha,red,green,blue);

    }

}
