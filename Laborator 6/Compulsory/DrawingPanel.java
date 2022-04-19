import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {

    private final MainFrame frame;

    int rows, cols;
        int canvasWidth = 400, canvasHeight = 400;
        int boardWidth, boardHeight;
        int cellWidth, cellHeight;
        int padX, padY;
        int stoneSize = 20;

    BufferedImage image; //the offscreen image
    Graphics2D offscreen; //the offscreen graphics
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }
    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }
    private void paintGrid() {
        //same as before, only we draw in memory now
        //only using offscreen instead of the original graphics
        offscreen.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            offscreen.drawLine(x1, y1, x2, y1);
        }
        //vertical lines TODO
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }
    @Override
    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        paintGrid();
        graphics.drawImage(image, 0, 0, this);
    }
    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    private void drawStone(int x, int y) {
//TODO
        offscreen.setColor(Color.RED);

        int copyOfx = x / cellWidth;
        int copyOfy = y / cellHeight;

        int a = padX + copyOfx * cellWidth;
        int b = padY + copyOfy * cellHeight;

        if (x <= a + stoneSize / 2 && x >= a - stoneSize / 2 && y <= b + stoneSize/2 && y>= b-stoneSize/2)
            offscreen.fillOval(a - stoneSize / 2, b - stoneSize / 2, stoneSize, stoneSize);
//Draw a filled oval in the offscreen image
    }



}