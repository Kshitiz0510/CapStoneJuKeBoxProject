import com.userLogins.UserLogin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserLoginTest {

    UserLogin userLogin=null;
        Connection con= null;
        Statement st=null;

        @Before
        public void setUp() throws SQLException {

            userLogin=new UserLogin();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails","root","root@123");
            st= con.createStatement();
        }
        @After
        public void tearDown() {
            userLogin=null;
        }
        @Test
        public void ExistingUserSuccess() throws SQLException
        {
            String email="Kshitiz@gmail.com";
            String pass="abcda";
            boolean flag=userLogin.ExistingUser(email,pass);
            assertFalse(flag);
        }
    }

