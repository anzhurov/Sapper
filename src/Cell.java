import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Cell extends JPanel {
    private Image icon;
    private int bombs_around;
    private boolean bomb;
    private int height_coordinate;
    private int width_coordinate;
    private boolean isOpened;

    public Cell(String title, boolean bomb, int heigth_coordinate, int width_coordinate){
        try {
            icon = ImageIO.read(new File(title));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.bomb = bomb;
        this.height_coordinate = heigth_coordinate;
        this.width_coordinate = width_coordinate;
        this.isOpened = false;
    }

    public boolean is_bomb(){
        return bomb;
    }

    public void set_bombs(int bombs_arround) { this.bombs_around = bombs_arround; }

    public void repaint_Cell(String title){
        try {
            icon = ImageIO.read(new File(title));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getWidth_coordinate() {
        return width_coordinate;
    }

    public int getHeigth_coordinate() {
        return height_coordinate;
    }

    public int getBombs_arround() {
        return bombs_around;
    }

    public void open() { isOpened = true; }

    public boolean isOpened() {
        return isOpened;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(icon, 0, 0,20,20,null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(20,20);
    }

}
