class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0; 
        while ( i < v1.length && i < v2.length ){
            int i1 = Integer.valueOf(v1[i]);
            int i2 = Integer.valueOf(v2[i]);

            if(i1 > i2) {
                return 1; 
            }else if (i2 > i1) {
                return -1;
            }
            i++;
        }
        if(v1.length == v2.length) {
            return 0;
        }else if (v1.length > v2.length) {
            while(i < v1.length) {
                if(Integer.valueOf(v1[i]) != 0) {
                    return 1;
                }
                i++;
            }
            return 0;
        }else {
             while(i < v2.length) {
                if(Integer.valueOf(v2[i]) != 0) {
                    return -1;
                }
                i++;
            }
            return 0;
        }

    }
}