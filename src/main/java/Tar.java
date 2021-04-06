import java.io.*;

public class Tar {
    public static void main(String[] args){
        if (args[0].equals("-u")) {
            String[] parts = readFile(args[1]).split("---");
            int i = 1;
            for (String part: parts)
            {
                writeFile("output" + i + ".txt", part);
                i++;
            }
        } else {
            String outputName = args[3];
            String output = readFile(args[0]);
            int i = 1;
            while (!args[i].equals("-out")) {
                output += ("\n---\r" + readFile(args[i]));
                i++;
            }
            writeFile(outputName,output);
        }
    }

    public static void writeFile(String file, String data){
        try (FileWriter writer = new FileWriter(file, false)){
            writer.write(data);
            writer.flush();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String readFile(String file){
        try{
            FileReader nnn = new FileReader(file);
            BufferedReader reader = new BufferedReader(nnn);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
        catch(Exception e){
            return null;
        }
    }
}
