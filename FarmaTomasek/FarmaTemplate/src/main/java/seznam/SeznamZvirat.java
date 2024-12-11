package seznam;

import farma.zvirata.Zvire;

public class SeznamZvirat implements Seznam {
    
    private final Zvire[] seznam;
    private final int kapacita;
    private int pocet;
    private int index;
    
    public SeznamZvirat(int kapacita) {
        if(kapacita <= 0) {
            throw new IllegalArgumentException();
        }
        seznam = new Zvire[kapacita + 1];
        this.kapacita = kapacita;
    }
    
    @Override
    public void pridej(Zvire zvire) {
        if (zvire == null) {
            throw new NullPointerException();
        }
        if(pocet > kapacita) {
            throw new ArrayIndexOutOfBoundsException();
        }
        seznam[pocet++] = zvire;
        
    }

    @Override
    public Zvire odeber(final int pozice) {
        if (pozice <= 0 || pozice >= kapacita) {
            throw new IllegalArgumentException();
        }
        int index = pozice - 1;
        Zvire zvire = seznam[index];
        System.arraycopy(seznam, index + 1, seznam, index, kapacita - pocet);
        pocet--;
        return zvire;
    }

    @Override
    public String vydejZvuky() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < pocet; i++) {
            buffer.append(seznam[i].toString()).append("\n");
        }
        return buffer.toString();
    }
    
    @Override
    public void zrus() {
        for (int i = 0; i < seznam.length; i++) {
            seznam[i] = null;
        }  
        pocet = 0;
        index = 0;
    }

    @Override
    public String vypis() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < pocet; i++) {
            buffer.append(seznam[i].toString()).append("\n");
        }
        return buffer.toString();
    }

    @Override
    public void nastavPrvni() {
        index = 0;
    }

    @Override
    public Zvire dejDalsi() {
        if(index < pocet) {
            return seznam[index++];
        }
        return null;
    }
    
}
