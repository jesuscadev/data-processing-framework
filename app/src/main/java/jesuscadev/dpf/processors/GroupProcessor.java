package jesuscadev.dpf.processors;

import jesuscadev.dpf.core.Processor;
import jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jesuscadev.dpf.Main.logger;

@XmlRootElement
public class GroupProcessor implements Processor {
	private String name;
	private String inputTable;
	private String outputTable;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<String> groupColumns;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<String> aggregateColumns;

	public GroupProcessor() {
		groupColumns = new ArrayList<>();
		aggregateColumns = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getInputTable() {
		return inputTable;
	}

	public String getOutputTable() {
		return outputTable;
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
		DataRow[] dr = new DataRow[2];
		boolean esIgual = true;

		if (Group.Count == 0)
		{
			if (Utils.Logs.Logging.IsDebugEnabled)
				Utils.Logs.Logging.Debug("Group is empty, skipping grouping.");
			return dataTables;
		}

		DataTable dt = Utils.Utils.GetDataTableByName(dataTables, TableName);

		if (dt.Rows.Count <= 1)
		{
			return dataTables;
		}

		// Loop through DataTable 0 to compare against each row in DataTable 1
		for (int i = dt.Rows.Count - 1; i >= 1; i--)
		{
			dr[0] = dt.Rows[i];
			// Reverse loop through DataTable 1
			for (int j = 0; j <= i - 1; j++)
			{
				dr[1] = dt.Rows[j];
				// Loop through Key List
				esIgual = true;
				foreach (String key in _group)
				{
					// Compare key
					if (String.Equals(dr[0][key].ToString(), dr[1][key].ToString(), StringComparison.Ordinal))
						continue;
					esIgual = false;
					break;
				}
				if (esIgual == true)
				{
					break;
				}
			}
			if (esIgual == true)
			{
				foreach (String field in _aggregate)
				{
					dr[1][field] = double.Parse(dr[0][field].ToString()) + double.Parse(dr[1][field].ToString());
				}
				// Remove matched row from table 0
				dt.Rows[i].Delete();
				dt.AcceptChanges();
			}
		}

		if (Utils.Logs.Logging.IsDebugEnabled)
			Utils.Logs.Logging.Debug("Grouped {0} dataRows from {1}.", dt.Rows.Count, TableName);

		return dataTables;

		// fin
		*/
	}
}
