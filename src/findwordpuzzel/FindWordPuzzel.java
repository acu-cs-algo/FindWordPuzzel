
package findwordpuzzel;
import java.util.Scanner; 
import java.io.*;

public class FindWordPuzzel {

    private int rows;
    private int cols;
    private int words;
    private char[][] wordSearchchar;
    private String[] wordSearchstring;
    
    public FindWordPuzzel()
    {   		
    }
    
    public int addX(int x, int ax)
    {
    	x = x + ax;
	if(x < 0) x = rows - 1;
	if(x >= rows) x = 0;
	return x;
    }

    public int addY(int y, int ay)
    {
	y = y + ay;
	if(y < 0) y = cols - 1;
	if(y >= cols) y = 0;
	return y;
    }

    public boolean testdirect(int x, int y, int d,String word, int ax, int ay)
    {
	if(d == word.length()) return true;
	if(wordSearchchar[x][y] == word.charAt(d))
	{
		return testdirect(addX(x, ax), addY(y, ay), d+1, word, ax, ay);
	}
	return false;
    }

    public void wordFind()
    {
	for(int d = 0; d < words; d++)
	{
            String word = wordSearchstring[d];
            boolean foundWord = false;
            for(int i = 0; i < rows; i++)
            {
		if(foundWord == true)
		{
                    break;
		}
		for(int j = 0; j < cols; j++)
		{
                    if(wordSearchchar[i][j] == word.charAt(0))
                    {
			if(testdirect(i, j, 0, word, 1, 0) == true)
			{
                            System.out.println(i + " " + j);
                            foundWord = true;
			}
			else if(testdirect(i, j, 0, word, -1, 0) == true)
			{
                            System.out.println(i + " " + j);
                            foundWord = true;
			}
			else if(testdirect(i, j, 0, word, 0, 1) == true)
			{
                            System.out.println(i + " " + j);
                            foundWord = true;
			} 
			else if(testdirect(i, j, 0, word, 0, -1) == true)
			{
                            System.out.println(i + " " + j);				
                            foundWord = true;
			} 
			else if(testdirect(i, j, 0, word, 1, 1) == true)
			{
                            System.out.println(i + " " + j);
                            foundWord = true;
			}
			else if(testdirect(i, j, 0, word, -1, -1) == true)
			{ 
                            System.out.println(i + " " + j);
                            foundWord = true;
			}			
			else if(testdirect(i, j, 0, word, -1, 1) == true)
			{
                            System.out.println(i + " " + j);
                            foundWord = true;
			}
			else if(testdirect(i, j, 0, word, 1, -1) == true)
			{
                            System.out.println(i + " " + j);
                            foundWord = true;
			}
                    }
		}
            }

            if(foundWord == false)
            {
		System.out.println("NOT FOUND");
            }
        }
    }

    public void readWordSearch()
    {
        String inputLine;
	Scanner fileInput;
	File inFile = new File("input.txt");
		
	try
	{
            fileInput = new Scanner(inFile);

            rows = fileInput.nextInt();
            cols = fileInput.nextInt();
            wordSearchchar = new char[rows][cols];

            fileInput.nextLine();
        
            for(int i = 0; i < rows; i++)
            {
                inputLine = fileInput.nextLine();
                for(int j = 0; j < cols; j++)
                {
                    wordSearchchar[i][j] = inputLine.charAt(j);
                }
            }   

            words = fileInput.nextInt();
            wordSearchstring = new String[words];

        	
            fileInput.nextLine();
            for(int i = 0; i < words; i++)
            {
                wordSearchstring[i] = fileInput.nextLine();
            }   
            fileInput.close();

        }
	catch (FileNotFoundException e)
	{
            System.out.println(e);
            System.exit(1);		
	} 
    }
    
    public void printWordSearch()
    {
	for (int i = 0; i < rows; i++) 
	{
            for (int j = 0; j < cols; j++) 
            {
		System.out.print(wordSearchchar[i][j]);
            }
            System.out.println();
        }
		
	for(int i = 0;i < words; i++)
	{
            System.out.print(wordSearchstring[i]);
            System.out.println();
	}
    }
    
    public static void main (String [] args)
    {
		
        FindWordPuzzel findWordPuzzel = new FindWordPuzzel();

	findWordPuzzel.readWordSearch();

	findWordPuzzel.wordFind();

    }

}
