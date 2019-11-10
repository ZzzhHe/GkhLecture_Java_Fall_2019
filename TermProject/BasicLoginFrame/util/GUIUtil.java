package util;

import java.awt.*;

/*
*   窗口集中显示类：
*       功能：窗口居中显示
* */
public class GUIUtil {
    public static void toCenter( Component comp ){
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rec =
                ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        comp.setLocation(((int)rec.getWidth() - comp.getWidth())/2,
                ((int)rec.getHeight() - comp.getHeight())/2);
    }

}
