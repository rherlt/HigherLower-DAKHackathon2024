package de.higherlower.adipositas.restendpoints;

import de.higherlower.adipositas.data.DummyData;
import de.higherlower.adipositas.api.GameplayApi;
import de.higherlower.adipositas.data.StaticJsonData;
import de.higherlower.adipositas.model.LeaderboardItem;
import de.higherlower.adipositas.model.QuestionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameplayResource implements GameplayApi {

    @Override
    public ResponseEntity<QuestionResponse> getQuestion() {

        var options = StaticJsonData.getTwoOptions();
        var result = options.a.getCalories() >= options.b.getCalories() ? QuestionResponse.ResultEnum.OPTION1 : QuestionResponse.ResultEnum.OPTION2;
        var explanation = result.equals(QuestionResponse.ResultEnum.OPTION1) ? options.a.getDescription() : options.b.getDescription();
        var questionResponse = new QuestionResponse("Welches Lebensmittel hat mehr Kalorien pro 100g bzw. 100ml?", options.a.getProduct(), options.b.getProduct(), options.a. getImageBase64(), options.b.getImageBase64(), explanation, result);
        return ResponseEntity.ok(questionResponse);
    }

    @Override
    public ResponseEntity<Void> postGameResult(LeaderboardItem leaderboardItem) {
        return ResponseEntity.created(null).build();
    }
}
