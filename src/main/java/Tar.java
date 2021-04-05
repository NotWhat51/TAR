
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tar {
    public Tar() {
    }

    public static void main(String[] args) throws IOException {
        if (args[0].equals("-u")) {
            String a = readFile(args[1]);
            String[] parts = a.split("---");
            String[] var4 = parts;
            int var5 = parts.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String part = var4[var6];
                System.out.print("!");
                System.out.print(part);
            }
        } else {
            System.out.println(0);
        }

    }

    public static String readFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            String line;
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        } catch (Exception var5) {
            return null;
        }
    }
}