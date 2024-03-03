package bookManager.dto;

public class BookAddOrUpdateRequest {
    private final String name;
    private final int year;

    public BookAddOrUpdateRequest(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

}
