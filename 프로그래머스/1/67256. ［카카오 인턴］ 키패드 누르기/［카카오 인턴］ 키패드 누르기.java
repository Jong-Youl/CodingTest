class Solution {
    
    class Pos {
        int r, c;
        
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        // 10 -> x, 11 -> #
        Pos [] map = new Pos [10];
        Pos left = new Pos(3, 0);
        Pos right = new Pos(3, 2);
        map [0] = new Pos(3, 1);
        
        int r = 0;
        int c = 0;
        for(int i = 1; i < 10; i++) {
            map[i] = new Pos(r, c);
            if(c == 2) {
                c = 0;
                r++;
            }
            else
                c++;
        }
        
        for(int cmd : numbers) {
            if(cmd == 1 || cmd == 4 || cmd == 7) {
                sb.append("L");
                left.r = map[cmd].r;
                left.c = map[cmd].c;
            }
            else if (cmd == 3 || cmd == 6 || cmd == 9) {
                sb.append("R");
                right.r = map[cmd].r;
                right.c = map[cmd].c;
            }
            else {
                int diffL = Math.abs(left.r - map[cmd].r) + Math.abs(left.c - map[cmd].c);
                int diffR = Math.abs(right.r - map[cmd].r) + Math.abs(right.c - map[cmd].c);
                
                if(diffL == diffR) {
                    if(hand.equals("left")) {
                        sb.append("L");
                        left.r = map[cmd].r;
                        left.c = map[cmd].c;
                    }
                    else {
                        sb.append("R");
                        right.r = map[cmd].r;
                        right.c = map[cmd].c;
                    }
                }
                else if (diffL > diffR) {
                    sb.append("R");
                    right.r = map[cmd].r;
                    right.c = map[cmd].c;
                }
                else {
                    sb.append("L");
                    left.r = map[cmd].r;
                    left.c = map[cmd].c;        
                }
            }
        }
        
        return sb.toString();
    }
}