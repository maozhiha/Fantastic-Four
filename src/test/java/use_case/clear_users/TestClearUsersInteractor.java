package use_case.clear_users;

import org.junit.Test;

public class TestClearUsersInteractor {
    // Junit test to test ClearInteractor

    @Test
    public void testClearUsers() {
        // Test to clear all users
        ClearInteractor clearInteractor = new ClearInteractor(new ClearUserDataAccessInterface() {
            @Override
            public String clearAllUsers() {
                return "All users cleared";
            }
        }, new ClearOutputBoundary() {
            @Override
            public void receiveClearResult(ClearOutputData outputData) {
                assert(outputData.getMessage().equals("All users cleared"));
            }
        });
        clearInteractor.clearUsers(new ClearInputData());
    }
}
