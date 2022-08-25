

public class Problem_2 {
        public String solution(String new_id) {
        String answer = "";

        var targetArr = new_id.toCharArray();

        var builder = new StringBuilder(new_id);
        // 1~2단계
        // 알파벳, 숫자, 빼기, 밑줄, 마침표 제외 문자 제거
        // 대문자 알파벳 변경

        int index = 0;
        while (index < builder.length()) {
            char c = builder.charAt(index);
            if (c >= 'A' && c <= 'Z') {
                c = Character.toLowerCase(c);
            }
            builder.replace(index, index + 1, Character.toString(c));

            if (Character.isAlphabetic(c) || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                index++;
                continue;
            }
            builder.deleteCharAt(index);
        }

        index = 0;
        var isAfterPeriod = false;
        while (index < builder.length()) {
            char c = builder.charAt(index);

            if (c != '.') {
                index++;
                isAfterPeriod = false;
                continue;
            }

            if (isAfterPeriod) {
                builder.deleteCharAt(index);
                continue;
            }

            index++;
            isAfterPeriod = true;

        }

        if(builder.length()> 0 && builder.charAt(0) == '.') {
            builder.deleteCharAt(0);
        }


        if(builder.length() > 0 && builder.charAt(builder.length() - 1) == '.') {
            builder.deleteCharAt(builder.length() - 1);
        }

        var length = new_id.length();
                new_id = builder.toString();


        if (new_id.length() == 0) {
            new_id = "a";
        }
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            }
        }

        if (new_id.length() <= 2) {
            var fillNums = 3 - new_id.length();
            var lastStr = new_id.charAt(new_id.length() - 1);
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            new_idBuilder.append(String.valueOf(lastStr).repeat(fillNums));
            new_id = new_idBuilder.toString();
        }

        return new_id;
    }

}