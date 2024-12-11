
package farma.zvirata;


public enum BarvaKocek {
    BILA("Bila"), CERNA("Cerna");
    
    private final String nazev;

    private BarvaKocek(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }

    @Override
    public String toString() {
        return ", barva=" + nazev;
    }
    
}
