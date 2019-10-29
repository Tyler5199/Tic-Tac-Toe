package project_2final;

public class Model 
{
    private String[][] grid;
    private boolean player1;
    private int width;
    
    public Model(int width)
    {
        this.width = width;
        grid = new String[width][width];
        
        for (int row = 0; row < width; ++ row)
        {
            for (int col = 0; col < width; ++ col)
            {
                grid[row][col] = "";
            }
        }
    }
    
    private boolean isSquareMarked(int row, int col)
    {
        boolean marked = false;
        
        if (!grid[row][col].isEmpty())

        {
            marked = true;
        }
        
        return marked;
    }
    
    
    
    public boolean makeMark(int row, int col)
    {
        boolean mark = false;
        
        if (player1 && isSquareMarked(row, col) == false)
        {
            grid[row][col] = "X";
            System.out.println("X");
            player1 = false;
            mark = true;
        }
        
        else if (!player1 && isSquareMarked(row, col) == false)
        {
            grid[row][col] = "0";
            player1 = true;
            mark = true;
        }
        
        
        return mark;
    }
    
    public String getMark(int row, int col)
    {
        String mark = grid[row][col];
        
        return mark;
    }
    
    
    private boolean isSquareValid(int row, int col)
    {
        if ( row < width && col < width && row >= 0 && col >= 0)
        {
            return true;
        }
        
        else
        {
            return false;
        }
        
    }
    
    
    private boolean isMarkWin(String mark)
    {
        int count = 0;
        
        for (int col = 0; col < width; col++)
        {
            for (int row = 0; row < width; row++)
            {
               if (grid[col][row] == mark)
               {
                   ++count;
               }
               
               else
               {
                   count = 0;
               }
               
               if (count == width)
               {
                   return true;
               }
               
            }
            
            count = 0;
        }
        
        for (int row = 0; row < width; row++)
        {
            for (int col = 0; col < width; col++)
            {
                if (grid[row][col] == mark)
                {
                    ++count;
                }
                
                else
                {
                    count = 0;
                }
                
                if (count == width)
                {
                    return true;
                }
                
            }
            
            count = 0;
        }
        
        for (int row = 0; row < width; row++)
        {
            for (int col = 0; col < width; col++)
            {
                if (grid[row][col] == mark)
                {
                    for(int i = 0; i < width; i++)
                    {
                    if (grid[row + i][col + i] == mark || grid[row - i][col + i] == mark)
                    {
                        ++count;
                    }

                    else
                    {
                        count = 0;
                    }

                    if (count == width)
                    {
                        return true;
                    }

                    }
                  
                }
               
                count = 0;
            }  
            
        }

        return false;
    }
    
    private boolean isTie()
    {
        int count = 0;
        boolean win;
        
        for (int row = 0; row < width; row++)
        {
            for (int col = 0; col < width; col++)
            {
                if (isSquareMarked(row, col))
                {
                    ++count;
                }
            }
        }
        
        if (isMarkWin("X") == false && isMarkWin("O") == false)
        {
            win = false;
            
        }
        
        else
        {
            win = true;
        }
        
        if (count == (width * width) && win == false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String getResult()
    {
        String result;
        
        if (isMarkWin("X"))
        {
            result = "X WINS!";
        }
        else if (isMarkWin("O"))
        {
            result = "O WINS!";
        }
        else if (isTie())
        {
            result = "TIE!";
        }
        else
        {
            result = "NONE";
        }
        
        return result;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    
    
}
