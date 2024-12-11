package generator;

import farma.zvirata.Ovce;
import farma.zvirata.BarvaKocek;
import farma.zvirata.Kocka;
import farma.zvirata.Kun;
import farma.zvirata.Pes;
import farma.zvirata.PlemenaKoni;
import farma.zvirata.Zvire;
import farma.zvirata.ZvireTyp;
import java.util.Random;

public class GeneratorZvirat {

    private static final Random random = new Random();

    private GeneratorZvirat() {
    }
    
    public static Zvire[] generuj(int pocet) {
        Zvire[] zvirata = new Zvire[pocet];
        for (int i = 0; i < pocet; i++) {
            zvirata[i] = generujZvire();

        }
        return zvirata;
    }

    private static Zvire generujZvire() {
        int volba = random.nextInt(ZvireTyp.values().length);
        Zvire zvire;
        zvire = switch (ZvireTyp.values()[volba]) {
            case KOCKA ->
                dejKocku();
            case KUN ->
                dejKone();
            case PES ->
                dejPsa();
            case OVCE -> 
                dejOvci();
        };
        return zvire;
    }

    private static Zvire dejKocku() {
        String[] jmena = {"Eliška", "Mína", "Amálka", "Jůlinka", "Míša",
            "Barunka", "Žofie", "Róza", "Vendulka"};
        int index = random.nextInt(jmena.length);
        Kocka kocka = new Kocka(jmena[random.nextInt(jmena.length)]);
        kocka.setHmotnost(random.nextFloat(2,100));
        kocka.setBarva(BarvaKocek.values()[random.nextInt(BarvaKocek.values().length)]);
        return kocka;
    }
    
    private static Zvire dejKone() {
        String[] jmena = {"Adios", "Bahamas", "Barry", "Boxer", "Donald"};
        Kun kun = new Kun (jmena[random.nextInt(jmena.length)]);
        kun.setHmotnost(random.nextFloat(20, 1000));
        kun.setPlemeno(PlemenaKoni.values()[random.nextInt(PlemenaKoni.values().length)]);
        return kun;
    }

    private static Zvire dejPsa() {
        String[] jmena = {"Calvin", "Cappi", "Cappuccino", "Carlos", "Cekin",
            "Cezar", "Chacho", "Chaps", "Charlie"};
        Pes pes = new Pes (jmena[random.nextInt(jmena.length)]);
        pes.setHmotnost(random.nextFloat(2,100));
        pes.setVyska(random.nextFloat(15, 80));
        return pes;
    }
    
    private static Zvire dejOvci() {
        String[] jmena = {"Ovce1", "Ovce2", "Ovce3", "Ovce4", "Ovce6"};
        Ovce ovce = new Ovce (jmena[random.nextInt(jmena.length)]);
        ovce.setVlna(random.nextFloat(2,30));
        ovce.setHmotnost(random.nextFloat(2,100));
        return ovce;
    }
}
