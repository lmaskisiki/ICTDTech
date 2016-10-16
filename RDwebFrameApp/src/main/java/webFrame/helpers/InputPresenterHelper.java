package webFrame.helpers;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InputPresenterHelper implements Serializable {
	private String attribute;
	private String type;
	private String[] inputOptionValues;
	private boolean hasInputOptions;
	private boolean hasFunction;
	private String functionName;

	public boolean isHasFunction() {
		return hasFunction;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		if (functionName.length() > 2 && functionName.contains("()")) {
			hasFunction = true;
		} else {
			System.out.println("Invalid function for attribute :" + attribute);
		}
		this.functionName = functionName;
	}

	public String[] getInputOptionValues() {
		return inputOptionValues;
	}

	public void setInputOptionValues(String[] inputOptionValues) {
		if (inputOptionValues.length > 0) {
			hasInputOptions = true;
		}
		this.inputOptionValues = inputOptionValues;
	}

	public boolean HasInputOptions() {
		return hasInputOptions;
	}

	public void HasInputOptions(boolean hasInputOptions) {
		this.hasInputOptions = hasInputOptions;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
