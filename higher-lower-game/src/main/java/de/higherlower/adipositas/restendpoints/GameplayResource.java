package de.higherlower.adipositas.restendpoints;

import de.higherlower.adipositas.api.GameplayApi;
import de.higherlower.adipositas.data.StaticJsonData;
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

    @Value("${openapi.HigherlowerGameApi.base-path:/}")
    private String basePath;

    @Autowired
    private LeaderItemEntityRepository leaderItemEntityRepository;

    @Override
    public ResponseEntity<QuestionResponse> getQuestion() {

        var options = StaticJsonData.getTwoOptions();
        var result = options.a.getCalories() >= options.b.getCalories() ? QuestionResponse.ResultEnum.OPTION1 : QuestionResponse.ResultEnum.OPTION2;
        var explanation = result.equals(QuestionResponse.ResultEnum.OPTION1) ? options.a.getDescription() : options.b.getDescription();
        var questionResponse = new QuestionResponse("Welches Lebensmittel hat mehr Kalorien pro 100g bzw. 100ml?", options.a.getProduct(), options.b.getProduct(), options.a.getImageBase64(), options.b.getImageBase64(), explanation, result);
        return ResponseEntity.ok(questionResponse);
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
