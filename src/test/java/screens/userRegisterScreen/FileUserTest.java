package screens.userRegisterScreen;

import intefaceAdapters.userRegister.FileUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import useCases.userRegister.UserRegisterDsGateway;
import useCases.userRegister.UserRegisterDsRequestModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileUserTest {
    UserRegisterDsGateway user;

    @BeforeEach
    void setUp() {
        try {
            user = new FileUser("./test_users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
    }

    @AfterEach
    void tearDown(){
    }

    /**
     * tests that save correctly saves a new user in the database. For testing we use the test_users.csv.
     */
    @Test
    void save() throws IOException {
        UserRegisterDsRequestModel requestModel = new UserRegisterDsRequestModel(
                "ryan@gmail.com", "ryan", "password",
                LocalDateTime.now(), "", "M5S1J4");
        user.save(requestModel);
        assertTrue(user.existsByEmail("ryan@gmail.com"));

//        resets the test_users.csv file since it was changed
        File csvFile = new File("./test_users.csv");
        Map<String, Integer> headers = new LinkedHashMap<>();

        headers.put("email", 0);
        headers.put("password", 1);
        headers.put("name", 2);
        headers.put("creation_time", 3);
        headers.put("listings", 4);
        headers.put("location", 5);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter(csvFile));
        writer.write(String.join(",", headers.keySet()));
        writer.newLine();
        String line = "manav@gmail.com,password,manav,2022-11-04T23:35:18.475716500,,null";
        writer.write(line);
        writer.newLine();
        writer.close();
    }

    @Test
    void existsByEmail(){
        System.out.println(user);
        assertTrue(user.existsByEmail("manav@gmail.com"));
    }
}