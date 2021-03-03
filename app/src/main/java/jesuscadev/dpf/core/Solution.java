package jesuscadev.dpf.core;

import jesuscadev.dpf.data.DataSet;
import jesuscadev.dpf.processors.ConciliateProcessor;
import jesuscadev.dpf.processors.FilterProcessor;
import jesuscadev.dpf.processors.SortProcessor;
import jesuscadev.dpf.publishers.DataBasePublisher;
import jesuscadev.dpf.publishers.DelimitedTextFilePublisher;
import jesuscadev.dpf.readers.DataBaseReader;
import jesuscadev.dpf.readers.DelimitedTextFileReader;
import jesuscadev.dpf.readers.FixedWidthTextFileReader;
import jesuscadev.dpf.readers.XmlFileReader;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jesuscadev.dpf.Main.logger;

@XmlSeeAlso({
	DataBaseReader.class,
	DelimitedTextFileReader.class,
	FixedWidthTextFileReader.class,
	XmlFileReader.class,
	ConciliateProcessor.class,
	FilterProcessor.class,
	SortProcessor.class,
	DataBasePublisher.class,
	DelimitedTextFilePublisher.class})

@XmlRootElement
public class Solution {
	private String name;

	private DataSet dataSet;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<Reader> readers;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<Processor> processors;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<Publisher> publishers;

	public Solution() {
		name = "";
		dataSet = new DataSet();
		readers = new ArrayList<>();
		processors = new ArrayList<>();
		publishers = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public DataSet getDataSet() {
		return dataSet;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	public void process() {
		try {
			for (Reader reader : readers) {
				reader.readData(dataSet);
			}
			for (Processor processor : processors) {
				processor.processData(dataSet);
			}
			for (Publisher publisher : publishers) {
				publisher.publishData(dataSet);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			logger.severe(e.getMessage());
		}
	}
}
