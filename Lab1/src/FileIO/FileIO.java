/**
 *
 * @author Plankton
 */

package FileIO;

import java.io.*;
public class FileIO
{
    static File file1;
    static File file2;
    static BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws Exception
    {
	int choice=0;
	while(true)
	{
            System.out.println("MENU");
            System.out.println("1. Write to a file");
            System.out.println("2. Read from a file");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");
            choice=Integer.parseInt(in.readLine());
            switch(choice)
            {
                case 1: writeTo();
                break;
                case 2: readFrom();
                break;
                case 3: System.exit(0);
            }
        }
    }
	static void writeTo()throws Exception
	{
            System.out.println("Enter filename: ");
            file1=new File(in.readLine());
            System.out.println("Enter data to write: ");
            String data=in.readLine();
            FileWriter fw=new FileWriter(file1, true);
            fw.write(data, 0, data.length());
            fw.close();
	}
	static void readFrom()throws Exception
	{
            System.out.println("Enter filename: ");
            file1=new File(in.readLine());
            try (FileInputStream fis = new FileInputStream(file1)) 
            {
                int x=0;
                while(true)
                {
                    x=fis.read();
                    if(x==-1)
                        break;
                    else
                        System.out.print(""+(char)x);
                }
                System.out.println("\n");
            }
	}
}