package org.libraryLorran.controller;

import org.libraryLorran.model.Book;
import org.libraryLorran.model.Member;
import org.libraryLorran.services.LibraryService;
import org.libraryLorran.services.LoanService;

import java.util.Optional;
import java.util.Scanner;

public class LibraryController {
    private final LibraryService libraryService;
    private final LoanService loanService;
    private final Scanner scanner;

    public LibraryController(LibraryService libraryService, LoanService loanService) {
        this.libraryService = libraryService;
        this.loanService = loanService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean runningSystem = true;
        while (runningSystem) {
            showMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> registerUser();
                case 4 -> registerLoan();
                case 5 -> returnLoan();
                case 6 -> listBookAvaliables();
                case 7 -> runningSystem = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("\n=== Sistema Biblioteca ===");
        System.out.println("1. Adicionar Livro");
        System.out.println("2. Remover Livro");
        System.out.println("3. Registrar Membro");
        System.out.println("4. Realizar Empréstimo");
        System.out.println("5. Devolver Livro");
        System.out.println("6. Listar Livros Disponíveis");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void addBook() {
        System.out.println("Digite o title do livro");
        String title = scanner.next();
        System.out.println("Digite o autor do livro");
        String author = scanner.next();
        System.out.println("Digite o ISBN do livro");
        int isbn = scanner.nextInt();
        libraryService.addBook(new Book(title, author, isbn));
    }

    private void removeBook() {
        System.out.println("Insira o titulo do livro para remove-lo");
        String title = scanner.next();
        if (libraryService.removeBook(title)) {
            System.out.println("Livro: " + title + " removido com sucesso");
        } else {
            System.out.println("Há alguma formação errada, confira a lista de livros.");
            listBookAvaliables();
        }
    }

    private void registerUser() {
        System.out.println("Digite o id de usuario");
        int id = scanner.nextInt();
        System.out.println("Digite o nome do usuario");
        String name = scanner.next();
        System.out.println("Digite o email do usuario");
        String email = scanner.next();
        libraryService.registerMember(new Member(id, name, email));
    }

    private void registerLoan() {
        System.out.println("Digite o id de usuario");
        int id = scanner.nextInt();
        System.out.println("Digite o livro desejado");
        String title = scanner.next();
        Optional<Member> member = libraryService.findMemberbyId(id);
        Optional<Book> book = libraryService.findBookByTitle(title);

        if (member.isPresent() && book.isPresent()) {
            loanService.loanBook(member.get(), book.get());
            System.out.println("Empréstimo realizado com sucesso");
        } else {
            System.out.println("Membro ou livro não encontrado");
        }
    }

    private void returnLoan() {
        System.out.println("Digite o id de usuario");
        int id = scanner.nextInt();
        System.out.println("Digite o livro desejado");
        String title = scanner.next();
        Optional<Member> member = libraryService.findMemberbyId(id);
        Optional<Book> book = libraryService.findBookByTitle(title);

        if (member.isPresent() && book.isPresent()) {
            loanService.returnBook(member.get(), book.get());
            System.out.println("Livro devolvido com sucesso");
        } else {
            System.out.println("Membro ou livro não encontrado");
        }
    }

    private void listBookAvaliables() {
        System.out.println();
        libraryService.listAvaliable().forEach(System.out::println);
    }
}