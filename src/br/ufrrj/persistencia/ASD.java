package br.ufrrj.persistencia;

/* 
* To change this template, choose Tools | Templates 
* and open the template in the editor. 
*/  
  
/* 
* Copyright 2004-2013 H2 Group. Multiple-Licensed under the H2 License, 
* Version 1.0, and under the Eclipse Public License, Version 1.0 
* (http://h2database.com/html/license.html). 
* Initial Developer: H2 Group 
*/  
  
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;  
import org.h2.tools.DeleteDbFiles;  
  
/** 
* A very simple class that shows how to load the driver, create a database, 
* create a table, and insert some data. 
*/  
public class ASD {  
  
    /** 
     * Called when ran from command line. 
     * 
     * @param args ignored 
     */  
    public static void main(String... args) throws Exception {  
        // delete the database named 'test' in the user home directory  
        DeleteDbFiles.execute("~", "test", true);  
  
        Class.forName("org.h2.Driver");  
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test");  
        Statement stat = conn.createStatement();  
  
        // this line would initialize the database  
        // from the SQL script file 'init.sql'  
        // stat.execute("runscript from 'init.sql'");  
  
        stat.execute("create table test(id int primary key, name varchar(255))");  
        stat.execute("insert into test values(1, 'Hello')");  
        ResultSet rs;  
        rs = stat.executeQuery("select * from test");  
        while (rs.next()) {  
            System.out.println(rs.getString("name"));  
        }  
        stat.close();  
        conn.close();  
    }  
  
}  