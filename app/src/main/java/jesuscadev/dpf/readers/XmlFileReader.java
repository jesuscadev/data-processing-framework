package jesuscadev.dpf.readers;

import jesuscadev.dpf.core.Reader;
import jesuscadev.dpf.data.DataColumn;
import jesuscadev.dpf.data.DataSet;
import jesuscadev.dpf.data.DataTable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.annotation.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jesuscadev.dpf.Main.logger;

@XmlSeeAlso({DataColumn.class})
@XmlRootElement
public class XmlFileReader implements Reader {
	private String name;
	private String filePath;
	private String rootNode;
	private String tagName;

	private File file;

	@XmlElementWrapper
	@XmlAnyElement(lax = true)
	public List<DataColumn> dataColumns;

	public XmlFileReader() {
		file = null;
		dataColumns = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getRootNode() {
		return rootNode;
	}

	public String getTagName() {
		return tagName;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@XmlElement
	public void setRootNode(String rootNode) {
		this.rootNode = rootNode;
	}

	@XmlElement
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public void readData(DataSet dataSet) throws IOException {
		logger.entering(this.getName(), "readData");
		logger.info(name);
		try {
			open();
			readAll(dataSet);
		}
		catch (IOException e) {
			logger.severe(e.toString());
			throw e;
		} finally {
			close();
		}
		logger.exiting(this.getName(), "readData");
	}

	private void readAll(DataSet dataSet) throws IOException {
		DataTable dataTable;
		String nextLine;
		logger.info(name);
		try {
			//http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			document.getDocumentElement().normalize();

			System.out.println("Root element :" + rootNode);
			System.out.println("Root element :" + document.getDocumentElement().getNodeName());

			NodeList nodeList = document.getElementsByTagName(tagName);

			System.out.println("----------------------------");

			for (int nodeIndex = 0; nodeIndex < nodeList.getLength(); nodeIndex++) {

				Node nNode = nodeList.item(nodeIndex);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
/*
		// OLD CODE
		try {
			file = new File(filePath);
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			dataTable = new Table(name);
			dataTable.dataColumns = this.dataColumns;
			int line = 0;
			while ((nextLine = bufferedReader.readLine()) != null) {
				line++;
				if (line <= this.headerLines) {
					logger.info("Discarded header line: [" + nextLine + "]");
				} else {
					String[] row = new String[dataColumns.size()];
					String[] tokens = nextLine.split(delimiter);
					int columnIndex = 0;
					for (Column column : dataColumns) {
						String columnValue;
						if (nextLine == null || nextLine.length() <= 0) {
							columnValue = "";
						} else {
							columnValue = tokens[column.getPosition()];
						}
						row[columnIndex++] = columnValue;
					}
					dataTable.rows.add(row);
				}
			}
			logger.info("Finished reading [" + line + "] lines.");
			tables.add(dataTable);
		} catch (IOException e) {
			logger.severe(e.toString());
			throw e;
		} finally {
			bufferedReader.close();
		}
*/		// OLD CODE
	}

	private void open() {
		File file = new File(filePath);
	}

	private void close() throws IOException {
	}
}
