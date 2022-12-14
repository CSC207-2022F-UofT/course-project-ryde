package interface_adapters.user_register;

import use_cases.user_register.UserRegisterDsGateway;
import use_cases.user_register.UserRegisterDsRequestModel;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class to read users and store them in a hashmap, then add new user to the hashmap and create a new database
 * with the new user.
 */
public class FileUser implements UserRegisterDsGateway {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, UserRegisterDsRequestModel> accounts = new HashMap<>();

    /**
     * @param csvPath for this application this will be the users.csv file where all the user accounts are stored
     * This reads the csv file and stores all the users in accounts
     */
    public FileUser(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("email", 0);
        headers.put("password", 1);
        headers.put("name", 2);
        headers.put("creation_time", 3);
        headers.put("listings", 4);
        headers.put("location", 5);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String email = String.valueOf(col[headers.get("email")]);
                String password = String.valueOf(col[headers.get("password")]);
                String name = String.valueOf(col[headers.get("name")]);
                String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                String location = String.valueOf(col[headers.get("location")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                UserRegisterDsRequestModel user = new UserRegisterDsRequestModel(email, name, password, ldt, location);
                accounts.put(email, user);
            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(UserRegisterDsRequestModel requestModel) {
        accounts.put(requestModel.getEmail(), requestModel);
        this.save();
    }

    /**
     * Rewrites the csv file but this time with the new user account added
     */
    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (UserRegisterDsRequestModel user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s",
                        user.getEmail(),
                        user.getPassword(),
                        user.getName(),
                        user.getCreationTime(),
                        "",
                        user.getLocation());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new UserCreationFailed(e.getMessage());
        }
    }

    /**
     * @param identifier email that the user has input
     * @return whether a user with the same email already exists in the database
     */
    @Override
    public boolean existsByEmail(String identifier) {
        return accounts.containsKey(identifier);
    }

}
