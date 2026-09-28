import java.util.*;

public class bai2 {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Nếu là ngoặc mở
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            // Nếu là ngoặc đóng
            else {
                // Stack rỗng -> không có ngoặc mở tương ứng
                if (stack.isEmpty()) {
                    return "NO";
                }

                char top = stack.peek();

                // Kiểm tra đúng cặp ngoặc
                if (c == ')' && top != '(') {
                    return "NO";
                }

                if (c == ']' && top != '[') {
                    return "NO";
                }

                if (c == '}' && top != '{') {
                    return "NO";
                }

                // Đúng cặp -> lấy ngoặc mở ra
                stack.pop();
            }
        }

        // Duyệt xong mà Stack còn phần tử
        if (!stack.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {

        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("((("));
    }
}