package Design.Singleton.DatabaseSingleton;

public class DatabaseConnection {
    public int id;
    public boolean isAvailable;

    public DatabaseConnection(int id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
    }
}
