package at.aau.serg.exercises.bookstore.entity;

import at.aau.serg.exercises.bookstore.dao.EntityWithId;

public class Book implements EntityWithId<Long> {
    private Long id;
    private final String title;
    private final String author;
    private final double price;
    private final String isbn13;

    public Book(Long id, String isbn13, String title, String author, double price) {
        this.id = id;
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Validates the ISBN 13 according to the spec
     * <br />
     * See: <a href="https://de.wikipedia.org/wiki/Internationale_Standardbuchnummer#ISBN-13">Wikipedia</a>
     * @return true if the book was initialized with a valid ISBN-13 ID
     */
    public boolean validateIsbn13() {
        // Remove hyphens and spaces
        final String cleanIsbn = isbn13.replaceAll("[\\s-]+", "");

        // Check if the length is 13 after cleaning
        if (cleanIsbn.length() != 13) {
            return false;
        }

        // Check if all characters are digits
        if (!cleanIsbn.matches("\\d+")) {
            return false;
        }

        // Calculate and check the checksum
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(cleanIsbn.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }

        int checksum = (10 - (sum % 10)) % 10;
        int lastDigit = Character.getNumericValue(cleanIsbn.charAt(12));

        return checksum == lastDigit;
    }
}
