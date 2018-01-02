package javaa;
import java.util.Random;

public class miniLibrary {

    public static int generateID(String type){
        Random rand = new Random();
        int id = 0;
        if (type == "customer")
        {
            for(int i = 0 ; i < 5 ; i++)
            {
                id = (id *10) + rand.nextInt(9) + 1;

            }
        }
        else if (type == "employee")
        {
            for(int i = 0 ; i < 6 ; i++)
            {
                id = (id*10) + rand.nextInt(9) + 1;
            }

        }
        else if (type == "item")
        {
            for(int i = 0 ; i < 4 ;i++ )
            {
                id = (id*10) + rand.nextInt(9) + 1;
            }
        }
        else if (type == "payment")
        {
            for(int i = 0 ; i < 7 ; i++)
            {
                id = (id*10) + rand.nextInt(9) + 1;
            }
        }
        else if (type == "shipment")
        {
            for(int i = 0 ; i < 9 ; i++)
            {
                id = (id*10) + rand.nextInt(9) + 1;
            }
        }

        return id;
    }
}


