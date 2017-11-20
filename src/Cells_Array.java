import javax.swing.*;

public class Cells_Array {
    private Cell[][] array;

    public Cells_Array(int height, int width){
        array = new Cell[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                Cell cell;
                int bomb_chance = (int)(1 + Math.random()*100);
                if(bomb_chance<=15) {
                    cell = new Cell("default_cell.jpg", true, i, j);
                } else {
                    cell = new Cell("default_cell.jpg", false, i, j);
                }
                cell.addMouseListener(new CellMouseListener());
                array[i][j] = cell;
            }
        }
        set_digits();

    }

    public Cell getCell(int y, int x){
        return array[y][x];
    }

    void openCells(int x, int y) { // recursive procedure of opening the cells
        if (x < 0 || x > array[0].length - 1 || y < 0 || y > array.length - 1) return; // wrong coordinates
        if (array[y][x].isOpened()) return; // cell is already open
        array[y][x].open();
        if (array[y][x].getBombs_arround() > 0 ) return; // the cell is not empty
        for (int dx = -1; dx < 2; dx++)
            for (int dy = -1; dy < 2; dy++) openCells(x + dx, y + dy);
    }


    void set_digits(){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int bombs_amount = 0;
                if (!array[i][j].is_bomb()) {
                    if (i-1>=0&&j-1>=0) { if(array[i - 1][j - 1].is_bomb()){ bombs_amount++; } }
                    if (i-1>=0) { if (array[i - 1][j].is_bomb()) { bombs_amount++; } }
                    if (i-1>=0&&j+1<array[i].length) { if (array[i - 1][j + 1].is_bomb()) { bombs_amount++; } }
                    if (j+1<array[i].length) { if (array[i][j + 1].is_bomb()) { bombs_amount++; } }
                    if (i+1<array.length&&j+1<array[i].length) { if (array[i + 1][j + 1].is_bomb()) { bombs_amount++; } }
                    if (i+1<array.length){ if(array[i + 1][j].is_bomb()) { bombs_amount++; } }
                    if (i+1<array.length&&j-1>=0){ if(array[i + 1][j - 1].is_bomb()) { bombs_amount++; } }
                    if (j-1>=0){ if(array[i][j - 1].is_bomb()) { bombs_amount++; } }
                }
                array[i][j].set_bombs(bombs_amount);
            }
        }
    }

    public void print(JPanel panel){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                panel.add(array[i][j]);
            }
        }
    }

}
