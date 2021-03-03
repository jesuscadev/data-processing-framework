package jesuscadev.dpf.core;

import jesuscadev.dpf.data.DataSet;

import java.io.IOException;

public interface Processor {
	void processData(DataSet dataSet) throws IOException;
}
