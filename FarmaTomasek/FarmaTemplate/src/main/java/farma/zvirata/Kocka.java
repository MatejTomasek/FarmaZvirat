package farma.zvirata;

public class Kocka extends Zvire {

    private final String zvuk = "Mňau";
    private BarvaKocek barva;
    
    public Kocka(String jmeno) {
        super(jmeno, ZvireTyp.KOCKA);
    }
    
    @Override
    public String vyvolejZvuk() {
        return zvuk;
    }

    public BarvaKocek getBarva() {
        return barva;
    }
    
    public void setBarva(BarvaKocek barva) {
        this.barva = barva;
    }

    @Override
    public String toString() {
        return "Kocka{" + "zvuk=" + zvuk + barva + super.toString() + "}";
    }
    

    
    
}
