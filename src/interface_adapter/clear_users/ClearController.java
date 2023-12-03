package interface_adapter.clear_users;

import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInputData;

public class ClearController {
    final ClearInputBoundary clearInputBoundary;
    public ClearController(ClearInputBoundary clearinteractor){
        this.clearInputBoundary = clearinteractor;
    }
    // Clears all user data
    public boolean clearAllUsers() {
        ClearInputData clearInputData = new ClearInputData();
        clearInputBoundary.clearUsers(clearInputData);

        return true; // Assuming the operation is always successful for simplicity.
    }
}
