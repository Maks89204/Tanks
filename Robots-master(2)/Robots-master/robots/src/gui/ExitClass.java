package gui;

import javax.swing.*;
import java.awt.*;

public class ExitClass {

    public static void onClose(JInternalFrame frame) {
        if (dialogWindow(frame,"Действительно ли хотите закрыть окно")) {
            frame.dispose();
        }
    }
    private static boolean dialogWindow( Component component, String title )
    {
        int result = JOptionPane.showConfirmDialog(component,
                title,
                "Подтвердите закрытие", JOptionPane.YES_NO_OPTION);
        return  result == JOptionPane.YES_OPTION;
    }
    public static void onClose(JFrame frame) {

        if ( dialogWindow(frame,"Действительно ли хотите закрыть приложение")) {
            frame.dispose();
            System.exit(0);
        }
    }
}
