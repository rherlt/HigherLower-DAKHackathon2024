package de.higherlower.adipositas.restendpoints;

import de.higherlower.adipositas.DummyData;
import de.higherlower.adipositas.api.GameplayApi;
import de.higherlower.adipositas.model.LeaderboardItem;
import de.higherlower.adipositas.model.QuestionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameplayResource implements GameplayApi {

    private int dummyCounter = 0;

    @Override
    public ResponseEntity<QuestionResponse> getQuestion() {
        dummyCounter++;
        int index = dummyCounter % 2;
        return ResponseEntity.ok(DummyData.DUMMY_QUESTIONS.get(index));
    }

    @Override
    public ResponseEntity<Void> postGameResult(LeaderboardItem leaderboardItem) {
        return ResponseEntity.created(null).build();
    }
}
