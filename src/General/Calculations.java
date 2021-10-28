package General;

import java.io.File;
import java.io.FileWriter;

public class Calculations {
    public static void main(String[] args) throws Exception {
        final double proportion = (72.6-15.0)/72.6;
        FileWriter file = new FileWriter(new File("resources/values.txt"));
        for (int i=1;i<=200;++i) {
            String text = i + " = " + Math.round(i*proportion) + "\n";
            System.out.print(text);
            file.append(text);
            if (Math.round(i*proportion) == 100) {
                break;
            }
        }
        file.close();
    }
}


