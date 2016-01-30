import java.util.ArrayList;

/**
 * Siin failis kasutatakse objekti Foor, aga Foor klassi ei eksisteeri. Sinu ülesanne
 * on see luua. Pane tähele, et mitte ükski objekti muutuja ei tohi olla
 * kättesaadav objektist väljaspoolt.
 *
 * Käesolevat klassi ei tohi muuta! Arvad, et ei jää vahele? :)
 */
public class Objekt_foor {

    public static void main(String[] args) {
        ArrayList<Foor> foorid = new ArrayList<>();

        String fooriNimetus = "Sõle-Paldiski SR3A";
        Foor foor = new Foor(fooriNimetus);
        Foor foor2 = new Foor(fooriNimetus);
        foorid.add(new Foor("kass"));
        System.out.println("SUURUS" + foorid.get(0).votaNimetus());


        foor.syytaTuli("punane");
        foor.syytaTuli("kollane");
        foor.syytaTuli("roheline");
        foor.kustutaTuli("punane");
        foor.kustutaTuli("kollane");

        System.out.println("Fooril peaks põlema ainult punane, tegelt põleb: " + foor.misTuledPolevad());
        System.out.println("Foori nimetus on " + foor.votaNimetus());

        foor.hakkeridSaidKontrolli(); // Paanika!

        System.out.println("Fooris põlevad tuled: " + foor.misTuledPolevad());
        System.out.println("Fooris2 põlevad tuled: " + foor2.misTuledPolevad());
        System.out.println("Foori nimetus on: " + foor.votaNimetus());
        System.out.println("Foori2 nimetus on: " + foor2.votaNimetus());
    }
}
