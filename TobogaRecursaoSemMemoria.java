import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TobogaRecursaoSemMemoria{
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
        System.out.println(TobogaRecursao(matrix,rows-1,cols-1));
    }


public static long TobogaRecursao(int[][] mapa, int altura, int largura){
    long possis=0;
    if (altura < 0 || largura < 0) return 0;
    if(altura>largura)return 0;
    if(altura==0 && largura==0) return 1;
    if(altura!=0){
    if(mapa[altura-1][largura-1]==1 && mapa[altura][largura-1]==1 )return 0;
    
    if(mapa[altura-1][largura-1]==1){
        possis = TobogaRecursao(mapa, altura, largura-1);
        return possis;
    };
    if(mapa[altura][largura-1]==1){
        possis = TobogaRecursao(mapa, altura-1, largura-1);
        return possis;
    };
    
    };
    if(altura==0 && mapa[altura][largura-1]==1){
        return 0;
    }
    
    
    possis = TobogaRecursao(mapa, altura-1, largura-1)+ TobogaRecursao(mapa, altura, largura-1);

    return possis;
}





}