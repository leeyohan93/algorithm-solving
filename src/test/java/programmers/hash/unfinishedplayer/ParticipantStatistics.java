package programmers.hash.unfinishedplayer;

import java.util.List;
import java.util.Map;

public class ParticipantStatistics {
    private final Map<Participant, Integer> statistics;

    public ParticipantStatistics(final Map<Participant, Integer> statistics) {
        this.statistics = statistics;
    }

    public String getUnfinishedParticipantName(Participants completion) {
        List<Participant> participants = completion.getParticipants();
        for (Participant participant : participants) {
            Integer count = statistics.get(participant);
            if (count == 1) {
                statistics.remove(participant);
            }
            if (count > 1) {
                statistics.put(participant, count - 1);
            }
        }

        return statistics.keySet()
                .stream()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getName();
    }
}
