import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.EmployeeProfile;

public class EmployeeeProfileTest {
    @Test
    public void testUserName(){
EmployeeProfile profile=
new EmployeeProfile(1, "Raj", 
"Raj@capgemini.com");
assertEquals("RAJ", profile.extractUserNameFromEmail());
    }
}
