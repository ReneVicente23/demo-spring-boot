package bo.edu.ucb.chatbot.bl;

import bo.edu.ucb.chatbot.dao.ActorDao;
import bo.edu.ucb.chatbot.dao.FilmDao;
import bo.edu.ucb.chatbot.dto.Film;
import bo.edu.ucb.chatbot.exception.SakilaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorSearchBl {

    private final ActorDao actorDao;

    @Autowired
    public ActorSearchBl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    public List<Film> findByActor(String firstname,String lastname) {
        if (firstname == null || firstname.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The title parameter is mandatory and can't be null or empty");
        }
        if (lastname == null || lastname.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The title parameter is mandatory and can't be null or empty");
        }
        return actorDao.findByActor(firstname,lastname);
    }
}
