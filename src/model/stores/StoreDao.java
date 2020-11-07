package model.stores;
import java.util.List;

public interface StoreDao {
    public List<DataStore> getAllStores();
    public void addStore(DataStore store);
}
