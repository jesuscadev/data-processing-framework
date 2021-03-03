package jesuscadev.dpf.core;

import jesuscadev.dpf.data.DataSet;

import java.io.IOException;
import java.sql.SQLException;

public interface Publisher {
	void publishData(DataSet dataSet) throws IOException, SQLException, ClassNotFoundException;
}
