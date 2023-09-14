package synthesissystems.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        //Honestly you could get away with just using an int array but I'm too lazy to fix it :D
        Cell[] grid = new Cell[9];
        String gridRender;
        Boolean ended = false;
        int turn = 1;
        
        //Make some cells, dunno if this is the best way to do it though
        
        while(!ended) {
            String turnStr = turn % 2 == 0 ? "O" : "X";
            System.out.println("Turn of: " + turnStr);
            
            renderGrid(grid);
            
            Scanner scanner = new Scanner(System.in);
            
            String inn = scanner.next();
            int in = Integer.parseInt(inn) - 1;
            
            if(in < 9 && canPlace(grid, in)) {
                int value = turn % 2 == 0 ? 2 : 1;
                
                grid[in].value = value;
                
                ended = checkForWin(grid);
                
                if(ended) renderGrid(grid);
                
                turn++;
            }
        }
    }
    
    public static void renderGrid(Cell[] grid) {
        String str = "";
        String ch = "";
        
        for(int i=0; i<9; i++) {
            switch(grid[i].value) {
                case 0:
                    ch = " ";
                    break;
                    
                case 1:
                    ch = "X";
                    break;
                    
                case 2:
                    ch = "O";
                    break;
            }
            
            if(i%3 != 0){
                str += ch + "|";
            }
            else {
                str += "\n|" + ch + "|";
            }
        }
        
        System.out.println(str);
    }
    
    public static Boolean checkForWin(Cell[] grid) {
        for(int i = 0; i < 9; i++) {
            System.out.println(i);
            if(grid[i].value == 0) continue;
            else if(i < 3 && grid[i].value == grid[i+3].value && grid[i].value == grid[i + 6].value) return true;
            else if(i+1 % 3 == 1 && grid[i].value == grid[i+1].value && grid[i].value == grid[i+2].value) return true;
            else if(i == 0 && grid[0].value == grid[4].value && grid[0].value == grid[8].value) return true;            else if(i == 0 && grid[0].value == grid[4].value && grid[0].value == grid[8].value) return true;
            else if(i == 2 && grid[2].value == grid[4].value && grid[2].value == grid[6].value) return true;
        }
        return false;
    }
    
    public static Boolean canPlace(Cell[] grid, int i) {
        if(grid[i].value != 0) return false;
        else return true;
    }
}
