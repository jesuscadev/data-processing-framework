package com.jesuscadev.dpf.core;

import com.jesuscadev.dpf.data.DataSet;

import java.io.IOException;
import java.sql.SQLException;

public interface Publisher {
	void publishData(DataSet dataSet) throws IOException, SQLException, ClassNotFoundException;
}
