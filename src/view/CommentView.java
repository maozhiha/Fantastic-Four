package view;

import entity.Comment.Comment;
import entity.Comment.Comments;
import interface_adapter.comment.CommentController;
import interface_adapter.comment.CommentState;
import interface_adapter.comment.CommentViewModel;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CommentView extends JPanel implements PropertyChangeListener {


    public final String viewName = "Comment View";

    private final CommentController commentController;
    private final CommentViewModel commentViewModel;


    private JTextPane commentPane;

    public CommentView(CommentController commentController, CommentViewModel commentViewModel) {
        this.commentController = commentController;
        this.commentViewModel = commentViewModel;
        this.commentViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Comment");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);

        JPanel commentViewAndEditPanel = new JPanel();
        commentViewAndEditPanel.setLayout(new BoxLayout(commentViewAndEditPanel, BoxLayout.Y_AXIS));
        commentPane = new JTextPane();
        commentPane.setEditable(false);
        JScrollPane commentScrollPane = new JScrollPane(commentPane);
        commentViewAndEditPanel.add(commentScrollPane);
        JTextField commentEditorField = new JTextField();
        commentEditorField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 600));
        commentViewAndEditPanel.add(commentEditorField);
        this.add(commentViewAndEditPanel, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton comment = new JButton("Comment");
        JButton backButton = new JButton("Back");
        buttons.add(comment);
        buttons.add(backButton);

        this.add(buttons, BorderLayout.SOUTH);

        comment.addActionListener(actionEvent -> {
            String commentText = commentEditorField.getText();
            CommentState commentState = commentViewModel.getState();
            commentController.addNewComment(commentState.getComments(), "SAM_SMITH", commentText);
            commentEditorField.setText("");
        });

        backButton.addActionListener(actionEvent -> {
            commentController.goBackToRecipeList();
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        CommentState state = (CommentState) propertyChangeEvent.getNewValue();
        Comments comments = state.getComments();

        String commentString = buildCommentString(comments.getComments());
        commentPane.setText(commentString);
    }

    private String buildCommentString(List<Comment> Comments) {
        StringBuilder commentString = new StringBuilder();
        for (Comment comment : Comments) {
            commentString.append(comment.getUser()).append(": ").append(comment.getComment()).append("\n");
        }
        return commentString.toString();
    }
}
