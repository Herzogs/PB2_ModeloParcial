package parcial.vengadores;

import java.util.Comparator;

public class PersonajeComparatorDescendente implements Comparator<Personaje> {
    @Override
    public int compare(Personaje o1, Personaje o2) {
        return o2.compareTo(o1);
    }
}
