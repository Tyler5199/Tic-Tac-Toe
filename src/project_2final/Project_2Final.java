package project_2final;

import javax.swing.JFrame;

public class Project_2Final
{

    public static void main(String[] args)
    {

        Model m = new Model (3);    
        View view = new View(m);
        JFrame win = new JFrame("Tic-Tac-Toe");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.add(view);
        win.setVisible(true);
        win.pack();
       
    };
        
}
    
   
