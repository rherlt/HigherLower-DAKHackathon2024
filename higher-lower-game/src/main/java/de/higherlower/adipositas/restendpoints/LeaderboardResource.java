package de.higherlower.adipositas.restendpoints;

import de.higherlower.adipositas.DummyData;
import de.higherlower.adipositas.api.LeaderboardApi;
import de.higherlower.adipositas.model.LeaderboardItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaderboardResource implements LeaderboardApi {

    @Override
    public ResponseEntity<List<LeaderboardItem>> getLeaderboard() {

        return ResponseEntity.ok(DummyData.LEADERBOARD);
    }
}
