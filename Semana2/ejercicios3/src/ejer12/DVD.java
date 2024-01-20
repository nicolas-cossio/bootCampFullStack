package ejercicios3.ejer12;

public class DVD extends LibraryItem{
    private String director;
    private String duration;

    public DVD(String title, int itemID, Boolean isLoaned, String director, String duration) {
        super(title, itemID, isLoaned);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public void showDetails(){
        if (!isLoaned()){
            System.out.println("DVD Title: "+getTitle()+" ID: "+getItemID()+
                    " Director: "+director+" Duration: "+duration+" Status: Available");
        }
        else{
            System.out.println("DVD Title: "+getTitle()+" ID: "+getItemID()+
                    " Director: "+director+" Duration: "+duration+" Status: NOT Available");
        }
    }
}
