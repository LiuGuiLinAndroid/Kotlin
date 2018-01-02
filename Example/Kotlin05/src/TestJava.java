import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestJava {

    private static Window window;

    public static void main(String[] str) {
        System.out.print("Hello Main ...");

        List<String> mStr = new ArrayList<>();
        List<? extends Object> mObStr = mStr;

        //JAVA
        window.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }
        });
    }
}

//JAVA
//interface Source<T> {
//    T nextT();
//}

