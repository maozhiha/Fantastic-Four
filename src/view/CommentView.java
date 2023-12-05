package view;

import interface_adapter.comment.CommentController;
import interface_adapter.comment.CommentState;
import interface_adapter.comment.CommentViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CommentView extends JPanel implements PropertyChangeListener {


    public final String viewName = "Comment View";

    private final CommentController commentController;
    private final CommentViewModel commentViewModel;


    JTextPane commentPane;

    public CommentView(CommentController commentController, CommentViewModel commentViewModel) {
        this.commentController = commentController;
        this.commentViewModel = commentViewModel;
        this.commentViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Comment");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);

        commentPane = new JTextPane();
        commentPane.setEditable(false);
        JScrollPane commentScrollPane = new JScrollPane(commentPane);
        this.add(commentScrollPane, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton comment = new JButton("Comment");
        JButton backButton = new JButton("Back");
        buttons.add(comment);
        buttons.add(backButton);

        this.add(buttons, BorderLayout.SOUTH);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        CommentState state = (CommentState) propertyChangeEvent.getNewValue();

    }
}
