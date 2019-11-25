package util;

import java.awt.Color;

public class colorSet {

    public static Color setColor( int times ) {

        if (times == 0)
            return new Color(148, 155, 160);
        else if(times > 0 && times <= 10)
            return new Color(135,206,255);
        else if(times > 10 && times <= 25)
            return new Color(42, 155,255);
        else if(times > 25 && times <= 45)
            return new Color(17, 107,205);
        else if(times > 45 && times <= 60)
            return new Color(4, 84,205);
        else
            return new Color(10, 67,139);
    }
    public static Color RandedColor(int i){
        switch (i){
            case 1:{
                return new Color(93, 212, 184);
            }
            case 2: {
                return new Color(56, 214, 16);
            }
            case 3:{
                return new Color(17, 118, 221);
            }
            case 4:{
                return new Color(166, 49, 163);
            }
            case 5:{
                return new Color(204, 213, 220);
            }
            case 6:{
                return new Color(191, 232, 107);
            }
            case 7:{
                return new Color(115, 147, 223);
            }
            case 8:{
                return new Color(232, 78, 150);
            }
            case 9:{
                return new Color(122, 210, 158);
            }
            case 10:{
                return new Color(224, 170, 4);
            }
            default:
                return new Color(255, 254, 0);
        }
    }
}
