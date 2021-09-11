import java.lang.reflect.Constructor;
import java.util.Scanner;
public class main extends tables{
	
	public static void main(String[] args) {
	
		
		int linha = -1, coluna = -1, numeroEscolhido = -1, nivelDificuldade = -1; // Valores Base Iniciais
		Scanner teclado = new Scanner(System.in);
		boolean answer = true;    //Garante que os numeros digitados sejam validados 
		String reset = "\u001B[0m";     //define cores
		String mensagemSistema = "\u001B[41;43m"; //define cores
		int[][] sudoku = new int[9][9];        //Matriz que irá ser utilizada
		boolean[][] slots = new boolean[9][9];          //Posições predeterminadas não podem ser alteradas
		
		
	
		System.out.println("+---------------------------------------------------+");
		System.out.println("|                      --------                     |");
		System.out.println("|                       SUDOKU                      |");
		System.out.println("|                      --------                     |");
		System.out.println("+---------------------------------------------------+");
		System.out.println();
		System.out.println("                     DIFICULDADE");
		System.out.println();
		System.out.println("  1 - Facil");
		System.out.println("  2 - Medio");
		System.out.println("  3 - Dificil");
		System.out.println();
		System.out.println("+---------------------------------------------------+");
		System.out.println();
	
		System.out.print("     Qual o numero da dificuldade que deseja? : ");
		nivelDificuldade = Integer.parseInt(teclado.next());
		
		
		
		do {
			if (nivelDificuldade > 0 && nivelDificuldade < 4)
				answer = false;
			else {
				System.out.println("     " + mensagemSistema + "Aceitamos somente de 1 á 3" + reset);
				System.out.print("     Tente novamente: ");
				nivelDificuldade = Integer.parseInt(teclado.next());
			}
		} while(answer);
	
		constructor_class sud_level = new constructor_class();
	
		if (nivelDificuldade == 1) {
			sudoku = tabuleiroFacil;
			System.out.print("     " + mensagemSistema + " Dificuldade: Fácil  " + reset);
		}
		if (nivelDificuldade == 2) {
			sudoku = tabuleiroMedio;
			System.out.print("     " + mensagemSistema + " Dificuldade: Médio  " + reset);
		}
		if (nivelDificuldade == 3) {
			sudoku = tabuleiroDificil;
			System.out.print("     " + mensagemSistema + " Dificuldade: Difícil" + reset);
		}
	
		constructor_class constructor_class = new constructor_class();
		slots = constructor_class.defineOcupacao(slots, sudoku);
		
		do {
			
			answer = true;
			System.out.println();
			constructor_class.exibeMatriz(sudoku);
			
			
			System.out.println("Especifique a coluna a linha e o numero respectivamente.");
			
			do {
				
				System.out.print("Linha: ");
				linha = Integer.parseInt(teclado.next()) - 1;
				
				System.out.print("Coluna: ");
				coluna = Integer.parseInt(teclado.next()) - 1;
				
				System.out.println("Linha: ");
				numeroEscolhido = Integer.parseInt(teclado.next());
				
				
				
				if (linha < 0 || linha > 8 || coluna < 0 || coluna > 8 || numeroEscolhido < 1 || numeroEscolhido > 9)
					System.out.println(mensagemSistema + "Somente numeros de 1 à 9 são validos." + reset);
				else
					answer = false;
				
			}while(answer);
			
			answer = true;
			
			
			if(slots[linha][coluna]) {
				System.out.println(mensagemSistema + "Não pode colocar nada aqui." + reset);
				constructor_class.permPositions(slots, sudoku);
			} else {
				constructor_class.blockMove(sudoku, linha, coluna, numeroEscolhido);
			}
			
			if (constructor_class.checkTable(tipicoSudoku))
				answer = false;
			
			constructor_class.pressEnter();
			
		}while(answer);
		
		System.out.println("Você terminou o jogo.^^");
		
	}

}
