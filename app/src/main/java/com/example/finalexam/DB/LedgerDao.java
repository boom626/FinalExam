package com.example.finalexam.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LedgerDao {
    @Query("SELECT * FROM ledger")
    List<LedgerItem> getAll();

    //    @Query("SELECT * FROM ledger where Username = :Username")
//    List<LedgerItem> getUser(String Username);
//
//    @Query("SELECT * FROM ledger where Fullname = :Fullname")
//    List<LedgerItem> getFullname(String Fullname);
//
//    @Query("SELECT * FROM ledger where Pass = :Pass")
//    List<LedgerItem> getPass(String Pass);

    @Insert
    void insert(LedgerItem ledgerItem);
}


