package programmers.hash.unfinishedplayer;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Participants {
    private final List<Participant> participants;

    public static Participants from(String[] participants) {
        return Arrays.stream(participants)
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));
    }

    public Participants(final List<Participant> participants) {
        this.participants = new ArrayList<>(Collections.unmodifiableList(participants));
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public ParticipantStatistics getStatistics() {
        Map<Participant, Integer> statistics = new HashMap<>();
        for (Participant participant : participants) {
            statistics.merge(participant, 1, Integer::sum);
        }
        return new ParticipantStatistics(statistics);
    }
}
