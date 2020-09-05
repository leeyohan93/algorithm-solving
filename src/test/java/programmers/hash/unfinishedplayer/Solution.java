package programmers.hash.unfinishedplayer;


import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void solve() {
        String[] participant = "a,b,c".split(",");
        String[] completion = "b,c".split(",");

        Participants participants = Participants.from(participant);
        ParticipantStatistics statistics = participants.getStatistics();
        String unfinishedParticipantName = statistics.getUnfinishedParticipantName(Participants.from(completion));

        System.out.println(unfinishedParticipantName);
    }
}
