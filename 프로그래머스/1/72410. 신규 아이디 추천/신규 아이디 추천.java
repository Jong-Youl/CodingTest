class Solution {
    public String solution(String new_id) {        
        /*
            규칙
            1. id.length <= 15 && >= 3
            2. -, _ , . , 소문자, 숫자
            3. .처음과 끝, 연속 사용 불가능
            
            아이디 추천
            1. 대문자 -> 소문자
            2. 사용 가능 문자 제외 모두 제거
            3. . 연속을 .하나로 바꿈
            4. . 이 앞이나 뒤에 위치하면 제거
            5. 빈 문자열이라면 a를 대입
            6. 15자를 넘으면 15 이후로 전부 삭제, 삭제 후 .이 맨뒤에 위치하면 마지막 .를 제거
            7. new_id의 길이가 2자 이하면 마지막 문자를 new_id의 길이가 3이 될 때 까지 반복

            System.out.println(new_id);
        */        
        new_id = checkUpper(new_id);
        new_id = checkValid(new_id);
        new_id = checkDot(new_id);
        new_id = checkEmpty(new_id);
        new_id = checkMaxLength(new_id);
        new_id = checkMinLength(new_id);
        
        return new_id;
    }
    
    public String checkMinLength(String str) {
        if(str.length() > 3)
            return str;
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            
            for(int i = str.length(); i < 3; i++)
                sb.append(str.charAt(str.length() - 1));
            
            return sb.toString();
        }
    }
    
    public String checkMaxLength(String str) {
        if(str.length() <= 15)
            return str;
        else {
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < 15; i++) {
                if(i == 14 && str.charAt(i) == '.')
                    continue;

                sb.append(str.charAt(i));
            }
                
            return sb.toString();
        }
    }
    
    public String checkEmpty(String str) {
        if(str.length() > 0)
            return str;
        else
            return "aaa";
    }
    
    public String checkDot(String str) {
        StringBuilder sb = new StringBuilder();
        char before = ' ';
        
        for(int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            
            if(curr == '.') {
                if(before == '.')
                    continue;
            }
            
            sb.append(curr);
            before = curr;
        }
        
        String temp = sb.toString();
        int st = (temp.charAt(0) == '.')? 1 : 0;
        int ed = (temp.charAt(temp.length() - 1) == '.')? temp.length() - 1 : temp.length();
        sb.setLength(0);
        
        while(st < ed)
            sb.append(temp.charAt(st++));
            
        
        return sb.toString();
    }
    
    public String checkValid(String str) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            
            if(Character.isLowerCase(curr) || Character.isDigit(curr) || curr == '-' || curr == '.' || curr == '_') 
                sb.append(curr);
        }
        
        return sb.toString();
    }
    
    public String checkUpper(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if(Character.isUpperCase(curr))
                curr = Character.toLowerCase(curr);
            
            sb.append(curr);
        }
        
        return sb.toString();
    }
    
}