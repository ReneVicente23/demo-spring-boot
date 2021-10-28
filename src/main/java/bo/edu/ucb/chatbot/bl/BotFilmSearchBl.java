package bo.edu.ucb.chatbot.bl;

import bo.edu.ucb.chatbot.dto.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Procesar la lógica de negocio de las conversaciones del bo.
 * Recibe los mensajes enviados por el usuario como String.
 * Y restorna una List<String> como respuesta a estos mensajes
 * Con el proposito de hacer High Cohesion esta clase no debería utilizar ningun API de Telegram
 */

@Component
public class BotFilmSearchBl {

    private FilmSearchBl filmSearchBl;
    private ActorSearchBl actorSearchBl;
    private FilmActorSearchBl filmActorSearchBl;

    @Autowired
    public BotFilmSearchBl(FilmSearchBl filmSearchBl) {
        this.filmSearchBl = filmSearchBl;
    }
    @Autowired
    public BotFilmSearchBl(ActorSearchBl actorSearchBl) {
        this.actorSearchBl = actorSearchBl;
    }
    @Autowired
    public BotFilmSearchBl(FilmActorSearchBl filmActorSearchBl) {
        this.filmActorSearchBl = filmActorSearchBl;
    }


    public List<String> processMessage(String message) {
        List<String> result = new ArrayList<>();
        String mes[]=message.split("\\|");
        List<Film> filmList;
        if(mes.length>1){
            String a[]=mes[0].split("=");
            String b[]=mes[1].split("=");
            if(a[0].contentEquals("Titulo")){
                String nom[]=b[1].split(" ");
                //System.out.println(a[1]+"- "+nom[0]+" "+nom[1]);
                filmList =  filmActorSearchBl.findByActorFilm(a[1],nom[0],nom[1]);
            }else{
                String nom[]=a[1].split(" ");
                filmList =  filmActorSearchBl.findByActorFilm(b[1],nom[0],nom[1]);
            }
        }else{
            String a[]=message.split("=");
            if(a[0].contentEquals("Titulo")){
                filmList =  filmSearchBl.findByTitle(a[1]);
            }else {
                String nom[]=a[1].split(" ");
                filmList =  actorSearchBl.findByActor(nom[0],nom[1]);
            }
        }
        if (!filmList.isEmpty()) {
            result.add("Encontré las siguientes películas:");
            for (Film film : filmList) {
                result.add(film.toString());
            }
        } else {
            result.add("No encontré ninguna película para: " + message);
        }
        return result;
    }
}
