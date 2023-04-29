package aiss.gitlabminer.service;

import aiss.gitlabminer.service.UserService;
import aiss.gitlabminer.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService service;
    @Test
    @DisplayName("Get user by project id")
    void getUsersByProjectId() {
        String id = "20699";
        List<User> users = service.getUsersByProjectId(id);
        assertTrue(!users.isEmpty(), "list of users is empty");
        for(User p:users){
            System.out.println(p);
        }
    }
}