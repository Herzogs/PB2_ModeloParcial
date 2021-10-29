package parcial.vengadores;

import java.util.Objects;

public class Heroe extends Personaje{

    private Integer poder;

    public Heroe(String nombre, Integer poder) {
        super(nombre);
        this.poder = poder;
    }

    public Boolean aumentarPoder(){
        Boolean est = false;
        if(this.getGema() != null && this.getGema().esHechizable()){
            this.poder *=2;
            est = true;
        }
        return est;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heroe)) return false;
        Heroe heroe = (Heroe) o;
        return getPoder().equals(heroe.getPoder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoder());
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }
}
