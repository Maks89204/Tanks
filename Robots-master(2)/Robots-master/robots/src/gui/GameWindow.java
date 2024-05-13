package gui;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class GameWindow extends JInternalFrame {
    private final GameVisualizer m_visualizer;

    public GameWindow() {
        super("Игровое поле", true, true, true, true);
        m_visualizer = new GameVisualizer();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        addInternalFrameListener(new InternalFrameAdapter() {
                                     @Override
                                     public void internalFrameClosing(InternalFrameEvent e) {
                                         ExitClass.onClose(GameWindow.this);
                                     }
                                 }
        );
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().add(panel);
        pack();
    }
}