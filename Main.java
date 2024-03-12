import java.util.Scanner;

public class Main {

    /*----------------------------Print Board----------------------------*/
    public static void PrintBoard(char [][]  board){
        System.out.println(" === === === ");
        for (int i = 0 ; i <= 2 ; i++){
            System.out.print("| ");
            for (int j = 0; j <= 2 ; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n === === === ");
        }
    }

    /*------------------------------GetMove------------------------------*/

    public static int[] GetMove(Scanner Scan){
        int [] move = new int[2] ;
        System.out.println("Enter the position of your move row ↓ (0,1,2)  colum → (0,1,2) :");
        move[0] = Scan.nextInt();
        move[1] = Scan.nextInt();
        return move;
    }

    /*------------------------------BoardFull----------------------------*/

    public static boolean BoardFull(char [][] board){
        for (int i=0 ; i<=2 ; i++){
            for (int j=0 ; j<=2 ; j++){
                if (board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    /*------------------------------ValidMove----------------------------*/

    public static boolean ValidMove(char [][] board , int a , int b){
        /* a = row , b = colum */
        if ( a <= 2 && a >= 0 && b <= 2  && b >= 0 && board[a][b] == ' ' ){
            return true;
        }else return false;
    }

    /*------------------------------CheckWinnig--------------------------*/

    public static boolean CheckWinnig(char[][] board , char Player){
        for(int i = 0 ; i<=2 ; i++){
            if (board[i][0] == Player && board[i][1] == Player && board[i][2] == Player ) {
                return true;

            } else

            if (board[0][i] == Player && board[1][i] == Player && board[2][i] == Player ) {
                return true;
            }
        }
        if(board[0][0] == Player && board[1][1] == Player && board[2][2] == Player ){
            return true;
        }
        if(board[0][2] == Player && board[1][1] == Player && board[2][0] == Player ){
            return true;
        }
        return false;
    }

    /*-------------------------------Main--------------------------------*/


    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        char [][] board = {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };

        char Player = 'X';
        boolean EndGame = false;


        while (!EndGame){
            PrintBoard(board);

            int [] move = GetMove(Scan);
            int x = move[0];
            int y = move[1];

            if (ValidMove(board , x , y)){
                board[x][y]= Player;
                if (CheckWinnig(board , Player)){
                    PrintBoard(board);
                    System.out.println("The winner is :" + Player + " (▀̿Ĺ̯▀̿ ̿)");
                    EndGame = true ;
                } else if (BoardFull(board)) {
                    PrintBoard(board);
                    System.out.println("No More Valid Move (ಠ .̫.̫ ಠ ) . it's a draw  -_- XD");
                    EndGame = true ;
                }else {
                    Player = (Player == 'X') ? 'O' : 'X';
                }
            }
        }

    }
}
