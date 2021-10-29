package parcial.vengadores;

public class Personaje {
    private String nombre;
    private Gema gema;
    private Boolean lucho;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.gema = null;
        this.lucho = false;
    }

    public String getNombre() {
        return nombre;
    }

    public Gema getGema() {
        return gema;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGema(Gema gema) {
        this.gema = gema;
    }

    public Boolean getLucho() {
        return lucho;
    }

    public void setLucho(Boolean lucho) {
        this.lucho = lucho;
    }

    public Integer compareTo(Personaje o2) {
        return this.nombre.compareTo(o2.getNombre());
    }
}
