package org.libraryLorran.services;

import org.libraryLorran.model.Book;
import org.libraryLorran.model.Loan;
import org.libraryLorran.model.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoanService {
    List<Loan> loans = new ArrayList<>();

    public void loanBook(Member member, Book book) {
        loans.add(new Loan(member, book));
        System.out.println("Empréstimo realizado com sucesso.");
    }

    public void returnBook(Member member, Book book) {
        loans.removeIf(loan -> loan.getMember().equals(member) && loan.getBook().equals(book));
        System.out.println("Livro devolvido com sucesso");
    }

}
