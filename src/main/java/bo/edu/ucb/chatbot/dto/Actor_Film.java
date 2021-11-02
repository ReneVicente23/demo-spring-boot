package bo.edu.ucb.chatbot.dto;

import java.util.Date;
import java.util.Objects;

public class Actor_Film {
    private Integer Actor_id;
    private Integer filmId;
    private Date lastUpdate;

    public Actor_Film() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Actor_Film actor_film = (Actor_Film) o;
        return filmId.equals(actor_film.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId);
    }

    @Override
    public String toString() {
        return "Film_Actor{" +
                "Actor_Id='" + Actor_id + '\'' +
                ",Film_Id='" + filmId + '\'' +
                '}';
    }

    public Integer getActor_id() {
        return Actor_id;
    }

    public void setActor_id(Integer actor_id) {
        Actor_id = actor_id;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
