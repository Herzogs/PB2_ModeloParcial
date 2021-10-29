package parcial.vengadores;

import java.util.Objects;

public class Gema implements Hechizable{
    private String nombre;

    public Gema(String nombre){
            this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Boolean esHechizable() {
        return this.nombre.equals("TIEMPO") || this.nombre.equals("MENTE") || this.nombre.equals("PODER");
    }
}
