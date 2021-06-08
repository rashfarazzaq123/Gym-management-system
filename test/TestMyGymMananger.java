import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestMyGymMananger {

    GymManager gymManager = new MyGymManager();
    private List<DefaultMember> memberList = new ArrayList<DefaultMember>();

    @Test
    public void testAddMember1() {
        DefaultMember defaultMember2 = new Over60Member("1", "someName", new Date(1, 1, 1), 2);
        gymManager.addMember(defaultMember2);
        Assert.assertEquals(gymManager.getmemberList().size(), 2);
    }

    @Test
    public void testAddMember2() {
        StudentMember studentMember = new StudentMember("1", "someName", new Date(1, 1, 1), "someschool");
        gymManager.addMember(studentMember);
        Assert.assertEquals(gymManager.getmemberList().size(), 1);
    }

    @Test
    public void testAddMember3() {
        Over60Member over60Member = new Over60Member("1", "someName", new Date(1, 1, 1), 67);
        gymManager.addMember(over60Member);
        assertEquals(gymManager.getmemberList().size(), 1);
    }

    @Test
    public void deleteMember() {
        DefaultMember member1 = new DefaultMember("s1", "rashfa", new Date(1, 1, 1));
        DefaultMember member2 = new DefaultMember("s2", "rashfa1", new Date(2, 3, 5));
        memberList.add(member1);
        memberList.add(member2);
        memberList.remove(member1);
        assertEquals(1, memberList.size());
        assertEquals(99, 100 - (memberList.size()));
    }
    @Test
    public void deleteMember1() {
        StudentMember studentMember = new StudentMember("s1","rashfa",new Date(1, 1, 1),"school");
        StudentMember studentMember1 = new StudentMember("s2","rashfa1",new Date(1, 1, 1),"school");

        memberList.add(studentMember);
        memberList.add(studentMember1);
        memberList.remove(studentMember1);
        assertEquals(1, memberList.size());
        assertEquals(99, 100 - (memberList.size()));
    }

    @Test
    public void printMember() {
        DefaultMember member1 = new DefaultMember("s1", "ann", new Date(1, 1, 1));
        DefaultMember member2 = new DefaultMember("s2", "rann", new Date(3, 6, 1));
        memberList.add(member1);
        memberList.add(member2);
        int iteration = 0;
        for (DefaultMember member : memberList) {
            System.out.println(member.getName() + " " + member.getMembershipNo() + " " + member.getMembershipStartDate());
            iteration++;
        }
        assertEquals(2, memberList.size());
    }

    @Test
    public void sortMember() {
        DefaultMember member1 = new DefaultMember("s1", "ann", new Date(1, 1, 1));
        DefaultMember member2 = new DefaultMember("s2", "rann", new Date(3, 6, 1));
        memberList.add(member1);
        memberList.add(member2);
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
        assertEquals("ann rann",memberList.get(0).getName()+" "+memberList.get(1).getName());


    }

}