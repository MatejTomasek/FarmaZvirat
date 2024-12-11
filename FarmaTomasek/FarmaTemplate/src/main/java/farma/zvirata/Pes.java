package farma.zvirata;

public class Pes extends Zvire {
    
    private final String zvuk = "Haf";
    private float vyska;
    
    public Pes(String jmeno) {
        super(jmeno, ZvireTyp.PES);
    }
    
    @Override
    public String vyvolejZvuk() {
        return zvuk;
    }
    
    public float getVyska() {
        return vyska;
    }

    public void setVyska(float vyska) {
        this.vyska = vyska;
    }

    @Override
    public String toString() {
        return "Pes{" + "zvuk=" + zvuk + ", vyska=" + vyska + super.toString() + "}";
    }

    
    
    
}
