import java.util.*;

class Film {
    private String title;
    private String director;
    private int year;

    Film(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return title + " (" + director + ", " + year + ")";
    }
}

class FilmLibrary {
    private List<Film> films = new ArrayList<>();

    public void addFilm(Film film) {
        films.add(film);
    }

    public void removeFilm(String title) {
        Iterator<Film> it = films.iterator();
        while (it.hasNext()) {
            Film film = it.next();
            if (film.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Removed Film: " + film);
                it.remove();
                return;
            }
        }
    }

    public List<Film> getFilms() {
        return films;
    }

    public List<Film> searchFilms(String query) {
        List<Film> result = new ArrayList<>();
        for (Film film : films) {
            if (film.getTitle().toLowerCase().contains(query.toLowerCase())
                    || film.getDirector().toLowerCase().contains(query.toLowerCase())) {
                result.add(film);
            }
        }
        return result;
    }

    public int getTotalFilmCount() {
        return films.size();
    }
}

public class Example3 {
    public static void main(String[] args) {
        FilmLibrary library = new FilmLibrary();

        library.addFilm(new Film("Raaz", "Vikram Bhatt", 2002));
        library.addFilm(new Film("1920", "Vikram Bhatt", 2008));
        library.addFilm(new Film("Ragini MMS", "Pawan Kripalani", 2011));
        library.addFilm(new Film("Bhoot", "Ram Gopal Varma", 2003));

        String searchQuery = "Vikram Bhatt";
        String deleteTitle = "Bhoot";

        System.out.println("Total Film Count: " + library.getTotalFilmCount());

        List<Film> searchResults = library.searchFilms(searchQuery);
        System.out.println("Search Results for " + searchQuery + ":");
        for (Film film : searchResults) {
            System.out.println(film);
        }

        library.removeFilm(deleteTitle);

        System.out.println("All Films:");
        for (Film film : library.getFilms()) {
            System.out.println(film);
        }
    }
}