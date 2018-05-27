package config;

/**
 * NOT USE
 * Create a new Configuration class in config package. After it, copy this content and edit to valid data.
 */
public final class ConfigurationExample {
    public final static class Database {
        public final static String username = "username"; // need edit
        public final static String password = "password"; // need edit
        public final static String driver  = "com.mysql.cj.jdbc.Driver";
        public final static String url = "jdbc:mysql://localhost:3306/dbname"; // need edit
        public final static String sqlFile = "src/main/resources/init.sql";
    }
}
