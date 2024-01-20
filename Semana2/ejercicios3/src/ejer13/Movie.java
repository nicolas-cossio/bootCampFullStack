package ejercicios3.ejer13;

public class Movie extends RentalItem {
    private String director;
    private String duration;
    private int ageRating;
    private String genre;

    public Movie(String itemName, int itemID, boolean available, String director, String duration,
                 int ageRating, String genre) {
        super(itemName, itemID, available);
        this.director = director;
        this.duration = duration;
        this.ageRating = ageRating;
        this.genre = genre;
    }

    @Override
    public void showDetails(){
        System.out.print("ID: "+getItemID()+" - Movie Name: "+getItemName()+" - Director: "+director+
                " - Duration: "+duration+" - Age Rating: "+ageRating+" - Genre: "+genre);

    }
}
