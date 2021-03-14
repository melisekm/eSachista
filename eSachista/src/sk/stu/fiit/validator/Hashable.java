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
	 * @param original Pole znakov, ktory sa ma zahashovat
	 * @return Zahashovany String
	 */
	public char[] stringToHash(char[] original);

	/**
	 * Rozpozna <b>desifruje</b> zahashovany string
	 * 
	 * @param hashed Pole znakov ktory je zahashovany a ma sa rozpoznat
	 * @return Desifrovany String
	 */
	public char[] hashToString(char[] hashed);
}
