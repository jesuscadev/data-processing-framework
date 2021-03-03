package jesuscadev.dpf.core;

import jesuscadev.dpf.data.DataSet;

import java.io.IOException;
import java.sql.SQLException;

public interface Reader {
	void readData(DataSet dataSet) throws IOException, SQLException, ClassNotFoundException;
}


