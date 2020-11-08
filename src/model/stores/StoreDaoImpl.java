package model.stores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//This class is the implementation of the StoreDao interface.
//It has a list of DataStore objects which you can add to.
//It is part of the Data Access Object design pattern

//This class also uses the Singleton design pattern
//This is done by allowing only one instance of the class to be made and for it to be accessible by getting the one instance using getInstance().

public class StoreDaoImpl implements StoreDao, Serializable {
    public List<DataStore> stores;

    private static StoreDaoImpl instance = new StoreDaoImpl();


    private StoreDaoImpl(){
        stores = new ArrayList<DataStore>();
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
