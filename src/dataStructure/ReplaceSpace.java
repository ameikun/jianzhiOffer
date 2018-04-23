package dataStructure;

/**将字符串中的空格替换成%20
 * 例如We are happy
 * 替换后为We%20are%20happy*/
public class ReplaceSpace {
	/**使用java 的已有类和方法替换*/
	 public static String replaceSpace(StringBuffer str) {  
	        for(int k=0; k<str.length(); k++)  
	              {  
	              char index = str.charAt(k);  
	                   if(index == ' ')  
	                     {  
	                      str.replace(k, k+1, "%20");  
	                     }  
	              }  
	           
	        return str.toString();  
	    }  
	
	/**类剑指Offer里面的方法的java版*/
	public static void realize(char[] str) {
		if (str == null || str.length <= 0) {
			return;
		}
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				count++;
			}
		}
		System.out.println(count);
		int oldlen = str.length;
		int newlen = oldlen + 2 * count;
		
		char[] tempArray = new char[newlen]; 
		
		int indexOfold = oldlen - 1;
		int indexOfnew = newlen - 1;
		while (indexOfold >= 0 && indexOfnew > indexOfold) {
			if (str[indexOfold] == ' ') {
				tempArray[indexOfnew--] = '0';
				tempArray[indexOfnew--] = '2';
				tempArray[indexOfnew--] = '%';
			}else {
				tempArray[indexOfnew--] = str[indexOfold];//越界
			}
			indexOfold--;
		}	
		
		for (int i = 0; i < tempArray.length; i++) {
			System.out.print(tempArray[i]+' ');
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "We are happy";
		realize(str.toCharArray());
		
		StringBuffer sBuffer = new StringBuffer(str);
		System.out.println(replaceSpace(sBuffer));

	}

}
