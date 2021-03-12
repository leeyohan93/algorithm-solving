package etc.phonesort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // given
        String[] membersInput = {"kim 010-0000-0000", "eve 010-9999-9999", "kim 010-2222-2222"};

        Arrays.stream(membersInput)
                .map(Member::of)
                .sorted()
                .forEach(member -> System.out.println(member.toString()));
    }


    @DisplayName("")
    @Test
    void test() {
        // given
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            members.add(Member.of(scanner.nextLine()));
        }
        members.stream()
                .sorted()
                .forEach(member -> System.out.println(member.toString()));
    }
}
