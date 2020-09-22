package programmers.sort.k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Commands {
    private final List<Command> commands;

    public static Commands from(int[][] commands) {
        return Arrays.stream(commands)
                .map(command -> new Command(command[0] - 1, command[1], command[2] - 1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Commands::new));
    }

    public Commands(final List<Command> commands) {
        this.commands = new ArrayList<>(Collections.unmodifiableList(commands));
    }

    public int[] getCommandNumbers(Numbers numbers) {
        return commands.stream()
                .mapToInt(command -> command.getNumber(numbers))
                .toArray();
    }
}
