package parcial.vengadores;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class AvengerTest {

    private Avengers marvel;

    @Before
    public void crearElJuego() {
        this.marvel = new Avengers();
    }

    @Test
    public void queSeIntentaAgregarUnPersonajeAlJuego() {
        Personaje personaje = new Heroe("Thor", 250);
        Boolean valorEsperado = true;
        Boolean valorObtenido = this.marvel.agregarPersonaje(personaje);
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void queUnPersonajeQueTieneUnaGemaHechizableDoblaElPoder() {
        this.marvel.asginarGema(new Heroe("Thor", 100), new Gema("MENTE"));
        Integer valorEsperado = 200;
        Heroe aux = ((Heroe) this.marvel.getPersonajexIND(0));
        aux.aumentarPoder();
        Integer valorObtenido = aux.getPoder();
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void queUnPersonajeQueTieneUnaGemaNoHechizableNoDoblaElPoder() {
        this.marvel.asginarGema(new Heroe("Thor", 100), new Gema("REALIDAD"));
        Integer valorEsperado = 100;
        Heroe aux = ((Heroe) this.marvel.getPersonajexIND(0));
        aux.aumentarPoder();
        Integer valorObtenido = aux.getPoder();
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void queSeIntentaAgregarUnPersonajeRepetidoAlJuego() {
        Personaje personaje = new Heroe("Thor", 250);
        this.marvel.agregarPersonaje(personaje);
        Boolean valorEsperado = false;
        Boolean valorObtenido = this.marvel.agregarPersonaje(personaje);
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void queSeIntentaAgregarUnaGemaAlJuego() {
        Gema gem = new Gema("PODER");
        Boolean valorEsperado = true;
        Boolean valorObtenido = this.marvel.agregarGema(gem);
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void queSeIntentaAgregarUnaGemaRepetidaAlJuego() {
        Gema gem = new Gema("PODER");
        this.marvel.agregarGema(gem);
        Boolean valorEsperado = false;
        Boolean valorObtenido = this.marvel.agregarGema(gem);
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void queSeEmuleLaBatallaFinalYQueGanenLosHeroes() throws WorldDestroyerException {
        this.marvel.agregarPersonaje(new Heroe("Thor", 600));
        this.marvel.agregarPersonaje(new Villano("Loki", 150));
        this.marvel.agregarPersonaje(new Heroe("Capitan America", 630));
        this.marvel.agregarPersonaje(new Villano("Ronnan", 100));
        this.marvel.agregarPersonaje(new Heroe("Hulk", 650));
        this.marvel.agregarPersonaje(new Villano("Hela", 500));
        this.marvel.agregarGema(new Gema("PODER"));
        this.marvel.agregarGema(new Gema("MENTE"));
        this.marvel.agregarGema(new Gema("TIEMPO"));
        this.marvel.agregarGema(new Gema("ALMA"));
        this.marvel.agregarGema(new Gema("ESPACIO"));
        this.marvel.agregarGema(new Gema("REALIDAD"));
        this.marvel.asignarGemas();
        Boolean valorEsperado = true;
        Boolean valorObtenido = this.marvel.batallaFinal();
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void queSeEmuleLaBatallaFinalYQueGanenLosVillanosYLanceException() {
        Exception myException = null;
        try {
            this.marvel.agregarPersonaje(new Heroe("Thor", 2));
            this.marvel.agregarPersonaje(new Villano("Loki", 150));
            this.marvel.agregarPersonaje(new Heroe("Capitan America", 3));
            this.marvel.agregarPersonaje(new Villano("Ronnan", 100));
            this.marvel.agregarPersonaje(new Heroe("Hulk", 4));
            this.marvel.agregarPersonaje(new Villano("Hela", 500));
            this.marvel.agregarGema(new Gema("PODER"));
            this.marvel.agregarGema(new Gema("MENTE"));
            this.marvel.agregarGema(new Gema("TIEMPO"));
            this.marvel.agregarGema(new Gema("ALMA"));
            this.marvel.agregarGema(new Gema("ESPACIO"));
            this.marvel.agregarGema(new Gema("REALIDAD"));
            this.marvel.asignarGemas();
            this.marvel.batallaFinal();

        } catch (Exception e) {
            myException = e;
        }
        assertEquals(WorldDestroyerException.class, myException.getClass());
    }

    @Test
    public void queDespuesDeUnaBatallaSeObtengaElListadoDeHeroesGanadosOrdenadoDeFormaAscendente() throws WorldDestroyerException {
        Heroe h1 = new Heroe("Thor", 600);
        Heroe h2 = new Heroe("Capitan America", 630);
        Heroe h3 = new Heroe("Hulk", 650);
        this.marvel.agregarPersonaje(h1);
        this.marvel.agregarPersonaje(new Villano("Loki", 150));
        this.marvel.agregarPersonaje(h2);
        this.marvel.agregarPersonaje(new Villano("Ronnan", 100));
        this.marvel.agregarPersonaje(h3);
        this.marvel.agregarPersonaje(new Villano("Hela", 500));
        this.marvel.agregarGema(new Gema("PODER"));
        this.marvel.agregarGema(new Gema("MENTE"));
        this.marvel.agregarGema(new Gema("TIEMPO"));
        this.marvel.agregarGema(new Gema("ALMA"));
        this.marvel.agregarGema(new Gema("ESPACIO"));
        this.marvel.agregarGema(new Gema("REALIDAD"));
        this.marvel.asignarGemas();
        this.marvel.batallaFinal();
        assertEquals(h2, this.marvel.obtenerListaDeHeroesOrdenadosAscendente().first());
        assertEquals(h1, this.marvel.obtenerListaDeHeroesOrdenadosAscendente().last());
    }

    @Test
    public void queDespuesDeUnaBatallaSeObtengaElListadoDeVillanosGanadosOrdenadoDeFormaDescente() {
        Villano v1 = new Villano("Loki", 150);
        Villano v2 = new Villano("Ronnan", 100);
        Villano v3 = new Villano("Hela", 500);
        try {
            this.marvel.agregarPersonaje(new Heroe("Thor", 2));
            this.marvel.agregarPersonaje(v1);
            this.marvel.agregarPersonaje(new Heroe("Capitan America", 3));
            this.marvel.agregarPersonaje(v2);
            this.marvel.agregarPersonaje(new Heroe("Hulk", 4));
            this.marvel.agregarPersonaje(v3);
            this.marvel.agregarGema(new Gema("PODER"));
            this.marvel.agregarGema(new Gema("MENTE"));
            this.marvel.agregarGema(new Gema("TIEMPO"));
            this.marvel.agregarGema(new Gema("ALMA"));
            this.marvel.agregarGema(new Gema("ESPACIO"));
            this.marvel.agregarGema(new Gema("REALIDAD"));
            this.marvel.asignarGemas();
            this.marvel.batallaFinal();

        } catch (WorldDestroyerException e) {
        }finally {
            assertEquals(v2.getNombre(), this.marvel.obtenerListaDeVillanosOrdenadosDescendente().first().getNombre());
            assertEquals(v3.getNombre(), this.marvel.obtenerListaDeVillanosOrdenadosDescendente().last().getNombre());
        }

    }

}