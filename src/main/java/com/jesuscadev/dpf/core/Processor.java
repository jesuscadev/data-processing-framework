package com.jesuscadev.dpf.core;

import com.jesuscadev.dpf.data.DataSet;

import java.io.IOException;

public interface Processor {
	void processData(DataSet dataSet) throws IOException;
}
