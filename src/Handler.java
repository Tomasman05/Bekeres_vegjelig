import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Handler {
    public void handle() throws IOException{
        ArrayList<String> nameList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String name = "";
        while(!name.equals("vege") && !name.equals("Vege")){
            System.out.print("Adjon meg nevet: ");
            name= sc.nextLine();
            if(!name.equals("vege")&& !name.equals("Vege")){
                nameList.add(name);
            }
        }
        System.out.println(nameList);
        writeList(nameList);
        sc.close();
    }
    private void writeList(ArrayList<String> nameList){
        try {
            tryWriteList(nameList);
        } catch (IOException e) {
            System.err.println("Hiba, a fájlba írás sikertelen.");
            System.err.println(e.getMessage());
        }
    }
    private void tryWriteList(ArrayList<String> nameList) throws IOException{
        FileWriter fw = new FileWriter("nevek.txt",Charset.forName("utf-8"));
        PrintWriter pw = new PrintWriter(fw);
        nameList.forEach(name ->{
            pw.println(name);
        });
        pw.close();
    }
}
