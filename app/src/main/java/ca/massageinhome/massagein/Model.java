package ca.massageinhome.massagein;

public class Model {

    private int image;
    private String title;
    private String book;


    public Model(int image, String title, String book) {
        this.image = image;
        this.title = title;
        this.book = book;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String date) {
        this.book = book;
    }


}
