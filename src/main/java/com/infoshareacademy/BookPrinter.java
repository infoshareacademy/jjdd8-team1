package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    Menu menu = new Menu();
    UserInput getNumber = new UserInput();

    private int bookChoice = 0;

    public void printBooks(List<Book> books) {

        int record = 1;
        int counter = 0;
        int recordsLimit = 0;

        ScreenCleaner.clearScreen();
        stdout.info("\nIle rekordow na stronie? (1-" + BookRepository.getInstance().getBookRepository().size() + ")\n ");

        recordsLimit = getNumber.getChoice(BookRepository.getInstance().getBookRepository().size());

        for (Book book : books) {

            if (record < books.size() + 1) stdout.info(record + ". " + book);
            counter++;
            record++;

            if (counter >= recordsLimit) {
                stdout.info("\nWpisz 'q' jesli chcesz opuscic liste , dowolny znak kontynuuje wyswietlanie\n");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice.equals("q")) {

                        break;
                    }
                    counter = 0;
                    ScreenCleaner.clearScreen();
            }
        }
        menu.showMenu(Menu.BOOK_MENU_POSITION);
    }

    public void getOneBook() {

                    int temp = chooseBookToPrint();
                    stdout.info(temp + 1 + ". " + BookRepository.getInstance().getBookRepository().get(temp));
                    chooseBookToPrint();
                    stdout.info(bookChoice + 1 + ". " + BookRepository.getInstance().getBookRepository().get(bookChoice));
        menu.showMenu(Menu.BOOK_MENU_POSITION);

    }

    private boolean isCorrectChooseBook(String choice) {
        return (getNumber.isANumber(choice)) && areThereThatManyBooks(choice);

    }
    private boolean areThereThatManyBooks(String choice){
        return (Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= BookRepository.getInstance().getBookRepository().size());
    }

    public int chooseBookToPrint() {
        stdout.info("\nWpisz numer książki: \n");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();


            if (!isCorrectChooseBook(choice)) {
                stdout.info("Błędny wybór! Spróbuj ponownie!: \n");
                bookChoice = 0;
                chooseBookToPrint();
            }  else {
                bookChoice = Integer.parseInt(choice) -1 ;
                return bookChoice;
            }

        return bookChoice;

    }

}


