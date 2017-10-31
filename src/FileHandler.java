import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static List<String> fileNames = new ArrayList<String>();
    private static List<Integer> namesSize = new ArrayList<Integer>();
    private static List<Long> filesSize = new ArrayList<Long>();
    private static String userPath;

    FileHandler(String myFolder){
        setFolder();
        setFileNames(userPath);
        SetNamesSizes(fileNames);
        SetFileSizes(fileNames, userPath);
    }

    public void getFiles(){
        System.out.println("");

    }
    public void setFolder() {
        System.out.println("Digite o caminho da pasta com os arquivos que deseja unir");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            userPath = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setFileNames(String userFolder) {
        File[] files = new File(userFolder).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                fileNames.add(file.getName());
            }
        }
    }

    void SetNamesSizes(List<String> fileNames){
        for (String name : fileNames){
                namesSize.add(name.length());
        }
    }

    void SetFileSizes(List<String> fileNames, String userPath){

        for (File file : new File(userPath).listFiles()){
            if (file.isFile()) {
                System.out.println(file.getName() + " " + file.length());
                filesSize.add(file.length());
            }
        }
    }
}
