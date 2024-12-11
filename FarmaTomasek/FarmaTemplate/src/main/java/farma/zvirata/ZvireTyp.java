package farma.zvirata;

public enum ZvireTyp {
    KOCKA("kocka"), PES("pes"), KUN("kun"), OVCE("ovce");

    private final String nazev;

    private ZvireTyp(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }

    @Override
    public String toString() {
        return  nazev;
    }

}
