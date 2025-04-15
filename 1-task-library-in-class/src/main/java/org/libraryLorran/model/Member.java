package org.libraryLorran.model;

public class Member {

    private int memberId;
    private String name;
    private String email;

    public Member() { }

    public Member(int memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }

    public int getMemberId() { return memberId; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Member{" +
                "memberId ='" + memberId + '\'' +
                ", name ='" + name + '\'' +
                ", email ='" + email + '\'' +
                '}';
    }
}
