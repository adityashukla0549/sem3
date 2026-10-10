import java.util.Arrays;

abstract class LibraryMemberQ5 {
    private final String memberId;
    private int borrowLimit;
    private int booksBorrowed;
    private int[] fineHistory;
    private int fineCount;

    public LibraryMemberQ5(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid memberId");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
        this.fineHistory = new int[10];
        this.fineCount = 0;
    }

    public final String getMemberId() {
        return memberId;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }
        return total;
    }

    public abstract String displayInfo();
}

class StudentMemberQ5 extends LibraryMemberQ5 {
    private String course;

    public StudentMemberQ5(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }

    @Override
    public String displayInfo() {
        return "Student Member: " + getMemberId() + " | Course: " + course + " | Books Borrowed: " + getBooksBorrowed();
    }
}

class HonorsStudentMemberQ5 extends StudentMemberQ5 {
    private int bonusLimit;

    public HonorsStudentMemberQ5(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    public int getBonusLimit() {
        return bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member: " + getMemberId() + " | Course: " + getCourse() + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + getBooksBorrowed();
    }
}

class FacultyMemberQ5 extends LibraryMemberQ5 {
    private String department;

    public FacultyMemberQ5(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member: " + getMemberId() + " | Department: " + department + " | Books Borrowed: " + getBooksBorrowed();
    }
}

class FineAuditSystem {
    public static int auditFines(LibraryMemberQ5[] members) {
        int totalFineCollected = 0;
        for (LibraryMemberQ5 member : members) {
            totalFineCollected += member.getTotalFine();
        }
        return totalFineCollected;
    }

    public static void printMemberDetails(LibraryMemberQ5[] members) {
        for (LibraryMemberQ5 member : members) {
            System.out.println(member.displayInfo());
        }
    }
}

public class Q5 {
    public static void main(String[] args) {
        StudentMemberQ5 student = new StudentMemberQ5("STU101", 3, "CSE");
        HonorsStudentMemberQ5 honors = new HonorsStudentMemberQ5("HON202", 5, "ECE", 2);
        FacultyMemberQ5 faculty = new FacultyMemberQ5("FAC303", 10, "Physics");

        student.chargeFine(100); 
        honors.chargeFine(200);  
        faculty.chargeFine(150); 

        LibraryMemberQ5[] memberList = {student, honors, faculty};

        FineAuditSystem.printMemberDetails(memberList);

        int totalFines = FineAuditSystem.auditFines(memberList);
        System.out.println("Total Fines Collected: " + totalFines);
    }
}