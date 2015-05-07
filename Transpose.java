import java.util.Stack;

public class Transpose {
	/*
	 * �÷������ӡ�ʿ��е���
	 * @param list ���ʿ�
	 */
	public void transposeWord(Stack<String> list) {
		while (!list.empty()) {
			System.out.print(list.pop() + " ");
		}
	}

	/*
	 * �����ʴ��ַ�������ȡ�����ŵ�һ��ջ�У������ء�
	 */
	public Stack<String> getWords(String article) {
		Stack<String> list = new Stack<String>();
		StringBuffer sb = new StringBuffer();
		// �Ƿ�ʼ�齨����
		boolean isLetter = false;
		boolean addWord = false;
		// �������ַ������ַ����б����������ַ����½�һ��StringBuffer���ѵ�һ����ĸ�ŵ�StringBuffer�У�
		// ��������ɨ�裬�������ĸ�Ͱ��ַ�׷�ŵ���StringBuffer�ֱ���������ַ����Ͱ�StringBuffer��Ϊһ�����ʷŵ�List��
		for (int i = 0; i < article.length(); i++) {
			char tmp = article.charAt(i);
			// �������ĸ�Ļ����ͽ�״̬��Ϊ<��ʼ�齨����>
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
				// �����<��ʼ�齨����>�ͽ����ʼӵ�list��
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
