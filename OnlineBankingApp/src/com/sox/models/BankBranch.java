package com.sox.models;

import java.io.Serializable;

public class BankBranch implements Cloneable, Serializable {
    private int bankBranchId;
    private String name;
    private String location;
    private String description;

    public BankBranch(int bankBranchIdIn) {
        this.bankBranchId = bankBranchIdIn;
    }

    public int getBankBranchId() {
        return this.bankBranchId;
    }

    public void setBankBranchId(int bankBranchIdIn) {
        this.bankBranchId = bankBranchIdIn;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String nameIn) {
        this.name = nameIn;
    }

    public String getLocation() {
        return this.location;
    }

    public String getDescription() {
        return this.description;
    }

    public void setLocation(String locationIn) {
        this.location = locationIn;
    }


    public void setDescription(String descriptionIn) {
        this.description = descriptionIn;
    }

    //Set all
    public void setAll(int bankBranchIdIn, String nameIn, String locationIn, String descriptionIn) {
        this.bankBranchId = bankBranchIdIn;
        this.name = nameIn;
        this.location = locationIn;
        this.description = descriptionIn;
    }

    public boolean hasEqualMapping(BankBranch valueObject) {

        if (valueObject.getBankBranchId() != this.bankBranchId) {
            return false;
        }

        if (name == null) {
            if (valueObject.getName() != null)
                return false;
        } else if (!this.name.equals(valueObject.getName())) {
            return false;
        }

        if (location == null) {
            if (valueObject.getLocation() != null)
                return false;
        } else if (!this.location.equals(valueObject.getLocation())) {
            return false;
        }

        if (description == null) {
            if (valueObject.getDescription() != null)
                return false;
        } else if (!this.description.equals(valueObject.getDescription())) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass BankBranch, mapping to table bank_branch\n");
        out.append("Persistent attributes: \n");
        out.append("bank_branch_id = " + this.bankBranchId + "\n");
        out.append("name = " + this.name + "\n");
        out.append("location = " + this.location + "\n");
        out.append("description = " + this.description + "\n");
        return out.toString();
    }

    //Cloned
    public Object clone() {
        BankBranch cloned = new BankBranch(2);
        cloned.setBankBranchId(this.bankBranchId);

        if (this.name != null)
            cloned.setName(this.name);
        if (this.location != null)
            cloned.setLocation(this.location);
        if (this.description != null)
            cloned.setDescription(this.description);
        return cloned;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }
}
