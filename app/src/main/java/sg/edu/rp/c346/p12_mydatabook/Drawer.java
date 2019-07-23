package sg.edu.rp.c346.p12_mydatabook;

import android.widget.ImageView;

public class Drawer {

    String name;
    int img;

    public Drawer(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
