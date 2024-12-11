package farma.zvirata;

public abstract class Zvire {

    private final String jmeno;
    private final ZvireTyp typ;
    private float hmotnost;
    private String datumNarozeni;

    public Zvire(String jmeno, ZvireTyp typ) {
        this.jmeno = jmeno;
        this.typ = typ;
    }
    
    public abstract String vyvolejZvuk();

    public String getJmeno() {
        return jmeno;
    }

    public ZvireTyp getTyp() {
        return typ;
    }

    public float getHmotnost() {
        return hmotnost;
    }

    public void setHmotnost(float hmotnost) {
        this.hmotnost = hmotnost;
    }
    
    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }
    
    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    @Override
    public String toString() {
        return ", jmeno=" + jmeno + ", typ=" + typ + ", hmotnost=" + hmotnost + " narozeni: " + datumNarozeni;
    }
    
}
