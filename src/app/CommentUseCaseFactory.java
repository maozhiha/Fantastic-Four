package app;

import data_access.CommentFileDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentController;
import interface_adapter.comment.CommentPresenter;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import use_case.comment.CommentInputBoundary;
import use_case.comment.CommentInteractor;
import use_case.comment.CommentOutputBoundary;
import view.CommentView;

public class CommentUseCaseFactory {

    private CommentUseCaseFactory() {
    }

    public static CommentView create(ViewManagerModel viewManagerModel, RecipeListViewModel recipeListViewModel, CommentViewModel commentViewModel, CommentFileDataAccessObject commentFileDataAccessObject) {
        CommentController commentController = createCommentController(viewManagerModel, recipeListViewModel, commentViewModel, commentFileDataAccessObject);

        return new CommentView(commentController, commentViewModel);
    }

    private static CommentController createCommentController(ViewManagerModel viewManagerModel, RecipeListViewModel recipeListViewModel, CommentViewModel commentViewModel, CommentFileDataAccessObject commentFileDataAccessObject){
        CommentOutputBoundary commentOutputBoundary = new CommentPresenter(viewManagerModel, recipeListViewModel, commentViewModel);
        CommentInputBoundary commentInputBoundary = new CommentInteractor(commentOutputBoundary, commentFileDataAccessObject);

        return new CommentController(commentInputBoundary);
    }
}
