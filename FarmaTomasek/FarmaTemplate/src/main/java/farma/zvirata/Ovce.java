package farma.zvirata;

public class Ovce extends Zvire{
    
    private final String zvuk = "Bee";
    private float vlna;
    
    public Ovce(String jmeno) {
        super(jmeno, ZvireTyp.OVCE);
    }
    
    @Override
    public String vyvolejZvuk() {
        return zvuk;
    }

    public void setVlna(float vlna) {
        this.vlna = vlna;
    }
    
    public float getVlna() {
        return vlna;
    }

    @Override
    public String toString() {
        return "Ovce{" + "zvuk=" + zvuk + ", vlna=" + vlna + "kg" + super.toString() + "}";
    }


    

    
    
}
