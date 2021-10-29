package parcial.vengadores;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Avengers {

    private final Integer MAX_GEMAS_PARA_SALVAR_MUNDO = 6;
    private List<Personaje> listaDePersonajes;
    private List<Gema> listaDeGemas;
    private List<Personaje> listaDeHeroesGanadores;
    private List<Personaje> listaDeVillanosGanadores;
    private Integer cantGemas;

    public Avengers() {
        this.listaDePersonajes = new LinkedList<>();
        this.listaDeGemas = new LinkedList<>();
        this.listaDeHeroesGanadores = new LinkedList<>();
        this.listaDeVillanosGanadores = new LinkedList<>();
        this.cantGemas = 3;
    }

    public Boolean agregarPersonaje(Personaje per) {
        Boolean est = false;
        if(!this.listaDePersonajes.contains(per)) {
            this.listaDePersonajes.add(per);
            est = true;
        }
        return est;
    }

    public Boolean agregarGema(Gema gema) {
        Boolean est = false;
        if(!this.listaDeGemas.contains(gema)) {
            this.listaDeGemas.add(gema);
            est = true;
        }
        return est;
    }

    public Boolean asginarGema (Personaje p, Gema g){
        Boolean est = false;
        if(!this.listaDeGemas.contains(g)&&!this.listaDePersonajes.contains(p)){
            p.setGema(g);
            this.listaDePersonajes.add(p);
            est = true;
        }
        return est;
    }

    public void asignarGemas() {
        this.listaDePersonajes.get(0).setGema(this.listaDeGemas.get(0));
        this.listaDePersonajes.get(1).setGema(this.listaDeGemas.get(1));
        this.listaDePersonajes.get(2).setGema(this.listaDeGemas.get(2));
        this.listaDePersonajes.get(3).setGema(this.listaDeGemas.get(3));
        this.listaDePersonajes.get(4).setGema(this.listaDeGemas.get(4));
        this.listaDePersonajes.get(5).setGema(this.listaDeGemas.get(5));
    }

    private Personaje obtenerHeroeDisponible(){
        Boolean est = false;
        Personaje per = null;
        for (int i = 0; i < this.listaDePersonajes.size() && !est; i++) {
            per = this.listaDePersonajes.get(i);
            if((per instanceof Heroe) && per.getLucho().equals(false)){
                est = true;
                per.setLucho(true);
            }
        }
        return est?per:null;
    }

    private Personaje obtenerVillanoDisponible(){
        Boolean est = false;
        Personaje per = null;
        for (int i = 0; i < this.listaDePersonajes.size() && !est; i++) {
            per = this.listaDePersonajes.get(i);
            if((per instanceof Villano) && per.getLucho().equals(false)){
                est = true;
                per.setLucho(true);
            }
        }
        return est?per:null;
    }

    public Boolean batallaFinal() throws WorldDestroyerException{
        Personaje per1 = this.obtenerHeroeDisponible();
        Personaje per2 = this.obtenerVillanoDisponible();
        Boolean est = false;
        while(per1 != null && per2 != null){
            ((Heroe)per1).aumentarPoder();
            ((Villano)per2).aumentarPoder();
            if(((Heroe)per1).getPoder() > ((Villano)per2).getPoder()){
                this.listaDeHeroesGanadores.add(per1);
                if(per2.getGema() != null){
                    this.cantGemas++;
                }
            }else{
                this.listaDeVillanosGanadores.add(per2);
                if (per1.getGema() != null) {
                    this.cantGemas --;
                }
            }
            per1 = this.obtenerHeroeDisponible();
            per2 = this.obtenerVillanoDisponible();
        }
        if (this.cantGemas != this.MAX_GEMAS_PARA_SALVAR_MUNDO)
            throw new WorldDestroyerException("GAME OVER");
        else
            est = true;
        return est;
    }

    public TreeSet<Personaje> obtenerListaDeVillanosOrdenadosDescendente() {
        TreeSet<Personaje> orden = new TreeSet<>(new PersonajeComparatorDescendente());
        orden.addAll(this.listaDeVillanosGanadores);
        return orden;
    }

    public TreeSet<Personaje> obtenerListaDeHeroesOrdenadosAscendente() {
        TreeSet<Personaje> orden = new TreeSet<>(new PersonajeComparatorAscendente());
        orden.addAll(this.listaDeHeroesGanadores);
        return orden;
    }

    public List<Personaje> getListaDePersonajes() {
        return listaDePersonajes;
    }

    public Personaje getPersonajexIND(Integer ind){
        return this.listaDePersonajes.get(ind);
    }
}
