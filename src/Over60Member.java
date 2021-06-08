public class Over60Member extends DefaultMember {
    private int age;
    public Over60Member(String membershipNo, String name, Date membershipStartDate , int age) {
        super(membershipNo, name, membershipStartDate);
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

    }
}
