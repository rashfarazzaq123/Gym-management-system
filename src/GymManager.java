import java.util.List;

public interface GymManager {
    public void addMember(DefaultMember member);
    public void deleteMember(String membershipNo);
    public void printListMember();
    public void sort();
    public void save();
    public List<DefaultMember>getmemberList();
    public DefaultMember getmember();
    public DefaultMember getMemberbyMembershipNo(String membershipNo);
    public DefaultMember getMemberbyname(String name);
    public int getAge() ;
    public String getMembershipStartDate() ;
    public String  getSchoolName() ;
    String getMemberbyname();
    String getMemberbyMembershipNo();

    void sort(StudentMember studentMember);
}
