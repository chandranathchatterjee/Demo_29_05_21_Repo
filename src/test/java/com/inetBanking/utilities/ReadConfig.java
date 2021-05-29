package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties prop;

    public ReadConfig() {
        File src=new File("./Config/config.properties");
        try{
            FileInputStream fis= new FileInputStream(src);
            prop= new Properties();
            prop.load(fis);
        }
        catch (Exception e) {
            System.out.println("Exception is : "+e.getMessage());
        }
    }
    public String getApplicationURL(){
        String url=prop.getProperty("baseURL");
        return url;
    }
    public String getUserName(){
        String username=prop.getProperty("username");
        return username;
    }
    public String getPassword(){
        String password=prop.getProperty("password");
        return password;
    }
    public String getChromePath(){
        String cpath=prop.getProperty("chromepath");
        return cpath;
    }

    public String getFirefoxPath(){
        String fpath=prop.getProperty("firefoxpath");
        return fpath;
    }
    public String getIEpath(){
        String ipath=prop.getProperty("IEpath");
        return ipath;
    }


}
