package com.springapp.mvc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "phoneBook")
public class PhoneBook {

    private String name;
    private String lastName;
    private String patronymicName;
    private String cellPhoneNum;
    private String officePhoneNum;
    private String homePhoneNum;
    @Id @GeneratedValue private long id;

   /*getters & setters*/
    public long getId() {
          return id;
      }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhoneNum() {
        return cellPhoneNum;
    }
    public void setCellPhoneNum(String cellPhoneNum) {
        this.cellPhoneNum = cellPhoneNum;
    }

    public String getPatronymicName() {
        return patronymicName;
    }
    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getOfficePhoneNum() {
        return officePhoneNum;
    }
    public void setOfficePhoneNum(String officePhoneNum) {
        this.officePhoneNum = officePhoneNum;
    }

    public String getHomePhoneNum() {
        return homePhoneNum;
    }
    public void setHomePhoneNum(String homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
    }

}
