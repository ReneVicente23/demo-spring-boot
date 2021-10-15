package bo.edu.ucb.chatbot.bl;

import bo.edu.ucb.chatbot.dao.FilmDao;
import bo.edu.ucb.chatbot.dto.Film;

import java.util.List;

public class FilmSearchBl {

    private final FilmDao filmDao;

    public FilmSearchBl(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    public List<Film> findByTitle(String title) {
        // Conexion a la BBDD
        return filmDao.findByTitle(title);
    }
}
