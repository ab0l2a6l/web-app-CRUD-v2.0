package common;

import java.io.IOException;
import java.sql.SQLException;

public class WrapperClass extends Exception{
    public int get(Exception e){
        e.printStackTrace();
        if (e instanceof IOException)
            return 700;
        else if (e instanceof SQLException)
            return 701;
        else
            return 800;
    }
}
