package com.jesuscadev.dpf.publishers;

import com.jesuscadev.dpf.core.Publisher;
import com.jesuscadev.dpf.data.DataColumn;
import com.jesuscadev.dpf.data.DataRow;
import com.jesuscadev.dpf.data.DataSet;

import javax.xml.bind.annotation.*;
import java.sql.*;
import java.util.List;

import static com.jesuscadev.dpf.Main.logger;

@XmlRootElement
public class DataBasePublisher implements Publisher {
	private String name;
	private String controllerString;
	private String connectionString;
	private String user;
	private String password;
	private String queryString;

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public DataBasePublisher() {
	}

	public String getName() {
		return name;
	}

	public String getControllerString() {
		return controllerString;
	}

	public String getConnectionString() {
		return connectionString;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getQueryString() {
		return queryString;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setControllerString(String controllerString) {
		this.controllerString = controllerString;
	}

	@XmlElement
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	@XmlElement
	public void setUser(String user) {
		this.user = user;
	}

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElement
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<DataColumn> dataColumns;

	@Override
	public void publishData(DataSet dataSet) throws ClassNotFoundException, SQLException {
		logger.entering(this.getName(), "publishData");
		logger.info(name);
		try {
			open();
			publishAll(dataSet);
		} catch (ClassNotFoundException | SQLException e) {
			logger.severe(e.toString());
			throw e;
		} finally {
			close();
		}
		logger.exiting(this.getName(), "publishData");
	}

	private void publishAll(DataSet dataSet) throws SQLException {
		/*
		dataTable = dataSet.getTable(tableName);
		if (includeHeader) {
			publishRow(dataTable.getColumnsRow(), false);
		}
		for (DataRow dataRow : dataTable.dataRows) {
			publishRow(dataRow, includeQuotes);
		}
		*/
	}

	private void publishRow(DataRow dataRow, boolean includeQuotes) throws SQLException {
		/*
		if (dataRow == null) {
			return;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int columnIndex = 0; columnIndex < dataRow.getLength(); columnIndex++) {
			if (columnIndex != 0) {
				stringBuilder.append(delimiter);
			}
			String nextValue = dataRow.getValue(columnIndex);
			if (nextValue == null) {
				continue;
			}
			if (includeQuotes && dataTable.isColumnString(columnIndex)) {
				stringBuilder.append(quotes).append(nextValue).append(quotes);
			} else {
				stringBuilder.append(nextValue);
			}
		}
		stringBuilder.append(endOfLine);
		printWriter.write(stringBuilder.toString());
		*/
	}

	private void open() throws ClassNotFoundException, SQLException {
		Class.forName(controllerString);
		connection = DriverManager.getConnection(connectionString, user, password);
	}

	private void close() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
