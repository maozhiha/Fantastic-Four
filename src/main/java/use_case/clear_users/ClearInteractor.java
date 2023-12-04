package use_case.clear_users;

public class ClearInteractor implements ClearInputBoundary {
    private ClearUserDataAccessInterface dataAccess;
    private ClearOutputBoundary outputBoundary;

    public ClearInteractor(ClearUserDataAccessInterface dataAccess, ClearOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void clearUsers(ClearInputData inputData) {
        String result = dataAccess.clearAllUsers();
        ClearOutputData outputData = new ClearOutputData();

        outputData.setMessage(result);

        outputBoundary.receiveClearResult(outputData);
    }
}
