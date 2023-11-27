package fantastticfour.src.main.java.interface_adapter.clear_users;

import fantastticfour.src.main.java.use_case.clear_users.ClearOutputBoundary;
import fantastticfour.src.main.java.use_case.clear_users.ClearOutputData;

public class ClearPresenter  implements ClearOutputBoundary {

    private final ClearViewModel clearViewModel;

    public ClearPresenter(ClearViewModel clearViewModel) {

        this.clearViewModel = clearViewModel;

    }



    @Override
    public void receiveClearResult(ClearOutputData outputData) {
        clearViewModel.setStatusMessage(outputData.getMessage());
    }
}
