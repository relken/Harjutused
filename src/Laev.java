  import java.util.ArrayList;  
     
  /**  
   * Created by Leemets on 26.01.2016.  
   */  
  public class Laev {  
   private String nimi;  
   private ArrayList<String> reisijad = new ArrayList<>();  
     
   Laev(String laevaNimi) {  
   nimi = laevaNimi;  
   }  
     
   public void lisaReisija(String reisija) {  
   reisijad.add(reisija);  
   }  
     
   public void eemaldaReisija(String reisija) {  
   reisijad.remove(reisija);  
   }  
     
   public String votaReisijad() {  
   return reisijad.toString();  
   }  
     
   public int reisijateArv() {  
   return reisijad.size();  
   }  
     
   public String misNimi() {  
   return nimi;  
   }  
     
   public void kalaHammustasKummipaatiAugu() {  
   reisijad.clear();  
   System.out.println("Kala hammustas paati ja paat läks põhja!");  
   }  
  }  
