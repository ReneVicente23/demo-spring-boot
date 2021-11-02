package bo.edu.ucb.chatbot.bl;

import bo.edu.ucb.chatbot.dao.Actor_FilmDao;
import bo.edu.ucb.chatbot.dto.Film;
import bo.edu.ucb.chatbot.exception.SakilaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmActorSearchBl {

    private final Actor_FilmDao actor_filmDao;


    @Autowired
    public FilmActorSearchBl(Actor_FilmDao actor_filmDao) {
        this.actor_filmDao = actor_filmDao;
    }

    public List<Film> findByActorFilm(String title, String firstname, String lastname) {
        if (title == null || title.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The title parameter is mandatory and can't be null or empty");
        }
        if (firstname == null || firstname.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The title parameter is mandatory and can't be null or empty");
        }
        if (lastname == null || lastname.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The title parameter is mandatory and can't be null or empty");
        }
        return actor_filmDao.findByActorFilm(title,firstname,lastname);
    }
}
