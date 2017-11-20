
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Window extends JFrame {
    private static int WIDTH_CELLS_AMOUNT = 20;
    private static int HEIGHT_CELLS_AMOUNT = 20;
    private JPanel battle_field;
    private Cell cell;

    public Window(String title) throws IOException{
        super(title);
        setLayout(new FlowLayout());
        battle_field = new JPanel(new GridLayout(HEIGHT_CELLS_AMOUNT,WIDTH_CELLS_AMOUNT,0,0));
        battle_field.setSize(WIDTH_CELLS_AMOUNT*20, HEIGHT_CELLS_AMOUNT*20);
        Cells_Array array = new Cells_Array(HEIGHT_CELLS_AMOUNT, WIDTH_CELLS_AMOUNT);
        array.print(battle_field);
        add(battle_field);
    }

    public static void main(String[] args) throws IOException {
        Window window = new Window("Sapper");
        window.setSize(420,445);
        window.setVisible(true);
//        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
