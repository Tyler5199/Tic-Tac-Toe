package project_2final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;



public class View extends JPanel implements ActionListener
{
    private Model model;
    private JButton squares[][];
    private JLabel resultLabel;
    
    public View (Model model)
    {
        this.model = model;
        int width = model.getWidth();
        squares = new JButton [width][width];
        JPanel squaresPanel = new JPanel(new GridLayout(width+1, width+1));
        
    
    for (int row = 0; row < width; row++)
    {
        for (int col = 0; col < width; col++)
        {
            squares[row][col] = new JButton();
            squares[row][col].addActionListener(this);
            squares[row][col].setName("Square" + row + col);
            squares[row][col].setPreferredSize(new Dimension(64,64));
            squaresPanel.add(squares[row][col]);
        }
    }
    
    resultLabel = new JLabel();
    resultLabel.setName("ResultLabel");
    resultLabel.setText("Welcome to Tic-Tac-Toe!");
    squaresPanel.add(resultLabel);
    add(squaresPanel);

    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
      String button = ((JButton) e.getSource()).getName();
      int row = button.charAt(6) - 48;
      int col = button.charAt(7) -48;
      
      model.makeMark(row, col);
      JButton click = (JButton) e.getSource();
      click.setText(model.getMark(row, col).toString());
        
        
    }
    
}

