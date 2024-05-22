package de.higherlower.adipositas.restendpoints;

import de.higherlower.adipositas.api.GameplayApi;
import de.higherlower.adipositas.model.LeaderboardItem;
import de.higherlower.adipositas.model.QuestionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameplayResource implements GameplayApi {


    @Override
    public ResponseEntity<QuestionResponse> getQuestion() {
        return GameplayApi.super.getQuestion();
    }

    @Override
    public ResponseEntity<Void> postGameResult(LeaderboardItem leaderboardItem) {
        return GameplayApi.super.postGameResult(leaderboardItem);
    }
}
