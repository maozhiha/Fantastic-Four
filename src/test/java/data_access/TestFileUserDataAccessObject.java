package data_access;

import entity.CommonUserFactory;
import entity.UserFactory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestFileUserDataAccessObject {

    @Test
    public void testCreateCsv() throws IOException {
        File csvFile = new File("test_user.csv");

        UserFactory userFactory = new CommonUserFactory();

        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("test_user.csv", userFactory);


        // Assert that the file exists.
        assert csvFile.exists();

        // Delete the file after the test is done.
        csvFile.delete();
    }

    @Test
    public void testSaveUser() throws IOException {
        File csvFile = new File("test_user.csv");

        UserFactory userFactory = new CommonUserFactory();

        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("test_user.csv", userFactory);

        fileUserDataAccessObject.save(userFactory.create("test", "test", null));

        // Assert that the file exists.
        assert csvFile.exists();

        // Delete the file after the test is done.
        csvFile.delete();
    }

    @Test
    public void testGetUser() throws IOException {
        File csvFile = new File("test_user.csv");

        UserFactory userFactory = new CommonUserFactory();

        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("test_user.csv", userFactory);

        fileUserDataAccessObject.save(userFactory.create("test", "test", null));

        fileUserDataAccessObject.get("test");

        // Assert that the file exists.
        assert csvFile.exists();

        // Delete the file after the test is done.
        csvFile.delete();
    }

    @Test
    public void testClearAllUser() throws IOException {
        File csvFile = new File("test_user.csv");

        UserFactory userFactory = new CommonUserFactory();

        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("test_user.csv", userFactory);

        fileUserDataAccessObject.save(userFactory.create("test", "test", null));

        fileUserDataAccessObject.clearAllUsers();

        // Assert that the file exists.
        assert csvFile.exists();

        // Delete the file after the test is done.
        csvFile.delete();
    }

    @Test
    public void testCheckExistsUser() throws IOException {
        File csvFile = new File("test_user.csv");

        UserFactory userFactory = new CommonUserFactory();

        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("test_user.csv", userFactory);

        fileUserDataAccessObject.save(userFactory.create("test", "test", null));

        fileUserDataAccessObject.existsByName("test");

        // Assert that the file exists.
        assert csvFile.exists();

        // Delete the file after the test is done.
        csvFile.delete();
    }
}
