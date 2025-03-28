package Design.Singleton.DatabaseSingleton;

import java.util.ArrayList;

public class ConnectionPoolImpl implements ConnectionPool{


    private static int max;
    private static ConnectionPoolImpl INSTANCE=null;

    private ArrayList<DatabaseConnection> databaseConnectionsPool=new ArrayList<>();

    private ConnectionPoolImpl(int max){
        this.max=max;
        initializePool();
    }
    /**
     * this method is used to create database pool
     */
    @Override
    public void initializePool() {
        for(int i=0;i<max;i++){
            databaseConnectionsPool.add(new DatabaseConnection(i,true));
        }
    }

    public static ConnectionPoolImpl getInstance(){
        if(INSTANCE!=null){
            return INSTANCE;
        }
        else{
            INSTANCE=new ConnectionPoolImpl(max);
        }
        return INSTANCE;
    }

    public static void releaseInstance(){
        INSTANCE=null;
    }


    /**
     * @return Database available Connection
     */
    @Override
    public DatabaseConnection getConnection() {
        if(databaseConnectionsPool == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < max; i++) {
            if (databaseConnectionsPool.get(i).isAvailable == true) {
                databaseConnectionsPool.set(i, new DatabaseConnection(i, false));
                return databaseConnectionsPool.get(i);
            }
        }
        return null;
    }

    /**
     * @param connection
     * release the connection and add into available pool
     */
    @Override
    public void releaseConnection(DatabaseConnection connection) {
        if(databaseConnectionsPool == null) {
            throw new NullPointerException();
        }
        databaseConnectionsPool.set(connection.id, new DatabaseConnection(connection.id, true));
    }

    /**
     * @return available database connection count
     */
    @Override
    public int getAvailableConnectionsCount() {
        if(databaseConnectionsPool == null) {
            throw new NullPointerException();
        }
        int count=0;
        for (int i = 0; i < max; i++) {
            if (databaseConnectionsPool.get(i).isAvailable == true) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return total database count
     */
    @Override
    public int getTotalConnectionsCount() {
        return databaseConnectionsPool.size();
    }
}
