package Contact;

import java.util.List;

public interface databaseInferface{

	public boolean connect();

	public boolean remove();

	public boolean add(List<String> values);

	public boolean update(List<String> values);

	public List<Integer> search(String firstname);

	public List<Integer> search(String lastname, String firstname);

	public int count();



}
