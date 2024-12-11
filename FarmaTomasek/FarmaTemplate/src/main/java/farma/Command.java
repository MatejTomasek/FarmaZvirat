
package farma;

import farma.zvirata.BarvaKocek;
import farma.zvirata.Kocka;
import farma.zvirata.Kun;
import farma.zvirata.Pes;
import farma.zvirata.PlemenaKoni;
import farma.zvirata.Zvire;
import generator.GeneratorZvirat;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import seznam.Seznam;
import seznam.SeznamZvirat;
import farma.zvirata.Ovce;


public class Command {
    private static final Path path = Path.of(System.getProperty("user.home")
            ,File.separator + "Desktop", "farma", "zvirata.txt");
    
    private static final Scanner scanner = new Scanner(System.in);
    
    private final Seznam seznam;
    
    public Command(int kapacita) {
        seznam = new SeznamZvirat(kapacita);
    }
    
    public void run() {
        System.out.println("Evidence zvirat na farme.");
        boolean run = true;
        
        do {
            System.out.println("Zadej prikaz: ");
            String line = scanner.nextLine();
            try {
                switch (line) {
                    case "p", "pridej" ->
                        pridejNoveZvire();
                    case "o", "odeber" ->
                        odeberZvire();
                    case "u", "uloz" ->
                        ulozZvirata();
                    case "n", "nacti" ->
                        nactiZvirata();
                    case "g", "generuj" ->
                        seznam.pridej(GeneratorZvirat.generuj(10));
                    case "r", "reset" ->
                        seznam.zrus();
                    case "v", "vypis" ->
                        vypisZvirata();
                    case "k", "e", "exit" ->
                        run = false;
                    default ->
                        System.out.println("Chybny prikaz");
                }
            }
            catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
                System.out.println("");
            }
        } while (run == true);
        System.out.println("Konec evidence zvirat na farme.");
    }
    
    private void pridejNoveZvire() {
        System.out.println("Zvol p-pes k-kocka n-kun o-ovce ");
        String typ = scanner.nextLine();
        System.out.println("Jmeno zvirete: ");
        String jmeno = scanner.nextLine();
        System.out.println("Zadej hmotnost zvirete: ");
        String line = scanner.nextLine();
        Float hmotnost = Float.valueOf(line);
        
        switch(typ) {
            case "p" -> {
                Pes pes = new Pes(jmeno);
                pes.setHmotnost(hmotnost);
                System.out.println("Zadej vysku v kohoutku: ");
                line = scanner.nextLine();
                pes.setVyska(Float.parseFloat(line));
                System.out.println("Zadej datum narozeni: ");
                line = scanner.nextLine();
                pes.setDatumNarozeni(line); 
                seznam.pridej(pes);
            }
            case "n" -> {
                Kun kun = new Kun(jmeno);
                kun.setHmotnost(hmotnost);
                System.out.println("Zadej plemeno 0-Arab, 1-Anglican, 2-Belgik, 3-Hucul: ");
                Integer index = scanner.nextInt();
                kun.setPlemeno(PlemenaKoni.values()[index]);
                System.out.println("Zadej datum narozeni: ");
                line = scanner.nextLine();
                kun.setDatumNarozeni(line); 
                seznam.pridej(kun);
            }
            case "k" -> {
                Kocka kocka = new Kocka(jmeno);
                kocka.setHmotnost(hmotnost);
                System.out.println("Zadej barvu 0-Bila, 1-Cerna: ");
                line = scanner.nextLine();
                int index = Integer.parseInt(line);
                kocka.setBarva(BarvaKocek.values()[index]);
                System.out.println("Zadej datum narozeni: ");
                line = scanner.nextLine();
                kocka.setDatumNarozeni(line); 
                seznam.pridej(kocka);
            }
            case "o" -> {
                Ovce ovce = new Ovce(jmeno);
                ovce.setHmotnost(hmotnost);
                System.out.println("Zadej kolik dala vlny: ");
                line = scanner.nextLine();
                ovce.setVlna(Float.parseFloat(line));
                System.out.println("Zadej datum narozeni: ");
                line = scanner.nextLine();
                ovce.setDatumNarozeni(line);                
                seznam.pridej(ovce);
            }
        }
    }
    
    private void odeberZvire() {
        System.out.println("Zadej poradi zvirete: ");
        String line = scanner.nextLine();
        int poradi = Integer.parseInt(line);
        Zvire zvire = seznam.odeber(poradi);
        if (zvire != null) {
            System.out.println("Bylo odebrano zvire=" + zvire.toString());
        }
    }
    
    private void ulozZvirata() {
        try {
            Files.createDirectories(path.getParent());
            Files.writeString(path, "Seznam zvirat" + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            seznam.nastavPrvni();
            String str = "";
            Zvire zvire = seznam.dejDalsi();
            while (zvire != null) {
                switch (zvire.getTyp()) {
                    case KOCKA -> {
                        Kocka kocka = (Kocka) zvire;
                        str = new StringBuilder()
                            .append("kocka")
                            .append(",").append(kocka.getJmeno())
                            .append(",").append(kocka.getHmotnost())
                            .append(",").append(kocka.getBarva().ordinal())
                            .append(",").append(kocka.getDatumNarozeni())    
                            .toString();
                    }
                    case PES -> {
                        Pes pes = (Pes) zvire;
                        str = new StringBuilder()
                            .append("pes")
                            .append(",").append(pes.getJmeno())
                            .append(",").append(pes.getHmotnost())
                            .append(",").append(pes.getVyska())
                            .append(",").append(pes.getDatumNarozeni())    
                            .toString();
                    }
                    case KUN -> {
                        Kun kun = (Kun) zvire;
                        str = new StringBuilder()
                            .append("kun")
                            .append(",").append(kun.getJmeno())
                            .append(",").append(kun.getHmotnost())
                            .append(",").append(kun.getPlemeno().ordinal())
                            .append(",").append(kun.getDatumNarozeni())    
                            .toString();
                    }
                    case OVCE -> {
                        Ovce ovce = (Ovce) zvire;
                        str = new StringBuilder()
                            .append("ovce")
                            .append(",").append(ovce.getJmeno())
                            .append(",").append(ovce.getHmotnost())
                            .append(",").append(ovce.getVlna())
                            .append(",").append(ovce.getDatumNarozeni())                               
                            .toString();
                    }
                }
                Files.writeString(path, str + System.lineSeparator(), 
                        StandardOpenOption.APPEND);
                zvire = seznam.dejDalsi();
            }
        } catch (IOException ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void nactiZvirata() {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
            
            for (String line : lines) {
                String[] items = line.split(",");
                if (items.length == 1) {
                    continue;
                }
                String jmeno = items[1];
                Float hmotnost = Float.valueOf(items[2]);
                switch (items[0]) {
                    case "kocka" -> {
                        Kocka kocka = new Kocka(jmeno);
                        int index = Integer.parseInt(items[3]);
                        BarvaKocek barva = BarvaKocek.values()[index];
                        kocka.setBarva(barva);
                        kocka.setHmotnost(hmotnost);
                        seznam.pridej(kocka);
                    }
                    case "pes" -> {
                        Pes pes = new Pes(jmeno);
                        Float vyska = Float.valueOf(items[3]);
                        pes.setVyska(vyska);
                        pes.setHmotnost(hmotnost);
                        seznam.pridej(pes);
                    }
                    case "kun" -> {
                        Kun kun = new Kun(jmeno);
                        int index = Integer.parseInt(items[3]);
                        PlemenaKoni plemeno = PlemenaKoni.values()[index];
                        kun.setPlemeno(plemeno);
                        kun.setHmotnost(hmotnost);
                        seznam.pridej(kun);
                    }
                    case "ovce" -> {
                        Ovce ovce = new Ovce(jmeno);
                        Float vlna = Float.valueOf(items[3]);
                        ovce.setVlna(vlna);
                        ovce.setHmotnost(hmotnost);
                        seznam.pridej(ovce);
                    }                   
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void vypisZvirata() {
        System.out.println(seznam.vypis());
    }
}
