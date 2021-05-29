package com.jesuscadev.dpf.processors;

import com.jesuscadev.dpf.core.Processor;
import com.jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

import static com.jesuscadev.dpf.Main.logger;

@XmlRootElement
public class MergeProcessor implements Processor {
	private String name;
	private String firstInputTable;
	private String secondInputTable;
	private String outputTable;

	public MergeProcessor() {
	}

	public String getName() {
		return name;
	}

	public String getFirstInputTable() {
		return firstInputTable;
	}

	public String getSecondInputTable() {
		return secondInputTable;
	}

	public String getOutputTable() {
		return outputTable;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setFirstInputTable(String firstInputTable) {
		this.firstInputTable = firstInputTable;
	}

	@XmlElement
	public void setSecondInputTable(String secondInputTable) {
		this.secondInputTable = secondInputTable;
	}

	@XmlElement
	public void setOutputTable(String outputTable) {
		this.outputTable = outputTable;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
		// TODO
		/*
		// ini
		DataTable[] dt = new DataTable[2];

		dt[0] = Utils.Utils.GetDataTableByName(dataTables, _mergeTableNames[0]);
		dt[1] = Utils.Utils.GetDataTableByName(dataTables, _mergeTableNames[1]);
		DataTable mdt = dt[0].Copy();
		mdt.Merge(dt[1]);
		mdt.TableName = _tableName;
		dataTables.Add(mdt);

		if (Utils.Logs.Logging.IsDebugEnabled)
			Utils.Logs.Logging.Debug("Merged {0} dataRows from {1} and {2} dataRows from {3}.", dt[0].Rows.Count, _mergeTableNames[0], dt[1].Rows.Count, _mergeTableNames[1]);

		return dataTables;

		// fin
		*/
	}
}
