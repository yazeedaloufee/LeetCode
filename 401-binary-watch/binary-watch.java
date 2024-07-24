class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
	var times = new ArrayList<String>();

	for (var hour = 0; hour < 12; hour++)
		for (var minute = 0; minute < 60; minute++)
			if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn)
				times.add(String.format("%d:%02d", hour, minute));
				
	return times;
}
}