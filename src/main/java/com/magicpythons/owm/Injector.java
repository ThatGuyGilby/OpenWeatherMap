package com.magicpythons.owm;

import java.net.http.HttpResponse;

public class Injector {

    private ConnectionManager connectionManager;

    public Injector(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public DataTransferObject convertResponseToDTO(HttpResponse<String> response){
        DataTransferObject dto = new DataTransferObject();
        
        return null;
    }
}
