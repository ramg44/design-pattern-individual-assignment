import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Login {

    HashMap<String,String> userLoginsForBuyer ;
    HashMap<String,String> userLoginsForSeller ;

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    Login() throws Exception {

        String path = System.getProperty("user.dir");
        String[] buyerInfos = readFileAsString(path.concat("/src/DataBase/BuyerInfo.txt")).split("\\R");
        String[] sellerInfos = readFileAsString(path.concat("/src/DataBase/SellerInfo.txt")).split("\\R");
        userLoginsForBuyer = new HashMap<>();
        userLoginsForSeller = new HashMap<>();
        for (String buyerInfo : buyerInfos) {
            String user[] = buyerInfo.split(":");
            userLoginsForBuyer.put(user[0], user[1]);
        }
        for (String sellerInfo : sellerInfos) {
            String user[] = sellerInfo.split(":");
            userLoginsForSeller.put(user[0], user[1]);
        }
    }

    public boolean login(String name, String password, String user) {
        if(user.equals("Buyer")){
            if (userLoginsForBuyer.containsKey(name) && userLoginsForBuyer.get(name).equals(password)) {
                return true;
            }
            else {
                return false;
            }
        } else if (user.equals("Buyer")) {
            if (userLoginsForSeller.containsKey(name) && userLoginsForSeller.get(name).equals(password)) {
                return true;
            }
            else {
                return false;
            }
        }

        return false;
    }
}
