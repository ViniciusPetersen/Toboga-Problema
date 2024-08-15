import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TobogaMatrizSemRecursao {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Por favor, forneça o caminho do arquivo como argumento.");
            System.exit(1);
        }

        String filePath = args[0]; // Usa o primeiro argumento como o caminho do arquivo

        try {
            CalcularPossibilidades(filePath);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado. Por favor, verifique o caminho do arquivo: " + filePath);
        }
    }


    public static void CalcularPossibilidades(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();  // Move to the next line

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (scanner.hasNextInt()) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }
        scanner.close();
        System.out.println(TobogaMatriz(matrix, rows-1, cols-1));
    }

    public static long TobogaMatriz(int[][] mapa, int altura, int largura){
        long[][]matriz = new long[altura+1][largura+1];
        if(altura>largura)return 0;
        
        for (int i = 0; i <= altura; i++) {
            for (int j = 0; j <= largura; j++){
                if(i>j){
                    matriz[i][j]=0;
                    continue;
                };
                if(i==0 && j==0){
                    matriz[i][j]=1;
                    continue;
                }
                if(i > 0  && mapa[i][j - 1] == 1 && mapa[i - 1][j - 1] == 1){
                    matriz[i][j]=0;
                    continue;
                }
                if (i > 0  && mapa[i][j - 1] == 1) {  
                    matriz[i][j] = matriz[i-1][j - 1];
                    continue;
                }
                if (i > 0  && mapa[i - 1][j - 1] == 1) { 
                    matriz[i][j] = matriz[i][j - 1];
                    continue;
                }
                if(i==0 && j > 0 && mapa[i][j-1]==1){
                    matriz[i][j]=0;
                    continue;
                }
                if(i==0 && j!=-0){
                    matriz[i][j]= matriz[i][j-1];
                    continue;
                }
    
                matriz[i][j]= matriz[i-1][j-1]+matriz[i][j-1];
            }
        }
    
        return matriz[altura][largura];
    }
}
