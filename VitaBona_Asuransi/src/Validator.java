import java.util.HashMap;

import person.Prospect;

public class Validator {
	
	public static boolean checkProspectIsEmpty(HashMap<String, Prospect> pros) {
		boolean isEmpty;
		
		if (pros.isEmpty()) {
			isEmpty = true;
		} else {
			isEmpty = false;
		}
		
		return isEmpty;
	}
}
