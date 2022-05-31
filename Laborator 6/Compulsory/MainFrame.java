import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;

public class MainFrame extends JFrame {
   ConfigPanel configPanel;
   ControlPanel controlPanel;
   DrawingPanel canvas;


    public MainFrame(){
        super("Drawing application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);

        add(canvas, BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
        add(configPanel, BorderLayout.NORTH);
        canvas.setPreferredSize(new Dimension(400,400));
        pack();
    }

    public void createGame() {
        canvas = new DrawingPanel(this);
        add(canvas, CENTER);

        //invoke the layout manager
        pack();
    }
}
