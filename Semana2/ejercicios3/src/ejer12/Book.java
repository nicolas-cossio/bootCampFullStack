package ejercicios3.ejer12;

public class Book extends LibraryItem{
    private String author;

    public Book(String title, int itemID, Boolean isLoaned, String author) {
        super(title, itemID, isLoaned);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void showDetails(){
        if (!isLoaned()){
            System.out.println("Book Title: "+getTitle()+" ID: "+getItemID()+
                    " Author: "+author+" Status: Available");
        }
        else{
            System.out.println("Book Title: "+getTitle()+" ID: "+getItemID()+
                    " Author: "+author+" Status: NOT Available");
        }
    }
}
