package Topics.Final;
import java.util.*;
public final class  Final_Keyword {
	static final int MOD = (int)Math.pow(10, 9) + 7;
	
	public static final long sumMod(long value) {
		return ((value * (value + 1)) / 2 ) % MOD;
	}
}

