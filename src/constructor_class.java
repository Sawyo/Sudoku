import java.util.Scanner;

public class constructor_class extends tables{
	
	public static boolean[][] defineOcupacao(boolean[][] slots, int[][] matriz) {
		
        for (int i = 0; i < matriz.length; i++) {
        	
            for (int j = 0; j < matriz[0].length; j++) {
            	
                if (matriz[i][j] != 0)
                    slots[i][j] = true;
                
            }
            
        }
        
        return slots;
    }
	
	
	public static void exibeMatriz(int[][] matriz) {
		
		System.out.println(RED_BACKGROUND + "                           " + RESET);
        for (int i = 0; i < matriz.length; i++) {
        	
            System.out.print(RED_BACKGROUND + "L" + (i+1) + " - " + RESET);
            
            for (int j = 0; j < matriz.length; j++) {
            	
                System.out.print( BLACK + WHITE_BACKGROUND + matriz[i][j] + " " + RESET);
                if (j == 2 || j == 5) System.out.print(RED_BACKGROUND + "  " + RESET);
                
            }
            
            System.out.println();
            
            if (i == 2 || i == 5)
            	System.out.print(RED_BACKGROUND + "                           \n" + RESET);
            
        }
        
        System.out.println(RED_BACKGROUND + "                           " + RESET);
        
    }
	
	
	public static boolean canOrNot(int[][] matriz, int linha, int coluna, int numero) {
		
		//Pode colocar nesta linha?
		for (int i = 0; i < matriz[0].length; i++) {
			if (matriz[linha][i] == numero)
				return false;
		}
		
		//Pode colocar nesta coluna?
		for (int i = 0; i < matriz[0].length; i++) {
			if (matriz[i][coluna] == numero)
				return false;
		}
		
		
		// Verificação de Caixa
		int boxLinha = linha - linha % 3;
        int boxColuna = coluna - coluna % 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[boxLinha + i][boxColuna + j] == numero)
                    return false;
                }
        }    
            
         return true;
	}
	
	
	public static void permPositions(boolean [][] slots, int[][] matriz) {
        
        for (int i = 0; i < matriz.length; i++) {
            System.out.print((i+1) + " - ");
            for (int j = 0; j < matriz.length; j++) {
                    if (slots[i][j])            
                        System.out.print(RED_BACKGROUND_BRIGHT + matriz[i][j] + " " + RESET);
                    else
                        System.out.print(matriz[i][j] + " ");
                        
                if (j == 2 || j == 5) System.out.print("| "); //box divisoria interna vertical
            }
            System.out.println();
            if (i == 2 || i == 5)
                System.out.print("    ------|-------|-------\n"); //box divisoria interna horizontal
        }
    }
    
	
	public static boolean defineDestaques(int[] posicoesDestaque, int i, int j){
        for (int k = 0; k < posicoesDestaque.length; k++) {
            int linha = k; int coluna = k + 1;
            if(posicoesDestaque[linha] == i && posicoesDestaque[coluna] == j) {
                return true;
            }
            k++;
        }
        return false;
    }

    public static int[][] copiaMatriz(int[][] matriz) {
        int[][] novaMatriz = new int[matriz.length][matriz[0].length];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                novaMatriz[i][j] = matriz[i][j];
            }
        }
        
        return novaMatriz;
    }
    
    
    public static boolean checkTable(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
    
    
    public  static void pressEnter() {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Pressione Enter para continuar...");
        leitor.nextLine();
    }
    
    
    public static void blockMove(int[][] matriz, int linha, int coluna, int numero) {
        int[][] novaMatriz = copiaMatriz(matriz);
        
        //cada par representa uma posicao a se destacar
        //jogada do usuario / bloqueio na linha / bloqueio na coluna / bloqueio no box
        int[] posicoesDestaque = {linha, coluna, -1, -1, -1, -1, -1, -1};
        
        System.out.println("    " + RED_BACKGROUND_BRIGHT + " Movimento inválido! " + RESET);
        
        novaMatriz[linha][coluna] = numero;

        //verifica linha
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[linha][i] == numero) {
                posicoesDestaque[2] = linha;
                posicoesDestaque[3] = i;
            }
        }
        
        //verifica coluna
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][coluna] == numero) {
                posicoesDestaque[4] = i;
                posicoesDestaque[5] = coluna;   
            }
        }

        int boxLinha = linha - linha % 3;
        int boxColuna = coluna - coluna % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[boxLinha + i][boxColuna + j] == numero) {
                    posicoesDestaque[6] = boxLinha + i;
                    posicoesDestaque[7] = boxColuna + j;
                }
            }
        }
        
        for (int i = 0; i < matriz.length; i++) {
            System.out.print((i+1) + " - ");
            for (int j = 0; j < matriz.length; j++) {
                    boolean destaques = defineDestaques(posicoesDestaque, i, j);
                    
                    //if (posicoesDestaque[0] == i && posicoesDestaque[1] == j || posicoesDestaque[2] == i && posicoesDestaque[3] == j || posicoesDestaque[4] == i && posicoesDestaque[5] == j || posicoesDestaque[6] == i && posicoesDestaque[7] == j)
                    if (destaques)            
                        System.out.print(GREEN_BACKGROUND_BRIGHT + novaMatriz[i][j] + " " + RESET);
                    else
                        System.out.print(novaMatriz[i][j] + " ");
                        
                if (j == 2 || j == 5) System.out.print("| "); //box divisoria
            }
            System.out.println();
            if (i == 2 || i == 5)
                System.out.print("    ------|-------|-------\n"); //box divisoria
        }
       
    }

}
