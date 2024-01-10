package dp;

class Solution2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean a = true;

        boolean isBulky = (Math.max(Math.max(length, width), height) >= 1e4)
                || (1L * length * width * height >= 1e9);
        boolean isHeavy = mass >= 100;
        if (isBulky && isHeavy) {
            return "Both";
        } else if (isBulky) {
            return "Bulky";
        } else if (isHeavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }

}

