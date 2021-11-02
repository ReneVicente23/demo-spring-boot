package bo.edu.ucb.chatbot.dto;

import java.util.Date;
import java.util.Objects;

public class Actor {
    private Integer actorId;
    private String firstname;
    private String lastname;
    private Date lastUpdate;

    public Actor() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Actor actor = (Actor) o;
        return actorId.equals(actor.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "Actor_Id='" + actorId + '\'' +
                ",Firstname='" + firstname + '\'' +
                ",Lastname='" + lastname + '\'' +
                '}';
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
