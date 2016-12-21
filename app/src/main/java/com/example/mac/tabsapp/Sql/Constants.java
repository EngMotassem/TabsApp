package com.example.mac.tabsapp.Sql;

/**
 * Created by mac on 10‏/12‏/2016.
 */

public class Constants {
    /*
  COLUMNS
   */
    static final String ROW_ID="id";
    static final String NAME="name";
    static final String CATEGORY="category";

    /*
    DB PROPERTIES
     */
    static final String DB_NAME="lv_DB";
    static final String TB_NAME="lv_TB";
    static final int DB_VERSION=1;

    /*
    TABLE CREATION STATEMENT
     */
    static final String CREATE_TB="CREATE TABLE lv_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL,category TEXT NOT NULL);";


    /*
    TABLE DELETION STMT
     */
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;

}
