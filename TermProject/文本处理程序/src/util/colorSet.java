package util;

import java.awt.Color;

public class colorSet {
    // TODO: 2019/11/18
//            设计不同的出现频率和颜色RGB的对应关系

    public static Color setColor( int times ) {

        if(times >= 0 && times <= 15)
            return new Color(135,206,255);
        else if(times > 15 && times <= 30)
            return new Color(42, 155,255);
        else if(times > 35 && times <= 50)
            return new Color(17, 107,205);
        else if(times > 65 && times <= 80)
            return new Color(4, 84,205);
        else
            return new Color(10, 67,139);
    }
}
