import java.util.Arrays;

public class Board {

	public enum Mark {
		NONE, X, O
	}

	private Mark[] fields;

	public Board() {
		fields = new Mark[3 * 3];
		Arrays.fill(fields, Mark.NONE);
	}

	public void setMark(Mark mark, int x, int y) throws InvalidPositionException {
		if(x < 0 || x > 2 || y < 0 || y > 2 || fields[3 * y + x] != Mark.NONE)
			throw new InvalidPositionException();
		fields[3 * y + x] = mark;
	}

	public boolean hasWinner() {				
		return sameMark(0,1,2)
				|| sameMark(3,4,5)
				|| sameMark(6,7,8)
				|| sameMark(0,3,6)
				|| sameMark(1,4,7)
				|| sameMark(2,5,8)
				|| sameMark(0,4,8)
				|| sameMark(2,4,6);
	}
	
	
	private boolean sameMark(int firstIndex, int secondIndex, int thirdIndex) {
		return fields[firstIndex] == fields[secondIndex] && fields[firstIndex] == fields[thirdIndex] && fields[firstIndex] != Mark.NONE;		
	}
	


}