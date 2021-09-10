
public class base_generator {

	public static void main(String[] args) {
		
		int k=1;int n=1;
		int sudoku[][] = new int[9][9];
		
		for(int i=0;i<9;i++)
		   {
		      k=n;
		      for(int j=0;j<9;j++)
		      {
		          if(k<=9){
		        	  sudoku[i][j]=k;
		              k++;
		          }else{
		           k=1;
		           sudoku[i][j]=k;
		           k++;
		          }
		      }
		      n=k+3;
		      if(k==10) {
		      n=4;}
		      if(n>9) {
		      n=(n%9)+1;}
		   }

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
	


