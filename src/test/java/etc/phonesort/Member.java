package etc.phonesort;

public class Member implements Comparable<Member> {

    private String name;

    private String phone;

    public static Member of(String input) {
        String[] nameAndPhone = input.split(" ");
        return new Member(nameAndPhone[0], nameAndPhone[1]);
    }

    public Member(final String name, final String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public int compareTo(final Member o) {
        int compareName = name.compareTo(o.name);
        return compareName == 0 ? phone.compareTo(o.phone) : compareName;
    }

    @Override
    public String toString() {
        return name + " " + phone;
    }
}
