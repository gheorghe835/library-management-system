package main.java.com.library;

public class Member {
    private final MemberInfo info;
    private int borrowedCount;

    public Member(String memberId,
                  String fullName){
        this.info = new MemberInfo(memberId,fullName);
        this.borrowedCount = 0;
    }

    public String getMemberId(){
        return info.memberId();
    }

    public String getFullName(){
        return info.fullName();
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public void increaseBorrowedCount(){
        borrowedCount++;
    }

    public void decreaseBorrowedCount(){
        if (borrowedCount > 0){
            borrowedCount --;
        }
    }
}
