
import java.util.Random;
import java.util.Scanner;

public class generator_test05 {

	public static void main(String[] args) {
		
		//Criar matriz 9x9 e adicionar elementos na diagonal
		int k=1;
		int sudoku[][] = new int[9][9];
		int c=0;
		Random random=new Random();
		
		while (c<9) {
			
			for (int j = 0; j < 9; j++) {
				k++;
				if(k<=7) {
		        	 k=k+random.nextInt(10);
				      if(k>9) {
				      k=(k%9)+1;
				      sudoku[c][j]=k;
				      } 
		         }else {
		        	 sudoku[c][j]=random.nextInt(100)/10;
					 k=1;
		         }
				
				 c++;
				
				

			}
			
			
		}
		//Exibir a matriz

		String board = "";
		 for (int i = 0; i < sudoku.length; i++)
		 {
		     for (int j = 0; j < sudoku[i].length; j++)
		     {
		         board += " "
		                 + ((sudoku[i][j] < 0) ? -1 * sudoku[i][j] : sudoku[i][j]) + " ";
		     }
		     board += "\n";
		 }
		 System.out.println("" + board);
	}

		
	}


