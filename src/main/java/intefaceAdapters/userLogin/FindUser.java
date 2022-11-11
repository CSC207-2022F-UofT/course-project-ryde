package intefaceAdapters.userLogin;

import useCases.userLogin.UserLoginDsGateway;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindUser implements UserLoginDsGateway {
    private final Map<String, String> emailToPassword = new HashMap<>();


    public FindUser(String csvPath) throws IOException {
        File csvFile = new File(csvPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("email", 0);
        headers.put("password", 1);
        headers.put("name", 2);
        mapEmailToPassword(csvFile, headers);
    }

    private void mapEmailToPassword(File csvFile, Map<String, Integer> headers) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header

        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            String email = String.valueOf(col[headers.get("email")]);
            String password = String.valueOf(col[headers.get("password")]);
            emailToPassword.put(email,password);
        }

        reader.close();
    }

    @Override
    public boolean validLogin(String email, String password){
        boolean correctEmail = emailToPassword.containsKey(email);
        boolean correctPassword = password.equals(emailToPassword.get(email));
        return correctPassword && correctEmail;
    }
}
