package de.higherlower.adipositas.restendpoints;

import de.higherlower.adipositas.DummyData;
import de.higherlower.adipositas.api.GameplayApi;
import de.higherlower.adipositas.data.LeaderItemEntity;
import de.higherlower.adipositas.data.LeaderItemEntityRepository;
import de.higherlower.adipositas.model.LeaderboardItem;
import de.higherlower.adipositas.model.QuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class GameplayResource implements GameplayApi {

    private int dummyCounter = 0;

    @Value("${openapi.HigherlowerGameApi.base-path:/}")
    private String basePath;

    @Autowired
    private LeaderItemEntityRepository leaderItemEntityRepository;

    @Override
    public ResponseEntity<QuestionResponse> getQuestion() {
        dummyCounter++;
        int index = dummyCounter % 2;
        return ResponseEntity.ok(DummyData.DUMMY_QUESTIONS.get(index));
    }

    @Override
    public ResponseEntity<Void> postGameResult(LeaderboardItem leaderboardItem) {
        LeaderItemEntity leaderItemEntity = new LeaderItemEntity();
        leaderItemEntity.setScore(leaderboardItem.getScore());
        leaderItemEntity.setName(leaderboardItem.getName());
        leaderItemEntity.setUserId(leaderboardItem.getUserId());
        leaderItemEntity.setGameId(leaderboardItem.getGameId());
        leaderItemEntity.setDate(leaderboardItem.getDate());
        LeaderItemEntity saved = leaderItemEntityRepository.save(leaderItemEntity);
        return ResponseEntity.created(URI.create(basePath + "/leaderboard/" + saved.getId())).build();
    }
}
