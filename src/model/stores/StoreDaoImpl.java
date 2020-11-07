package model.stores;

import java.util.List;

public class StoreDaoImpl implements StoreDao{
    List<DataStore> stores;

    private static StoreDaoImpl instance = new StoreDaoImpl();


    private StoreDaoImpl(){
    }
    public static StoreDaoImpl getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("This is the StoreDaoImpl class");
    }



    @Override
    public List<DataStore> getAllStores() {
        return stores;
    }

    @Override
    public void addStore(DataStore store) {
        stores.add(store);
    }
}
