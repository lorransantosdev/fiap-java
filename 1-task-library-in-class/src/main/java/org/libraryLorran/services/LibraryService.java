package org.libraryLorran.services;

import org.libraryLorran.model.Book;
import org.libraryLorran.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibraryService {
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String title) {
        return books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public void registerMember(Member member) {
        if (members.stream().anyMatch(m -> m.getMemberId() == member.getMemberId())) {
            System.out.println("Este usuário já foi registrado");
        } else {
            members.add(member);
            System.out.println("Usuário registrado com sucesso");
        }
    }

    public Optional<Member> findMemberbyId(int memberId) {
        return members.stream()
                .filter(member -> member.getMemberId() == memberId)
                .findFirst();
    }

    public Optional<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public List<Book> listAvaliable() {
        return books;
    }
}