package com.inetBanking.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Date;

public class TC_Demo_DBTestData {
    String dbUrl="jdbc:mysql://localhost:3306/chandra_test?user=root&password=mysql";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;


    @Test(dataProvider = "PublicationData")
    public void setPublicationData(int id, String type, String title, Date date){
        System.out.print(id);
        System.out.print(" ");
        System.out.print(type);
        System.out.print(" ");
        System.out.print(title);
        System.out.print(" ");
        System.out.print(date);
        System.out.print(" ");
        System.out.println();
    }


    @DataProvider(name="PublicationData")
    public Object[][] pubData(){
        int rowCount= 0,colCount=0;
        try {
            conn= DriverManager.getConnection(dbUrl);
            stmt = conn.createStatement();
            rs=stmt.executeQuery("select * from pub");
            if(rs.next()){
                rowCount = rs.getRow();
                colCount= rs.getMetaData().getColumnCount();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[][] pubdata = new Object[rowCount][colCount];
        int rowNum=0;
        try {
            while(rs.next()){

                for(int i =0;i<colCount;i++){
                    pubdata[rowNum][i]=rs.getObject(i+1);
                }
                rowNum++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pubdata;
    }

}
