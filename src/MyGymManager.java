import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyGymManager implements GymManager {
    private List<DefaultMember> memberList = new ArrayList<DefaultMember>();
    private String membershipStartDate;

    @Override
    public void addMember(DefaultMember member) {
        System.out.println("no slots available :" + memberList.size());
        System.out.println("no of free slots: " + (100 - memberList.size()));

        if (memberList.size() < 100) {
            memberList.add(member);
        } else {
            System.out.println("no free slots are available");
        }

    }

    @Override
    public void deleteMember(String membershipNo) {

        boolean flag = false;
        for (DefaultMember member : memberList) {
            if (member.getMembershipNo().equals(membershipNo)) {
                flag = true;
                memberList.remove(member);
                System.out.println("membership no" + membershipNo + "removed");
                System.out.println("");
                if (member instanceof StudentMember) {
                    System.out.println("member type:student member");
                } else if (member instanceof Over60Member) {
                    System.out.println("member type: over60 member");
                } else {
                    System.out.println("member type: default member");
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("membership number not found");
        }
    }


    @Override
    public void printListMember() {
        for (DefaultMember member : memberList) {
            System.out.println("membership number : " + member.getMembershipNo() + " ");
            if (member instanceof StudentMember) {
                System.out.println("membership type : " + "student member");
            } else if (member instanceof Over60Member) {
                System.out.println("membership type is : " + "over60member");
            } else {
                System.out.println("membership number is:  Defualt member");
            }
            System.out.println("name is  " + member.getName() + " ");
            System.out.println("date is  " + member.getMembershipStartDate() + " ");
        }
        if (memberList.size() == 0) {
            System.out.println("empty");
        }
    }

    @Override
    public  void sort() {

            for (int j = 0; j < memberList.size(); j++) {
                for (int i = j + 1; i < memberList.size(); i++) {
                    if (memberList.get(i).getName().compareTo(memberList.get(j).getName()) < 0) {
                        DefaultMember temp = memberList.get(j);
                        memberList.set(j, memberList.get(i));
                        memberList.set(i, temp);
                    }
                }
            }int x=0;
            for(DefaultMember member: memberList){
                System.out.println(memberList.get(x).getName());
                x++;
            }


        }



    @Override
    public void save() {
        if (memberList.size() != 0) {
            JSONArray members = new JSONArray();
            for (DefaultMember gymMember: memberList) {
                JSONObject member = new JSONObject();
                if (gymMember instanceof StudentMember) {
                    StudentMember studentMember = (StudentMember) gymMember;
                    member.put("name", studentMember.getName());
                    member.put("date",studentMember.getName());
                    member.put("membership number",studentMember.getMembershipNo());
                    member.put("school name",studentMember.getSchoolName());
                    members.add(member);
                } else if(gymMember instanceof Over60Member) {
                    Over60Member over60Member = (Over60Member) gymMember;
                    member.put("name", over60Member.getName());
                    member.put("date",over60Member.getMembershipStartDate());
                    member.put("membership number",over60Member.getMembershipNo());
                    member.put("age",over60Member.getAge());
                }else{
                    DefaultMember defaultMember = (DefaultMember) gymMember;
                    member.put("name", defaultMember.getName());
                    member.put("date",defaultMember.getMembershipStartDate());
                    member.put("membership number",defaultMember.getMembershipNo());

                }
            }
            persistData(members);
        } else {
            System.out.println("empty list");
        }
    }

    @Override
    public List<DefaultMember> getmemberList() {
        return this.memberList;
    }

    @Override
    public DefaultMember getmember() {
        return null;
    }

    @Override
    public DefaultMember getMemberbyMembershipNo(String membershipNo) {
        return null;
    }

    @Override
    public DefaultMember getMemberbyname(String name) {
        return null;
    }

    @Override
    public int getAge() {
    return 0;
    }

    @Override
    public String getMembershipStartDate() {
        return null;
    }

    @Override
    public String getSchoolName() {
        return null;
    }

    @Override
    public String getMemberbyname() {
        return null;
    }

    @Override
    public String getMemberbyMembershipNo() {
        return null;
    }

    @Override
    public void sort(StudentMember studentMember) {

    }

    private void persistData(JSONArray jsonArray) {
        try (FileWriter file = new FileWriter("c:\\Users\\rashfa\\gymmanager\\data.json")) {
            file.write(jsonArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
