package bankuti.robert.vault;

import config.Configuration;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public final class DataBaseInit {
    static void executeScriptUsingStatement() throws IOException, SQLException {
        String scriptFilePath = "src/main/resources/init.sql";
        BufferedReader reader = null;
        Connection con = null;
        Statement statement = null;
        try {
            // load driver class for mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create connection
            con = DriverManager.getConnection(
                Configuration.Database.url,
                Configuration.Database.username,
                Configuration.Database.password
            );
            
            if(con != null) {
                // create statement object
                statement = con.createStatement();
                // initialize file reader
                reader = new BufferedReader(new FileReader(scriptFilePath));
                String line;
                // read script line by line
                while ((line = reader.readLine()) != null) {
                    // execute query
                    statement.execute(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}