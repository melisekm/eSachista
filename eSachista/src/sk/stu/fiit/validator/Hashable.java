package sk.stu.fiit.validator;

/**
 * Rozhranie pre vnorenu triedu, ktore hashuje passwordy
 * 
 * @author Martin Melisek
 * @see AIS
 */
public interface Hashable {
	/**
	 * Pomocou hashovacej techniky zahashuje string
	 * 
	 * @param original String, ktory sa ma zahashovat
	 * @return Zahashovany String
	 */
	public String stringToHash(String original);

	/**
	 * Rozpozna <b>desifruje</b> zahashovany string
	 * 
	 * @param hashed String ktory je zahashovany a ma sa rozpoznat
	 * @return Desifrovany String
	 */
	public String hashToString(String hashed);
}
