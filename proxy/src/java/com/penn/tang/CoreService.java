package com.penn.tang;

import java.sql.SQLException;

public interface CoreService {

    @Transaction
    void insertCategorie() throws SQLException;


}
