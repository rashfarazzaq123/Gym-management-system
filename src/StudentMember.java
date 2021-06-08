public class StudentMember extends DefaultMember{
    private String schoolName;
    public StudentMember(String membershipNo,String name,Date membershipDate,String schoolName){
        super(membershipNo,name,membershipDate);
        this.schoolName=schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
