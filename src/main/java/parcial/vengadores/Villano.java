package parcial.vengadores;

import java.util.Objects;

public class Villano extends Personaje {

    private Integer poder;

    public Villano(String nombre, Integer poder) {
        super(nombre);
        this.poder = poder;
    }

    public Boolean aumentarPoder(){
        Boolean est = false;
        if(this.getGema() != null && this.getGema().esHechizable()){
            this.poder *= 2;
            est = true;
        }
        return est;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Villano)) return false;
        Villano villano = (Villano) o;
        return getPoder().equals(villano.getPoder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoder());
    }
}
