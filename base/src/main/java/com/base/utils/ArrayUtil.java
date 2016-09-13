package com.base.utils;

import java.util.ArrayList;

public class ArrayUtil {
	public static int[] stringToIntArray(String s, String division) {
		if (s == null || s.length() == 0) return new int[0];
		String tmpData[] = s.split(division);
		int rc[] = new int[tmpData.length];
		for (int i = 0; i < tmpData.length; i++)
			rc[i] = StringUtil.stringToInt(tmpData[i], 0);

		return rc;
	}

	public static String intArrayToString(int data[], String division) {
		if (data == null || data.length == 0) return "";
		StringBuffer sb = new StringBuffer();
		sb.append(data[0]);
		for (int i = 1; i < data.length; i++) {
			sb.append(division);
			sb.append(data[i]);
		}

		return sb.toString();
	}

	public static String intArrayToString(int data[][], int pos, String division) {
		if (data == null || data.length == 0) return "";
		StringBuffer sb = new StringBuffer();
		if (data[0].length < pos + 1) return "";
		sb.append(data[0][pos]);
		for (int i = 1; i < data.length; i++) {
			if (data[i].length >= pos + 1) {
				sb.append(division);
				sb.append(data[i][pos]);
			}
		}

		return sb.toString();
	}

	public static String[] stringToArray(String s, String division) {
		if (s == null || s.length() == 0) return new String[0];
		return s.split(division, -1);
	}

	public static String arrayToString(String data[], String division) {
		if (data == null || data.length == 0) return "";
		StringBuffer sb = new StringBuffer(data[0]);
		for (int i = 1; i < data.length; i++) {
			sb.append(division);
			sb.append(data[i]);
		}

		return sb.toString();
	}

	public static String arrayToString(String data[][], int pos, String division) {
		if (data == null || data.length == 0) return "";
		if (data[0].length < pos + 1) return "";
		StringBuffer sb = new StringBuffer(data[0][pos]);
		for (int i = 1; i < data.length; i++) {
			if (data[i].length >= pos + 1) {
				sb.append(division);
				sb.append(data[i][pos]);
			}
		}

		return sb.toString();
	}

	public static String[] quoteStringToArray(String s, String division, String quote) {
		if (s == null || s.length() == 0) return new String[0];
		ArrayList<String> list = new ArrayList<String>();
		String tmp[] = s.split(division, -1);
		for (int i = 0; i < tmp.length; i++) {
			if (!tmp[i].startsWith(quote)) {
				list.add(tmp[i]);
			} else {
				String value = tmp[i];
				while (i + 1 < tmp.length) {
					int rc[] = countQuote(value, quote);
					if ((rc[0] - rc[1]) % 2 == 0 && (rc[0] != value.length() || rc[0] % 2 == 0)) {
						break;
					}
					value += division + tmp[++i];
				}
				if (value.length() >= 2 * quote.length())
					value = value.substring(quote.length(), value.length() - quote.length()).replaceAll(quote + quote, quote);
				else
					value = "";
				list.add(value);
			}
		}

		return list.toArray(new String[0]);
	}

	private static int[] countQuote(String value, String quote) {
		int rc[] = { 0, 0 };
		if (value == null || value.length() < quote.length()) return rc;
		for (int j = 0; j <= value.length() - quote.length(); j += quote.length()) {
			if (!value.substring(j, j + quote.length()).equals(quote)) {
				break;
			}
			rc[0]++;
		}
		for (int j = value.length() - quote.length(); j >= 0; j -= quote.length()) {
			if (!value.substring(j, j + quote.length()).equals(quote)) {
				break;
			}
			rc[1]++;
		}

		return rc;
	}

	public static String arrayToQuoteString(String data[], String division, String quote) {
		if (data == null || data.length == 0) return "";
		StringBuffer sb = new StringBuffer(quote + data[0] + quote);
		for (int i = 1; i < data.length; i++) {
			sb.append(division);
			sb.append(quote);
			sb.append(data[i]);
			sb.append(quote);
		}

		return sb.toString();
	}

	public static String arrayToSingleQuoteString(String data[][], int pos, String division, String quote) {
		if (data == null || data.length == 0) return "";
		if (data[0].length < pos + 1) return "";
		StringBuffer sb = new StringBuffer(quote + data[0][pos] + quote);
		for (int i = 1; i < data.length; i++) {
			if (data[i].length >= pos + 1) {
				sb.append(division);
				sb.append(quote);
				sb.append(data[i][pos]);
				sb.append(quote);
			}
		}

		return sb.toString();
	}

	public static int[] columnArray(int data[][], int pos, int defaultValue) {
		if (data == null || data.length == 0) {
			return new int[0];
		}
		int[] rc = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null || pos >= data[i].length)
				rc[i] = defaultValue;
			else
				rc[i] = data[i][pos];
		}

		return rc;
	}

	public static String[] columnArray(String data[][], int pos, String defaultValue) {
		if (data == null || data.length == 0) {
			return new String[0];
		}
		String[] rc = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null || pos >= data[i].length)
				rc[i] = defaultValue;
			else
				rc[i] = data[i][pos];
		}

		return rc;
	}

	public static String[] camelToDash(String data[], boolean keepOldName) {
		if (data == null || data.length == 0) {
			return new String[0];
		}

		String rc[] = new String[data.length];
		if (keepOldName) {
			for (int i = 0; i < rc.length; i++) {
				rc[i] = data[i] + "->" + StringUtil.camel2Dash(data[i]);
			}
		} else {
			for (int i = 0; i < rc.length; i++) {
				rc[i] = StringUtil.camel2Dash(data[i]);
			}
		}

		return rc;
	}

	public static String[] dashToCamel(String data[], boolean keepOldName) {
		if (data == null || data.length == 0) {
			return new String[0];
		}

		String rc[] = new String[data.length];
		if (keepOldName) {
			for (int i = 0; i < rc.length; i++) {
				rc[i] = data[i] + "->" + StringUtil.dash2Camel(data[i]);
			}
		} else {
			for (int i = 0; i < rc.length; i++) {
				rc[i] = StringUtil.dash2Camel(data[i]);
			}
		}

		return rc;
	}

}
