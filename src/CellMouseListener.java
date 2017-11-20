import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CellMouseListener implements MouseListener {
    private boolean is_clicked = false;
    private static boolean is_pressed = false;

    @Override
    public void mousePressed(MouseEvent e){//прижал
        Cell cell = (Cell)e.getSource();
        if(!is_clicked) {
            cell.repaint_Cell("0.jpg");
        }
        is_pressed = true;
    }
    @Override
    public void mouseReleased(MouseEvent e){//отпустил
        Cell cell = (Cell)e.getSource();
        if(is_pressed) {
            if (cell.is_bomb()) {
                cell.repaint_Cell("bomb_cell.jpg");
            } else {
                if(cell.getBombs_arround() != 0) {
                    int bombs_amount = cell.getBombs_arround();
                    cell.repaint_Cell(bombs_amount + ".jpg");
                } else {
                    int y = cell.getHeigth_coordinate();
                    int x = cell.getWidth_coordinate();

                }
            }
        }
        is_pressed = false;
        is_clicked = true;
        cell.open();
    }
    @Override
    public void mouseEntered(MouseEvent e){//навел
        Cell cell = (Cell) e.getSource();
        if(!is_clicked) {
            if (is_pressed) {
                cell.repaint_Cell("0.jpg");
            } else {
                cell.repaint_Cell("entered_cell.jpg");
            }
        }
    }
    @Override
    public void mouseExited(MouseEvent e){//ожидает
        if(!is_clicked) {
            Cell cell = (Cell) e.getSource();
            cell.repaint_Cell("default_cell.jpg");
        }
    }
    @Override
    public void mouseClicked(MouseEvent e){//нажал и отпустил
//        Cell cell = (Cell)e.getSource();
//        if(cell.is_bomb()){
//            cell.repaint_Cell("bomb_cell.jpg");
//        } else{
//            int bombs_amount = cell.get_bombs();
//            cell.repaint_Cell(bombs_amount+".jpg");
//        }
//        is_clicked = true;
    }
}
