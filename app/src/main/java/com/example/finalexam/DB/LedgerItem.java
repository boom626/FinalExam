package com.example.finalexam.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "ledger")
public class LedgerItem {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "fullName")
    public String fullName;
    @ColumnInfo(name = "username")
    public String username;
    @ColumnInfo(name = "password")
    public String password;

    public LedgerItem(int id, String fullName, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

//@Entity(tableName = "ledger")
//public class LedgerItem {
//    @PrimaryKey(autoGenerate = true)
//    public int id;
//
//    @ColumnInfo(name = "fullName")
//    public String fullName;
//
//    @ColumnInfo(name = "Username")
//    public String Username;
//
//    @ColumnInfo(name = "Pass")
//    public String Pass;
//
//
//
//    public LedgerItem(int id, String fullName, String User, String pass) {
//        this.id = id;
//        this.fullName = fullName;
//        this.Username = User;
//        this.Pass = pass;
//    }

//    public boolean lookuserLedgerItem( String User ) {
//        if(this.Username.equals(User)){
//        return true;
//        }
//        return false;
//    }
//    public boolean lookpassLedgerItem( String Pass) {
//        if(Pass.equals(this.Pass)){
//            return true;
//        }
//        return false;
//    }
}
