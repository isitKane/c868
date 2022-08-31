package controller;

import DAO.DBUsers;
import Database.DBConnection;
import model.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.sql.SQLException;

/**
 * The type Login screen controller test.
 */
class LoginScreenControllerTest {
    @Mock
    private DBConnection dbConnection;
    @Mock
    private DBUsers dbUsers;
    private Users users;
    private String username = "test";
    private String password = "test";

    /**
     * Sets up.
     *
     * @throws SQLException the sql exception
     */
    @BeforeEach
    void setUp() throws SQLException {
        DBConnection.openConnection();
        users = new Users(123, username, password);
        Boolean login = DBUsers.getUserLogin(username, password);
        if(login){
            System.out.println("Login successful!");
        }

    }

    /**
     * On action login.
     */
    @Test
    void onActionLogin() {
        Assertions.assertEquals(username, "test");
        Assertions.assertEquals(password, "test");

    }
}