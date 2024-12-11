package farma.zvirata;

public class Kun extends Zvire{
    
    private final String zvuk = "Hije";
    private PlemenaKoni plemeno;
    
    public Kun(String jmeno) {
        super(jmeno, ZvireTyp.KUN);
    }
    
    @Override
    public String vyvolejZvuk() {
        return zvuk;
    }

    public PlemenaKoni getPlemeno() {
        return plemeno;
    }

    public void setPlemeno(PlemenaKoni plemeno) {
        this.plemeno = plemeno;
    }

    @Override
    public String toString() {
        return "Kun{" + "zvuk=" + zvuk + ", plemeno=" + plemeno + super.toString() + "}";
    }

    

    
    
}
