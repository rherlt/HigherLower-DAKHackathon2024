package de.higherlower.adipositas.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class LeaderItemEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID gameId;

    @Column
    private String name;

    @Column
    private String userId;

    @Column
    private Integer score;

    @Column
    private String date;

    public String getGameId() {
        return gameId != null ? gameId.toString() : null;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
