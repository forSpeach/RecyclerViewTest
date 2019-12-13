package android.example.recyclerview;

public class RecyclerViewItem {
    private int imageResource;
    private String text1;
    private String text2;

    RecyclerViewItem(int imageResource, String text1, String text2 ) {
        this.imageResource = imageResource;
        this.text1 = text1;
        this.text2 = text2;

    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}
