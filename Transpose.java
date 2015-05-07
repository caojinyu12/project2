import java.util.Stack;

public class Transpose {
	/*
	 * 该方法会打印词库中单词
	 * @param list 单词库
	 */
	public void transposeWord(Stack<String> list) {
		while (!list.empty()) {
			System.out.print(list.pop() + " ");
		}
	}

	/*
	 * 将单词从字符串中提取出来放到一个栈中，并返回。
	 */
	public Stack<String> getWords(String article) {
		Stack<String> list = new Stack<String>();
		StringBuffer sb = new StringBuffer();
		// 是否开始组建单词
		boolean isLetter = false;
		boolean addWord = false;
		// 对文章字符串的字符进行遍历，遇到字符就新建一个StringBuffer，把第一个字母放到StringBuffer中，
		// 继续向下扫描，如果是字母就把字符追放到到StringBuffer里，直到遇到非字符，就把StringBuffer作为一个单词放到List中
		for (int i = 0; i < article.length(); i++) {
			char tmp = article.charAt(i);
			// 如果是字母的话，就将状态变为<开始组建单词>
			if (Character.isLetter(tmp)) {
				isLetter = true;
				addWord = false;
				sb.append(tmp);
				if (i == article.length() - 1) {
					addWord = true;
				}
			} else {
				addWord = true;
			}
			if (addWord) {
				// 如果是<开始组建单词>就将单词加到list中
				if (isLetter) {
					list.push(sb.toString());
					sb.delete(0, sb.length());
					isLetter = false;
				}
			}
		}
		return list;
	}

}
