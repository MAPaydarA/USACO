/*
ID: ****
PROG: gift1
LANG: JAVA
*/
import java.io.*;
import java.util.Scanner;
public class gift1 
{
     public static void main(String[] args) throws FileNotFoundException, IOException
     {      
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        String memberNum, giftMoney, reciverNum, giver, temp;
        int memberNum1, giftMoney1, reciverNum1, index = 0;
        String memberList[];
        int memberMoney [];
        memberNum = f.readLine();
        memberNum1 = Integer.parseInt(memberNum);
        memberList = new String[memberNum1];
        memberMoney = new int[memberNum1];
        for (int i = 0; i < memberNum1; i++) 
        {
            memberList[i] = f.readLine();
            memberMoney[i] = 0;
        }  
        while(f.ready())
        {
            giver = f.readLine();
            temp = f.readLine();
            for (int i = 0; i < temp.length(); i++) 
            {
                if(temp.charAt(i) == ' ')
                 index = i;
            }
            giftMoney = temp.substring(0, index);
            reciverNum = temp.substring(index + 1, temp.length());
            giftMoney1 = Integer.parseInt(giftMoney);
            reciverNum1 = Integer.parseInt(reciverNum);
            String reciverList[] = new String [reciverNum1]; 
            int n = 0;
            while (n < reciverNum1 && reciverNum1 != 0)
            {
		reciverList[n] = f.readLine(); 
                n++;
            }
	    if(reciverNum1 == 0)
                continue;
	    else
            {
                if(giftMoney1 == 0)
                    continue;
                else
                {
                    for (int i = 0; i < memberNum1; i++)
		    {
                        if (giver.equals(memberList[i]))
			{
                            int rest = giftMoney1 / reciverNum1;
                            memberMoney[i] = memberMoney[i] - (reciverNum1 * rest);
			}
		    }
                    for (int j = 0; j < reciverNum1; j++)
                    {
			for (int k = 0; k < memberNum1; k++)
			{
                            if (reciverList[j].equals(memberList[k]))
                            {
				memberMoney[k] += giftMoney1 / reciverNum1;
                            }
			}
                    }
                }
            }
        } 
        for (int k = 0; k < memberNum1; k++) 
        {
            temp = memberMoney[k] + "";
            out.write(memberList[k]);
            out.write(" ");
            out.write(temp);
            out.write("\n");
        }
        out.close();
        System.exit(0); 
    }
}
