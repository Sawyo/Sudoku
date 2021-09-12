import java.util.Scanner;
public class main extends tables{
	
	public static void main(String[] args) {
	
		
		int linha = -1, coluna = -1, numeroEscolhido = -1, nivelDificuldade = -1; // Valores Base Iniciais
		Scanner teclado = new Scanner(System.in);
		boolean answer = true;    //Garante que os numeros digitados sejam validados 
		int[][] sudoku = new int[9][9];        //Matriz que irá ser utilizada
		boolean[][] slots = new boolean[9][9];          //Posições predeterminadas não podem ser alteradas
		
		
	
		System.out.println(RED_BACKGROUND + "                                                     " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                      --------                     " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                       SUDOKU                      " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                      --------                     " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + "                                                     " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                    DIFICULDADE                    " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "  1 - Facil                                        " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "  2 - Medio                                        " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "  3 - Dificil                                      " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + "                                                     " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "    Qual o numero da dificuldade que deseja?       " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
		System.out.println(RED_BACKGROUND + "                                                     " + RESET);
		
		System.out.println();
		System.out.print("> ");
		nivelDificuldade = Integer.parseInt(teclado.next());
		System.out.println();

		
		
		do {
			if (nivelDificuldade > 0 && nivelDificuldade < 4)
				answer = false;
			else {
				System.out.println(RED_BACKGROUND + "                                                     " + RESET);
				System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
				System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "    Aceitamos somente de 1 á 3                     " + RESET + RED_BACKGROUND + " " + RESET);
				System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "    Tente novamente:                               " + RESET + RED_BACKGROUND + " " + RESET);
				System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
				System.out.println(RED_BACKGROUND + "                                                     " + RESET);

				System.out.println();
				System.out.print("> ");
				nivelDificuldade = Integer.parseInt(teclado.next());
				System.out.println();
				
			}
		} while(answer);
	
		
		
		constructor_class sud_level = new constructor_class();
	
		
		
		if (nivelDificuldade == 1) {
			
			sudoku = tabuleiroFacil;
			
			System.out.println(RED_BACKGROUND + "                                                     " + RESET);
			System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
			System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "       " + RESET + GREEN_BACKGROUND_BRIGHT + " Dificuldade: Fácil " + BLACK + WHITE_BACKGROUND + "                        " + RESET + RED_BACKGROUND + " " + RESET);
			System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
			System.out.println(RED_BACKGROUND + "                                                     " + RESET);
			
		}
		if (nivelDificuldade == 2) {
			
			sudoku = tabuleiroMedio;
			
			System.out.println(RED_BACKGROUND + "                                                     " + RESET);
			System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
			System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "       " + RESET + BLACK + YELLOW_BACKGROUND +" Dificuldade: Média "+ RESET + BLACK + WHITE_BACKGROUND + "                        " + RESET + RED_BACKGROUND + " " + RESET);
			System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
			System.out.println(RED_BACKGROUND + "                                                     " + RESET);
			
		}
		if (nivelDificuldade == 3) {
			
			sudoku = tabuleiroDificil;
			
			System.out.println(RED_BACKGROUND + "                                                     " + RESET);
			System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
			System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "       " + RESET + BLACK + RED_BACKGROUND_BRIGHT +" Dificuldade: Difícil "+ RESET + BLACK + WHITE_BACKGROUND + "                      " + RESET + RED_BACKGROUND + " " + RESET);
			System.out.println(RED_BACKGROUND + " " + RESET + BLACK + WHITE_BACKGROUND + "                                                   " + RESET + RED_BACKGROUND + " " + RESET);
			System.out.println(RED_BACKGROUND + "                                                     " + RESET);
			
		}
	
		constructor_class constructor_class = new constructor_class();
		slots = constructor_class.defineOcupacao(slots, sudoku);
		
		do {
			
			answer = true;
			System.out.println();
			constructor_class.exibeMatriz(sudoku);
			
			System.out.println();
			System.out.println("Especifique a coluna a linha e o numero respectivamente.");
			System.out.println();
			
			do {
				
				System.out.print("Linha: ");
				linha = Integer.parseInt(teclado.next()) - 1;
				
				System.out.print("Coluna: ");
				coluna = Integer.parseInt(teclado.next()) - 1;
				
				System.out.print("Numero: ");
				numeroEscolhido = Integer.parseInt(teclado.next());
				
				
				
				if (linha < 0 || linha > 8 || coluna < 0 || coluna > 8 || numeroEscolhido < 1 || numeroEscolhido > 9)
					System.out.println(YELLOW_BACKGROUND + "Somente numeros de 1 à 9 são validos." + RESET);
				else
					answer = false;
				
			}while(answer);
			
			answer = true;
			
			
			if(slots[linha][coluna]) {
				System.out.println(YELLOW_BACKGROUND + "Não pode colocar nada aqui." + RESET);
				constructor_class.permPositions(slots, sudoku);
			} else {
				if (constructor_class.canOrNot(sudoku, linha, coluna, numeroEscolhido)) {
					
					sudoku[linha][coluna] = numeroEscolhido;
					
				} else {
					constructor_class.blockMove(sudoku, linha, coluna, numeroEscolhido);
				}
			}
			
			if (constructor_class.checkTable(tipicoSudoku))
				answer = false;
			
			constructor_class.pressEnter();
			
		}while(answer);
		
		System.out.println("Você terminou o jogo.^^");
		
	}

}
