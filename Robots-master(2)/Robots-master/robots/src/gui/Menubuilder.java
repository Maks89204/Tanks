package gui;

import log.Logger;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.KeyEvent;

public class Menubuilder {
    MainApplicationFrame frame;
    JMenuBar menuBar;
    public Menubuilder(MainApplicationFrame frame)
    {
        this.frame=frame;
        menuBar = new JMenuBar();

    }
    public JMenuBar Build() {
        menuBar.add(createLookAndFeelMenu());
        menuBar.add(createExitMenu());
        menuBar.add(CreateTestMenu());
        return menuBar;
    }
    private JMenu CreateTestMenu()
    {

        JMenu testMenu = new JMenu("Тесты");
        testMenu.setMnemonic(KeyEvent.VK_T);
        testMenu.getAccessibleContext().setAccessibleDescription(
                "Тестовые команды");

        {
            JMenuItem addLogMessageItem = new JMenuItem("Сообщение в лог", KeyEvent.VK_S);
            addLogMessageItem.addActionListener((event) -> {
                Logger.debug("Новая строка");
            });
            testMenu.add(addLogMessageItem);
            return testMenu;
        }
    }

    private JMenu createExitMenu()
    {
        JMenu exitMenu = new JMenu("Выход");
        exitMenu.setMnemonic(KeyEvent.VK_T);
        exitMenu.getAccessibleContext().setAccessibleDescription(
                "Выход из программы");
        JMenuItem exititem = new JMenuItem("Выход", KeyEvent.VK_S);
        exititem.addActionListener((event) -> {
            int result=JOptionPane.showConfirmDialog(frame,"Действительно ли хотите закрыть приложение","Подтвердите закрытие",JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION){
                frame.dispose();
                System.exit(0);
            }
        });
        exitMenu.add(exititem);
        return exitMenu;
    }
    private JMenu createLookAndFeelMenu()
    {
        JMenu lookAndFeelMenu = new JMenu("Режим отображения");
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        lookAndFeelMenu.getAccessibleContext().setAccessibleDescription(
                "Управление режимом отображения приложения");

        {
            JMenuItem systemLookAndFeel = new JMenuItem("Системная схема", KeyEvent.VK_S);
            systemLookAndFeel.addActionListener((event) -> {
                frame.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                frame.invalidate();
            });
            lookAndFeelMenu.add(systemLookAndFeel);
        }

        {
            JMenuItem crossplatformLookAndFeel = new JMenuItem("Универсальная схема", KeyEvent.VK_S);
            crossplatformLookAndFeel.addActionListener((event) -> {
                frame.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                frame.invalidate();
            });
            lookAndFeelMenu.add(crossplatformLookAndFeel);
            return lookAndFeelMenu;
        }
    }
}
