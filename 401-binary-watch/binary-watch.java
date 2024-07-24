class Solution {
    public List<String> readBinaryWatch(int turnedOn) {

        Map<Integer, List<String>> hm = new HashMap();
        Map<Integer, List<String>> mm = new HashMap();
        // i runs to 59 which the number of possible minutes
        List<String> output = new ArrayList<>();

        for (int i = 0; i < 60; i++) {
            // calculate number of 1's for number i;
            int k = i;
            int ones = 0;
            while (k > 0) {
                ones += k % 2;
                k = k / 2;
            }

            List<String> curr = mm.getOrDefault(ones, new ArrayList<>());
            curr.add(mToString(i));
            mm.put(ones, curr);

            // i runs to 1 which the number of possible hours

            if (i < 12) {
                List<String> currh = hm.getOrDefault(ones, new ArrayList<>());
                currh.add(hToString(i));
                hm.put(ones, currh);
            }

        }
        for (int i = 0, j = 0; i < 4; i++) {
            for (String s : hm.get(i)) {
                if (turnedOn - i >= 0 && turnedOn - i < 6) {
                    for (String m : mm.get(turnedOn - i)) {
                        output.add(s + ":" + m);
                    }
                }
            }

        }
        return output;

    }

    private String mToString(int m) {
        if (m < 10) {
            return "0" + m;
        }
        return "" + m;
    }

    private String hToString(int h) {
        return "" + h;
    }
}