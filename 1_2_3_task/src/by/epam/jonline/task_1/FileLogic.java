package by.epam.jonline.task_1;

import java.nio.charset.StandardCharsets;

/*Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить.*/

public class FileLogic {

	private long sizeOfTxt(String text) {
		byte[] mas = text.getBytes(StandardCharsets.UTF_16) ;
		long size = 0;
		for (byte b : mas) {
			size += b;
		}
		return size;
	}

	public TextFile createTextFile(String name, String format, String content) {
		long size = sizeOfTxt(content);
		return new TextFile(name, size, format, content);
	}

	public void rename(File file, String name) {
		file.setName(name);
	}

	public void addTxtContent(File file, String addition) {
		TextFile text = (TextFile) file;
		StringBuilder sb = new StringBuilder(text.getText());
		
		sb.append(" " + addition);
		text.setText(sb.toString());
		
		long newSize = file.getSize() + sizeOfTxt(addition);
		file.setSize(newSize);
	}
	
	public File deleteFile(File file) {
		return null;
	}

	public boolean addToDirectory(File file, Directory directory) {
		return directory.getFiles().add(file);
	}
	
	public boolean delFromDirectory(File file, Directory directory) {
		return directory.getFiles().remove(file);
	}

}
