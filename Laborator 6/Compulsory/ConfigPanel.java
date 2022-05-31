
import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner[] spinners = new JSpinner[2];
    JButton create;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        label = new JLabel("Grid size:");
        spinners[0] = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinners[1] = new JSpinner(new SpinnerNumberModel(10,2,100,1));
        create = new JButton("Create");
        add(label);
        for (JSpinner spinner : spinners) {
            add(spinner);
        }

        add(create);

        create.addActionListener(this::createNewGame);
    }

    private void createNewGame(ActionEvent actionEvent) {
        frame.remove(frame.canvas);
        frame.createGame();
    }
    public int getRows() {return (int) spinners[0].getValue();}
    public int getCols() {
        return (int) spinners[1].getValue();
    }
}