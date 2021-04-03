package etc.devmatching;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem3 {

    @Test
    void test() {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};

        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        List<Member> members = IntStream.range(0, enroll.length)
                .mapToObj(index -> Member.of(enroll[index], referral[index]))
                .collect(Collectors.toList());

        for (int i = 0; i < seller.length; i++) {
            for (Member member : members) {
                if (seller[i].equals(member.getName())) {
                    member.setAmount(amount[i] * 100);
                    break;
                }
            }
        }

        members.forEach(member -> member.calculate(members));
        members.forEach(member -> System.out.println(member.totalAmount()));

    }

    public static class Member {
        public String getName() {
            return name;
        }

        private final String name;
        private String ref;
        private int amount;

        private int refAmount;

        public static Member of(final String name, final String ref) {
            return new Member(name, ref, 0, 0);
        }

        public Member(final String name, final String ref, final int amount, final int refAmount) {
            this.name = name;
            this.ref = ref;
            this.amount = amount;
            this.refAmount = refAmount;
        }

        public void setAmount(final int amount) {
            this.amount = amount;
        }

        private void calculate(final List<Member> members) {
            int refAmount = amount / 10;
            this.amount -= refAmount;
            if (!ref.equals("-")) {
                for (Member member : members) {
                    if (ref.equals(member.name)) {
                        member.refCalculate(refAmount, members);
                        break;
                    }
                }
            }
        }

        private void refCalculate(int amount, final List<Member> members) {
            int refAmount = amount / 10;
            this.refAmount += (amount - refAmount);
            if (!ref.equals("-")) {
                for (Member member : members) {
                    if (ref.equals(member.name)) {
                        member.refCalculate(refAmount, members);
                        break;
                    }
                }
            }
        }

        public int totalAmount() {
            return amount + refAmount;
        }
    }
}
