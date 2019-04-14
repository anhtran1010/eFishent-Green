import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class parseFile {
	Scanner sc;
	public parseFile(LinkedHashMap data, File file) {
		try {
			sc = new Scanner(file);
			sc.useDelimiter(",");

			parse(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void parse(LinkedHashMap data) {
		sc.nextLine();
		while(sc.hasNext()) {
			String key = sc.next();
			String[] controlVar = new String[8];
			for (int k =0; k<8; ++k) {
				String temp = "";
				char[] rawData = sc.next().toCharArray();
				for (char c:rawData) {
					if(Character.isDigit(c)||c=='.') {
						temp+=c;
					}
				}
				controlVar[k] = temp;
				data.put(key, controlVar);
				
			}
		}
	}
}
