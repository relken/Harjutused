public class Sudoku {
    public static void main(String[] args ){
        int k=0;
        int fillCount =1;
        int subGrid=1;
        int N=3;
        int[][] a=new int[N*N][N*N];
        for (int i=0;i<N*N;i++){
            if(k==N){
                k=1;
                subGrid++;
                fillCount=subGrid;
            }else{
                k++;
                if(i!=0)
                    fillCount=fillCount+N;
            }
            for(int j=0;j<N*N;j++){
                if(fillCount==N*N){
                    a[i][j]=fillCount;
                    fillCount=1;
                    System.out.print("  "+a[i][j]);
                }else{
                    a[i][j]=fillCount++;
                    System.out.print("  "+a[i][j]);
                }
            }
            System.out.println();
        }
    }
}
