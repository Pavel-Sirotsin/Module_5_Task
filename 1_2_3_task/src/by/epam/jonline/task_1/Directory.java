package by.epam.jonline.task_1;

import java.util.ArrayList;
import java.util.List;

public class Directory {
	private String name;
	private List<File> files = new ArrayList<File>();

	public Directory() {
		super();
	}

	public Directory(String name) {
		super();
		this.name = name;
	}

	public Directory(String name, List<File> files) {
		super();
		this.name = name;
		this.files = files;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((files == null) ? 0 : files.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Directory other = (Directory) obj;
		if (files == null) {
			if (other.files != null)
				return false;
		} else if (!files.equals(other.files))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Directory: " + name + "\n");
		for (File file : files) {
			sb.append(file);
			sb.append("\n");
		}
		return sb.toString();
	}

}
