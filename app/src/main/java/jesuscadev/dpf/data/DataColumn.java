package jesuscadev.dpf.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataColumn {
	private String name;
	private Integer position;
	private Integer length;
	private String dataType;
	private String format;
	private Integer decimals;

	public DataColumn() {
	}

	public String getName() {
		return name;
	}

	public Integer getPosition() {
		return position;
	}

	public Integer getLength() {
		return length;
	}

	public String getDataType() {
		return dataType;
	}

	public String getFormat() {
		return format;
	}

	public Integer getDecimals() {
		return decimals;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public void setPosition(Integer position) {
		this.position = position;
	}

	@XmlElement
	public void setLength(Integer length) {
		this.length = length;
	}

	@XmlElement
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@XmlElement
	public void setFormat(String format) {
		this.format = format;
	}

	@XmlElement
	public void setDecimals(Integer decimals) {
		this.decimals = decimals;
	}
}
