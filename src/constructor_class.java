
public class constructor_class {
	
	public static boolean[][] defineOcupacao(boolean[][] slots, int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if (sudoku[i][j] != 0)
                    slots[i][j] = true;
            }
        }
        return slots;
    }
	
	
	public static void exibeMatriz(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            System.out.print("L" + (i+1) + " - ");
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
                if (j == 2 || j == 5) System.out.print("| ");
            }
            System.out.println();
            if (i == 2 || i == 5)
                System.out.print("     ------|-------|------\n");
        }
    }
        

}
