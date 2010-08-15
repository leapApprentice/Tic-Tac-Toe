
public class player {
	
	protected char token = 'o';
	//int[][] moves
	
	//player constructor
	public player(int type) {
		if (type == 0) {
			token = 'x';	//x
		} else if (type == 1) {
			token = 'o';	//o
		}
		
		
	}
}