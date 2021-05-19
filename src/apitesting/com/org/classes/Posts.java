package apitesting.com.org.classes;

public class Posts {

    /**
     * id
     */
    private String id;

    /**
     * Title
     */
    private String title;

    /**
     * Author
     */
    private String author;

    /**
     * Set id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set Title
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set author
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get
     * @return String
     */
    public String getTitle() {
        return title;
    }
    /**
     * Get
     * @return String
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Get
     * @return String
     */
    public String getId() {
        return id;
    }
}
