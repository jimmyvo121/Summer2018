package crexa_inc.summer2018.activity;
import android.graphics.Color;
import android.support.annotation.NonNull;

import java.util.Random;

public class colorRNG{

    private static Random random = new Random();
    private static int color = 1;
    private  static String Hex;

    public colorRNG(){

    }
    public static String getHex(){
        String hex=Integer.toHexString(color);
        return hex;

    }
    public static String getColorHex(){
        Hex=getHex();
        colors();
        Hex += getHex();
        colors();
        Hex += getHex();
        return Hex;

    }
    public static String getHexString(){
        String hexColor;
        //hexColor= String.format("#%06X", (0xFFFFFF & color));
        hexColor =  Integer.toHexString(color);
        return hexColor;
    }

//    public static Color genColor(){
//        float r = random.nextFloat();
//        float g = random.nextFloat();
//        float b = random.nextFloat();
//        Color randomColor = new Color( r, g, b);
//        return randomColor;
//    }


//    public static int getColorInt(){
//        String Hex= Integer.toString(color) ;
//        colors();
//        Hex += Integer.toString(color) ;
//        colors();
//        Hex += Integer.toString(color) ;
//
//        return Integer.valueOf(Hex);
//
//    }
    public static int getColorInt(){
        colors();
        //color = -1;
        int Hex =(color*256*256) ;
        colors();
        Hex +=(color*256) ;
        colors();
        Hex +=(color) ;
        return -Hex;

    }

    public static void colors(){
                                            color = random.nextInt(256);
    }
    public static void colorLights(){ color = random.nextInt(256/2);  }
    public static void colorDarks(){
         color = random.nextInt(256/2)+256/2;
    }
    public static void colorMids(){
        color = random.nextInt(256/2)+256/4;
    }
    public static void colorRanges(int min, int max){
        color = random.nextInt(max) + min;
    }
    
    public static void colorPercentages(int percentage){
        color = (int)(random.nextInt(256)*percentage);
    }


}
