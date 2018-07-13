package crexa_inc.summer2018.activity;
import android.support.annotation.NonNull;

import java.util.Random;

public class colorRNG{

    private static Random random = new Random();
    private static int color = -1;

    public colorRNG(){

    }
    public static int getColor(){
        return color;
    }

    public static void colors(){
                                            color = random.nextInt(256);
    }
    public static void colorLights(){ color = random.nextInt(256/2);  }
    public static void colorDarks(){
         color = random.nestaticxtInt(256/2)+256/2;
    }
    public static void colorMids(){
        color = random.nextInt(256/2)+256/4;
    }
    public static void colorRanges(int min, int max){
        color = random.nextInt(max) + min;
    }
    
    public static void colorPercentages(int percentage){
        color = (int)(random.nextInt(256)*0.8);
    }


}
