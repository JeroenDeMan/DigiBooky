package be.switchfully.codecavalry.digibooky.service.dto;

public class LendingDTO {

    private String bookId;
    private String memberId;
    private String lendingId;
    private String memberName;
    private String bookTitle;
    private String dateOfLending;
    private String dateOfReturn;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getLendingId() {
        return lendingId;
    }

    public void setLendingId(String lendingId) {
        this.lendingId = lendingId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getDateOfLending() {
        return dateOfLending;
    }

    public void setDateOfLending(String dateOfLending) {
        this.dateOfLending = dateOfLending;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
