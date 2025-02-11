/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



package com.mycompany.sistempemesanantiketbioskop;
import java.util.*;

class Movie {
    String name;
    String genre;
    double rating;
    List<String> schedule;

    // Constructor
    public Movie(String name, String genre, double rating, List<String> schedule) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.schedule = schedule;
    }

    // Method untuk menampilkan detail film
    public void displayMovieDetails() {
        System.out.println("Nama Film: " + name);
        System.out.println("Genre: " + genre);
        System.out.println("Rating: " + rating);
        System.out.println("Jadwal: ");
        for (String time : schedule) {
            System.out.println(" - " + time);
        }
    }
}

public class SistemPemesananTiketBioskop {
    static List<Movie> movies = new ArrayList<>();
    
    // Fungsi untuk menambahkan film ke dalam daftar
    public static void addMovies() {
        movies.add(new Movie("Film A", "Action", 8.0, Arrays.asList("10:00", "14:00", "18:00")));
        movies.add(new Movie("Film B", "Comedy", 7.5, Arrays.asList("12:00", "16:00", "20:00")));
        movies.add(new Movie("Film C", "Drama", 8.5, Arrays.asList("11:00", "15:00", "19:00")));
    }

    // Fungsi untuk menampilkan daftar film
    public static void showMovies() {
        System.out.println("\nDaftar Film Tayang:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.print((i + 1) + ". ");
            movies.get(i).displayMovieDetails();
            System.out.println();
        }
    }

    // Fungsi untuk mencari film berdasarkan nama
    public static void searchMovie(String movieName) {
        boolean found = false;
        for (Movie movie : movies) {
            if (movie.name.toLowerCase().contains(movieName.toLowerCase())) {
                movie.displayMovieDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Film tidak ditemukan.");
        }
    }

    // Fungsi untuk mengurutkan film berdasarkan rating
    public static void sortMoviesByRating() {
        movies.sort(Comparator.comparingDouble((Movie movie) -> movie.rating).reversed());
        System.out.println("\nFilm diurutkan berdasarkan rating:");
        showMovies();
    }

    // Fungsi untuk memesan tiket
    public static void bookTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nPilih film (masukkan nomor): ");
        int movieChoice = sc.nextInt() - 1;
        
        if (movieChoice >= 0 && movieChoice < movies.size()) {
            Movie movie = movies.get(movieChoice);
            System.out.println("Film yang dipilih: " + movie.name);
            System.out.println("Jadwal tersedia: ");
            for (int i = 0; i < movie.schedule.size(); i++) {
                System.out.println((i + 1) + ". " + movie.schedule.get(i));
            }
            System.out.print("Pilih jadwal (masukkan nomor): ");
            int timeChoice = sc.nextInt() - 1;
            
            if (timeChoice >= 0 && timeChoice < movie.schedule.size()) {
                System.out.println("Tiket untuk film " + movie.name + " pada jam " + movie.schedule.get(timeChoice) + " berhasil dipesan!");
            } else {
                System.out.println("Jadwal tidak valid.");
            }
        } else {
            System.out.println("Film tidak valid.");
        }
    }

    // Main program untuk interaksi dengan pengguna
    public static void main(String[] args) {
        addMovies();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Daftar Film");
            System.out.println("2. Cari Film");
            System.out.println("3. Urutkan Film Berdasarkan Rating");
            System.out.println("4. Pesan Tiket");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    showMovies();
                    break;
                case 2:
                    System.out.print("Masukkan nama film yang dicari: ");
                    String movieName = sc.nextLine();
                    searchMovie(movieName);
                    break;
                case 3:
                    sortMoviesByRating();
                    break;
                case 4:
                    bookTicket();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    sc.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}

