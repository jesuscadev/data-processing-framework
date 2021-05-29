package com.jesuscadev.dpf.readers;

import com.jesuscadev.dpf.core.Reader;
import com.jesuscadev.dpf.data.DataColumn;
import com.jesuscadev.dpf.data.DataRow;
import com.jesuscadev.dpf.data.DataSet;
import com.jesuscadev.dpf.data.DataTable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.*;

import static com.jesuscadev.dpf.Main.logger;

@XmlRootElement
public class DataBaseReader implements Reader {
	private String name;
	private String controllerString;
	private String connectionString;
	private String user;
	private String password;
	private String queryString;

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public DataBaseReader() {
		connection = null;
		statement = null;
		resultSet = null;
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

	@Override
	public void readData(DataSet dataSet) throws ClassNotFoundException, SQLException {
		logger.entering(this.getName(), "readData");
		logger.info(name);
		try {
			open();
			readAll(dataSet);
		} catch (ClassNotFoundException | SQLException e) {
			logger.severe(e.toString());
			throw e;
		} finally {
			close();
		}
		logger.exiting(this.getName(), "readData");
	}

	private void readAll(DataSet dataSet) throws SQLException {
		DataTable dataTable = new DataTable(name);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(queryString);
		int columnCount = resultSet.getMetaData().getColumnCount();
		for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
			DataColumn dataColumn = new DataColumn();
			dataColumn.setPosition(columnIndex);
			dataColumn.setName(resultSet.getMetaData().getColumnName(columnIndex));
			dataColumn.setDataType(resultSet.getMetaData().getColumnTypeName(columnIndex));
			dataTable.addColumn(dataColumn);
		}
		while (resultSet.next()) {
			DataRow dataRow = new DataRow(dataTable.dataColumns.size());
			for (DataColumn dataColumn : dataTable.dataColumns) {
				dataRow.addValue((dataColumn.getPosition() - 1), resultSet.getString(dataColumn.getName()));
			}
			dataTable.addRow(dataRow);
		}
		dataSet.addTable(dataTable);
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
