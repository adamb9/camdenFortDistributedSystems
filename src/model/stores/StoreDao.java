package model.stores;
import java.util.List;

//This is the interface for the all of the data stores.
//It only contains a list of DataStore objects.
//The only function it needs is to add a new store.
//It is also part of the Data Access Object design pattern.

public interface StoreDao {
    public List<DataStore> getAllStores();
    public void addStore(DataStore store);
}
