package app;

import data_access.CommentFileDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentController;
import interface_adapter.comment.CommentPresenter;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import use_case.comment.CommentInputBoundary;
import use_case.comment.CommentInteractor;
import use_case.comment.CommentOutputBoundary;
import view.CommentView;
import view.LoggedInView;

public class CommentUseCaseFactory {

    private CommentUseCaseFactory() {
    }

    public static CommentView create(ViewManagerModel viewManagerModel, RecipeDetailViewModel recipeDetailViewModel, CommentViewModel commentViewModel, LoggedInViewModel loggedInViewModel,  CommentFileDataAccessObject commentFileDataAccessObject) {
        CommentController commentController = createCommentController(viewManagerModel, recipeDetailViewModel, commentViewModel, commentFileDataAccessObject);

        return new CommentView(commentController, commentViewModel, loggedInViewModel);
    }

    private static CommentController createCommentController(ViewManagerModel viewManagerModel, RecipeDetailViewModel recipeDetailViewModel, CommentViewModel commentViewModel, CommentFileDataAccessObject commentFileDataAccessObject){
        CommentOutputBoundary commentOutputBoundary = new CommentPresenter(viewManagerModel, recipeDetailViewModel, commentViewModel);
        CommentInputBoundary commentInputBoundary = new CommentInteractor(commentOutputBoundary, commentFileDataAccessObject);

        return new CommentController(commentInputBoundary);
    }
}
