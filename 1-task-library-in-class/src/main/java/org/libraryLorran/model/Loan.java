package org.libraryLorran.model;

import java.util.Date;

public class Loan {

    private Member member;
    private Book book;

    public Loan() { }

    public Loan(Member member, Book book) {
        this.member = member;
        this.book = book;
    }

    public Member getMember() { return member; }

    public Book getBook() { return book; }

    @Override
    public String toString() {
        return "Loan{" +
                "book ='" + book + '\'' +
                ", name ='" + member.getName() + '\'' +
                '}';
    }

}
