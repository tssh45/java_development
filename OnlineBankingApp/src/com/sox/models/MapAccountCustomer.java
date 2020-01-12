package com.sox.models;

public class MapAccountCustomer implements Cloneable{
    private int mapId;
    private int accountId;
    private int customerId;

    public MapAccountCustomer () {
    }

    public MapAccountCustomer (int maipIdIn) {
        this.mapId = maipIdIn;
    }

    public int getMapId() {
        return this.mapId;
    }

    public void setMapId(int mapIdIn) {
        this.mapId = mapIdIn;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountIdIn) {
        this.accountId = accountIdIn;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerIdIn) {
        this.customerId = customerIdIn;
    }

    public void setAll(int mapIdIn, int accountIdIn, int customerIdIn) {
        this.mapId = mapIdIn;
        this.accountId = accountIdIn;
        this.customerId = customerIdIn;
    }

    //Equal mapping
    public boolean hasEqualMapping(MapAccountCustomer valueObject) {

        if (valueObject.getMapId() != this.mapId) {
            return false;
        }
        if (valueObject.getAccountId() != this.accountId) {
            return false;
        }
        if (valueObject.getCustomerId() != this.customerId) {
            return false;
        }
        return true;
    }

    /**
     * toString will return String object representing the state of this
     * valueObject. This is useful during application development, and
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass MapAccountCustomer, mapping to table map_account_customer\n");
        out.append("Persistent attributes: \n");
        out.append("map_id = " + this.mapId + "\n");
        out.append("account_id = " + this.accountId + "\n");
        out.append("customer_id = " + this.customerId + "\n");
        return out.toString();
    }


    public Object clone() {
        MapAccountCustomer cloned = new MapAccountCustomer();

        cloned.setMapId(this.mapId);
        cloned.setAccountId(this.accountId);
        cloned.setCustomerId(this.customerId);

        return cloned;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    }



