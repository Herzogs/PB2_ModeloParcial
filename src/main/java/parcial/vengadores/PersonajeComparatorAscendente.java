package parcial.vengadores;

import java.util.Comparator;

public class PersonajeComparatorAscendente implements Comparator<Personaje> {

    @Override
    public int compare(Personaje o1, Personaje o2) {
        return o1.compareTo(o2);
    }
}
