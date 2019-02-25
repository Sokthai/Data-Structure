

public interface databaseInferface {

	/**
	 * 
	 * @param firstname 
	 */
	public void search(String firstname);

	/**
	 * 
	 * @param firstname 
	 * @param lastname 
	 * @return 
	 */
	public boolean search(String firstname, String lastname);

	/**
	 * 
	 * @return 
	 */
	public boolean add();

	/**
	 * 
	 * @return 
	 */
	public boolean update();

	/**
	 * 
	 * @return 
	 */
	public boolean remove();

	/**
	 * 
	 * @param host 
	 * @param username 
	 * @param password 
	 * @return 
	 */
	public boolean connect(String password, String host, String username);

	/**
	 * 
	 * @return 
	 */
	public int count(); 

}