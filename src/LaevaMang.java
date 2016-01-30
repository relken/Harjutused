public class LaevaMang {

    private static char[][] board = new char[10][10];
    //private static int[] shipLengths = { 2, 4, 5, 5, 6 };
    private static int[] shipLengths = { 3, 3, 3, 3, 3 };
    private static void init() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = 'O';
            }
        }
    }
    private static void addShips() {
        for(int ship: shipLengths) {
            System.out.println("Adding ship " + ship);
            boolean added = false;
            while(!added) {
                int x = (int)(board.length * Math.random());
                int y = (int)(board[0].length * Math.random());
                boolean horizontal = ((int)(10 * Math.random())) % 2 == 0;
                System.out.println(horizontal);
                System.out.println(x + " " +y);
                if(horizontal) {
                    // Check for vertical space
                    boolean hasSpace = true;
                    for(int i = 0; i < ship+1; i++) {
                        if(y + i >= board[0].length) {
                            hasSpace = false;
                            break;
                        }
                        if (i==0 && (y>=1 && y<=board[0].length-2)) {
                            //System.out.println("kontroll " + x + " " +y);
                            if(board[x][y-1] != 'O') {
                                hasSpace = false;
                                break;
                            }
                        }
                        if(board[x][y+i] != 'O') {
                            hasSpace = false;
                            break;
                        }
                        if(x>=1 && x<=board.length-2) {
                            if(board[x-1][y+i] != 'O' || board[x+1][y+i] != 'O') {
                                hasSpace = false;
                                break;
                            }
                        }
                        if(x==board.length-1) {
                            if(board[x-1][y+i] != 'O') {
                                hasSpace = false;
                                break;
                            }
                        }
                        if (x==0) {
                            if(board[x+1][y+i] != 'O') {
                                hasSpace = false;
                                break;
                            }
                        }
                    }
                    if(!hasSpace) {
                        // No room there, check again
                        continue;
                    }
                    for(int i = 0; i < ship; i++) {
                        board[x][y+i] = 'X';
                    }
                    added = true;
                } else {
                    // Check for vertical space
                    boolean hasSpace = true;
                    for(int i = 0; i < ship+1; i++) {
                        if(x + i >= board[0].length) {
                            hasSpace = false;
                            break;
                        }
                        if (i==0 && (x>=1 && x<=board[0].length-2)) {
                            //System.out.println("kontroll " + x + " " +y);
                            if(board[x-1][y] != 'O') {
                                hasSpace = false;
                                break;
                            }
                        }
                        if(board[x+i][y] != 'O') {
                            hasSpace = false;
                            break;
                        }
                        if(y>=1 && y<=board[0].length-2) {
                            if(board[x+i][y-1] != 'O' || board[x+i][y+1] != 'O') {
                                hasSpace = false;
                                break;
                            }
                        }
                        if(y==board[0].length-1) {
                            if (board[x + i][y - 1] != 'O') {
                                hasSpace = false;
                                break;
                            }
                        }
                        if (y==0) {
                            if(board[x+i][y+1] != 'O') {
                                    hasSpace = false;
                                    break;
                            }
                        }


                    }
                    if(!hasSpace) {
                        // No room there, check again
                        continue;
                    }
                    for(int i = 0; i < ship; i++) {
                        board[x+i][y] = 'X';
                    }
                    added = true;
                }
            }
        }
    }
    private static void print() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(""+board[i][j]);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        init();
        print();
        addShips();
        print();
    }
}


