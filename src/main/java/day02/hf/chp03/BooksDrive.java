package day02.hf.chp03;

/**
 * Created by bollsal on 2016. 11. 13..
 */
public class BooksDrive {
    static class Books {
        String title;
        String author;
    }

    public static void main(String... args) {
        Books[] myBooks = new Books[3];

        for (int i = 0; i < myBooks.length; i++) {
            myBooks[i] = new Books();
        }

        int x = 0;

        myBooks[0].title = "The grapes of java";
        myBooks[1].title = "The java gatbsy";
        myBooks[2].title = "The cook book";

        myBooks[0].author = "bob";
        myBooks[1].author = "sue";
        myBooks[2].author = "ian";

        while (x < 3) {
            System.out.print(myBooks[x].title);
            System.out.print(" by ");
            System.out.println(myBooks[x].author);
            x++;
        }
    }
}
