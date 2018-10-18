package service;

public class CheckValue {
	public static boolean isNumber(String value) {
		boolean isNum=false;
		char[] mas=value.toCharArray();
		for(int i=0;i<mas.length;i++) {
			for(int j=48;j<=57;j++)
				if((int)mas[i]==j)
					isNum=true;
					break;
		}
		return isNum;
	}

}
