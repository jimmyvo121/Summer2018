package crexa_inc.summer2018.activity;
import android.graphics.Color;
import android.support.annotation.NonNull;

import java.util.Random;

public class colorRNG{

    private static Random random = new Random();
    private static int color = 1;
    private static String Hex;
    private static String [] alphaList = new String[101];

    public colorRNG(){

    }
    public static String getHex(){
        color();
        String hex=Integer.toHexString(color);
        return hex;

    }
    public static String getColorHex(){
        Hex=getHex();
        color();
        Hex += getHex();
        color();
        Hex += getHex();
        color();
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
        color();
        //color = -1;
        int Hex =(color*256*256) ;
        color();
        Hex +=(color*256) ;
        color();
        Hex +=(color) ;
        return -Hex;

    }
    public void populatealpha(){
        int count= 0;
        for (double i = 0; i <= 1; i += 0.01) {
            i = Math.round(i * 100) / 100.0d;
            int alpha = (int) Math.round(i * 255);
            String hex = Integer.toHexString(alpha).toUpperCase();
            if (hex.length() == 1) {
                hex = "0" + hex;
            }
            //int percent = (int) (i * 100);
            //System.out.println(String.format("%d%% — %s", percent, hex));

            alphaList[count] = hex;
            count ++;
        }
    }
    public void getAlpha(int perecent){
        
    }

    public static void color(){
        color = random.nextInt(256);
    }
    public static int colors(){
        return random.nextInt(256);
    }
    public static int colorLights(){
        return  random.nextInt(256/2);
    }
    public static int colorDarks(){
        return random.nextInt(256/2)+256/2;
    }
    public static int colorMids(){
        return  random.nextInt(256/2)+256/4;
    }
    public static int colorRanges(int min, int max){
        return random.nextInt(max) + min;
    }
    
    public static int colorPercentages(int percentage){
        return (int)(random.nextInt(256)*percentage);
    }


}
