/**
 * Created by 38307220306 on 27.01.2016.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sudoku27_27 {

    public static boolean checker(int[][] bs, int i, ArrayList<Integer> ar) {
        ArrayList<Integer> temp_ar = new ArrayList<Integer>();
        boolean check1 = true;          //For returning true for good Sudoku
        for(int e=0;e<27;e++){
            bs[i][e] = ar.get(e);
        }

        for(int t=0;t<27;t++){
            for(int e=0;e<=i;e++){

                temp_ar.add(e, bs[e][t]);

            }
            Set<Integer> temp_set = new HashSet<Integer>(temp_ar);
            if(temp_set.size()<temp_ar.size()){
                check1 = false; break;                                      //Something smelly
            }
            else {
                temp_ar.clear();
                temp_set.clear();
            }
        }
        return check1;
    }
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int[][] bs  = new int[27][27];
        for(int i=0;i<27;i++){
            ar.add(i+1);
            // System.out.print(ar.get(i));
        }
        Collections.shuffle(ar);



        for(int i=0;i<1;i++){
            for(int j=0;j<27;j++){

                bs[i][j] = ar.get(j);
            }

        }
        boolean check = true;
        for(int i=0;i<27;i++){
            if(i==8 ){
                check = checkPath(bs, i);
                if(check==false)
                    i=i-8;
                //System.out.print("Haiii");
            }
            if(i==18){
                check = checkPath(bs,i);
                if(check==false){
                    i=i-8;
                }
            }

            for(int j=0;j<27;j++){
                if(i>0) {
                    check = checker(bs,i,ar);
                    if(check==false){
                        i--;
                        break;
                    }
                    else {
                        bs[i][j]=ar.get(j);
                    }
                }

            }

            Collections.shuffle(ar);
        }

        for(int i=0;i<27;i++){
            for(int j=0;j<27;j++){

                System.out.print(bs[i][j]+" ");
                if(j==8 || j==18)
                    System.out.print("| ");

            }
            System.out.print("\n");
            if(i==2 || i==5 ||i==8 ||i==11 ||i==14 ||i==17 ||i==20 ||i==23) System.out.print("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");

        }
    }

    public static boolean checkPath(int[][] bs, int i) {
        //boolean check_cP = false;
        ArrayList<Integer> temp_cP = new ArrayList<Integer>();
        Set<Integer> temp_setcP = new HashSet<Integer>();
        boolean denoter = true;
        while(i==8){
            for(int k =0;k<i;k++ ){
                for(int e=0;e<9;e++){
                    temp_cP.add(e, bs[k][e]);
                }
            }
            temp_setcP = new HashSet<Integer>(temp_cP);
            if(temp_cP.size()>temp_setcP.size()){
                denoter = false;break;

            }
            else {
                temp_cP.clear();
                temp_setcP.clear();

                for(int k =0;k<i;k++ ){
                    for(int e=3;e<9;e++){
                        temp_cP.add(bs[k][e]);
                    }
                }
                temp_setcP = new HashSet<Integer>(temp_cP);
                if(temp_cP.size()>temp_setcP.size()){
                    denoter = false;break;

                }
                else {
                    break;
                }
            }
        }
        while(i==18){

            for(int k =3;k<i;k++ ){
                for(int e=0;e<9;e++){
                    temp_cP.add(e, bs[k][e]);
                }
            }
            temp_setcP = new HashSet<Integer>(temp_cP);
            if(temp_cP.size()>temp_setcP.size()){
                denoter = false;break;

            }
            else {
                temp_cP.clear();
                temp_setcP.clear();

                for(int k =3;k<i;k++ ){
                    for(int e=3;e<9;e++){
                        temp_cP.add(bs[k][e]);
                    }
                }
                temp_setcP = new HashSet<Integer>(temp_cP);
                if(temp_cP.size()>temp_setcP.size()){
                    denoter = false;break;

                }
                else {
                    break;
                }
            }

        }
        return denoter;
    }

}

