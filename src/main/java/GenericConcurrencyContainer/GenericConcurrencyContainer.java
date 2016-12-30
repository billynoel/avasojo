/**
 * 
 */
package GenericConcurrencyContainer;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Avasojo
 * @param <V>
 *
 */
public abstract class GenericConcurrencyContainer<V> implements ConcurrentMap<String, Integer> {

	/**
	 * 
	 */
	public GenericConcurrencyContainer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<String, Integer>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void putAll(Map<? extends K, ? extends V> arg0) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Integer> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer putIfAbsent(String arg0, Integer arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replace(String arg0, Integer arg1, Integer arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer put(String arg0, Integer arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
}
