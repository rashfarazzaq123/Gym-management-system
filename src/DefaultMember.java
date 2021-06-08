public class DefaultMember  {
    private String membershipNo;
    private String name;
    private Date membershipStartDate;


    public DefaultMember(String membershipNo,String name,Date membershipStartDate){
        super();
        this.membershipNo=membershipNo;
        this.name=name;
        this.membershipStartDate=membershipStartDate;
    }

    public String getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(String membershipNo) {
        this.membershipNo = membershipNo;
    }

    public Date getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(Date membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
