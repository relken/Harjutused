import java.util.ArrayList;

/**
 * Created by 38307220306 on 28.01.2016.
 */
public class Foor {
    private String fooriNimetus;
    private ArrayList<String> tuled = new ArrayList<>();

    Foor(String fooriNimi) {
        fooriNimetus = fooriNimi;
        System.out.println(fooriNimi);
    }

    public void syytaTuli(String varv) {
        tuled.add(varv);
        System.out.println(varv);
    }

    public void kustutaTuli(String varv) {
        tuled.remove(varv);
        System.out.println(varv);
    }

    public String misTuledPolevad() {
        String misTuled = "";
        for (int i = 0; i <tuled.size() ; i++) {
            misTuled+= tuled.get(i);
        }
        return misTuled;
    }

    public String votaNimetus() {
        return fooriNimetus;
    }

    public void hakkeridSaidKontrolli() {
        tuled.clear();
        tuled.add("punane");
        fooriNimetus = "Kamarajura";
        System.out.println("Paanika");
    }
}
