class BaseLibraryMember {
    private String memberId;
    private int borrowLimit;
    private int booksBorrowed;

    public BaseLibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid memberId");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getMemberId() {
        return memberId;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }
}

class StudentMemberQ2 extends BaseLibraryMember {
    private String course;

    public StudentMemberQ2(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course + " | Books Borrowed: " + getBooksBorrowed();
    }
}

class HonorsStudentMember extends StudentMemberQ2 {
    private int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    public int getBonusLimit() {
        return bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member | Course: " + getCourse() + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + getBooksBorrowed();
    }
}

class FacultyMember extends BaseLibraryMember {
    private String department;

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department + " | Books Borrowed: " + getBooksBorrowed();
    }
}

public class Q2 {
    public static String classifyGeneration(BaseLibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof StudentMemberQ2) {
            return "Single descendant (2 generations deep)";
        } else {
            return "Base Member";
        }
    }

    public static int getTotalBooksBorrowed(BaseLibraryMember[] members) {
        int total = 0;
        for (BaseLibraryMember member : members) {
            total += member.getBooksBorrowed();
        }
        return total;
    }

    public static void main(String[] args) {
        BaseLibraryMember general = new BaseLibraryMember("STU1", 3);
        StudentMemberQ2 student = new StudentMemberQ2("STU2", 3, "CSE");
        HonorsStudentMember honors = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember faculty = new FacultyMember("STU4", 5, "Physics");

        System.out.println(general.displayInfo());
        System.out.println(student.displayInfo());
        System.out.println(honors.displayInfo());
        System.out.println(faculty.displayInfo());

        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));

        student.borrowBook();
        student.borrowBook();
        honors.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();

        BaseLibraryMember[] list = {student, honors, faculty};
        System.out.println("Total Books Borrowed: " + getTotalBooksBorrowed(list));
    }
}