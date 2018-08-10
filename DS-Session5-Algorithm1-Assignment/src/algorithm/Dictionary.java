package algorithm;

import java.util.List;

/**
 * Interface to implement Dictionary
 */
public interface Dictionary {

	public boolean addWord(String key, String value);

	public boolean deleteWord(String key);

	public String getValue(String key);

	public List<KeyValuePair> sortDictionary();

	public List<KeyValuePair> sortDictionaryInRange(String key1, String key2);
}
