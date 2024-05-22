package de.higherlower.adipositas.restendpoints;

import de.higherlower.adipositas.api.LeaderboardApi;
import de.higherlower.adipositas.data.LeaderItemEntity;
import de.higherlower.adipositas.data.LeaderItemEntityRepository;
import de.higherlower.adipositas.model.LeaderboardItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaderboardResource implements LeaderboardApi {

    @Autowired
    private LeaderItemEntityRepository leaderItemEntityRepository;

    @Override
    public ResponseEntity<List<LeaderboardItem>> getLeaderboard() {
        List<LeaderboardItem> list = leaderItemEntityRepository.findAll()
                .stream()
                .map(this::convertToLeaderboardItem)
                .toList();

        return ResponseEntity.ok(list);
    }

    private LeaderboardItem convertToLeaderboardItem(LeaderItemEntity leaderboardItem) {
        return new LeaderboardItem(leaderboardItem.getName(),
                leaderboardItem.getUserId(),
                leaderboardItem.getGameId(),
                leaderboardItem.getScore(),
                leaderboardItem.getDate());
    }
}
