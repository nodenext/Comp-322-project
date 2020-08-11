
import java.io.File;  
import java.io.IOException;  
  
public class MySQLDatabaseImport {  
  
    public static boolean importDatabase(String hostIP, String userName, String password, String importFilePath, String sqlFileName, String databaseName) {  
        File saveFile = new File(importFilePath);  
        if (!saveFile.exists()) {
            saveFile.mkdirs(); 
        }  
        if (!importFilePath.endsWith(File.separator)) {  
            importFilePath = importFilePath + File.separator;  
        }         
  
        StringBuilder stringBuilder=new StringBuilder();  
        stringBuilder.append("mysql").append(" -h").append(hostIP);  
        stringBuilder.append(" -u").append(userName).append(" -p").append(password);  
        stringBuilder.append(" ").append(databaseName);  
        stringBuilder.append(" <").append(importFilePath).append(sqlFileName);  
        try {  
            Process process = Runtime.getRuntime().exec("cmd /c "+stringBuilder.toString());/”  
            if (process.waitFor() == 0) {
                return true;  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        return false;  
    }  
  
    public static void main(String[] args) throws InterruptedException {  
        if (importDatabase("", "", "", "", "", "")) {  
            System.out.println("successful！！！");  
        } else {  
            System.out.println("unsuccessful！！！");  
        }  
    }  
}  

