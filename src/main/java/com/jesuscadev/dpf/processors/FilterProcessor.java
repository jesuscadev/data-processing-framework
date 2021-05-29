package com.jesuscadev.dpf.processors;

import com.jesuscadev.dpf.core.Processor;
import com.jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

import static com.jesuscadev.dpf.Main.logger;

@XmlRootElement
public class FilterProcessor implements Processor {
	private String name;
	private String inputTable;
	private String filterFormula;

	public FilterProcessor() {
	}

	public String getName() {
		return name;
	}

	public String getInputTable() {
		return inputTable;
	}

	public String getFilterFormula() {
		return filterFormula;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setInputTable(String inputTable) {
		this.inputTable = inputTable;
	}

	@XmlElement
	public void setFilterFormula(String filterFormula) {
		this.filterFormula = filterFormula;
	}

	@Override
	public void processData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "processData");
		logger.info(name);
		logger.exiting(this.getName(), "processData");
		// TODO
		/*
		// ini
		if (Filter.Trim() == string.Empty)
		{
			Filter = "1 = 1";
			if (Columns.Count == 0)
			{
				if (Utils.Logs.Logging.IsDebugEnabled)
					Utils.Logs.Logging.Debug("Filter is empty, skipping filtering.");
				return dataTables;
			}
		}

		DataTable table = Utils.Utils.GetDataTableByName(dataTables, TableName);
		DataTable copyTable = table.Copy();

		if (Columns.Count > 0)
		{
			List<string> cols = new List<string>();
			foreach (DataColumn col in copyTable.Columns)
			{
				cols.Add(col.ColumnName);
			}
			foreach (string colname in cols)
			{
				if (Columns.ContainsKey(colname))
				{
					if (Columns[colname].Trim() != string.Empty)
					{
						copyTable.Columns[colname].ColumnName = Columns[colname].ToString();
						table.Columns[colname].ColumnName = Columns[colname].ToString();
					}
				}
				else
				{
					copyTable.Columns.Remove(colname);
					table.Columns.Remove(colname);
				}
			}
		}

		DataRow[] dataRows = copyTable.Select(Filter);

		table.Rows.Clear();
		foreach (DataRow row in dataRows)
		{
			table.Rows.Add(row.ItemArray);
		}
		table.AcceptChanges();

		if (Utils.Logs.Logging.IsDebugEnabled)
			Utils.Logs.Logging.Debug("Filtered {0} dataRows from {1}.", dataRows.Length, TableName);


		// fin
		*/
	}
}
