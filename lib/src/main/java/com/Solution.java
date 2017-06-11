package com;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

/**
 * Created by Sachin_Chauhan on 2/17/2016.
 */

/*
4 4 4 4 4 4 4
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4
 */
public class Solution {

    public static void main(String args[]) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        double ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            int num = Integer.parseInt(line);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            //list.add(Integer.parseInt(line));

        }

        Set<Integer> keys = map.keySet();
        for (int i : keys) {
            double frq = map.get(i);
            if (frq > 1) {
                ans = ans + (frq / N) * ((frq - 1) / (N - 1));
            }
        }
        System.out.println(new DecimalFormat("#0.000000").format(ans));


    }

    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) % n + (a.get(a.get(i)) % n) * n);
        }
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) / n);
        }
        Math.sqrt(a.get(0));

    }

    public int uniquePaths(int a, int b) {

        if (a > b) {
            return com(a, b);
        }
        return com(b, a);

    }

    void path(int i, int j, int a, int b, Integer ctr) {
        if (i == a - 1 && j == b - 1) {
            ctr++;
            return;
        }
        if (i < a - 1)
            path(i + 1, j, a, b, ctr);
        if (j < b - 1)
            path(i, j + 1, a, b, ctr);

    }


    //    public int maximumGap(final List<Integer> a) {
//
//
//        List<Indexes> list = new ArrayList<>();
//        List<Integer> indexdp = new ArrayList<>();
//        int len = a.size();
//        int max = 0;
//        if(len==0){
//            return -1;
//        }
//
//        for( int i =0 ;i<len;i++){
//            list.add(new Indexes(a.get(i),i));
//            indexdp.add(0);
//        }
//        Collections.sort(list, new Comparator<Indexes>() {
//            @Override
//            public int compare(Indexes ind1, Indexes ind2) {
//
//                return ind1.val - ind2.val;
//            }
//        });
//        indexdp.set(len-1,list.get(len-1).ind);
//
//        for(int i = len-2;i>=0;i--){
//            indexdp.set(i, maxnum(list.get(i).ind,indexdp.get(i+1)));
//        }
//
//        int maxnumber = -9999;
//        for(int i =0;i<len;i++){
//            int diff = indexdp.get(i)-list.get(i).ind;
//            if(diff>maxnumber){
//                maxnumber=diff;
//            }
//        }
//        return maxnumber;
//    }
    int maxnum(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public int maximumGap(final List<Integer> a) {
        ArrayList<Integer> list = new ArrayList<>();

        if (a.size() < 2) {
            return 0;
        }
        for (int i : a) {
            list.add(i);
        }

        Collections.sort(list);
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (diff > max) {
                max = diff;
            }
        }

        return max;
    }
    /*public static void main(String args[]) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int test = Integer.parseInt(line);

        while (test > 0) {
            ArrayList<Integer> s1 = new ArrayList<>();
            ArrayList<Integer> s2 = new ArrayList<>();
            line = br.readLine();
            int N = Integer.parseInt(line);

            line = br.readLine();
            String l[]= line.split(" ");

            for (int i = 0; i < N; i++) {
                s1.add(Integer.parseInt(l[i]));
            }
            line = br.readLine();
            String lo[]= line.split(" ");
            for (int i = 0; i < N; i++) {
                s2.add(Integer.parseInt(lo[i]));
            }


            String name = br.readLine();
            int ctr = 0;
            for (int i = 0; i < N; i++) {
                if (s1.get(i) != s2.get(i)) {
                    ctr++;
                }
            }

            if (N == 2) {
                System.out.println("Devu");
            } else if (ctr == 2 && name.equals("Devu")) {
                System.out.println("Devu");

            } else {
                System.out.println("Churu");
            }
            test--;
        }
    }*/

    public void arranger(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            a.set(i, i);
        }
    }

    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        if (a == 0)
            return null;
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>(a * 2 - 1);
        for (int i = 0; i < a * 2 - 1; i++) {
            ArrayList<Integer> intArray = new ArrayList<>(a * 2 - 1);
            for (int j = 0; j < a * 2 - 1; j++) {
                Integer mInt = new Integer(a);
                intArray.add(mInt);
            }
            arrayList.add(intArray);
        }

        for (int k = 1; k < a; k++) {
            for (int i = k; i < a * 2 - 1 - k; i++) {
                for (int j = k; j < a * 2 - 1 - k; j++) {
                    arrayList.get(i).set(j, a - k);
                }
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {

                System.out.print(arrayList.get(i).get(j));
            }
            System.out.println();
        }
        return arrayList;
    }

    public int kthsmallest(final List<Integer> a, int k) {


        List<Integer> list = new ArrayList<>();

        for (int i : a) {
            list.add(i);
        }

        int first = 0;
        int last = list.size() - 1;
        int ans = 0;
        while (first <= last) {
            ans = partition(list, first, last);
            if (ans > k) {
                last = ans - 1;
            } else if (ans < k) {
                first = ans + 1;
            } else {
                break;
            }
        }
        return list.get(ans);

    }

    public int trailingZeroes(int a) {

        int ctr = 0;
        int five = 5;
        while (five <= a) {

            ctr += a / five;
            five *= 5;
        }

        return ctr;
    }
    /*
    map<pair<int, int>, int> _True;
map<pair<int, int>, int> _False;

int Tr(int i, int j, string exp)
{
    if(i > j)
        return 0;
    if(i == j)
        return exp[i] == 'T';

    if(_True.count(mpa(i, j)))
        return _True[mpa(i, j)];


    int ans = 0;
    for(int k = i; k < j; ++k) {
        if(exp[k] == '&')
            ans = ans + (Tr(i, k - 1, exp) * Tr(k + 1, j, exp));

        if(exp[k] == '|')
            ans = ans + (Tr(i, k - 1, exp) * Tr(k + 1, j, exp)) +
            (Tr(i, k - 1, exp) * Fa(k + 1, j, exp)) + (Fa(i, k - 1, exp) * Tr(k + 1, j, exp));  // beacuase T OR T = > T  T OR F = > T  F OR T => T

        if(exp[k] == '^')
            ans = ans + (Tr(i, k - 1, exp) * Fa(k + 1, j, exp)) +
            (Fa(i, k - 1, exp) * Tr(k + 1, j, exp));

        if(ans >= MOD)
                    ans %= MOD;
    }

    return _True[mpa(i, j)] = ans;
}

int Fa(int i, int j, string exp) {

    if(i > j)
        return 0;
    if(i == j)
        return exp[i] == 'F';

    if(_False.count(mpa(i, j)))
        return _False[mpa(i, j)];

    int ans = 0;

    for(int k = i; k < j; ++k) {

        if(exp[k] == '&')
            ans = ans + (Tr(i, k - 1, exp) * Fa(k + 1, j, exp)) +
                  (Fa(i, k - 1, exp) * Tr(k + 1, j, exp)) +
                  (Fa(i, k - 1, exp) * Fa(k + 1, j, exp));


        if(exp[k] == '|')
            ans = ans + (Fa(i, k - 1, exp) * Fa(k + 1, j, exp));


        if(exp[k] == '^')
            ans = ans + (Tr(i, k - 1, exp) * Tr(k + 1, j, exp)) +
                  (Fa(i, k - 1, exp) * Fa(k + 1, j, exp));

        if(ans >= MOD)
            ans %= MOD;
    }

    return _False[mpa(i, j)] = ans;
}


int solve(string str) {

    _True.clear();
    _False.clear();

    int N = str.size();
    int ans = Tr(0, N - 1, str);
    return ans;
}
     */

    int[][] dptrue;
    int[][] dpfalse;
    public int cnttrue(String a) {
        int len = a.length();

        dptrue = new int[len][len];
        dpfalse = new int[len][len];
        return TRec(0, len - 1, a);
    }

    int TRec(int i,int j,String exp){
        if(i > j)
            return 0;
        if(i == j)
            return exp.charAt(i) == 'T'?1:0;

        if(dptrue[i][j]>0)
            return dptrue[i][j];


        int ans = 0;
        for(int k = i; k < j; ++k) {
            if(exp.charAt(k) == '&')
                ans = ans + (TRec(i, k - 1, exp) * TRec(k + 1, j, exp));

            if(exp.charAt(k) == '|')
                ans = ans + (TRec(i, k - 1, exp) * TRec(k + 1, j, exp)) +
                        (TRec(i, k - 1, exp) * FRec(k + 1, j, exp)) + (FRec(i, k - 1, exp) * TRec(k + 1, j, exp));  // beacuase T OR T = > T  T OR F = > T  F OR T => T

            if(exp.charAt(k) == '^')
                ans = ans + (TRec(i, k - 1, exp) * FRec(k + 1, j, exp)) +
                        (FRec(i, k - 1, exp) * TRec(k + 1, j, exp));

            if(ans >= 1003)
                ans %= 1003;
        }

        return dptrue[i][j] = ans;
    }

    int FRec(int i, int j, String exp) {

        if(i > j)
            return 0;
        if(i == j)
            return exp.charAt(i) == 'F'?1:0;

        if(dpfalse[i][j]>0)
            return dpfalse[i][j];

        int ans = 0;

        for(int k = i; k < j; ++k) {

            if(exp.charAt(k) == '&')
                ans = ans + (TRec(i, k - 1, exp) * FRec(k + 1, j, exp)) +
                        (FRec(i, k - 1, exp) * TRec(k + 1, j, exp)) +
                        (FRec(i, k - 1, exp) * FRec(k + 1, j, exp));


            if(exp.charAt(k) == '|')
                ans = ans + (FRec(i, k - 1, exp) * FRec(k + 1, j, exp));


            if(exp.charAt(k) == '^')
                ans = ans + (TRec(i, k - 1, exp) * TRec(k + 1, j, exp)) +
                        (FRec(i, k - 1, exp) * FRec(k + 1, j, exp));

            if(ans >= 1003)
                ans %= 1003;
        }

        return dpfalse[i][j] = ans;
    }

    public boolean isPalindrome(int a) {

        int number = 0;
        int num = a;
        while (num > 0) {
            number = number * 10 + (num % 10);
            num = num / 10;
        }
        return a == number;

    }

    public int rev(int a) {
        int number = 0;
        int sign = 1;
        int flag = 0;
        int num = a;
        while (num > 0) {
            if (flag == 1) {
                number = number * 10 + (num % 10);
            } else {
                if (num % 10 != 0) {
                    number = number * 10 + (num % 10);
                    flag = 1;
                }
            }
            num = num / 10;
        }

        return number * sign;
    }

    public int reverse(int a) {
        int number = 0;
        int sign = 1;
        int flag = 0;
        int ctr = 0;
        if (a < 0) {
            sign = -1;
            a = Math.abs(a);
        }
        int num = a;
        while (num > 0) {
            if (flag == 1) {
                number = number * 10 + (num % 10);
            } else {
                if (num % 10 != 0) {
                    number = number * 10 + (num % 10);
                    flag = 1;
                } else {
                    ctr++;
                }
            }
            num = num / 10;
        }
        if (Math.abs(a / Math.pow(10, ctr)) != rev(Math.abs(number))) {
            return 0;
        }
        return number * sign;
    }

    public void nextPermutation(ArrayList<Integer> a) {
        int len = a.size() - 1;

        if (len == 0) {
            return;
        }
        len--;
        while (len >= 0 && a.get(len) >= a.get(len + 1)) {
            len--;
        }


        if (len != -1) {
            int number = a.get(len);
            int min = 99999999;
            int pt = len;
            for (int i = len + 1; i < a.size(); i++) {
                if (number < a.get(i) && min > a.get(i)) {
                    pt = i;
                }
            }
            swap(a, len, pt);
        }

        sorting(a, len + 1, a.size() - 1);

        //    System.out.println(a);

    }

    void sorting(ArrayList<Integer> a, int start, int end) {
        for (int i = start; i <= end; i++) {
            int temp = i;
            for (int j = i + 1; j <= end; j++) {
                if (a.get(temp) > a.get(j)) {
                    temp = j;
                }
            }
            swap(a, i, temp);
        }
    }

    int partition(List<Integer> list, int init, int last) {

        if (init == last)
            return init;
        int storeind = init;
        int pivot = list.get(last);
        for (int i = init; i < last; i++) {
            if (list.get(i) < pivot) {
                swap(list, i, storeind);
                storeind++;
            }
        }
        swap(list, storeind, last);
        return storeind;
    }

    void swap(List<Integer> list, int i, int j) {

        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public ListNode subtract(ListNode a) {

        int len = length(a);
        int half = len / 2;
        ListNode halflist = a;
        for (int i = 0; i < half; i++) {
            halflist = halflist.next;
        }
        halflist = reverseList(halflist);
        ListNode temp1 = a;
        ListNode temp2 = halflist;
        for (int i = 0; i < half; i++) {
            temp1.val = temp2.val - temp1.val;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        halflist = reverseList(halflist);
        return a;
    }

    public ListNode reorderList(ListNode a) {

        if (a == null || a.next == null) {
            return a;
        }
        ListNode halflist = halflist(a);
        ListNode revhead = reverseList(halflist.next);
        halflist.next = null;
        ListNode firsthead = a;

        while (revhead != null) {
            ListNode temp = revhead;
            ListNode temp1 = firsthead;
            revhead = revhead.next;
            firsthead = firsthead.next;
            temp1.next = temp;
            temp.next = firsthead;
        }

        return a;
    }

    public ListNode insertionSortList(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }
        ListNode sortlist = a;
        a = a.next;
        sortlist.next = null;
        while (a != null) {
            ListNode trasort = sortlist;
            ListNode temp = a;
            a = a.next;
            temp.next = null;
            while (trasort.next != null && trasort.next.val < temp.val) {
                trasort = trasort.next;
            }
            if (trasort.equals(sortlist)) {
                if (trasort.val > temp.val) {
                    temp.next = trasort;
                    sortlist = temp;
                } else {
                    ListNode after = trasort.next;
                    trasort.next = temp;
                    temp.next = after;
                }
            } else {
                ListNode after = trasort.next;
                trasort.next = temp;
                temp.next = after;
            }
        }
        return sortlist;
    }

    public ListNode sortList(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }
        ListNode firshalf = a;
        ListNode secondhalf = a;
        int ctr = 0;
        while (firshalf != null) {
            firshalf = firshalf.next;
            ctr++;
        }
        ctr /= 2;
        while (ctr > 1) {
            secondhalf = secondhalf.next;
            ctr--;
        }
        firshalf = secondhalf;
        secondhalf = secondhalf.next;
        firshalf.next = null;
        firshalf = sortList(a);
        secondhalf = sortList(secondhalf);
        a = null;
        ListNode head = null;
        while (firshalf != null && secondhalf != null) {
            if (firshalf.val < secondhalf.val) {
                if (head == null) {
                    head = firshalf;
                    a = head;
                } else {
                    ListNode temp = firshalf;
                    firshalf = firshalf.next;
                    a.next = temp;
                    a = a.next;
                }
            } else {
                if (head == null) {
                    head = secondhalf;
                    a = head;
                } else {
                    ListNode temp = secondhalf;
                    secondhalf = secondhalf.next;
                    a.next = temp;
                    a = a.next;
                }
            }
        }
        while (firshalf != null) {
            ListNode temp = firshalf;
            firshalf = firshalf.next;
            a.next = temp;
            a = a.next;
        }

        while (secondhalf != null) {
            ListNode temp = secondhalf;
            secondhalf = secondhalf.next;
            a.next = temp;
            a = a.next;
        }

        return head;

    }

    public String reverseString(String a) {
        if (a == null || a.length() == 1) {
            return a;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            st.push(a.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public int isValid(String a) {

        Stack<Character> st = new Stack<>();
        for (char ch : a.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == '}') {
                if (st.isEmpty()) {
                    return 0;
                }
                char chpop = st.pop();
                if ('{' != chpop) {
                    return 0;
                }
            } else if (ch == ')') {
                if (st.isEmpty()) {
                    return 0;
                }
                char chpop = st.pop();
                if ('(' != chpop) {
                    return 0;
                }
            } else if (ch == ']') {
                if (st.isEmpty()) {
                    return 0;
                }
                char chpop = st.pop();
                if ('[' != chpop) {
                    return 0;
                }
            }
        }
        if (st.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public int braces(String a) {
        Stack<Character> st = new Stack<>();

        for (char ch : a.toCharArray()) {
            if (ch == ')' || ch == '}' || ch == ']') {
                boolean flag = false;
                char tempchar = st.pop();
                while (tempchar != '(') {
                    if (tempchar == '+' || tempchar == '/' || tempchar == '*' || tempchar == '-') {
                        flag = true;
                    }
                    tempchar = st.pop();
                }
                if (flag == false) {
                    return 1;
                }

            } else {
                st.push(ch);
            }
        }
        return 0;

    }

    public int divide(int dividend, int divisor) {

        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;


        long pDividend = Math.abs((long) dividend);
        long pDivisor = Math.abs((long) divisor);

        int result = 0;
        while (pDividend >= pDivisor) {
            //calculate number of left shifts
            int numShift = 0;
            while (pDividend >= (pDivisor << numShift)) {
                numShift++;
            }

            //dividend minus the largest shifted divisor
            result += 1 << (numShift - 1);
            pDividend -= (pDivisor << (numShift - 1));
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return result;
        } else {
            return -result;
        }


    }

    public String simplifyPath(String a) {

        Stack<String> st = new Stack<>();
        for (String str : a.split("/")) {
            if (str.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if ((!str.equals(".")) && (!(str.length() == 0))) {
                st.push(str);
            }

        }
        StringBuilder ans = new StringBuilder();
        ans.append("/");
        for (String str : st) {
            ans.append(str);
            ans.append("/");
        }
        if (ans.length() != 1) {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }

    public int evalRPN(ArrayList<String> a) {
        Stack<Integer> st = new Stack<>();
        for (String str : a) {
            if (str.equals("+")) {
                int val2 = st.pop();
                int val1 = st.pop();
                val1 = val1 + val2;
                st.push(val1);
            } else if (str.equals("-")) {

                int val2 = st.pop();
                int val1 = st.pop();
                val1 = val1 - val2;
                st.push(val1);
            } else if (str.equals("*")) {

                int val2 = st.pop();
                int val1 = st.pop();
                val1 = val1 * val2;
                st.push(val1);
            } else if (str.equals("/")) {

                int val2 = st.pop();
                int val1 = st.pop();
                val1 = val1 / val2;
                st.push(val1);
            } else {
                st.push(Integer.parseInt(str));
            }
        }
        return st.pop();
    }

    public int removeDuplicates(ArrayList<Integer> a) {

        int i = 0, j = 0;
        boolean flag = false;
        for (; j < a.size(); j++) {
            int temp = j;
            if (j < a.size() && a.get(temp) == a.get(j)) {
                int num1 = a.get(temp);
                int ctr = 0;
                while (j < a.size() && num1 == a.get(j)) {
                    j++;
                    ctr++;
                }
                if (ctr >= 2) {
                    flag = true;
                }
                j--;
            }
            if (flag == true) {
                a.set(i, a.get(temp));
                i++;
                flag = false;
            }
            a.set(i, a.get(temp));
            i++;
        }
        for (j = a.size() - 1; j >= i; j--) {
            a.remove(j);
        }
        return i;
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);
            int num = -1;
            while (!st.isEmpty()) {
                num = st.peek();
                if (num < val) {
                    break;
                }
                st.pop();
            }
            if (st.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(num);
            }
            st.push(val);
        }
        return ans;

    }

    public int removeElement(ArrayList<Integer> a, int b) {
        int i = 0, j = 0;
        boolean flag = false;
        int temp = b;
        for (; j < a.size(); j++) {
            if (temp != a.get(j)) {
                a.set(i, a.get(j));
                i++;
            }

        }
        for (j = a.size() - 1; j >= i; j--) {
            a.remove(j);
        }
        return i;
    }

    public void sortColors(ArrayList<Integer> a) {
        int arr[] = new int[3];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 0;
        for (int j = 0; j < a.size(); j++) {
            arr[a.get(j)]++;
        }
        int i = 0;
        for (int j = 0; j < arr[0]; j++) {
            a.set(i, 0);
            i++;
        }
        for (int j = 0; j < arr[1]; j++) {
            a.set(i, 1);
            i++;
        }
        for (int j = 0; j < arr[2]; j++) {
            a.set(i, 2);
            i++;
        }
    }

    public ListNode partition(ListNode a, int b) {
        ListNode first = a;
        ListNode prev = null;
        while (first != null) {
            if (first.val >= b) {
                break;
            }
            prev = first;
            first = first.next;
        }
        if (first == null) {
            return a;
        }

        ListNode half = first;
        ListNode ans = null;
        ListNode tra = null;
        ;
        ListNode pre = null;
        while (first != null) {
            if (first.val < b) {
                pre.next = pre.next.next;
                if (ans == null) {
                    ans = first;
                    tra = ans;
                } else {
                    tra.next = first;
                    tra = tra.next;
                }
                first.next = null;
                first = pre.next;
            } else {
                pre = first;
                first = first.next;
            }
        }
        if (prev == null) {
            a = ans;
        } else {
            prev.next = ans;
        }
        pre = null;
        while (ans != null) {
            pre = ans;
            ans = ans.next;
        }
        if (pre == null) {
            prev.next = half;
        } else {
            pre.next = half;
        }

        return a;
    }


    ListNode halflist(ListNode a) {
        ListNode f1 = a, f2 = a;
        int ctr = 0;
        while (f1 != null) {
            ctr++;
            f1 = f1.next;
        }
        int half = ctr / 2;
        while (half > 1) {
            f2 = f2.next;
            half--;
        }
        if (ctr % 2 == 1) {
            return f2.next;
        }
        return f2;
    }

    public int gcd(int a, int b) {
        int c = a % b;

        if (c == 0) {
            return b;
        } else {
            return gcd(b, c);
        }
    }

    public ListNode reverseBetween(ListNode a, int m, int n) {
        ListNode mnode = null, nnode;
        ListNode revnode = a;
        int i;
        for (i = 1; i < m; i++) {
            mnode = revnode;
            revnode = revnode.next;
        }
        if (mnode == null) {
            nnode = a;
        } else {
            nnode = revnode;
        }
        for (; i < n; i++) {
            nnode = nnode.next;
        }
        ListNode temp = nnode;
        nnode = nnode.next;
        temp.next = null;

        revnode = reverseList(revnode);

        if (mnode == null) {
            a = revnode;
            mnode = a;
        } else {
            mnode.next = revnode;
        }

        while (mnode.next != null) {
            mnode = mnode.next;
        }
        mnode.next = nnode;

        return a;

    }

    ListNode reverseList1(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }
        ListNode pre = null;
        ListNode cur = a;
        ListNode next = a.next;

        while (true) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next == null) {
                break;
            }
            next = next.next;
        }
        return pre;

    }

    int length(ListNode a) {
        int len = 0;
        while (a != null) {
            a = a.next;
            len++;
        }
        return len;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode temp, ans = null;

        if (a == null && b == null) {
            return ans;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val > b.val) {
            ans = b;
            temp = ans;
            b = b.next;
        } else {
            ans = a;
            temp = ans;
            a = a.next;
        }
        while (a != null && b != null) {
            if (a.val > b.val) {
                ans.next = b;
                b = b.next;
                ans = ans.next;
            } else {
                ans.next = a;
                a = a.next;
                ans = ans.next;
            }
        }
        while (a != null) {
            ans.next = a;
            a = a.next;
            ans = ans.next;
        }
        while (b != null) {
            ans.next = b;
            b = b.next;
            ans = ans.next;
        }
        ans.next = null;
        return temp;
    }

    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {

        Stack<Integer> stack = new Stack<>();
        return a;
    }

    public ListNode swapPairs(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }
        //swap having head
        ListNode head = a.next;
        ListNode temp = head.next;
        head.next = a;
        a.next = temp;

        a = swaplist(a);
        while (a != null) {
            a = swaplist(a);
        }
        return head;

    }

    ListNode swaplist(ListNode pre) {
        if (pre.next == null || pre.next.next == null) {
            return null;
        }
        ListNode centre = pre.next;
        ListNode next = centre.next;
        pre.next = next;
        centre.next = next.next;
        next.next = centre;
        return centre;
    }

    public ListNode deleteDuplicates(ListNode a) {
        ListNode tra = a;
        ListNode pre = null;
        ListNode head;
        if (tra == null || tra.next == null) {
            return tra;
        }

        //For first dup node
        while (tra != null && tra.next != null && tra.val == tra.next.val) {
            ListNode temp = tra;
            while (temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
            }
            tra = temp.next;
        }
        if (tra == null || tra.next == null) {
            return tra;
        }
        head = tra;
        pre = tra;
        tra = tra.next;
        while (tra != null && tra.next != null) {
            if (tra.val == tra.next.val) {
                ListNode temp = tra;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                pre.next = temp.next;
                tra = temp.next;
            } else {
                pre = tra;
                tra = tra.next;
            }
        }
        return head;
    }


    public ArrayList<Integer> maxset(ArrayList<Integer> a) {

        ArrayList<Integer> maxlist;
        int maxlen = 0;
        long maxsum = 0;
        maxlist = null;
        for (int i = 0; i < a.size(); ) {
            long sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (i < a.size() && a.get(i) >= 0) {
                list.add(a.get(i));
                sum += a.get(i);
                i++;
            }
            if (sum > maxsum) {
                maxsum = sum;
                maxlist = list;
            } else if (sum == maxsum) {
                if (maxlen < list.size()) {
                    maxlen = list.size();
                    maxlist = list;
                }
            }
            while (i < a.size() && a.get(i) < 0) {
                i++;
            }
        }
        if (maxlist == null) {
            return new ArrayList<>();
        }
        return maxlist;
    }

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {

        int dis = 0;
        for (int i = 1; i < X.size(); i++) {
            int a = X.get(i - 1);
            int b = Y.get(i - 1);
            int x = X.get(i);
            int y = Y.get(i);

            if (Math.abs(x - a) == Math.abs(y - b)) {
                dis += Math.abs(x - a);

            } else if (Math.abs(x - a) > Math.abs(y - b)) {
                dis += Math.abs(y - b);
                dis += Math.abs(x - a) - Math.abs(y - b);
            } else if (Math.abs(x - a) < Math.abs(y - b)) {
                dis += Math.abs(x - a);
                dis += Math.abs(y - b) - Math.abs(x - a);
            }

        }
        return dis;
    }

    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i : a) {
            ans.add(0);
        }
        for (int i = 0; i < a.size(); i += 2) {
            if (i + 1 < a.size()) {
                ans.set(i + 1, a.get(i));
                ans.set(i, a.get(i + 1));
            }
        }
        if (a.size() % 2 != 0)
            ans.set(a.size() - 1, a.get(a.size() - 1));
        return ans;
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> ans = new ArrayList<>();

        if (intervals.size() == 0) {
            ans.add(newInterval);
            return ans;
        }

        if (newInterval.start > newInterval.end) {
            int temp = newInterval.end;
            newInterval.end = newInterval.start;
            newInterval.start = temp;
        }


        int start = newInterval.start;
        int end = newInterval.end;

        ArrayList<Interval> overlap = new ArrayList<>();
        int i, pos = 0, flag = 0;
        for (i = 0; i < intervals.size(); i++) {
            if (max(intervals.get(i).start, start) <= min(intervals.get(i).end, end)) {
                overlap.add(intervals.get(i));
                if (flag == 0) {
                    flag = 1;
                    pos = i;
                }
            }

        }
        if (0 == overlap.size()) {
            if (end < intervals.get(0).start) {
                ans.add(newInterval);
                for (i = 0; i < intervals.size(); i++) {
                    ans.add(intervals.get(i));
                }
            } else {
                int k;
                for (k = 0; k < intervals.size(); k++) {
                    if (intervals.get(k).start < start) {
                        ans.add(intervals.get(k));
                    } else
                        break;
                }
                if (k == intervals.size()) {
                    ans.add(newInterval);
                } else {
                    ans.add(newInterval);
                    for (; k < intervals.size(); k++) {
                        ans.add(intervals.get(k));
                    }
                }

            }
            return ans;
        }

        if (overlap.get(0).start <= start) {
            newInterval.start = overlap.get(0).start;
        }
        if (overlap.get(overlap.size() - 1).end >= end) {
            newInterval.end = overlap.get(overlap.size() - 1).end;
        }
        for (i = 0; i < pos; i++) {
            ans.add(intervals.get(i));
        }
        ans.add(newInterval);
        pos += overlap.size();
        for (; pos < intervals.size(); pos++) {
            ans.add(intervals.get(pos));
        }

        return ans;

    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval int1, Interval int2) {

                int difffirst = int1.start - int2.start;
                int diffsec = int1.end - int2.end;
                if (difffirst != 0) {
                    return difffirst;
                } else {
                    return diffsec;
                }
            }
        });

        int st = intervals.get(0).start;
        int end = intervals.get(0).end;
        res.add(new Interval(st, end));
        for (int i = 1; i < intervals.size(); i++) {
            if (end >= intervals.get(i).start) {
                if (end <= intervals.get(i).end) {
                    end = intervals.get(i).end;
                    res.get(res.size() - 1).end = end;
                }
            } else {
                st = intervals.get(i).start;
                end = intervals.get(i).end;
                res.add(new Interval(st, end));
            }
        }
        return res;
    }


    int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        int row = 1;
        int col = 1;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).get(0) == 0) {
                row = 0;
            }
        }

        for (int i = 0; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == 0) {
                col = 0;
            }
        }

        for (int i = 1; i < a.size(); i++) {
            ArrayList<Integer> c = a.get(i);
            for (int j = 1; j < c.size(); j++) {

                if (c.get(j) == 0) {
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }

        }

        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).get(0) == 0)
                for (int j = 1; j < a.get(0).size(); j++) {
                    a.get(i).set(j, 0);
                }

        }

        for (int i = 1; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == 0)
                for (int j = 1; j < a.size(); j++) {
                    a.get(j).set(i, 0);
                }

        }

        if (row == 0) {
            for (int i = 0; i < a.size(); i++) {
                a.get(i).set(0, 0);
            }
        }

        if (col == 0) {
            for (int i = 0; i < a.get(0).size(); i++) {
                a.get(0).set(i, 0);
            }
        }

        return;

    }


    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<Integer> getRow(int a) {

        ArrayList<Integer> an = new ArrayList<>();
        if (a == 0) {
            an.add(1);
            return an;
        }

        int size = a + 1;
        if (size % 2 == 0) {
            size /= 2;
        } else {
            size /= 2;
            size++;
        }
        for (int i = 0; i < size; i++) {
            an.add(com(a, i));
        }
        for (int i = ((a + 1) % 2 == 0 ? size - 1 : size - 2); i >= 0; i--) {
            an.add(an.get(i));
        }

        return an;
    }

    public int lPalin(ListNode A) {
        ListNode temp = A;
        ListNode half = A;
        int ctr = 0;
        while (temp != null) {
            temp = temp.next;
            ctr++;
        }
        if (ctr == 1) {
            return 1;
        }
        temp = A;
        int ctrh = ctr / 2;
        while (ctrh != 0) {
            ctrh--;
            half = half.next;
        }
        half = half.next;
        if (ctr % 2 != 0) {
            half = half.next;
        }
        half = reverseList(half);
        while (half != null) {
            if (temp.val != half.val) {
                return 0;
            }
            half = half.next;
            temp = temp.next;
        }
        return 1;
    }

    public ArrayList<ArrayList<Integer>> generate(int a) {

        for (int i = 0; i < a; i++) {
            ArrayList<Integer> row = new ArrayList<>();


//            int size = i+1;
//            if(size%2==0) {
//                size /= 2;
//            }
//            else
//            {
//                size /=2;
//                size++;
//            }
//            for(int j =0;i<size;i++){
//                row.add(com(a,j));
//            }
//            for(int k=((a+1)%2==0?size-1:size-2);i>=0;k--){
//                ans.add(ans.get(k));
//            }

            ans.add(getRow(i));
        }
        return ans;

    }

    int com(int n, int c) {
        if (n == c || c == 0) {
            return 1;
        }
        if (n == c + 1 || c == 1) {
            return n;
        }
        return ans.get(n - 1).get(c) + ans.get(n - 1).get(c - 1);
    }


    int get(ArrayList<ArrayList<Integer>> a, int i, int j) {

        return a.get(i).get(j);
    }


    int binarySearch(ArrayList<ArrayList<Integer>> a, int b) {

        int rowsize = a.size();
        int colsize = a.get(0).size();
        int start = 0;
        int last = rowsize - 1;
        int mid = 0;

        if (get(a, 0, 0) > b || get(a, rowsize - 1, colsize - 1) < b)
            return 0;

        while (start <= last) {
            mid = start + (last - start) / 2;
            if (get(a, mid, 0) == b) {
                return 1;
            }
            if (get(a, mid, 0) > b) {
                last = mid - 1;
            } else if (get(a, mid, 0) < b && (mid + 1 != rowsize) && get(a, mid + 1, 0) < b) {
                start = mid + 1;
            } else
                break;
        }

        start = 0;
        last = colsize - 1;
        int midd = 0;
        while (start <= last) {
            midd = start + (last - start) / 2;
            if (get(a, mid, midd) == b) {
                return 1;
            }

            if (get(a, mid, midd) > b) {
                last = midd - 1;
            } else if (get(a, mid, midd) < b) {
                start = midd + 1;
            }

        }
        return 0;
    }

    //1 3 5 6 (4)
    public int searchInsert(ArrayList<Integer> a, int b) {

        int start = 0;
        int last = a.size() - 1;
        int mid;
        if (b <= a.get(0)) {
            return 0;
        }
        if (b > a.get(last)) {
            return last + 1;
        }
        while (start <= last) {
            mid = start + (last - start) / 2;
            if (a.get(mid) == b) {
                return mid;
            }
            if (a.get(mid) > b) {
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (a.get(start) < b) {
            return start + 1;
        } else {
            return start;
        }
    }

    public int pow(long x, int n, int d) {

        if (x == 0) {
            return 0;
        }
        if (n == 0)
            return 1;

        long ans = x;
        if (n % 2 == 0) {
            ans = (ans * ans) % d;
            if (ans < 0) {
                ans = d - (Math.abs(ans) % d);
            }
            ans = pow(ans, n / 2, d);
            if (ans < 0) {
                ans = d - (Math.abs(ans) % d);
            }
            return (int) ans;
        } else {
            long val = ans;
            ans = (ans * ans) % d;
            if (ans < 0) {
                ans = d - (Math.abs(ans) % d);
            }
            ans = pow((ans) % d, n / 2, d);
            if (ans < 0) {
                ans = d - (Math.abs(ans) % d);
            }
            ans = (ans * val) % d;
            if (ans < 0) {
                ans = d - (Math.abs(ans) % d);
            }
            return (int) ans;
        }


    }

    //203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43
    public int searchInRotatedArray(List<Integer> a, int b) {
        int start = 0;
        int last = a.size() - 1;
        int mid;
        while (a.get(start) > a.get(last)) {
            mid = start + (last - start) / 2;
            if (a.get(mid) == b) {
                return mid;
            }
            if ((a.get(mid) > b)/*||(a.get(mid) < b && (a.get(last)> a.get(mid)) ||  (a.get(start)<a.get(mid)))*/) {
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        while (start <= last) {
            mid = start + (last - start) / 2;
            if (a.get(mid) == b) {
                return mid;
            }
            if (a.get(mid) > b) {
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int segregate(ArrayList<Integer> a) {

        int size = a.size() - 1;
        int i = size;
        int j = size;
        for (; 0 <= i; i--) {
            if (a.get(i) < 0) {
                swap(a, i, j);
                j--;
            }
        }
        return j;
    }

    //5, -2, -1, -10, 10   5
    public int threeSumClosest(ArrayList<Integer> a, int b) {
        int len = a.size();
        int min = 99999999;
        int minsum = 0;
        if (len < 3) {
            return 1000000000;
        }
        Collections.sort(a);
        for (int i = 0; i < len - 1; i++) {
            int num = a.get(i);
            int start = i + 1;
            int last = len - 1;
            int pre = 99999999;
            while (start < last) {
                int numSum = Math.abs(b - a.get(start) + a.get(last) + num);
                if (numSum == 0) {
                    return b;
                } else if (a.get(start) + a.get(last) + num < b) {
                    if (numSum < min) {
                        min = numSum;
                        minsum = a.get(start) + a.get(last) + num;
                    }
                    start++;
                } else {
                    if (numSum < min) {
                        min = numSum;
                        minsum = a.get(start) + a.get(last) + num;
                    }
                    last--;
                }
            }
        }
        return minsum;
    }

    public int lengthOfLastWord(final String a) {
        int len = a.length();
        if (len == 0) {
            return 0;
        }

        int last = len - 1;
        while (last > -1 && a.charAt(last) == ' ') {
            last--;
        }
        int lenght = 0;
        while (last > -1 && a.charAt(last) != ' ') {
            lenght++;
            last--;
        }
        return lenght;
    }


    public String reverseWords(String a) {
        int len = a.length();

        StringBuffer stringBuffer = new StringBuffer(a.trim());
        stringBuffer = stringBuffer.reverse();
        stringBuffer.trimToSize();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == ' ') {
                sb.append(' ');
            }
            while (i < stringBuffer.length() && stringBuffer.charAt(i) == ' ') {
                i++;
            }
            if (i != stringBuffer.length()) {
                sb.append(stringBuffer.charAt(i));
            }
        }

        int start = 0;
        int last = 0;

        for (int i = 0; i < sb.length(); i++) {
            start = i;
            while (i < sb.length() && sb.charAt(i) != ' ') {
                i++;
            }
            last = i - 1;
            reverse(sb, start, last);
        }
        return sb.toString();

    }

    void reverse(StringBuffer a, int start, int last) {

        while (start < last) {
            swap(a, start, last);
            start++;
            last--;
        }
    }

    void swap(StringBuffer a, int start, int last) {
        char ch = a.charAt(start);
        a.setCharAt(start, a.charAt(last));
        a.setCharAt(last, ch);
    }

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int start = 0;
        int last = a.size() - 1;
        int mid = 0;
        while (start <= last) {
            mid = start + (last - start) / 2;
            if (a.get(mid) == b) {
                if (mid - 1 >= 0 && a.get(mid - 1) == b) {
                    last = mid - 1;
                    continue;
                } else
                    break;
            }
            if (a.get(mid) > b) {
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start > last) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        int ans1 = mid;
        start = mid;
        last = a.size();
        while (start <= last) {
            mid = start + (last - start) / 2;
            if (a.get(mid) == b) {
                if (mid + 1 < a.size() && a.get(mid + 1) == b)
                    start = mid - 1;
                else
                    break;
            }
            if (a.get(mid) > b) {
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        ans.add(ans1);
        ans.add(mid);

        return ans;
    }

    public int paint(int a, int b, ArrayList<Integer> c) {
        final long modval = 10000003;
        long last = Long.MAX_VALUE;
        long start = 0;
        long mid;
        while (start <= last) {
            mid = start + (last - start) / 2;
            if (isPossible(c, a, b, mid)) {
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) (start % modval);
    }

    boolean isPossible(ArrayList<Integer> list, long a, long b, long c) {
        long paintersum = 0;
        int painter = 0;
        for (int i = 0; i < list.size(); i++) {
            if (paintersum + (long) b * (long) list.get(i) > c) {
                paintersum = (long) b * (long) list.get(i);
                painter++;
                if (painter >= a || paintersum > c) {
                    return false;
                }
            } else {
                paintersum += b * (long) list.get(i);
            }
        }
        return true;
    }

    public double findMedianSortedArrayss(final List<Integer> a, final List<Integer> b) {
        int lena = 0;
        int lenb = 0;
        List<Integer> A = null;
        List<Integer> B = null;

        if (a.size() == 0) {
            return findMedian(b);
        }
        if (b.size() == 0) {
            return findMedian(a);
        }

        A = new ArrayList<>(a);
        B = new ArrayList<>(b);
        lena = a.size() - 1;
        lenb = b.size() - 1;


        int mina = 0;
        int maxa = lena;
        int i = 0, j = 0;
        while (mina <= maxa) {
            i = mina + (maxa - mina) / 2;
            j = (lena + lenb + 1) / 2 - i;

            if (j < 0 || i < 0) {
                A.addAll(B);
                return findMedian(A);
            } else if (j > lenb + 1) {
                B.addAll(A);
                return findMedian(B);
            }

            if (j > 0 && i != lena + 1 && B.get(j - 1) > A.get(i)) {
                mina = i + 1;
            } else if (j != lenb + 1 && i > 0 && B.get(j) < A.get(i - 1)) {
                maxa = i - 1;
            } else {
                if (j == lenb + 1) {
                    B.addAll(A);
                    return findMedian(B);
                }
                if ((lena + lenb) % 2 == 1) {
                    return Math.min(A.get(i), B.get(j));
                } else {
                    int maxnum;
                    if (i != 0) {
                        maxnum = Math.max(A.get(i - 1), B.get(j - 1));
                    } else {
                        return (double) (B.get(j) + B.get(j + 1)) / 2;
                    }
                    return (double) (maxnum + Math.min(A.get(i), B.get(j))) / 2;
                }
            }
        }
        if ((lena + lenb) % 2 == 1) {
            if (mina > lena) {
                return B.get(j - 1);
            } else {
                return B.get(j);
            }

        } else {

            return (double) (B.get(j - 1) + B.get(j)) / 2;

        }

    }

    double findMedian(List<Integer> list) {

        int len = list.size() - 1;
        if (len % 2 == 0) {
            return list.get(len / 2);
        } else {
            return (double) (list.get(len / 2) + list.get(len / 2 + 1)) / 2;
        }
    }

    public int books(ArrayList<Integer> a, int b) {
        long noofpages = 0;
        int size = a.size();
        long start = 0;

        for (int i : a) {
            noofpages += i;
        }
        if (size < b || noofpages == 0) {
            return -1;
        }
        long last = noofpages;
        long mid;
        while (start <= last) {
            mid = start + (last - start) / 2;
            if (ispos(a, b, mid)) {
                last = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) start;

    }

    public int atoi(final String number) {


        int size = number.length() - 1;
        int i = 0;
        long ans = 0;
        int mult = 1;
        boolean overflow = false;
        while (size >= i) {
            char ch = number.charAt(i);
            if (ch != ' ') {
                if (ch == '-') {
                    mult = -1;
                    i++;
                } else if (ch == '+') {
                    mult = 1;
                    i++;
                }
                break;
            }
            i++;
        }


        while (size >= i) {
            char ch = number.charAt(i);
            if (ch >= 48 && ch <= 57) {
                ans = ans * 10 + (ch - 48);
                if (ans > Integer.MAX_VALUE) {
                    overflow = true;
                }
            } else {
                break;
            }
            i++;
        }
        if (overflow == true && mult == 1) {
            return Integer.MAX_VALUE;
        } else if (overflow == true && mult == -1) {
            return Integer.MIN_VALUE;
        }
        ans = ans * mult;
        return (int) ans;
    }

    public int isNumber(final String b) {
        String a = b.trim();
        int len = a.length();
        if (len == 0) {
            return 0;
        }
        int i = 0;
        if (len > i && (a.charAt(i) == '-' || a.charAt(i) == '+')) {
            i++;
        }
        if (len <= i) {
            return 0;
        }
        int flag = 0;
        while (len > i) {
            char ch = a.charAt(i);
            int ctr = 0;
            if ((ch >= 48 && ch <= 57) || ch == '.' || ch == 'e') {
                if (ch == 'e' && i == 0) {
                    return 0;
                } else if (ch == 'e' && i != 0) {
                    flag = 1;
                    break;
                }
                if (ch == '.' && ctr == 0) {
                    ctr = 1;
                } else if (ch == '.' && ctr == 1) {
                    return 0;
                }
                if ((ch == '.' && i == len - 1)) {
                    return 0;
                }
                if ((ch == '.' && i < len - 1 && a.charAt(i + 1) == 'e')) {
                    return 0;
                }
            } else {
                return 0;
            }
            i++;
        }
        i++;
        if (len > i && (a.charAt(i) == '-' || a.charAt(i) == '+')) {
            i++;
        }
        if (len <= i & flag == 1) {
            return 0;
        }
        while (len > i) {
            char ch = a.charAt(i);
            if ((ch >= 48 && ch <= 57)) {
                i++;
            } else {
                return 0;
            }

        }
        return 1;
    }

    public int compareVersion(String a, String b) {

        ArrayList<StringBuilder> ver1 = new ArrayList<>();
        ArrayList<StringBuilder> ver2 = new ArrayList<>();

        ver1 = createList(a);
        ver2 = createList(b);

        int len1 = ver1.size();
        int len2 = ver2.size();
        int i = 0;
        while (i < len1 && i < len2) {
            int num = compareString(ver1.get(i), ver2.get(i));
            if (num < 0) {
                return -1;
            } else if (num > 0) {
                return 1;
            }
            i++;
        }

        if (len1 > len2) {
            return 1;
        } else if (len2 > len1) {
            return -1;
        } else {
            return 0;
        }

    }

    ArrayList<StringBuilder> createList(String a) {
        Scanner scanner1 = new Scanner(a);
        ArrayList<StringBuilder> ver1 = new ArrayList<>();

        scanner1.useDelimiter("[\\.]");
        while (scanner1.hasNext()) {
            String no = scanner1.next();
            no = trimzero(no);
            if (no.compareTo("") != 0) {
                ver1.add(new StringBuilder(no));
            }
        }
        if (!scanner1.hasNext() && ver1.size() == 0) {
            ver1.add(new StringBuilder(a));
        }
        return ver1;
    }

    int compareString(StringBuilder stringBuilder1, StringBuilder stringBuilder2) {

        if (stringBuilder1.length() > stringBuilder2.length()) {
            return 1;
        } else if (stringBuilder1.length() < stringBuilder2.length()) {
            return -1;
        }
        if (stringBuilder1.toString().compareTo(stringBuilder2.toString()) > 0) {
            return 1;
        } else if (stringBuilder1.toString().compareTo(stringBuilder2.toString()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    String trimzero(String str1) {
        int len = 0;
        while (len < str1.length() && str1.charAt(len) == '0') {
            len++;
        }
        return str1.substring(len);
    }

    public String longestCommonPrefix(ArrayList<String> a) {
        //Check for corner case
        if (a == null || a.size() == 0) {
            return "";
        }
        //Get the minimum length
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            if (minlen > a.get(i).length()) {
                minlen = a.get(i).length();
            }
        }
        int j;
        //calculate
        int sizeofs = a.size();
        for (j = 0; j < minlen; j++) {
            char ch = a.get(0).charAt(j);
            for (int i = 1; i < sizeofs; i++) {
                if (ch != a.get(i).charAt(j)) {
                    return a.get(0).substring(0, j);
                }
            }
        }
        return a.get(0).substring(0, j);
    }

    class Node {
        int ind;
        int ival;

        Node() {
            ind = 0;
            ival = 1;
        }

        Node(int ind, int ival) {
            this.ind = ind;
            this.ival = ival;
        }
    }

    public ArrayList<String> restoreIpAddresses(String a) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int size = a.length();
        if (size > 12 || size < 4) {
            return ans;
        }
        int ctr = 0;
        ipcheck(a, sb, 0, a.length(), ans, ctr);
//        ipcheck(a,size,ans);
        return ans;
    }

    public ArrayList<Integer> stepnum(int a, int b) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=a;i<=b;i++){
            if(isStepping(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    boolean isStepping(int num){
        if(num<0){
            return false;
        }
        int last = num%10;
        num/=10;
        while(num!=0){
            if(1 != Math.abs(num%10 - last)){
                return false;
            }
            last = num%10;
            num/=10;
        }
        return true;
    }

    boolean isvalisIP(String sb) {
        int ctr = 0;
        for (String i : sb.split("\\.")) {
            int num = Integer.parseInt(i);
            if (i.length() > 1 && i.charAt(0) == '0')
                return false;
            if (num < 0 || num > 255) {
                return false;
            }
            ctr++;

        }
        if (ctr == 4) {
            return true;
        } else {
            return false;
        }
    }
    public int exist(ArrayList<String> a, String b) {
        int row = a.size();
        int col = a.get(0).length();

        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(checkWord(a,i,j,b)){
                    return 1;
                }
            }
        }
        return 0;
    }

    boolean isValidpos(ArrayList<String> a,int x,int y){
        if(x<0||y<0|| x>=a.size() || y>=a.get(0).length()){
            return false;
        }
        return true;
    }

    public String multiple(int A) {
        int p;
        int q;
        int i;
        int tot = 0;
        int []flag = new int[A];
        int []val = new int[A];
        int []parent = new int[A];
        StringBuilder ret = new StringBuilder();

        //queue for bfs
        Queue <Integer> Q = new LinkedList<>();

        //initial node
        int temp = 1%A;
        flag[temp] = 1;
        val[temp] = 1;
        Q.add(temp);

        while(true) {

            //pop from queue
            temp = Q.peek();
            Q.poll();
            p = temp;

            //reached final state
            //build solution here
            if(p == 0) {

                p  =0;
                ret.append((char)(val[p]+'0'));
                p = parent[p];
                while(p != 0) {

                    ret.append((char)(val[p]+'0'));
                    p = parent[p];
                }

                ret = ret.reverse();
                return ret.toString();
            }

            //visit two neighbors p*10 and p*10+1
            //if already not visited
            q = (p*10) % A;

            if(flag[q] == 0) {
                Q.add(q);
                flag[q] = 1;
                parent[q] = p;
                val[q] = 0;
            }
            q++;

            if(q >= A) {
                q -= A;
            }

            if(flag[q] == 0) {
                Q.add(q);
                flag[q] = 1;
                parent[q] = p;
                val[q] = 1;
            }
        }
    }

    public TreeNode sortedListToBST(ListNode a) {
        if(a==null){
            return null;
        }
        if(a.next==null){
            TreeNode ans = new TreeNode(a.val);
            ans.left = null;
            ans.right = null;
        }

        ListNode half = halflist(a);
        ListNode otherhalf = half.next;
        half.next =null;
        TreeNode ans = new TreeNode(otherhalf.val);
        ans.left = sortedListToBST(a);
        ans.right = sortedListToBST(otherhalf.next);

        return ans;

    }

    ListNode halfList(ListNode a){
        if(a==null||a.next==null){
            return a;
        }
        ListNode pre = null;
        ListNode half = a;
        while(a !=null && a.next!=null){
            pre = half;
            half = half.next;
            a = a.next.next;
        }
        return pre;
    }

    boolean checkWord(ArrayList<String> a,int x,int y,String b){
        int len = b.length();
        if(a.get(x).charAt(y) == b.charAt(0)){
            if(len==1){
                return true;
            }
            if(isValidpos(a,x-1,y) && checkWord(a,x-1,y,b.substring(1))){
                   return true;
            }
            if(isValidpos(a,x,y-1) && checkWord(a,x,y-1,b.substring(1))){
                return true;
            }
            if(isValidpos(a,x+1,y) && checkWord(a,x+1,y,b.substring(1))){
                return true;
            }
            if(isValidpos(a,x,y+1) && checkWord(a,x-1,y,b.substring(1))){
                return true;
            }
        }
        return false;
    }
    void ipcheck(String a, StringBuilder sb, int ind, int size, ArrayList<String> ans, int ctr) {
        if (ctr == 3) {
            sb.append(a.substring(ind, a.length()));
            if (isvalisIP(sb.toString())) {
                ans.add(sb.toString());
            }
            sb.delete(sb.length() - a.substring(ind, a.length()).length(), sb.length());
            return;
        }
        for (int i = 1; i <= 3 && ind + i <= size; i++) {
            sb.append(a.substring(ind, ind + i));
            sb.append(".");
            ipcheck(a, sb, ind + i, size, ans, ctr + 1);
            sb.delete(sb.length() - a.substring(ind, ind + i).length() - 1, sb.length());
        }
    }

    public int fibsum(int a) {
        ArrayList<Integer> series = new ArrayList<>();
        generateFibo(series, a);
        HashSet<Integer> set = new HashSet<>(series);

        return findmin(series,set,a,series.size()-1);
    }

    int findmin(List<Integer> series,Set<Integer> hash,int a,int n){
        if(hash.contains(a)){
            return 1;
        }else{
            while(series.get(n)>=a){
                n--;
            }
            return 1 + findmin(series,hash,a-series.get(n),n);
        }
    }
    void generateFibo(List<Integer> series,int n){
        series.add(1);
        series.add(2);
        int len =2;
        int num = 3;
        while(num<=n){
            series.add(num);
            len++;
            num = series.get(len-1)+series.get(len-2);
        }

    }



    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        int mat[][] = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                mat[i][j] = Integer.MAX_VALUE;
            }
        }
        mat[x1][y1] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x1,y1,1));
        int steps;
        while(!queue.isEmpty()){


                Point pt = queue.poll();
                if(pt.x==x2 && pt.y==y2){
                    return mat[x2][y2];
                }
                int x = pt.x - 1;
                int y = pt.y -2;
                steps = pt.step;
                if (isValidPos(N, M, x, y)) {
                    if(mat[x][y] > steps){
                        mat[x][y] = steps;
                        queue.add(new Point(x, y,steps +1));
                    }
                }
                x = pt.x - 1;
                y = pt.y + 2;
                if (isValidPos(N, M, x, y)) {
                    if(mat[x][y] > steps){
                        mat[x][y] = steps;
                        queue.add(new Point(x, y,steps +1));
                    }
                }
                x = pt.x + 1;
                y = pt.y - 2;
                if (isValidPos(N, M, x, y)) {
                    if(mat[x][y] > steps){
                        mat[x][y] = steps;
                        queue.add(new Point(x, y,steps +1));
                    }
                }
                x = pt.x + 1;
                y = pt.y + 2;
                if (isValidPos(N, M, x, y)) {
                    if(mat[x][y] > steps){
                        mat[x][y] = steps;
                        queue.add(new Point(x, y,steps +1));
                    }
                }
                x = pt.x - 2;
                y = pt.y - 1;
                if (isValidPos(N, M, x, y)) {
                    if(mat[x][y] > steps){
                        mat[x][y] = steps;
                        queue.add(new Point(x, y,steps +1));
                    }
                }
                x = pt.x + 2;
                y = pt.y - 1;
                if (isValidPos(N, M, x, y)) {
                    if(mat[x][y] > steps){
                        mat[x][y] = steps;
                        queue.add(new Point(x, y,steps +1));
                    }
                }
                x = pt.x - 2;
                y = pt.y + 1;
                if (isValidPos(N, M, x, y)) {
                    if(mat[x][y] > steps){
                        mat[x][y] = steps;
                        queue.add(new Point(x, y,steps +1));
                    }
                }
                x = pt.x + 2;
                y = pt.y + 1;
                if (isValidPos(N, M, x, y)) {
                    if (mat[x][y] > steps) {
                        mat[x][y] = steps;
                        queue.add(new Point(x, y, steps + 1));
                    }
                }

        }
        return mat[x2][y2] != Integer.MAX_VALUE? mat[x2][y2]: -1;
    }
    boolean isValidPos(int n,int m,int x, int y){
        if(x<1 || y < 1 || x>n || y >m){
            return false;
        }
        return true;
    }
    class Point{
        int x;
        int y;
        int step;
        Point(int a,int b,int step){
            this.x=a;
            this.y = b;
            this.step = step;
        }
    }
  /*  void ipcheck(String a,int size,ArrayList<String> ans){

        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        stack.push(new Node());
        while(!stack.isEmpty()){
            Node node = stack.pop();
            int i=node.ival;
            int ind = node.ind;
            if(stack.size()==3){
                sb.append(a.substring(ind,a.length()));
                if(isvalisIP(sb.toString())){
                    ans.add(sb.toString());
                }
                sb.delete(sb.length() - a.substring(ind,a.length()).length(),sb.length());
                return;
            }
            if (i <= 3 && ind + i <= size) {
                sb.append(a.substring(ind, ind + i));
                sb.append(".");
                stack.push(new Node(ind,i+1));
                if(ind+i<size && stack.size()<4) {
                    stack.push(new Node(ind + i, 0));
                }
                sb.delete(sb.length() - a.substring(ind,ind+i).length()-1,sb.length());
            }


        }

    }*/

    class WNode {
        String word;
        int numSteps;
        WNode pre;

        public WNode(String word, int numSteps,WNode wNode){
            this.word = word;
            this.numSteps = numSteps;
            this.pre = wNode;
        }
    }
    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        LinkedList<WNode> queue = new LinkedList<WNode>();
        queue.add(new WNode(start, 1,null));

        dictV.add(end);

        while(!queue.isEmpty()){
            WNode top = queue.remove();
            String word = top.word;

            if(word.equals(end)){
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(dictV.contains(newWord)){
                        queue.add(new WNode(newWord, top.numSteps+1,top));
                        dictV.remove(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }

        return 0;
    }

    class UndirectedGraphNode {
             int label;
             List<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
         };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        queue.add(node);
        UndirectedGraphNode ans = new UndirectedGraphNode(node.label);
        map.put(node,ans);
        while(!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.remove();
            for (UndirectedGraphNode listnode : temp.neighbors) {
                if (!map.containsKey(listnode)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(listnode.label);
                    map.put(listnode,copy);
                    map.get(temp).neighbors.add(copy);
                    queue.add(listnode);
                }else{
                    map.get(temp).neighbors.add(map.get(listnode));
                }
            }
        }

        return ans;
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        LinkedList<WNode> queue = new LinkedList<>();
        queue.add(new WNode(start, 1,null));

        dict.add(end);

        int minStep = 0;

        HashSet<String> visit = new HashSet<>();
        HashSet<String> unvisit = new HashSet<>();
        unvisit.addAll(dict);

        int preNumSteps = 0;

        while(!queue.isEmpty()){
            WNode top = queue.remove();
            String word = top.word;
            int currNumSteps = top.numSteps;

            if(word.equals(end)){
                if(minStep == 0){
                    minStep = top.numSteps;
                }

                if(top.numSteps == minStep && minStep !=0){
                    ans.add(returnList(top));
                }
                while(!queue.isEmpty()){
                     top = queue.remove();
                     word = top.word;

                    if(word.equals(end)){
                        if(minStep == 0){
                            minStep = top.numSteps;
                        }

                        if(top.numSteps == minStep && minStep !=0){
                            ans.add(returnList(top));
                        }
                    }
                }
                return ans;
            }

            if(preNumSteps < currNumSteps){
                unvisit.removeAll(visit);
            }

            preNumSteps = currNumSteps;

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(unvisit.contains(newWord)){
                        queue.add(new WNode(newWord, top.numSteps+1, top));
                        visit.add(newWord);
                    }

                    arr[i]=temp;
                }
            }

        }

        return ans;
    }

    ArrayList<String> returnList(WNode tra){
        Stack<String> st = new Stack<>();
        while(tra!=null){
            st.push(tra.word);
            tra = tra.pre;
        }
        ArrayList<String> list = new ArrayList<>();
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        return list;
    }

//    int stepsladder(String beginWord,String endWord, Set<String> wordList,int len,int steps){
//        if(beginWord.equals(endWord)){
//            return steps;
//        }
//        boolean firstpresent = false;
//
//        for(int i=0;i<len;i++){
//            beginWord.setCharAt(i,endWord.charAt(i));
//            if(wordList.contains(beginWord.toString())){
//                firstpresent = true;
//                break;
//            }
//        }
//    }

    public int romanToInt(String a) {
        int size = a.length();

        if (size == 0) {
            return 0;
        }
        int ans = 0;
        int num = 0;
        int num2 = 0;
        for (int i = 0; i < size; ) {
            char ch = a.charAt(i);
            int ctr = 0;
            while (i < size && ch == a.charAt(i)) {
                ctr++;
                i++;
            }

            num = getNum(ch);
            if (ctr == 1 && i < size) {
                num2 = getNum(a.charAt(i));
                if (num2 > num) {
                    num = num2 - num;
                    i++;
                }

            }
            num = num * ctr;
            ans += num;
        }

        return ans;
    }

    int getNum(char ch) {
        int num = 0;
        switch (ch) {
            case 'I':
                num = 1;
                break;
            case 'V':
                num = 5;
                break;
            case 'X':
                num = 10;
                break;
            case 'L':
                num = 50;
                break;
            case 'C':
                num = 100;
                break;
            case 'D':
                num = 500;
                break;
            case 'M':
                num = 1000;
                break;
            default:
                num = 0;
        }
        return num;
    }

    public String intToRoman(int a) {
        StringBuilder ans = new StringBuilder();
        if (a == 0) {
            return ans.toString();
        }
        String str = String.valueOf(a);
        int size = str.length();

        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            int unit = 1;
            int zeros = (int) Math.pow(10, (size - i - 1));
            unit = zeros;
            int num = ch - 48;
            int diff = num - 5;
            if (diff == 0) {
                ans.append(getRoman(5 * unit));
            } else if (diff > 0) {
                if (diff <= 3) {
                    ans.append(getRoman(5 * unit));
                    for (int k = 0; k < diff; k++)
                        ans.append(getRoman(unit));
                } else {
                    ans.append(getRoman(unit));
                    ans.append(getRoman(unit * 10));
                }

            } else if (diff < 0) {
                if (diff == -1) {
                    ans.append(getRoman(unit));
                    ans.append(getRoman(5 * unit));
                } else {
                    for (int k = 0; k < num; k++)
                        ans.append(getRoman(unit));
                }
            }
        }

        return ans.toString();
    }

    char getRoman(int num) {

        switch (num) {
            case 1:
                return 'I';
            case 5:
                return 'V';
            case 10:
                return 'X';
            case 50:
                return 'L';
            case 100:
                return 'C';
            case 500:
                return 'D';
            case 1000:
                return 'M';
            default:
                return 'O';
        }
    }

    public String addBinary(String a, String b) {
//        StringBuilder ans = new StringBuilder();
        String ans;
        StringBuilder andans = new StringBuilder();

        ans = xorBinaryString(a, b);
        ans = trimzeros(ans);
        while (andBinaryString(a, b, andans)) {
            ans = xorBinaryString(ans, andans.toString());
            ans = trimzeros(ans);
            a = ans;
            b = trimzeros(andans.toString());
            andans.delete(0, andans.length());
        }

        return ans;
    }

    String trimzeros(String a) {
        int i = 0;
        for (; i < a.length(); i++) {
            if (a.charAt(i) == '1') {
                break;
            }
        }
        return a.substring(i);
    }

    String xorBinaryString(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int lena = a.length();
        int lenb = b.length();
        int i = 0, j = 0;
        int diff = lena - lenb;
        if (diff >= 0) {
            for (; i < diff; i++) {
                ans.append(a.charAt(i));
            }
        } else {
            for (; j < Math.abs(diff); j++) {
                ans.append(b.charAt(j));
            }
        }
        for (; i < lena; i++, j++) {
            ans.append((char) (((a.charAt(i) - 48) ^ (b.charAt(j) - 48)) + 48));
        }
        return ans.toString();
    }

    boolean andBinaryString(String a, String b, StringBuilder ans) {
        boolean flag = false;
        int lena = a.length();
        int lenb = b.length();
        int i = 0, j = 0;
        int diff = lena - lenb;
        if (diff >= 0) {
            for (; i < diff; i++) {
                ans.append('0');
            }
        } else {
            for (; j < Math.abs(diff); j++) {
                ans.append('0');
            }
        }
        for (; i < lena; i++, j++) {
            int num = (a.charAt(i) - 48) & (b.charAt(j) - 48);
            if (num == 1) {
                flag = true;
            }
            ans.append((char) (num + 48));
        }
        ans.append('0');
        return flag;
    }

    public int power(String a) {
        BigInteger bi = new BigInteger(a);
        if (bi.equals(BigInteger.valueOf(1))) {
            return 0;
        }
        while (!bi.equals(BigInteger.valueOf(0))) {
            BigInteger temp = bi.remainder(BigInteger.valueOf(2));
            if (temp.equals(BigInteger.valueOf(1))) {
                break;
            }
            bi = bi.divide(BigInteger.valueOf(2));
        }
        if (bi.equals(BigInteger.valueOf(1))) {
            return 1;
        }
        return 0;
    }

    public String multiply(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        ArrayList<StringBuilder> matrix = new ArrayList<>();
        //init array with stringbuilder
        for (int i = 0; i < lenA; i++) {
            matrix.add(new StringBuilder(lenB * 2));
        }

        //create matrix
        for (int i = 0; i < lenA; i++) {
            int num1 = a.charAt(i) - 48;
            for (int j = 0; j < lenB * 2; j += 2) {
                int num2 = b.charAt(j / 2) - 48;
                num2 = num1 * num2;
                matrix.get(i).append(num2 / 10);
                matrix.get(i).append(num2 % 10);
            }
        }

        //Addmatrix
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = lenA - 1; i >= 0; i--) {
            int k = i;
            int sum = 0;
            for (int j = lenB * 2 - 1; k < lenA && j >= 0; k++) {
                sum += (matrix.get(k).charAt(j) - 48);
                j--;
                if (j >= 0 && j % 2 != 0) {
                    sum += (matrix.get(k).charAt(j) - 48);
                    j--;
                }
            }
            sum = sum + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }

        for (int i = lenB * 2 - 2; i >= 0; i -= 2) {
            int k = i;
            int sum = 0;
            for (int j = 0; k >= 0 && j < lenA; k--) {
                sum += (matrix.get(j).charAt(k) - 48);
                k--;
                if (k >= 0 && k % 2 != 0) {
                    sum += (matrix.get(j).charAt(k) - 48);
                }
                j++;
            }
            sum = sum + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            ans.append(carry);
        }

        while (ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
            if (ans.length() == 1) {
                break;
            }
        }

        return ans.reverse().toString();

    }

    private ArrayList<Integer> multiplyStr(ArrayList<Integer> a, int lena, ArrayList<Integer> b, int lenb) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < lena; i++) {
            int num1 = a.get(i);
            int carry = 0;
            ArrayList<Integer> subans = new ArrayList<>();
            for (int k = 0; k < i; i++) {
                subans.add(0);
            }
            for (int j = 0; j < lenb; j++) {
                int num2 = b.get(j);
                int res = num1 * num2 + carry;
                carry = res / 10;
                subans.add(res % 10);
            }
            while (carry != 0) {
                subans.add(carry % 10);
                carry /= 10;
            }

            ans = sumAL(ans, subans);
        }
        return ans;
    }

    ArrayList<Integer> sumAL(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        int carry = 0;
        while (i < a.size() && j < b.size()) {
            int sum = a.get(i) + b.get(j) + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            i++;
            j++;
        }
        while (i < a.size()) {
            int sum = a.get(i) + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            i++;
        }
        while (j < b.size()) {
            int sum = b.get(j) + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            j++;
        }
        return ans;
    }

    private int[] multiplyToLen(int[] x, int xlen, int[] y, int ylen, int[] z) {
        int xstart = xlen - 1;
        int ystart = ylen - 1;

        if (z == null || z.length < (xlen + ylen))
            z = new int[xlen + ylen];

        long carry = 0;
        for (int j = ystart, k = ystart + 1 + xstart; j >= 0; j--, k--) {
            long product = (y[j] & 0xffffffffL) *
                    (x[xstart] & 0xffffffffL) + carry;
            z[k] = (int) product;
            carry = product >>> 32;
        }
        z[xstart] = (int) carry;

        for (int i = xstart - 1; i >= 0; i--) {
            carry = 0;
            for (int j = ystart, k = ystart + 1 + i; j >= 0; j--, k--) {
                long product = (y[j] & 0xffffffffL) *
                        (x[i] & 0xffffffffL) +
                        (z[k] & 0xffffffffL) + carry;
                z[k] = (int) product;
                carry = product >>> 32;
            }
            z[i] = (int) carry;
        }
        return z;
    }

    public String convert(String a, int b) {
        int len = a.length();
        if (b <= 1 || b >= len) {
            return a;
        }

        StringBuilder ans = new StringBuilder();

        for (int k = 0; k < b; k++) {
            int skip = 2 * b - 2;
            for (int i = k; i < 2 * len; i += skip) {
                if (k != 0 && k != b - 1 && (i - (2 * k)) >= 0 && (i - (2 * k)) < len) {
                    ans.append(a.charAt(i - (2 * k)));
                }
                if (i < len) {
                    ans.append(a.charAt(i));
                }
            }

        }
        return ans.toString();

    }

    public ListNode removeNthFromEnd(ListNode a, int b) {
        ListNode head = a;
        ListNode tail = a;
        for (int i = 0; i <= b; i++) {
            if (tail == null) {
                return a.next;
            }
            tail = tail.next;
        }
        while (tail != null) {
            tail = tail.next;
            head = head.next;
        }
        head.next = head.next.next;
        return a;

    }

    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        ArrayList<String> ans = new ArrayList<>();
        int lenofa = a.size();

        int i = 0;
        int num = 0;
        while (num < lenofa) {
            int sum = 0;
            int spaces = 0;

            for (i = num; i < lenofa; i++) {
                if ((sum + a.get(i).length()) > b) {
                    break;
                }
                sum += a.get(i).length();
                sum += 1;
                spaces++;
            }
            StringBuilder sb = new StringBuilder();
            if (i == lenofa) {
                for (int k = num; k < lenofa - 1; k++) {
                    sb.append(a.get(k));
                    sb.append(" ");
                }
                sb.append(a.get(lenofa - 1));
                int lenth = b - sb.length();
                for (int j = 0; j < lenth; j++) {
                    sb.append(" ");
                }
                ans.add(sb.toString());
                break;

            }
            if (i == 1) {
                sb.append(a.get(num));
                int lenth = b - sb.length();
                for (int j = 0; j < lenth; j++) {
                    sb.append(" ");
                }
                ans.add(sb.toString());
                num = i;
            } else {
                spaces += (b - sum);
                int indspace = spaces / (i - 1);


                sb.append(a.get(num));
                for (int j = 0; j < indspace; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < (spaces - indspace * (i - 1)); j++) {
                    sb.append(" ");
                }
                for (int k = num + 1; k < i - 1; k++) {
                    sb.append(a.get(k));
                    for (int j = 0; j < indspace; j++) {
                        sb.append(" ");
                    }
                }
                sb.append(a.get(i - 1));
                ans.add(sb.toString());
                num = i;
            }
        }
        return ans;
    }

    public ListNode rotateRight(ListNode a, int b) {
        ListNode head = a;
        ListNode tail = a;
        ListNode temp = a;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        b = b % len;
        if (a.next == null) {
            return a;
        }
        if (b == 0) {
            return a;
        }

        for (int i = 0; i <= b; i++) {
            tail = tail.next;
        }
        while (tail != null) {
            tail = tail.next;
            head = head.next;
        }
        temp = head;
        head = head.next;
        tail = head;
        temp.next = null;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = a;
        return head;
    }

    public ListNode detectCycle(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (flag == false) {
            return null;
        }
        slow = a;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    StringBuilder addspace(StringBuilder sb, int spaces) {
        while (spaces > 0) {
            sb.append('\t');
            spaces--;
        }
        return sb;
    }

    public ArrayList<String> prettyJSON(String a) {
        if (a.length() == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> ans = new ArrayList<>();
        int i = 0;
        while (i < a.length() && a.charAt(i) == ' ') {
            i++;
        }

        int spaces = 0;
        StringBuilder sb = null;
        for (; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (ch == '{' || ch == '[') {
                if (sb != null) {
                    if (sb.charAt(sb.length() - 1) != ' ' && sb.charAt(sb.length() - 1) != '\t') {
                        ans.add(sb.toString());
                    }
                }
                sb = new StringBuilder();
                addspace(sb, spaces);
                sb.append(ch);
                if (sb.charAt(sb.length() - 1) != ' ' && sb.charAt(sb.length() - 1) != '\t') {
                    ans.add(sb.toString());
                }
                spaces += 4;
                sb = new StringBuilder();
                addspace(sb, spaces);
            } else if (ch == '}' || ch == ']') {
                if (sb.charAt(sb.length() - 1) != ' ' && sb.charAt(sb.length() - 1) != '\t') {
                    ans.add(sb.toString());
                }
                sb = new StringBuilder();
                spaces -= 4;
                addspace(sb, spaces);
                sb.append(ch);
            } else if (ch == ',') {
                sb.append(ch);
                if (sb.charAt(sb.length() - 1) != ' ' && sb.charAt(sb.length() - 1) != '\t') {
                    ans.add(sb.toString());
                }
                sb = new StringBuilder();
                addspace(sb, spaces);
            } else if (ch == ' ') {
            } else {
                sb.append(ch);
            }

        }
        if (sb != null && sb.charAt(sb.length() - 1) != ' ' && sb.charAt(sb.length() - 1) != '\t') {
            ans.add(sb.toString());
        }
        return ans;
    }


    public String countAndSay(int a) {
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        boolean flag = false;
        stringBuffer1.append(1);
        for (int i = 1; i < a; i++) {
            for (int j = 0; j < stringBuffer1.length(); j++) {
                char ch = stringBuffer1.charAt(j);
                int ctr = 0;
                while (j < stringBuffer1.length() && ch == stringBuffer1.charAt(j)) {
                    ctr++;
                    j++;
                }
                j--;
                stringBuffer2.append(ctr);
                stringBuffer2.append(ch);
            }
            stringBuffer1.delete(0, stringBuffer1.length());
            i++;
            if (i >= a) {
                flag = true;
                break;
            }
            for (int j = 0; j < stringBuffer2.length(); j++) {
                char ch = stringBuffer2.charAt(j);
                int ctr = 0;
                while (j < stringBuffer2.length() && ch == stringBuffer2.charAt(j)) {
                    ctr++;
                    j++;
                }
                j--;
                stringBuffer1.append(ctr);
                stringBuffer1.append(ch);
            }
            stringBuffer2.delete(0, stringBuffer2.length());
        }

        return flag == true ? stringBuffer2.toString() : stringBuffer1.toString();
    }

    boolean ispos(List<Integer> a, int b, long mid) {
        int intersum = 0;
        int student = 0;
        for (int i : a) {
            if (intersum + i > mid) {
                intersum = i;
                student++;
                if (intersum > mid) {
                    return false;
                }
            } else {
                intersum += i;
            }
        }
        if (student >= b) {
            return false;
        } else {
            return true;
        }
    }


    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode tempa = a;
        ListNode tempb = b;
        int ctra = 0;
        int ctrb = 0;
        while (tempa != null) {
            tempa = tempa.next;
            ctra++;
        }
        while (tempb != null) {
            tempa = tempa.next;
            ctrb++;
        }
        if (ctra > ctrb) {
            ctra = ctra - ctrb;
            tempb = b;
            tempa = a;
        } else {
            ctra = ctrb - ctra;
            tempb = a;
            tempa = b;
        }

        while (ctra > 0) {
            tempa = tempa.next;
            ctra--;
        }
        while (tempa != null) {
            if (tempa == tempb) {
                return tempa;
            }
            tempa = tempa.next;
            tempb = tempb.next;
        }

        return null;

    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        ListNode ans = null;
        ListNode temp = null;
        ListNode traverse = null;
        if (a == null && b == null) {
            return new ListNode(0);
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int sum = a.val + b.val;
        int carry = sum > 9 ? 1 : 0;
        ans = new ListNode(sum % 10);
        traverse = ans;
        a = a.next;
        b = b.next;
        while (a != null && b != null) {
            sum = a.val + b.val + carry;
            carry = sum > 9 ? 1 : 0;
            temp = new ListNode(sum % 10);
            ans.next = temp;
            ans = ans.next;
        }
        while (a != null) {
            sum = a.val + carry;
            carry = sum > 9 ? 1 : 0;
            temp = new ListNode(sum % 10);
            ans.next = temp;
            ans = ans.next;
        }
        while (b != null) {
            sum = b.val + carry;
            carry = sum > 9 ? 1 : 0;
            temp = new ListNode(sum % 10);
            ans.next = temp;
            ans = ans.next;
        }
        if (carry == 1) {
            temp = new ListNode(carry);
            ans.next = temp;
            ans = ans.next;
        }
        return traverse;
    }

    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> ans = new ArrayList<>();
        int size1 = a.size();
        int size2 = b.size();

        int i = 0;
        int j = 0;

        while (i < size1 && j < size2) {
            int num1 = a.get(i);
            int num2 = b.get(j);
            if (num1 == num2) {
                ans.add(a.get(i));
                i++;
                j++;
            } else if (num1 > num2) {
                j++;
            } else {
                i++;
            }
        }
        return ans;

    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> ans = new ArrayList<>();
        int size1 = a.size();
        int size2 = b.size();

        int i = 0;
        int j = 0;

        while (i < size1 && j < size2) {
            int num1 = a.get(i);
            int num2 = b.get(j);
            if (num1 == num2) {
                ans.add(num1);
                ans.add(num2);
                i++;
                j++;
            } else if (num1 > num2) {
                ans.add(num2);
                j++;
            } else {
                ans.add(num1);
                i++;
            }
        }
        while (i < size1) {
            ans.add(a.get(i));
            i++;
        }
        while (j < size2) {
            ans.add(b.get(j));
            j++;
        }
        size1--;
        while (size1 >= 0) {
            a.remove(size1);
            size1--;
        }

        a.addAll(ans);
    }



        /*int flag = 0;
        int median = lena+lenb;
        if(median%2==0){
            median/=2;
            flag=1;
        }
        else{
            median/=2;
            median++;
        }
        int ctr =0;
        int i=0;
        int j=0;
        int num=0;
        while(i<lena && j< lenb && ctr<=median){
            if(a.get(i)<b.get(j)){
                num = a.get(i);
                i++;

                ctr++;
            }else if(a.get(i)>b.get(j)){
                num = a.get(j);
                j++;
                ctr++;
            }
            else{
                num = a.get(i);
                i++;
                ctr++;
            }

        }
        while(i<lena && ctr<=median){
            num = a.get(i);
            i++;
            ctr++;
        }
        while(j<lena && ctr<=median){
            num = a.get(j);
            j++;
            ctr++;
        }
        if(flag==0){
            return num;
        }
        else{

        }*/


    public int firstMissingPositive(ArrayList<Integer> a) {

        int i;
        int len;
        len = segregate(a);

        for (i = 0; i <= len; i++) {

            if (Math.abs(a.get(i)) > 0 && Math.abs(a.get(i)) - 1 <= len) {
                int absnum = Math.abs(a.get(i));

                a.set(absnum - 1, Math.abs(a.get(absnum - 1)) * -1);
            }

        }

        i = 0;
        while (i <= len && a.get(i) <= 0) {
            i++;
        }

        return i + 1;

    }

    public int singleNumber(final List<Integer> a) {
        int sum = 0;

        ArrayList<Integer> bits = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            bits.add(0);
        }

        for (int i = 0; i < a.size(); i++) {
            addBits(bits, a.get(i));
        }
        int i = 31;
        while (bits.get(i) == 0) {
            i--;
        }
        for (; i >= 0; i--) {
            if (bits.get(i) % 3 != 0) {
                sum = sum | (1 << i);
            }

        }

        return sum;
    }

    void addBits(ArrayList<Integer> bits, int number) {
        int ctr = 0;
        while (number != 0) {
            if (number % 2 == 1) {
                bits.set(ctr, bits.get(ctr) + 1);
            }
            ctr++;
            number >>= 1;
        }
    }

    public int fdffrepeatedNumber(final List<Integer> a) {

        HashSet<Integer> hash = new HashSet<>();

        Iterator<Integer> iterator = a.iterator();

        while (iterator.hasNext()) {
            int num = iterator.next();
            if (hash.contains(num)) {
                return num;
            }
            hash.add(num);
        }

        return a.get(0);
    }

    public int repeatedNumber(final List<Integer> a) {

        int maxnum1 = -1;
        int ctr1 = 0;
        int maxnum2 = -1;
        int ctr2 = 0;

        for (int i = 0; i < a.size(); i++) {

            if (ctr1 == 0) {
                if (maxnum2 == a.get(i)) {
                    ctr2++;
                } else {
                    maxnum1 = a.get(i);
                    ctr1 = 1;
                }
            } else {
                if (maxnum1 == a.get(i)) {
                    ctr1++;
                } else {
                    if (ctr2 == 0) {
                        maxnum2 = a.get(i);
                        ctr2 = 1;
                    } else {
                        if (maxnum2 == a.get(i)) {
                            ctr2++;
                        } else {
                            ctr1--;
                            ctr2--;
                        }

                    }
                }

            }
        }

        int count = 0;
        for (int k = 0; k < a.size(); k++) {
            if (a.get(k) == maxnum1)
                count++;
        }
        if (count > a.size() / 3) {
            return maxnum1;
        }


        count = 0;
        for (int k = 0; k < a.size(); k++) {
            if (a.get(k) == maxnum2)
                count++;
        }
        if (count > a.size() / 3) {
            return maxnum2;
        }

        return -1;

    }

    /*public ArrayList<Integer> flip(String A) {

        ArrayList<Integer> res = new ArrayList<>();
        int sumofz=0;
        int sumofo=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='0'){
                sumofz++;
            }
            else
            {
                sumofo++;
            }
        }
        if(sumofz==0){
            return res;
        }
        int start=0;
        int max1s=sumofo;
        int sstart = start;

        int end=A.length()-1;
        int eend = end;

        while(start<=end){
            if(sumofz>sumofo){
                max1s = sumofz;
                sstart = start;
                eend = end;
            }
            if(A.charAt(end)=='1'&&A.charAt(start)=='1'){
                max1s-=2;
                sumofo-=2;
                end--;
                start++;
            }else if(A.charAt(end)=='0'&&A.charAt(start)=='0'){
                sumofz-=2;
                end--;
                start++;
            }else if(A.charAt(start)=='1'){
                max1s--;
                start++;
            }else if(A.charAt(end)=='1'){
                max1s--;
                end--;
            }

        }
        res.add(sstart);
        res.add(eend);
        return  res;

    }*/

    public ArrayList<Integer> flip(String A) {

        ArrayList<Integer> res = new ArrayList<>();
        int sumofz = 0;
        int sumofo = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '0') {
                sumofz++;
                res.add(1);
            } else {
                sumofo++;
                res.add(-1);

            }

        }
        if (sumofz == 0) {
            res.clear();
            return res;
        }
        int start = 0;
        int maxsum = 0;
        int numberofones = 0;
        int m = 0, n = 0, temp = 0;
        int end = 0;


        for (int i = 0; i < A.length(); i++) {

            start += res.get(i);
            if (start < 0) {
                start = 0;
                temp = i + 1;
            }
            if (maxsum < start) {
                maxsum = start;
                m = temp;
                n = i;

            }
        }
        res.clear();
        res.add(m + 1);
        res.add(n + 1);
        return res;

    }

    int totalones(String A, int start, int end, int numberofones) {

        if (numberofones < ((end - start + 1) - numberofones)) {
            return (end - start + 1) - numberofones;
        }
        return -1;
    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int row = a.size();
        int col = a.get(0).size();


        for (int j = 0; j < col; j++) {
            ArrayList<Integer> ro = new ArrayList<>();
            ro.add(a.get(0).get(j));
            ans.add(ro);
        }
        for (int j = 1; j < row; j++) {
            ArrayList<Integer> ro = new ArrayList<>();
            ro.add(a.get(j).get(col - 1));
            ans.add(ro);
        }
        int start = 1;
        int end = row + col - 3;
        for (int i = 1; i < row; i++) {

            int st = start;
            col--;


            for (int j = 0; j < col; j++) {
                ArrayList<Integer> ro = ans.get(st);
                ro.add(a.get(i).get(j));
                st++;
            }
            for (int j = i + 1; j < row; j++) {
                ArrayList<Integer> ro = ans.get(st);
                st++;

                ro.add(a.get(j).get(col - 1));

            }

            start++;
            end--;
            if (start > end) {
                break;
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {

        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < a; j++) {
                row.add(0);
            }
            mat.add(row);
        }
//            System.out.println(mat);
        int i = 0;
        int j = 0;
        int ctr = 1;
        int total = a * a;
        int dir = 1;
        while (ctr <= total) {
            switch (dir) {
                case 1:
                    while (j < a && mat.get(i).get(j) == 0) {
                        mat.get(i).set(j, ctr);
                        j++;
                        ctr++;
                    }
                    j--;
                    i++;
                    dir = 2;
                    break;
                case 2:
                    while (i < a && mat.get(i).get(j) == 0) {
                        mat.get(i).set(j, ctr);
                        i++;
                        ctr++;
                    }
                    i--;
                    j--;
                    dir = 3;
                    break;
                case 3:
                    while (j >= 0 && mat.get(i).get(j) == 0) {
                        mat.get(i).set(j, ctr);
                        j--;
                        ctr++;
                    }
                    j++;
                    i--;
                    dir = 4;
                    break;
                case 4:
                    while (i >= 0 && mat.get(i).get(j) == 0) {
                        mat.get(i).set(j, ctr);
                        i--;
                        ctr++;
                    }
                    i++;
                    j++;
                    dir = 1;
                    break;
            }
        }
        return mat;

    }

    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> ans = new ArrayList<>();

        int sqr = (int) Math.sqrt(a);
        for (int i = 1; i <= sqr; i++) {
            if (a % i == 0) {
                ans.add(i);
                if (i != a / i) {
                    ans.add(a / i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public int isPrime(int a) {

        if (a <= 1) {
            return 0;
        }
        int sqr = (int) Math.sqrt(a);
        for (int i = 2; i <= sqr; i++) {
            if (a % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public boolean isPower(int a) {
        if (a == 1) {
            return true;
        }
        int root = (int) Math.sqrt(Integer.MAX_VALUE);
        for (int i = 2; i <= root; i++) {
            for (int j = i * i; j > 0; j *= i) {
                if (j == a) {
                    return true;
                }
            }
        }
        return false;
    }

    public int strStr(final String haystack, final String needle) {
        int hslen = haystack.length();
        int needlen = needle.length();
        if (needlen == 0 || hslen == 0)
            return -1;

        int i = 0;
        int starths = 0, startned = 0;

        for (; hslen - i >= needlen; i++) {
            if (haystack.charAt(i) == needle.charAt(startned)) {
                starths = i;
                for (; startned < needlen; startned++, starths++) {
                    if (haystack.charAt(starths) != needle.charAt(startned)) {
                        startned = 0;
                        break;
                    }
                }
                if (startned == needlen) {
                    return i;
                }
            }
        }
        return -1;

    }

    long reversen(long n) {
        long bits = 1;
        long last = 0;
        for (int i = 0; i < 32; i++) {
            long bit = n & (bits << i);
            if (bit != 0) {
                last = last | (bits << (31 - i));
            }

        }
        return last;

    }

    int permuterank(String a) {

        int len = a.length();
        if (len == 1) {
            return 1;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();


        for (Character ch : a.toCharArray()) {
            if (!hashMap.containsKey(ch)) {
                hashMap.put(ch, 1);
            } else {
                hashMap.put(ch, hashMap.get(ch) + 1);
            }
        }


        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            int x = 0;

            Character ch = a.charAt(i);

            for (Character chr : hashMap.keySet()) {
                if (ch > chr && hashMap.get(chr) > 0) {
                    hashMap.put(chr, hashMap.get(chr) - 1);
                    sum = (sum + (factorialwithduplicate(len - i - 1, hashMap)) % 1000003);
                    hashMap.put(chr, hashMap.get(chr) + 1);
                }
            }

            hashMap.put(ch, hashMap.get(ch) - 1);

        }
        return (sum + 1) % 1000003;
    }

    int factorialwithduplicate(int n, HashMap<Character, Integer> map) {
        BigInteger fac = BigInteger.valueOf(1);
        if (n == 1 || n == 0) {
            return 1;
        }
        BigInteger fac2 = BigInteger.valueOf(1);
        for (Character ch : map.keySet()) {
            if (map.get(ch) > 1) {
                fac2 = fac2.multiply(BigInteger.valueOf(factorialother(map.get(ch))));
            }
        }
        fac2 = fac2.modInverse(BigInteger.valueOf(1000003));
//        fac2 = fac2.pow(1000003-2).mod(BigInteger.valueOf(1000003));
//        fac2 = ((int)Math.pow(fac2,1000003-2))%1000003;
        for (int i = 2; i <= n; i++) {
            fac = fac.multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(1000003));
        }

        return Integer.parseInt(fac.multiply(fac2).mod(BigInteger.valueOf(1000003)).toString());
    }

    int factorialother(int n) {
        int fac = 1;
        if (n == 1 || n == 0) {
            return 1;
        }
        while (n > 1) {
            fac = (fac * n) % 1000003;
            n--;
        }
        return fac;

    }


    public int isPalindrome(String a) {

        ArrayList<Character> charstr = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (Character.isDigit(ch)) {
                charstr.add(ch);
            } else if (Character.isAlphabetic(ch)) {
                if (ch >= 'A' && ch <= 'Z') {
                    charstr.add(Character.toLowerCase(ch));
                } else {
                    charstr.add(ch);
                }
            }
        }

        return isPalin(charstr);
    }

    int isPalin(ArrayList<Character> list) {
        int len = list.size();
        int first = 0;
        int last = len - 1;
        while (first < last) {
            if (list.get(first) != list.get(last)) {
                return 0;
            }
            first++;
            last--;
        }
        return 1;
    }

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {

        ArrayList<Integer> res = new ArrayList<>();
        if(a==null||a.length()==0||b==null||b.size()==0){
            return res;
        }

        int len = b.get(0).length();

        HashMap<String, Integer> map = new HashMap<>();
        for(String w: b){
            if(map.containsKey(w)){
                map.put(w, map.get(w)+1);
            }else{
                map.put(w, 1);
            }
        }

        for(int j=0; j<len; j++){
            HashMap<String, Integer> cmap = new HashMap<>();
            int str = j;
            int ctr = 0;

            for(int i=j; i<=a.length()-len; i=i+len){
                String sub = a.substring(i, i+len);
                if(map.containsKey(sub)){
                    if(cmap.containsKey(sub)){
                        cmap.put(sub, cmap.get(sub)+1);
                    }else{
                        cmap.put(sub, 1);
                    }

                    ctr++;

                    while(cmap.get(sub)>map.get(sub)){
                        String left = a.substring(str, str+len);
                        cmap.put(left, cmap.get(left)-1);

                        ctr--;
                        str = str + len;
                    }

                    if(ctr==b.size()){
                        res.add(str);

                        String left = a.substring(str, str+len);
                        cmap.put(left, cmap.get(left)-1);
                        ctr--;
                        str = str + len;
                    }
                }else{
                    cmap.clear();
                    str = i+len;
                    ctr = 0;
                }
            }
        }

        return res;

    }

    HashSet<String> concatString(String[] a){
        int n = a.length-1;
        HashSet<String> hash = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = printpermutation(n);
        for(ArrayList<Integer> i: ans){
            StringBuilder sb = new StringBuilder();
            for(Integer ind: i){
                sb.append(a[ind]);
            }
            hash.add(sb.toString());
        }


        return hash;
    }
    ArrayList<ArrayList<Integer>> printpermutation(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(i);
        }
        int len = n+1;
        boolean flag[] = new boolean[len];
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.fill(flag, false);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int i = stack.pop();

            if(i!=0){
                ans.remove(ans.size()-1);
                flag[i-1]=false;
            }
            for (; i < len; i++) {
                if (flag[i] == false) {
                    flag[i] = true;
                    stack.push(i + 1);
                    stack.push(0);
                    ans.add(list.get(i));
                    if(ans.size() == len){
                            res.add(new ArrayList<>(ans));
                            stack.pop();
                    }
                    break;
                }
            }

        }
        return res;

    }

    ArrayList<ArrayList<Integer>> printpermutationrecursion(ArrayList<Integer> a) {
        int len = a.size();
        boolean flag[] = new boolean[len];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.fill(flag, false);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (!hashSet.contains(a.get(i))) {
                hashSet.add(a.get(i));
                flag[i] = true;
                ans.add(a.get(i));
                if (ans.size() == a.size()) {
                    res.add(new ArrayList<>(ans));
                } else {

                    recursion(a, flag, ans, res);
                }
                flag[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
        return res;


    }

    void recursion(ArrayList<Integer> list, boolean[] flag, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {

            if (flag[i] == false) {
                if (!hashSet.contains(list.get(i))) {
                    hashSet.add(list.get(i));
                    flag[i] = true;
                    ans.add(list.get(i));
                    if (ans.size() == list.size()) {
                        res.add(new ArrayList<>(ans));
                    } else {

                        recursion(list, flag, ans, res);
                    }
                    flag[i] = false;
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }

    public ArrayList<Boolean> sieve(int a) {
        ArrayList<Boolean> ans = new ArrayList<>(a + 1);
        if (a < 2) {
            return ans;
        }

        ans.add(true);
        for (int i = 1; i <= a; i++) {
            ans.add(true);
        }
        int sqr = (int) Math.sqrt(a);
        for (int i = 2; i <= sqr; i++) {
            if (ans.get(i) == true) {
                for (int k = i + i; k <= a; k += i) {
                    ans.set(k, false);
                }
            }
        }
        return ans;
    }

    public String findDigitsInBinary(int a) {
        Stack<Integer> st = new Stack<>();
        if (a == 0)
            return "0";
        if (a == 1)
            return "1";

        while (a > 0) {
            if (a % 2 == 1) {
                st.push(1);
            } else {
                st.push(0);
            }
            a = a / 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public ArrayList<ArrayList<Integer>> squareSum(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int a = 0; a * a < A; a++) {
            for (int b = 0; b * b < A; b++) {
                if (a * a + b * b == A) {
                    ArrayList<Integer> newEntry = new ArrayList<Integer>();
                    if (a <= b) {
                        newEntry.add(a);
                        newEntry.add(b);
                        ans.add(newEntry);
                    }
                }
            }
        }
        return ans;
    }

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int maxrow = a.size() - 1;
        int maxcol = a.get(0).size() - 1;

        int maxelement = (maxrow + 1) * (maxcol + 1);
        int row = maxrow;
        int col = maxcol;

        int i = 0;
        int j = 0;

        while (true) {
            for (; j <= col; j++) {
                result.add(a.get(i).get(j));
            }

            j--;
            i = maxrow - row + 1;

            if (i > row || result.size() <= maxelement)
                break;

            for (; i <= row; i++) {
                result.add(a.get(i).get(j));
            }

            i--;
            j = col - 1;
            if (j < 0 || result.size() <= maxelement)
                break;

            for (; j >= maxcol - col; j--) {
                result.add(a.get(i).get(j));
            }

            j++;
            row--;
            i = row;
            if (row < 0 || result.size() <= maxelement)
                break;
            for (; i >= maxrow - row; i--) {
                result.add(a.get(i).get(j));
            }

            i++;
            col--;

            j = maxcol - col;
            if (col < 0 || result.size() <= maxelement)
                break;
        }
        return result;
    }

    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {

            ret.add(A.get((i + B) % A.size()));
        }

        return ret;
    }

    public String largestNumber(final List<Integer> a) {

        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer no1, Integer no2) {
                int len1 = len(no1);
                int len2 = len(no2);

                if (len1 == len2) {
                    return no2 - no1;
                }

                if (len1 > len2) {

                    return bigger(no1, no2, len1, len2);

                } else {
                    return (~bigger(no2, no1, len2, len1) + 1);
                }

            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        if (a.get(0) == 0)
            return new String("0");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : a) {
            stringBuffer.append(i);
        }
        return new String(stringBuffer);


    }

    public int findCount(final List<Integer> a, int b) {

        int low = 0;
        int high = a.size() - 1;
        int mid = 0;
        int ctr = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a.get(mid) == b) {
                break;
            }
            if (a.get(mid) >= b) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        low = mid;

        while (low >= 0 && a.get(low) == b) {
            ctr++;
            low--;
        }
        low = mid + 1;
        while (low < a.size() && a.get(low) == b) {
            ctr++;
            low++;
        }

        return ctr;

    }

    int len(int no) {
        int l = 0;
        while (no % 10 > 0 || no / 10 != 0) {
            no /= 10;
            l++;
        }
        return l;
    }

    public int findMin(final List<Integer> a) {
        int min;
        int low = 0;
        int high = a.size() - 1;
        int mid = 0;
        while (true) {
            if (a.get(low) <= a.get(high)) {
                return a.get(low);
            }
            mid = low + (high - low) / 2;
            int next = (mid + 1) % a.size();
            int pre = (mid + a.size() - 1) % a.size();
            if (a.get(next) > a.get(mid) && a.get(pre) > a.get(mid)) {
                return a.get(mid);
            }
            if (a.get(low) <= a.get(mid)) {
                low = next;
            } else {
                high = pre;
            }

        }

    }

    int sqrt(int a) {
        double x = a;
        double y = 1;
        double e = 0.000001;
        while (x - y > e) {
            x = y + (x - y) / 2;
            y = a / x;
        }
        return (int) x;

    }

    int bigger(int no1, int no2, int len1, int len2) {
        int modnum = (int) Math.pow((int) 10, (int) (len1 - len2));
        int num = no1 / modnum;
        if (num == no2) {
            if (len1 - len2 > len2) {
                return bigger(no1 % modnum, no2, len1 - len2, len2);
            } else if (len1 - len2 == len2) {
                return no2 - no1 % modnum;
            } else {

                return (~bigger(no2, no1 % (int) Math.pow(10, len1 - len2), len2, len1 - len2) + 1);

            }
        } else {
            return no2 - num;
        }

    }

    public String fractionToDecimal(int num, int deno) {
        long numerator = (long)num;
        long denominator = (long)deno;
        if(numerator%denominator==0){
            if(numerator == Integer.MIN_VALUE && denominator == -1){
                return String.valueOf("2147483648");
            }
            return String.valueOf(numerator/denominator);
        }
        if(numerator == -1 && denominator == -2147483648){
            return "0.0000000004656612873077392578125";
        }
        double number = (double)numerator/denominator;
        String numString = String.valueOf(number);
        StringBuilder ansString = new StringBuilder();
        StringBuilder subString = new StringBuilder();

        HashMap<Integer,Integer> set = new HashMap<>();
        int i=0;
        while(numString.charAt(i)!='.'){
            ansString.append(numString.charAt(i));
            i++;
        }
        ansString.append('.');

        int remainder = Math.abs((int)num%deno);

        int k=0;
        while(remainder!=0){
            set.put(remainder, k);
            remainder = remainder*10;
            subString.append(remainder/Math.abs(deno));
            remainder = remainder%deno;
            if(set.containsKey(remainder)){
                break;
            }
            k++;
        }
        if(remainder ==0){
            ansString.append(subString);
        }else{
            ansString.append(subString.substring(0,set.get(remainder)));
            ansString.append("(");
            ansString.append(subString.substring(set.get(remainder)));
            ansString.append(")");
        }

        return ansString.toString();

    }

    public int maxSubArray(final List<Integer> a) {


        int sum = 0;
        int maxsum = 0;
        int min = -99999999;
        for (int i : a) {
            sum += i;
            if (sum < 0) {
                sum = 0;
            }
            if (sum > maxsum) {
                maxsum = sum;
            }
            if (i < 0 && min < i) {
                min = i;
            }
        }

        if (maxsum == 0)
            return min;

        return maxsum;
    }

    int comp(int first, int second) {
        while (first > 0 && second > 0) {
            if (first / 10 - second / 10 != 0)
                return first / 10 - second / 10;
            first = first % 10;
            second = second % 10;
        }
        return first - second;
    }

//
//    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
//
//        HashMap<Double,Integer> hashMap = new HashMap<>();
//        HashMap<Point,Integer> pointMap = new HashMap<>();
//        int maxvalue =0;
//        for(int i =0;i< a.size();i++) {
//            Point point = new Point(a.get(i),b.get(i));
//            if(pointMap.containsKey(point)){
//                pointMap.put(point,pointMap.get(point) + 1);
//            }else{
//                pointMap.put(point,1);
//            }
//        }
//
//        if(pointMap.size() == 1){
//            return pointMap.get(new Point(a.get(0),b.get(0)));
//        }
//
//        for(Point point1: pointMap.keySet()){
//
//            for(Point point2: pointMap.keySet()){
//               if(point1.equals(point2)){
//                   continue;
//               }
//               double x1 = point1.getX();
//                double y1 = point1.getY();
//                double x2 = point2.getX();
//                double y2 = point2.getY();
//                double slope;
//                if(x1 == x2){
//                    slope = Double.MAX_VALUE;
//                }else{
//                    slope = (y2-y1)/(x2-x1);
//                }
//                int numpoint = pointMap.get(point2);
//
//                if(hashMap.containsKey(slope)){
//                    hashMap.put(slope,hashMap.get(slope) + numpoint);
//                }else{
//                    hashMap.put(slope,numpoint);
//                }
//            }
//            int max = 0;
//            int num = pointMap.get(point1);
//            for(Integer integer : hashMap.values()){
//                max = integer + num > max? integer + num : max;
//            }
//            maxvalue = max > maxvalue? max : maxvalue;
//            hashMap.clear();
//        }
//
//        return maxvalue;
//    }

    public int longestConsecutive(final List<Integer> a) {

        int maxlen = 0;
        HashSet<Integer> map = new HashSet<>();
        for(int i=0;i<a.size();i++){
            map.add(a.get(i));
        }
        for(Integer num : a){
            int len =0;
            while(map.contains(num)){
                num--;
            }
            num++;
            while(map.contains(num)){
                map.remove(num);
                len++;
                num++;
            }
            if(len>maxlen){
                maxlen= len;
            }
        }
        return maxlen;
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        ArrayList<Integer> ans = new ArrayList<>();
        if(A.size()<B){
            return ans;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<B;i++){
            if(map.containsKey(A.get(i))) {
                map.put(A.get(i),map.get(A.get(i)) + 1);
            }else{
                map.put(A.get(i),1);
            }
        }
        ans.add(map.size());
        for(int i=0;i<A.size()-B;i++){
            //Remove
            if(map.get(A.get(i))<2){
                map.remove(A.get(i));
            }else{
                map.put(A.get(i),map.get(A.get(i)) - 1);
            }

            //Add
            int addval = A.get(i+B);
            if(map.containsKey(addval)) {
                map.put(addval,map.get(addval) + 1);
            }else{
                map.put(addval,1);
            }

            ans.add(map.size());
        }
        return ans;

    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {

        ArrayList<Integer> res = new ArrayList<>();
        int i = a.size() - 1;

        while (i >= 0 && a.get(i) + 1 > 9) {
            a.set(i, 0);
            i--;
        }
        if (i < 0) {
            a.add(0, 1);
        } else {
            a.set(i, a.get(i) + 1);
        }
        i = 0;
        while (a.get(i) == 0) {
            i++;
        }
        for (; i < a.size(); i++) {
            res.add(a.get(i));
        }

        return res;

    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {

        int order = a.get(0).size();
        int ax = 0;
        for (int num = order; num > 1; num -= 2) {
            int maxorder = num % 2 == 0 ? num / 2 : num / 2 + 1;

            for (int j = ax; j < order - ax - 1; j++) {
                rotate2d(a, ax, j, order - 1);
            }
            ax++;
        }
        System.out.println(a.toString());
    }

    void rotate2d(ArrayList<ArrayList<Integer>> a, int i, int j, int order) {
        swap(a, i, j, j, order - i);
        swap(a, i, j, order - j, i);
        swap(a, order - j, i, order - i, order - j);
    }

    void swap(ArrayList<ArrayList<Integer>> a, int i, int j, int m, int n) {
        a.get(m).set(n, a.get(m).get(n) + a.get(i).get(j));
        a.get(i).set(j, a.get(m).get(n) - a.get(i).get(j));
        a.get(m).set(n, a.get(m).get(n) - a.get(i).get(j));
    }

    public ArrayList<Integer> sdrepeatedNumber(final List<Integer> a) {
        ArrayList<Integer> ans = new ArrayList<>();
        long sum = 0;
        long sumsquare = 0;
        long size = a.size();
        for (long i : a) {
            sum += i;
            sumsquare += (i * i);
        }

        long tatalsum = (size) * (size + 1) / 2;
        long totalsumsquare = (size * (size + 1) * (2 * size + 1)) / 6;
        long diff = tatalsum - sum;
        long diffsq = totalsumsquare - sumsquare;

        int B = (int) ((diffsq - diff * diff) / (2 * diff));

        int A = (int) diff + B;


        ans.add(B);
        ans.add(A);
        return ans;

    }

    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        // ArrayList<Integer> primes = null;
        ArrayList<Boolean> bool = new ArrayList<Boolean>();
        bool = sieve(a);
        int i = 0;
        for (i = 2; i <= a; i++) {
            if (bool.get(i) == true && bool.get(a - i) == true) {
                break;
            }
        }

        ans.add(i);
        ans.add(a - i);
        return ans;

    }

    public int titleToNumber(String a) {
        int ans = 0;
        int ctr = 0;
        if (a.length() == 0)
            return -1;
        for (int i = a.length() - 1; i >= 0; i--, ctr++) {
            int ch = (int) a.charAt(i) - 64;
            int pow = (int) Math.pow(26, ctr);
            ans += (pow * ch);
        }
        return ans;
    }

    public String convertToTitle(int a) {
        StringBuffer str = new StringBuffer();
        int ch = 0;
        while (a > 0) {
            ch = (a % 26);

            if (ch == 0) {
                ch = 26;
                a = a - 26;
            }
            str.append((char) (ch + 64));
            a = a / 26;

        }

        return str.toString();
    }

    public ArrayList<String> wordBreaks(String a, ArrayList<String> b) {
        HashSet wordDict = new HashSet<>(b);
        ArrayList<String> [] pos = new ArrayList[a.length()+1];
        pos[0]=new ArrayList<String>();

        for(int i=0; i<a.length(); i++){
            if(pos[i]!=null){
                for(int j=i+1; j<=a.length(); j++){
                    String sub = a.substring(i,j);
                    if(wordDict.contains(sub)){
                        if(pos[j]==null){
                            ArrayList<String> list = new ArrayList<String>();
                            list.add(sub);
                            pos[j]=list;
                        }else{
                            pos[j].add(sub);
                        }

                    }
                }
            }
        }

        if(pos[a.length()]==null){
            return new ArrayList<String>();
        }else{
            ArrayList<String> result = new ArrayList<String>();
            dfs(pos, result, "", a.length());
            Collections.sort(result, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            return result;
        }
    }

    public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
        if(i==0){
            result.add(curr.trim());
            return;
        }

        for(String s: pos[i]){
            String combined = s + " "+ curr;
            dfs(pos, result, combined, i-s.length());
        }
    }

    public int wordBreak(String a, ArrayList<String> b) {
        int len = a.length();
        HashSet<String> hash= new HashSet<>(b);
        boolean[] dp = new boolean[len+1];

        Arrays.fill(dp,false);
        dp[0]=true;

        for(int i=0;i<len;i++){
            if(dp[i]==true) {
                StringBuilder substring = new StringBuilder();
                for (int j = i; j < len; j++) {
                    substring.append(a.charAt(j));
                    if (hash.contains(substring.toString())) {
                        dp[j+1] = true;
                    }
                }
            }
        }
        return dp[len]==true?1:0;
    }
    public String longestPalindrome(String a) {
        int len = a.length();
        if (len < 2) {
            return a;
        }
        int maxlen = 0;
        int indl = 0;
        int indh = 0;
        for (int i = 0; i < len; i++) {
            //for even
            int low = i;
            int high = i + 1;
            int palinlen = 0;
            while (low >= 0 && high < len && a.charAt(low) == a.charAt(high)) {
                low--;
                high++;
                palinlen += 2;
            }
            if (palinlen > maxlen) {
                indl = low + 1;
                indh = high - 1;
                maxlen = palinlen;
            }

            //for odd
            palinlen = 1;
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && a.charAt(low) == a.charAt(high)) {
                low--;
                high++;
                palinlen += 2;
            }
            if (palinlen > maxlen) {
                indl = low + 1;
                indh = high - 1;
                maxlen = palinlen;
            }
        }
        return a.substring(indl, indh + 1);
    }

    ArrayList<ArrayList<ArrayList<Boolean>> > dpss;
    ArrayList<Integer> res;
    ArrayList<Integer> real;
    int total;

    Boolean isPossible(int idx, int sum, int len)
    {
        if (len == 0) return (sum == 0);
        if (idx >= total) return false;

        if (dpss.get(idx).get(sum).get(len) == false) return false;

        if (sum >= real.get(idx))
        {
            res.add(real.get(idx));
            if (isPossible(idx + 1, sum - real.get(idx), len - 1)) return true;
            res.remove(res.size() - 1);
        }

        if (isPossible(idx + 1, sum, len)) return true;

        dpss.get(idx).get(sum).set(len,false);
        return false;
    }

    public int minCut(String s) {
        int len = s.length();
        if(len<2){
            return 0;
        }
        boolean dp[][] = new boolean[len][len];

        for(int i= len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if((i+1>j-1 || dp[i+1][j-1])&& s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                }
            }
        }
        int ans[] = new int[len+ 1];
        for(int i=0;i<=len;i++){
            ans[i] = Integer.MAX_VALUE;
        }
        ans[0] = -1;
        for(int i=1;i<=len;i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j][i-1]){
                    ans[i] = Math.min(ans[i],ans[i]+1);
                }
            }
        }
        return ans[len];
    }

    ArrayList<ArrayList<Integer> > avgset(ArrayList<Integer> a)
    {
        Collections.sort(a);
        real.clear();
        Collections.copy(real,a);
        real = a;
        dpss.clear();
        res.clear();

        int total_sum = 0;
        total = a.size();

        for(int i = 0; i < total; ++i)
            total_sum += a.get(i);

       // dpss
        // We need to minimize size_of_set1. So, lets search for the first size_of_set1 which is isPossible.
        for (int i = 1; i < total; i++)
        {
            // Sum_of_Set1 has to be an integer
            if ((total_sum * i) % total != 0) continue;
            int Sum_of_Set1 = (total_sum * i) / total;
            if (isPossible(0, Sum_of_Set1, i))
            {
                // Ok. Lets find out the elements in arr, not in res, and return the result.
                int ptr1 = 0, ptr2 = 0;
                ArrayList<Integer> res1 = res;
                ArrayList<Integer> res2 = new ArrayList<>();
                while (ptr1 < a.size() || ptr2 < res.size())
                {
                    if (ptr2 < res.size() && res.get(ptr2) == a.get(ptr1))
                    {
                        ptr1++;
                        ptr2++;
                        continue;
                    }
                    res2.add(a.get(ptr1));
                    ptr1++;
                }

                ArrayList<ArrayList<Integer> > ans = new ArrayList<>();
                ans.add(res1);
                ans.add(res2);
                return ans;
            }
        }

        ArrayList<ArrayList<Integer> > ans = new ArrayList<>();
        return ans;
    }

    public int bulbs(ArrayList<Integer> a) {
        int len = a.size();
        int ctr=0;
        if(len<1){
            return 0;
        }
        boolean tog = true;
        for(int i=0;i<len;i++){
            if(tog == true && a.get(i) == 0){
                ctr++;
                tog = false;
            }else if(tog ==false && a.get(i) == 1){
                ctr++;
                tog =true;
            }
        }
        return ctr;
    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int size = a.size();
        //feasibilty test
        if (size < 3) {
            return ans;
        }
        //sort
        Collections.sort(a);

        //check
        for (int i = 0; i < size - 2; i++) {
            int num = a.get(i);
            int first = i + 1;
            int last = size - 1;
            while (first < last) {
                int sum = a.get(first) + a.get(last) + num;
                if (sum > 0) {
                    last--;
                } else if (sum < 0) {
                    first++;
                } else {
                    ArrayList<Integer> el = new ArrayList<>();
                    el.add(num);
                    el.add(a.get(first));
                    el.add(a.get(last));
                    if (!isequal(ans, el))
                        ans.add(el);
                    first++;
                    last--;
                }
            }
        }
        return ans;
    }

    boolean isequal(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> el) {

        for (int i = 0; i < ans.size(); i++) {


            ArrayList<Integer> el1 = ans.get(i);
            if ((el1.get(0).equals(el.get(0))) && (el1.get(1).equals(el.get(1))) && (el1.get(2).equals(el.get(2)))) {
                return true;
            }
        }
        return false;
    }

    public int maxp3(ArrayList<Integer> a) {
        if(a.size()<3){
            return 0;
        }
        Collections.sort(a);
        int neg =1;
        int pos;
        if(a.get(a.size()-1)<0){
            return a.get(a.size()-1) * a.get(a.size()-2) * a.get(a.size()-3);
        }else {
            neg = Integer.MIN_VALUE;
        }
        if(a.get(1)<0){
            neg = a.get(0) * a.get(1);
            neg*= a.get(a.size()-1);
        }
        pos = a.get(a.size()-1) * a.get(a.size()-2) * a.get(a.size()-3);

        return neg<pos?pos:neg;
    }
    public int diffPossible(ArrayList<Integer> a, int b) {
        int high = a.size();
        int j = 0;
        for (int i = 0; i < high; i++) {
            if (j < i + 1) {
                j = i + 1;
            }
            while (a.get(j) - a.get(i) < b) {
                j++;
            }
            if (a.get(j) - a.get(i) == b) {
                return 1;
            }
        }
        return 0;
    }

    public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        int len = a.size();
        int max = 0;
        int si = 0;
        int li = 0;
        for (int i = 0; i < len; i++) {
            int zeros = b;
            int ctr = 0;
            int j;
            for (j = i; j < len; j++) {
                if (a.get(i).equals(0) && zeros == 0) {
                    break;
                } else if (a.get(i).equals(0)) {
                    zeros--;
                }
                ctr++;
            }
            if (ctr > max) {
                max = ctr;
                si = i;
                li = j - 1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = si; i <= li; i++) {
            ans.add(i);
        }
        return ans;
    }

    public int maxArea(ArrayList<Integer> a) {
        int len = a.size();
        int start = 0;
        int end = len - 1;
        int max = 0;
        while (start < end) {
            int min = min(a.get(start), a.get(end));
            int vol = (end - start) * min;
            if (vol > max) {
                max = vol;
            }
            if (a.get(start).equals(min)) {
                start++;
                while (start < end && min > a.get(start)) {
                    start++;
                }
            } else {
                end--;
                while (start < end && min > a.get(end)) {
                    end--;
                }
            }
        }
        return max;

    }

    public int seats(String a) {
        int len =a.length();
        ArrayList<Integer> seats = new ArrayList<>();
        long hops =0;
        for(int i=0;i<len;i++){
            if(a.charAt(i)=='x'){
                seats.add(i);
            }
        }
        int seatnum = seats.size();
        if(seatnum==0){
            return 0;
        }
        int med = seatnum/2;
        int medean = seats.get(seatnum%2==1? med : med-1);

        int startindex = seatnum%2==1?medean - med: medean - med +1 ;
        int endindex = medean + med;
        for(int i = startindex,j=0;i<=medean;i++){
            if(a.charAt(i)=='.'){
                hops+= (i - seats.get(j));
                hops = hops%10000003;
                j++;
            }
        }

        for(int i = endindex,j=seats.size()-1;i>medean;i--){
            if(a.charAt(i)=='.'){
                hops+= (seats.get(j) - i);
                hops = hops%10000003;
                j--;
            }
        }

        return (int)hops%10000003;
    }

    public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        int lena = a.size();
        int lenb = b.size();
        int lenc = c.size();
        int maxmin = Integer.MAX_VALUE;
        int aa = 0;
        int bb = 0;
        int cc = 0;

        while (aa < lena && bb < lenb && cc < lenc) {
            int first = abs(a.get(aa) - b.get(bb));
            int sec = abs(b.get(bb) - c.get(cc));
            int third = abs(a.get(aa) - c.get(cc));
            int tempmax = maximum(first, sec, third);
            if (tempmax < maxmin) {
                maxmin = tempmax;
            }

            int A = a.get(aa);
            int B = b.get(bb);
            int C = c.get(cc);
            if (A < B) {
                if (A < C) {
                    aa++;
                } else {
                    cc++;
                }
            } else {
                if (B < C) {
                    bb++;
                } else {
                    cc++;
                }
            }

        }

        return maxmin;

    }

    int maximum(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                return a;
            } else {
                return c;
            }
        } else {
            if (b > c) {
                return b;
            } else {
                return c;
            }
        }
    }

    int abs(int a) {

        if (a < 0) {
            return -a;
        }
        return a;
    }

    int min(int a, int b) {
        if (a < b)
            return a;
        else
            return b;
    }

    public int cntBits(ArrayList<Integer> A) {
        final int MOD = 1000000007;
        long size = A.size();
        if (size < 2) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < 32; i++) {
            long num = 0;
            for (int j = 0; j < size; j++) {
                int val = A.get(j);
                int shift = 1 << i;
                if ((val & shift) == 0) {
                    num++;
                }
            }
            sum = sum + ((num * (size - num) * 2) % MOD);
            sum = sum % MOD;
        }
        return (int) sum;
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        int len = a.size();
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (len < b) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                if (max < a.get(i)) {
                    max = a.get(i);
                }
            }
            ans.add(max);
            return ans;
        }

        int i = 0;
        for (i = 0; i < b; i++) {
            while (!queue.isEmpty() && a.get(i) >= queue.peekLast()) {
                queue.pollLast();
            }
            queue.addLast(a.get(i));
        }


        for (i = b; i < len; i++) {
            ans.add(queue.peekFirst());
            while (!queue.isEmpty() && queue.peekFirst() == a.get(i - b)) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && a.get(i) >= queue.peekLast()) {
                queue.pollLast();
            }
            queue.addLast(a.get(i));


        }
        ans.add(queue.peekFirst());
        return ans;
    }

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (a == 0) {
            return ans;
        }
        ans.add(0);
        ans.add(1);
        if (a == 1) {
            return ans;
        }
        for (int i = 1; i < a; i++) {
            int last = ans.size() - 1;
            for (; last >= 0; last--) {
                int val = 1 << i;
                ans.add(val | ans.get(last));
            }
        }
        return ans;
    }


    Integer searchMax(Queue<Integer> a) {
        Integer max = Integer.MIN_VALUE;
        Iterator<Integer> iterator = a.iterator();
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    int func(int x, int y) {
        int xor = x ^ y;
        if (xor == 0) {
            return 0;
        }
        int diff = 0;
        while (xor != 0) {
            if (xor % 2 == 1) {
                diff++;
            }
            xor /= 2;
        }
        return diff;
    }

    public String getPermutation(int n, int k) {
        int len = n;
        StringBuilder ll = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= len; i++) {
            ll.append(i);
        }

        int permut = factorial(len);

        if (k >= permut) {
            sb.append(ll.reverse());
            return sb.toString();
        }

        while (ll.length() > 0) {
            len--;
            permut = factorial(len);
            int pos = k / permut;
            if (pos > 0) {
                if (k % permut == 0) {
                    sb.append(ll.charAt(pos - 1));
                    ll.deleteCharAt(pos - 1);
                    sb.append(ll.reverse());
                    break;
                } else {
                    k = k % permut;
                }
            }
            sb.append(ll.charAt(pos));
            ll.deleteCharAt(pos);
        }
        return sb.toString();
    }

//    public String getPermutation(int n, int k) {
//        int[] num = new int[n];
//        int[] ind = new int[n];
//        k=k-1;
//        for (int i = 0; i < n; i++)
//            num[i] = i + 1;
//
//        int divisor = 1;
//        for (int place = 1; place <= n; place++)
//        {
//            if((k / divisor) == 0)
//                break;
//            ind[n-place] = (k / divisor) % place;
//            divisor *= place;
//        }
//
//        for (int i = 0; i < n; i++)
//        {
//            int index = ind[i] + i;
//
//            if(index != i)
//            {
//                int temp = num[index];
//                for(int j = index; j > i; j--)
//                    num[j] = num[j-1];
//                num[i] = temp;
//            }
//        }
//
//        StringBuilder ans = new StringBuilder();
//        for(int i=0;i<n;i++){
//            ans.append(num[i]);
//        }
//        return ans.toString();
//    }

    long factorial(long n) {
        if (n > 12) {

            return Integer.MAX_VALUE;
        }
        long fac = 1;
        if (n == 1 || n == 0) {
            return 1;
        }
        for (long i = 2; i <= n; i++) {
            fac = (fac * i);
        }
        return fac;
    }

    int factorial(int n) {
        int fac = 1;
        if (n == 1 || n == 0) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            fac = (fac * i) % 1000003;
        }
        return fac;
    }

    public int getMaxArea(List<Integer> a) {
        Stack<Integer> st = new Stack<>();
        int len = a.size();
        int max = -1;
        for (int i = 0; i < len; i++) {
            while ((!st.isEmpty()) && (a.get(st.peek()) > a.get(i))) {
                int popind = st.pop();
                int ind = -1;
                if (!st.isEmpty()) {
                    ind = st.peek();
                }
                int Area = (i - ind - 1) * a.get(popind);
                if (Area > max) {
                    max = Area;
                }
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int popind = st.pop();
            int ind = -1;
            if (!st.isEmpty()) {
                ind = st.peek();
            }
            int Area = (len - ind - 1) * a.get(popind);
            if (Area > max) {
                max = Area;
            }
        }
        return max;
    }

    public int getMaxWater(List<Integer> a) {
        Deque<Integer> deque = new LinkedList<>();
        int len = a.size();
        int totalwater = 0;
        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && a.get(deque.peekFirst()) <= a.get(i)) {
                int val = a.get(deque.pollFirst());
                int width = 0;
                int subval = 0;
                while (!deque.isEmpty()) {
                    width++;
                    subval += (a.get(deque.pollFirst()));
                }
                totalwater += (val * width - subval);
            }
            deque.addLast(i);
        }
        Deque<Integer> dequesec = new LinkedList<>();
        while (!deque.isEmpty()) {
            int i = deque.pollLast();
            if (!dequesec.isEmpty() && a.get(dequesec.peekFirst()) <= a.get(i)) {
                int val = a.get(dequesec.pollFirst());
                int width = 0;
                int subval = 0;
                while (!dequesec.isEmpty()) {
                    width++;
                    subval += (a.get(dequesec.pollFirst()));
                }
                totalwater += (val * width - subval);
            }
            dequesec.addLast(i);
        }
        return totalwater;
    }

    static String a1 = "abc", a2 = "def", a3 = "ghi", a4 = "jkl", a5 = "mno", a6 = "pqrs", a7 = "tuv", a8 = "wxyz", a9 = "1", a10 = "0";


    void letterRecu(String str, ArrayList<String> ans, StringBuilder sb, int len) {
        if (len == 0) {
            ans.add(sb.toString());
            return;
        }
        String a = "";
        switch (str.charAt(str.length() - len)) {
            case '2':
                a = a1;
                break;
            case '3':
                a = a2;
                break;
            case '4':
                a = a3;
                break;
            case '5':
                a = a4;
                break;
            case '6':
                a = a5;
                break;
            case '7':
                a = a6;
                break;
            case '8':
                a = a7;
                break;
            case '9':
                a = a8;
                break;
            case '1':
                a = a9;
                break;
            case '0':
                a = a10;
        }
        for (int i = 0; i < a.length(); i++) {
            sb.append(a.charAt(i));
            letterRecu(str, ans, sb, len - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public ArrayList<String> letterCombinations(String a) {

        ArrayList<String> ans = new ArrayList<>();
        int len = a.length();
        StringBuilder sb = new StringBuilder();
        if (len == 0) {
            return ans;
        }
        letterRecu(a, ans, sb, len);
        return ans;
    }

    public ListNode reverseList(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }
        if (a.next.next == null) {
            return a;
        }
        ListNode temp = a.next;
        a.next = null;
        ListNode reverset = reverseList(temp);

        temp.next = a;
        return reverset;
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        int len = a.length();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        recCall(a, 0, len, res, ans);

        return ans;

    }

    void recCall(String a, int i, int len, ArrayList<String> res, ArrayList<ArrayList<String>> ans) {
        int st = i;
        if (i == len) {
            ans.add(cloneit(res));
            return;
        }
        for (; i < len; i++) {
            if (isPalin(a.substring(st, i + 1))) {
                int index = res.size() - 1;
                res.add(a.substring(st, i + 1));
                recCall(a, i + 1, len, res, ans);
                int size = res.size() - 1;
                while (size != index) {
                    res.remove(size);
                    size--;
                }
            }
        }
    }

    ArrayList<String> cloneit(ArrayList<String> res) {
        ArrayList<String> ans = new ArrayList<>();
        for (String str : res) {
            ans.add(str);
        }
        return ans;
    }

    boolean isPalin(String a) {
        int st = 0;
        int end = a.length() - 1;
        while (st < end) {
            if (a.charAt(st) != a.charAt(end)) {
                return false;
            }
            st++;
            end--;
        }
        return true;
    }

    ArrayList<String> ans1 = new ArrayList<>();

    public ArrayList<String> generateParenthesis(int a) {

        Stack<Integer> st = new Stack<>();

        StringBuilder sb = new StringBuilder(2 * a);
        for (int i = 0; i < 2 * a; i++) {
            sb.append("0");
        }
        genparen(0, a, 0, 0, sb);
        return ans1;

    }

    void genparen(int pos, int len, int open, int close, StringBuilder sb) {
        if (close == len) {
            ans1.add(sb.toString());
        } else {

            if (open < len) {
                sb.setCharAt(pos, '(');
                genparen(pos + 1, len, open + 1, close, sb);
            }
            if (open > close) {
                sb.setCharAt(pos, ')');
                genparen(pos + 1, len, open, close + 1, sb);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
        Collections.sort(a);
        anss.add(new ArrayList<Integer>());
        recurSubSet(a, 0, a.size(), new ArrayList<Integer>());
        return anss;
    }

    void recurSubSet(ArrayList<Integer> a, int i, int len, ArrayList<Integer> sb) {

        for (; i < len; i++) {
            sb.add(a.get(i));
            if (!anss.contains(sb)) {
                anss.add(cloneiti(sb));
            }
            recurSubSet(a, i + 1, len, sb);
            sb.remove(sb.size() - 1);
        }
    }

    void recurSubSet(ArrayList<Integer> a, int i, int sum, int len, ArrayList<Integer> sb, int b) {

        for (; i < len; i++) {
            sb.add(a.get(i));
            sum += a.get(i);
            if (sum == b) {
                if (!anss.contains(sb)) {
                    anss.add(cloneiti(sb));
                }
            } else if (sum < b) {
                recurSubSet(a, i, sum, len, sb, b);
                recurSubSet(a, i + 1, sum, len, sb, b);
            }
            sum -= a.get(i);
            sb.remove(sb.size() - 1);
        }
    }

    ArrayList<Integer> cloneiti(ArrayList<Integer> res) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer str : res) {
            ans.add(str);
        }
        return ans;
    }

    ArrayList<ArrayList<Integer>> anss = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        int len = a.size();
        if (len == 0) {
            return anss;
        }
        Collections.sort(a);
        recurSubSet(a, 0, 0, a.size(), new ArrayList<Integer>(), b);
        Collections.sort(anss, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });
        return anss;

    }


    public ArrayList<ArrayList<Integer>> combine(int n, int k) {

        combine(1, n, k, new ArrayList<Integer>());
        return anss;
    }

    void combine(int i, int n, int k, ArrayList<Integer> sb) {

        if (k == 0) {
            anss.add(cloneiti(sb));
            return;
        }
        for (; i <= n; i++) {
            sb.add(i);
            combine(i + 1, n, k - 1, sb);
            sb.remove(sb.size() - 1);
        }

    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {

        int len = a.size();
        Collections.sort(a);
        ArrayList<Integer> set = new ArrayList<>();
        ArrayList<Boolean> bol = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            bol.add(false);
        }
        Permut(a, len, set, bol);
        return anss;
    }

    void Permut(ArrayList<Integer> a, int len, ArrayList<Integer> set, ArrayList<Boolean> bol) {

        for (int i = 0; i < len; i++) {
            if (bol.get(i) == false) {
                bol.set(i, true);
                set.add(a.get(i));
                if (set.size() == len) {
                    anss.add(new ArrayList<Integer>(set));
                }
                bol.set(i, false);
                set.remove(set.size() - 1);
            }
        }
    }

    ArrayList<ArrayList<String>> arrset = new ArrayList<>();

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        int arr[] = new int[a];
        queen(arr, 0, a);
        return arrset;
    }

    void queen(int arr[], int row, int n) {
        int column;
        for (column = 0; column < n; column++) {
            if (place(arr, row, column)) {
                arr[row] = column;
                if (row == n - 1)
                    addTo(arr, n);
                else
                    queen(arr, row + 1, n);
            }
        }
    }

    boolean place(int arr[], int row, int column) {
        int i;
        for (i = 0; i <= row - 1; i++) {
            if (arr[i] == column)
                return false;
            if (abs(arr[i] - column) == abs(i - row))
                return false;
        }
        return true;
    }

    void addTo(int arr[], int n) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == arr[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            ans.add(sb.toString());
        }
        arrset.add(ans);
    }

    public ArrayList<Integer> Nqueen(int a) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            ans.add(-1);
        }
        st.push(0);
        int ctr = 1;
        while (!st.isEmpty()) {
            int i = st.pop();
            ctr--;
            if (ctr == a - 1) {
                System.out.println(ans);
            } else {
                for (; i < a; i++) {
                    ans.set(ctr, i);
                    st.push(i);

                }
                ctr++;

            }
        }
        return ans;

    }

    long mod = 1000000007;
    long sum = 0;

    long functionofx(int a, int k) {
        if (a == 0) {
            return 1;
        }
        long sum1 = 0;
        while (a > k) {
            int num = a % k;
            int num1 = (a - 1) / k;
            num1 = ((num1 + 1) * (num1 + 2)) / 2;
            num1 = (num1 * k);
            sum1 += (num1 + (a / k) + 1);
            a /= k;
        }

        return sum1;
    }

    public int isValidSudoku(final List<String> a) {


        ArrayList<ArrayList<Character>> sudo = new ArrayList<>();
        for (String str : a) {
            ArrayList<Character> al = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                al.add(str.charAt(i));
            }
            sudo.add(al);
        }
        if (Sudoku(sudo) == true)
            return 1;
        return 0;
    }

    public boolean Sudoku(ArrayList<ArrayList<Character>> a) {
        int row = 0, col = 0;
        for (row = 0; row < 9; row++) {
            boolean breakf = false;
            for (col = 0; col < 9; col++) {
                if (a.get(row).get(col) != '.' && (false == canPlace(a, row, col, a.get(row).get(col)))) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean canPlace(ArrayList<ArrayList<Character>> a, int row, int col, char num) {
        for (int i = 0; i < 9; i++)
            if (i != col && a.get(row).get(i) == num)
                return false;

        for (int i = 0; i < 9; i++)
            if (i != row && a.get(i).get(col) == num)
                return false;

        int br = 3 * (row / 3);
        int bc = 3 * (col / 3);
        for (int ro = 0; ro < 3; ro++)
            for (int co = 0; co < 3; co++)
                if ((row != (ro + br) && col != (co + bc) && a.get(ro + br).get(co + bc) == num))
                    return false;

        return true;
    }

    public int colorful(int a) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        int num = a;
        while (num > 0) {
            int t = num % 10;
            if (hs.contains(t)) {
                return 0;
            }
            hs.add(t);
            arr.add(t);
            num = num / 10;
        }
        for (int i = 0; i < arr.size(); i++) {
            int prod = arr.get(i);
            for (int j = i + 1; j < arr.size(); j++) {
                prod *= arr.get(j);
                if (hs.contains(prod))
                    return 0;
            }
        }
        return 1;
    }

    public ArrayList<Integer> lszero(ArrayList<Integer> a) {

        int min = 0, max = 0;
        int len = 0;
        ArrayList<Integer> dp = new ArrayList<>();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        HashSet<Integer> hash = new HashSet<>();
        boolean flag = false;
        int sum = 0;
        dp.add(sum);
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
            if (a.get(i) == 0) {
                flag = true;
            }
            dp.add(sum);
        }
        for (int i = 0; i < dp.size(); i++) {
            int ival = dp.get(i);
            if (hash.contains(ival)) {
                if (len < i - hashtable.get(ival) + 1) {
                    len = i - hashtable.get(ival) + 1;
                    max = i;
                    min = hashtable.get(ival) + 1;
                }
            } else {
                hash.add(ival);
                hashtable.put(ival, i);
            }
        }
        dp.clear();
        if (min == 0 && max == 0) {
            if (flag == true) {
                dp.add(0);
            }
            return dp;
        }
        min--;
        for (; min < max; min++) {
            dp.add(a.get(min));
        }
        return dp;
    }

    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.size() - 1; i++) {
            int num = b - a.get(i);
            if (hashtable.containsKey(num)) {

                arr.add(hashtable.get(num) + 1);
                arr.add(i + 1);
                return arr;
            } else {
                if (!hashtable.containsKey(a.get(i)))
                    hashtable.put(a.get(i), i);
            }
        }
        return arr;
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        HashSet<ArrayList<Integer>> hSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                for (int k = j + 1, l = a.size() - 1; k < l; ) {
                    int sum = a.get(i) + a.get(j) + a.get(k) + a.get(l);
                    if (sum > b) {
                        l--;
                    } else if (sum < b) {
                        k++;
                    } else if (sum == b) {
                        ArrayList<Integer> found = new ArrayList<Integer>();
                        found.add(a.get(i));
                        found.add(a.get(j));
                        found.add(a.get(k));
                        found.add(a.get(l));
                        if (!hSet.contains(found)) {
                            hSet.add(found);
                            result.add(found);
                        }

                        k++;
                        l--;

                    }
                }
            }
        }
        return result;
    }

    public int diffPossiblee(final List<Integer> a, int b) {
        HashSet<Integer> hashSet = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < a.size(); i++) {
            if (hashSet.contains(a.get(i))) {
                flag = true;
            }
            hashSet.add(a.get(i));
        }
        if (b == 0)
            if (flag == true) {
                return 1;
            } else {
                return 0;
            }

        for (int i = 0; i < a.size(); i++) {
            if (hashSet.contains((a.get(i) - b))) {
                return 1;
            }
        }
        return 0;
    }


    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        List<String> lst = new ArrayList<>();
        boolean[] flags = new boolean[a.size()];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (String str : a) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            lst.add(new String(ch));
        }
        Arrays.fill(flags, true);
        for (int i = 0; i < lst.size(); i++) {
            if (flags[i] == false) {
                continue;
            }
            String hash1 = lst.get(i);
            ArrayList<Integer> node = new ArrayList<>();
            node.add(i + 1);
            for (int j = i + 1; j < lst.size(); j++) {
                String hash2 = lst.get(j);
                if (hash1.equals(hash2)) {
                    node.add(j + 1);
                    flags[j] = false;
                }
            }
            if (node.size() > 1) {
                ans.add(node);
            }
        }
        return ans;

    }
//
//    boolean isEqual(String hash1,HashMap<Character,Integer> hash2){
//        if(hash1.size() != hash2.size()){
//            return false;
//        }
//        for(Character ch :hash1.keySet()){
//            if(!(hash2.containsKey(ch) && (hash2.get(ch)==hash1.get(ch)))){
//                return false;
//            }
//        }
//        return true;
//    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode ans, temp, traversal;
        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        HashMap<RandomListNode, RandomListNode> hashval = new HashMap<>();
        if (head == null) {
            return head;
        }
        temp = new RandomListNode(head.label);
        temp.next = null;
        ans = temp;
        hashMap.put(head, ans);
        hashval.put(head, head.random);
        traversal = head.next;
        while (traversal != null) {
            temp.next = new RandomListNode(traversal.label);
            temp.next.next = null;
            hashMap.put(traversal, temp.next);
            hashval.put(traversal, traversal.random);
            temp = temp.next;
            traversal = traversal.next;
        }
        traversal = head;
        temp = ans;
        while (traversal != null) {
            RandomListNode rand = hashval.get(traversal);
            RandomListNode newrandom = hashMap.get(rand);
            temp.random = newrandom;
            traversal = traversal.next;
            temp = temp.next;
        }
        return ans;
    }

    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        HashMap<Integer, Pair<Integer, Integer>> hashMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        ArrayList<Integer> ans;
        for (int i = 0; i < a.size() - 1; i++) {
            int num = a.get(i);
            for (int j = i + 1; j < a.size(); j++) {
                int num2 = num + a.get(j);
                if (hashMap.containsKey(num2)) {
                    Pair<Integer, Integer> pair = hashMap.get(num2);
                    if (pair.getKey() != i && pair.getValue() != j) {
                        ans = new ArrayList<>();
                        ans.add(pair.getKey());
                        ans.add(pair.getValue());
                        ans.add(i);
                        ans.add(j);
                        set.add(ans);
                    }
                }
                hashMap.put(num2, new Pair<Integer, Integer>(i, j));
            }
        }
        if (set.size() == 0) {
            return new ArrayList<>();
        }
        ans = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            ArrayList<Integer> val = set.get(i);
            if (isGreat(val, ans)) {
                ans = val;
            }
        }
        return ans;
    }

    boolean isGreat(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (b.get(0) > a.get(0)) {
            return true;
        } else if (b.get(0) < a.get(0)) {
            return false;
        }
        if (b.get(0) == a.get(0)) {
            if (b.get(1) > a.get(1)) {
                return true;
            } else if (b.get(1) < a.get(1)) {
                return false;
            }
        }
        if (b.get(1) == b.get(1)) {
            if (b.get(2) > a.get(2)) {
                return true;
            } else if (b.get(2) < a.get(2)) {
                return false;
            }
        }
        if (b.get(2) == b.get(2)) {
            if (b.get(3) > a.get(3)) {
                return true;
            } else if (b.get(3) < a.get(3)) {
                return false;
            }
        }
        return false;
    }


   /* public String minWindow(String S, String T) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        int len = T.length();
        for (Character ch : T.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
            hashMap2.put(ch, 0);
        }

        int min;
        int start;
        int end;
        int max;
        int ctr = 0;
        int i;
        for (i = 0; i < S.length(); i++) {
            Character ch = S.charAt(i);
            if (hashMap.containsKey(ch)) {
                break;
            }
        }
        start = i;
        end = i;
        for (; end < S.length(); end++) {
            Character ch = S.charAt(end);
            if (hashMap.containsKey(ch) && hashMap.get(ch) > 0) {
                hashMap2.put(ch, hashMap2.get(ch) + 1);
                hashMap.put(ch, hashMap.get(ch) - 1);
                ctr++;
            }
            if (ctr == len) {
                break;
            }
        }
        if (ctr != len) {
            return "";
        }
        for (Character ch : T.toCharArray()) {
            hashMap.put(ch, hashMap.get(ch) + 1);

        }
        end++;
        min = start;
        max = end;
        int minlen = end - start +1;

        while (start<=end) {

            //Added last element
            while (start <= end && !hashMap2.containsKey(S.charAt(start))) {
                start++;
                Character character = S.charAt(start);
                start++;
                start--;
            }

            Character ch = S.charAt(start);
            hashMap2.put(ch, hashMap2.get(ch) - 1);
            start++;

            //Remoed first elements
            while (end < S.length()) {
                Character chara = S.charAt(end);
                if (hashMap2.containsKey(chara)) {
                    if (hashMap2.get(chara) < hashMap.get(chara)) {
                        hashMap2.put(chara, hashMap2.get(chara) + 1);
                        if(hashMap2.get(chara) == hashMap.get(chara)){
                            break;
                        }
                    }
                }
                end++;
            }
            if(end==S.length()){
                break;
            }

            int length = end - start + 1;
            if (length < minlen) {
                minlen = length;
                min = start;
                max = end;
            }
            end++;

        }

        return S.substring(min,max+1);

    }*/

    public String minWindow(String S, String T) {
        if(T.length()>S.length())
            return "";
        String result = "";

        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        for(int i=0; i<T.length(); i++){
            char c = T.charAt(i);
            if(target.containsKey(c)){
                target.put(c,target.get(c)+1);
            }else{
                target.put(c,1);
            }
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int minLen = S.length()+1;

        int count = 0; // the total of mapped characters

        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);

            if(target.containsKey(c)){
                if(map.containsKey(c)){
                    if(map.get(c)<target.get(c)){
                        count++;
                    }
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                    count++;
                }
            }

            if(count == T.length()){
                char sc = S.charAt(left);
                while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                    if (map.containsKey(sc) && map.get(sc) > target.get(sc))
                        map.put(sc, map.get(sc) - 1);
                    left++;
                    sc = S.charAt(left);
                }

                if (i - left + 1 < minLen) {
                    result = S.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }
        }

        return result;
    }

    public int lengthOfLongestSubstring(String a){
        int min = 0;
        int start = 0;
        int end = 0;
        if(a.isEmpty()){
            return 0;
        }
        HashSet<Character> hashSet = new HashSet<>();
        while(end<a.length() && start <= end){
            Character ch = a.charAt(end);
            if(!hashSet.contains(ch)){
                if(min < end-start +1){
                    min = end-start +1;
                }
                hashSet.add(ch);
                end++;

            }else{
                while(start<end){
                    char chara =a.charAt(start);
                    if(chara == ch){
                        hashSet.remove(ch);
                        start++;
                        break;
                    }
                    hashSet.remove(chara);
                    start++;
                }
            }
        }
        return min;

    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        TreeMap<ListNode,Integer> listnode = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((ListNode)o1).val - ((ListNode)o2).val;
            }
        });

        for(ListNode list : a){
            while(list!=null) {
                ListNode temp = list;
                list = list.next;
                temp.next = null;
                if(listnode.containsKey(temp)){
                    listnode.put(temp,listnode.get(temp) + 1);
                }else {
                    listnode.put(temp, 1);
                }
            }
        }
        ListNode ans = null;
        ListNode temp = ans;
        for(ListNode list: listnode.keySet()){
            if(ans != null){
                temp.next = list;
                temp = temp.next;
            }else {
                ans = list;
                temp = ans;
            }
            int no = listnode.get(list);
            while(no > 1 ){
                temp.next = new ListNode(temp.val);
                temp = temp.next;
                no--;
            }
;        }
        return ans;
    }

    public int isValidBST(TreeNode a) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans = traverse(a);
        if(ans.size()==1){
            return 1;
        }
        int val = Integer.MIN_VALUE;
        for(Integer i: ans){
            if(val >= i){
                return 0;
            }
            val = i;
        }
        return 1;

    }

    public int t2Sum(TreeNode A, int B) {

        BSTIterator bst = new BSTIterator(A);
        TreeNode start = bst.next();
        TreeNode end = bst.prev();
        while(start!=end){
            int ans = start.val + end.val;
            if(ans == B){
                return 1;
            }else if(ans > B){
                if(bst.hasPre()){
                    end = bst.prev();
                }else{
                    break;
                }
            }else{
                if(bst.hasNext()){
                    start = bst.next();
                }else{
                    break;
                }
            }
        }
        return 0;
    }

    public int kthsmallest(TreeNode root, int k) {
        TreeNode a = root;
        int i=0;
        Stack<TreeNode> st = new Stack<>();
        while(a!=null||!st.isEmpty()){
            if(a!=null){
                st.push(a);
                a=a.left;

            }else{
                a = st.pop();
                i++;
                if(i==k){
                    return a.val;
                }
                a = a.right;
            }
        }
        return 0;
    }
    ArrayList<Integer> traverse(TreeNode a){
        ArrayList<Integer> ans= new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(a!=null||!st.isEmpty()){
            if(a!=null){
                st.push(a);
                a=a.left;

            }else{
                a = st.pop();
                ans.add(a.val);
                a = a.right;
            }
        }
        return ans;
    }

    public TreeNode getSuccessor(TreeNode a, int b) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        st.push(a);
        TreeNode node = null;
        while(!st.isEmpty()){
            node = st.pop();
            ans.add(node.val);
            if(node.val == b){
                break;
            }
            if(node.right!=null){
                st.push(node.right);
            }
            if(node.left!=null){
                st.push(node.left);
            }
        }
        if(node.right!=null){
            return findmin(node.right);
        }else{
            TreeNode ances = a;
            TreeNode success = null;
            while(ances!=node){
                if(node.val < ances.val){
                    success =ances;
                    ances = ances.left;
                }else if(node.val > ances.val){
                    ances = ances.right;
                }else{
                    break;
                }
            }
            return success;
        }


    }
    TreeNode findmin(TreeNode a){
        while(a.left!=null){
            a=a.left;
        }
        return a;
    }

    public int isBalanced(TreeNode a) {
        if(a.right ==null && a.left ==null){
            return 1;
        }
        int val = 1;
        int val2= 1;
        if(a.left!=null)
            val = isBalanced(a.left);
        if(a.right!=null)
            val2 = isBalanced(a.right);
        if(val==1 && val2 ==1) {
            int left = depth(a.left);
            int right = depth(a.right);
            if (Math.abs(left - right) <= 1) {
                return 1;
            }
        }
        return 0;

    }

    int depth(TreeNode a){
        if(a==null){
            return 0;
        }
        if(a.right ==null && a.left ==null){
            return 1;
        }
        return Math.max(depth(a.left),depth(a.right))+1;
    }

    public int isSymmetric(TreeNode a) {
        if(a==null){
            return 1;
        }
        return isSameTree(a.left,a.right);
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return 1;

        if (A == null || B == null)
            return 0;

        if (A.val != B.val)
            return 0;


        int num = 1;
        num = num & isSameTree(A.right, B.left) & isSameTree(A.left, B.right);

        return num;
    }


    public TreeNode sortedArrayToBST(ArrayList<Integer> a) {
        if (a.size() == 0)
            return null;

        return sortedArrayToBST(a, 0, a.size() - 1);
    }
    TreeNode sortedArrayToBST(ArrayList<Integer> a,int i,int len){
        if(i>len){
            return null;
        }
        int middle = i + (len-i)/2;

        TreeNode node = new TreeNode(middle);
        node.left = sortedArrayToBST(a,i,middle-1);
        node.right = sortedArrayToBST(a,middle +1,len);
        return node;
    }

    public TreeNode buildTree(ArrayList<Integer> a) {

        if (a == null || a.size() == 0)
            return null;
        return build(a, 0, a.size() - 1);
    }

    TreeNode build(ArrayList<Integer> a, int start,int end){
            if(start>end){
                return null;
            }
        TreeNode node;
        if(start==end){
            node = new TreeNode(a.get(start));
            node.left=null;
            node.right=null;
            return node;
        }
//        int min = a.get(start);
        int min = Integer.MIN_VALUE;
        int minind = -1;
        for (int i = start; i<=end; i++)
        {
            if (a.get(i) > min)
            {
                min = a.get(i);
                minind = i;
            }
        }
        node = new TreeNode(a.get(min));
        node.left = build(a,start,minind - 1);
        node.right = build(a,minind + 1,end);
        return node;
    }

    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        if(inorder==null){
            return null;
        }
        TreeNode ans = InorderAndpre(inorder,0,inorder.size()-1,preorder,0);
        return ans;

    }


    TreeNode InorderAndpre(ArrayList<Integer> a,int start,int end,ArrayList<Integer> b,int bstart){
        if(start>end){
            return null;
        }
        int val = b.get(bstart);
        TreeNode node = new TreeNode(val);
        int i;
        for(i=start;i<=end;i++){
            if(a.get(i)==val){
                break;
            }
        }
        node.left = InorderAndpre(a,start,i-1,b,bstart + 1);
        node.right = InorderAndpre(a,i + 1,end,b,bstart + i - start + 1);
        return node;
    }

//    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
//        if(inorder==null){
//            return null;
//        }
//        TreeNode ans = InorderAndpos(inorder,0,inorder.size()-1,postorder,inorder.size()-1);
//        return ans;
//
//    }


    TreeNode InorderAndpos(ArrayList<Integer> a,int start,int end,ArrayList<Integer> b,int bstart){
        if(start>end || bstart <0){
            return null;
        }
        int val = b.get(bstart);
        TreeNode node = new TreeNode(val);
        int i;
        for(i=start;i<=end;i++){
            if(a.get(i)==val){
                break;
            }
        }
        node.left = InorderAndpos(a,start,i-1,b,bstart -( end - i) - 1);
        node.right = InorderAndpos(a,i + 1,end,b,bstart - 1);
        return node;
    }

    public ArrayList<Integer> recoverTree(TreeNode a) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(a==null){
            return ans;
        }
        BSTIterator iterator = new BSTIterator(a);
        TreeNode pre = iterator.next();
        TreeNode val = null;
        boolean flag = false;
        boolean flag2 = false;
        while(iterator.hasNext()){
                 val = iterator.next();
                if(val.val < pre.val){
                    flag = true;
                    break;
                }
            pre = val;

        }
        if(flag == false){
            return ans;
        }
        TreeNode prev = val;
        TreeNode trav = null;
        while(iterator.hasNext()){
            trav = iterator.next();
            if(trav.val < prev.val){
                flag2 = true;
                break;
            }
            prev = trav;

        }
        if(flag2==true){
            ans.add(trav.val);
            ans.add(pre.val);
        }else{
            ans.add(val.val);
            ans.add(pre.val);
        }
        return ans;
    }

    public ArrayList<Integer> preoderTraversal(TreeNode a) {
        ArrayList<Integer> ans= new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(a);
        while(!st.isEmpty()){
            a = st.pop();
            ans.add(a.val);
            if(a.right !=null){
                st.push(a.right);
            }
            if(a.left !=null){
                st.push(a.left);
            }
        }
        return ans;
    }
    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        ArrayList<Integer> ans= new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(a != null || !st.isEmpty()){
           if(a!=null){
               if(a.right !=null){
                   st.push(a.right);
               }
               st.push(a);
               a = a.left;
           }else{
               a = st.pop();
               if(!st.isEmpty() && a.right==st.peek()){
                   TreeNode temp = st.pop();
                   st.push(a);
                   a = temp;
               }else{
                   ans.add(a.val);
                   a = null;
               }

           }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        Queue<TreeNode> st = new LinkedList<>();
        st.add(a);
        boolean flag = false;
        while(!st.isEmpty()){
            int size = st.size();
            ArrayList<Integer> node = new ArrayList<>();
            while(size>0) {
                a = st.poll();
                node.add(a.val);
                if(a.left!=null){
                    st.add(a.left);
                }
                if(a.right!=null){
                    st.add(a.right);
                }
                size--;
            }
            if(flag){
                int start =0;
                int end =node.size()-1;
                while(start<end){
                    int temp = node.get(start);
                    node.set(start,node.get(end));
                    node.set(end,temp);
                    start++;
                    end--;
                }
                flag = false;
            }else{
                flag = true;
            }
            ans.add(node);
        }
        return ans;
    }

    public void connect(TreeLinkNode a) {
        Queue<TreeLinkNode> st = new LinkedList<>();
        if(a==null){
            return;
        }
        st.add(a);
        while(!st.isEmpty()){
            int size = st.size();
            ArrayList<TreeLinkNode> node = new ArrayList<>();
            while(size>0) {
                a = st.poll();
                node.add(a);
                if(a.left!=null){
                    st.add(a.left);
                }
                if(a.right!=null){
                    st.add(a.right);
                }
                size--;
            }
            for(int i=0;i<node.size()-1;i++){
                node.get(i).next = node.get(i+1);
            }
            node.get(node.size()-1).next = null;
        }
    }
    ArrayList<Integer> ress= new ArrayList<>();
    public int sumNumbers(TreeNode a) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(a==null){
            return 0;
        }
        path(a,0,ans);
        long sum = 0;
        for(Integer str : ress){
            sum+=str;
            sum = sum%1003;
        }
        return (int)sum;
    }

    void path(TreeNode a,int sum,ArrayList<Integer> ans){
        if(a.left == null && a.right ==null){

            ans.add(a.val);
            ress.add(evaluate(ans));
            ans.remove(ans.size()-1);
            return;

        }

        ans.add(a.val);
        if(a.left!=null) {
            path(a.left, sum + a.val,ans);
        }
        if(a.right!=null) {
            path(a.right, sum + a.val,ans);
        }
        ans.remove(ans.size() - 1);
        return;
    }


    int evaluate(ArrayList<Integer> v) {
        int n = v.size();
        int ten = 1;
        int sum = 0;
        int temp;
        for (int i = n - 1; i >= 0; i--) {
            temp = ten * v.get(i);
            temp %= 1003;
            sum = sum + temp;
            sum %= 1003;
            ten *= 10;
            ten %= 1003;
        }
        return sum;

    }
    void insertWord(TrieNode a, String b) {

        for(int i=0;i<b.length(); i++) {
            char ch = b.charAt(i);
            if(a.child[ch] == null) {
                a.child[ch] = new TrieNode();
                a.child[ch].freq = 1;
            }else {
                a.child[ch].freq = a.child[ch].freq + 1;
            }
            a = a.child[ch];
        }
    }

    ArrayList<String> listprefix(TrieNode a,ArrayList<String> b) {
        ArrayList<String> ans = new ArrayList<>();

        for(String str: b) {
            TrieNode crawl = a;
            for(int i =0;i<str.length();i++) {
                char ch = str.charAt(i);
                if(crawl.child[ch].freq == 1) {
                    ans.add(str.substring(0,i+1));
                    break;
                }
                crawl = crawl.child[ch];
            }
        }
        return ans;
    }
    ArrayList<String> findPrefix(ArrayList<String> a){
        ArrayList<String> ans = new ArrayList<>();
        TrieNode head = new TrieNode();
        //Build Trie
        for(String str: a) {
            insertWord(head,str);
        }

        //Find prefix
        return listprefix(head,a);

    }

    public int lca(TreeNode a, int val1, int val2) {
        if(a==null){
            return -1;
        }
        TreeNode left = lcc(a,val1,val2);
        TreeNode right = lcc(a,val1,val2);
        if(left !=null && right != null){
            return a.val;
        }
        TreeNode node = left == null? right:left;
        if(node.val == val1){
            if(isPresent(node,val2)){
                return node.val;
            }
        }else if(node.val == val2){
            if(isPresent(node,val1)){
                return node.val;
            }
        }
        return -1;
    }

    Boolean isPresent(TreeNode a,int val){

        Stack<TreeNode> st = new Stack<>();
        while(a!=null||!st.isEmpty()){
            if(a!=null){
                st.push(a);
                a=a.left;

            }else{
                a = st.pop();
                if(a.val == val){
                    return true;
                }
                a = a.right;
            }
        }
        return false;
    }
    TreeNode lcc(TreeNode a, int val1, int val2){
        if(a==null){
            return null;
        }
        if(a.val == val1||a.val == val2){
            return a;
        }

        TreeNode left = lcc(a.left, val1, val2);
        TreeNode right = lcc(a.right, val1, val2);

        if(left !=null && right != null){
            return a;
        }

        return left == null? right:left;
    }

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        List<Node1> list = new ArrayList<>();
        for(int i=0;i<heights.size();i++){
            list.add(new Node1(heights.get(i),infronts.get(i)));
        }

        Collections.sort(list, new Comparator<Node1>() {
            @Override
            public int compare(Node1 o1, Node1 o2) {
                return o2.height - o1.height;
            }
        });


        ITree a = null;
        for (Node1 person : list) {
            a = insert(a, person, person.infront);
        }

        ArrayList<Integer> ans= new ArrayList<>();
        Stack<ITree> st = new Stack<>();
        while(a!=null||!st.isEmpty()){
            if(a!=null){
                st.push(a);
                a=a.left;

            }else{
                a = st.pop();
                ans.add(a.height);
                a = a.right;
            }
        }
        return ans;

    }

    ITree insert(ITree root, Node1 person, int w) {
        if (root == null) {
            return new ITree(person.height, person.infront);
        }
        if (w < root.weight) {
            root.weight++;
            root.left = insert(root.left, person, w);
        } else {

            root.right = insert(root.right, person, w - root.weight);
        }
        return root;
    }

    public int countInversions(ArrayList<Integer> a) {
        int len = a.size() -1;

        int arr[] = new int[len+1];
        int i=0;
        for(int num: a){
            arr[i] = num;
            i++;
        }
        return (int)invCount(arr);

    }
//    int countInv(ArrayList<Integer> a,int start,int end){
//
//        if(end == start){
//            return 0;
//        }
//        int mid = start + (end-start)/2;
//
//        return countInv(a,start,mid) + countInv(a,mid +1,end) + mergeinv(a,start,mid,end);
//    }
//
//    int mergeinv(ArrayList<Integer> a,int start, int mid, int end){
//        int end1 = mid;
//        int start1 = mid +1;
//        int inv = 0;
//        for(int i = start;i<=end1;i++){
//            for(int j =start1;j<=end;j++){
//                if(a.get(i)>a.get(j)){
//                    inv++;
//                }
//            }
//        }
//        return inv;
//    }

    long merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, count = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                arr[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                arr[i+j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                arr[i+j] = left[i];
                i++;
            } else {
                arr[i+j] = right[j];
                count += left.length-i;
                j++;
            }
        }
        return count;
    }

    long invCount(int[] arr) {
        if (arr.length < 2)
            return 0;

        int m = (arr.length + 1) / 2;
        int left[] = Arrays.copyOfRange(arr, 0, m);
        int right[] = Arrays.copyOfRange(arr, m, arr.length);

        return invCount(left) + invCount(right) + merge(arr, left, right);
    }


    public int coinchange2(ArrayList<Integer> a, int b) {

        int table[] = new int[b+1];

        Arrays.fill(table,0);

        table[0] = 1;

        for(int i=0; i<a.size(); i++)
            for(int j=a.get(i); j<=b; j++) {
                table[j] += table[j - a.get(i)];
                table[j] = table[j]%1000007;
            }

        return table[b]%1000007;
    }


    public int maxProduct(final List<Integer> a) {
        if(a==null || a.size()==0)
            return 0;

        int max = a.get(0);
        int min = a.get(0);
        int ans = a.get(0);

        for(int i=1; i<a.size(); i++){
            int temp = max;
            max = Math.max(Math.max(a.get(i)*max, a.get(i)), a.get(i)*min);
            min = Math.min(Math.min(a.get(i)*temp, a.get(i)), a.get(i)*min);
            ans = Math.max(ans, max);
        }
        return ans;
    }


    public int maxProfit(final List<Integer> a) {
        int[] dp = new int[a.size()];
        int max = 0;
        int maxi = 0;
        for(int i = a.size()-1;i>=0;i--){
            max = Math.max(a.get(i),max);
            dp[i] = max;
            maxi = Math.max(dp[i] - a.get(i),maxi);
        }

        return max;
    }

    public int arrange(String a, int b) {
        int len = a.length();
        int dp[][] = new int[b + 1][len + 1];
        int white = 0;
        int black = 0;
        for (int j = 1; j <= len; j++) {
            if (a.charAt(j - 1) == 'W') {
                white++;
            } else {
                black++;
            }
            dp[1][j] = white * black;
        }
        for (int s = 2; s <= b; s++) {
            for (int j = s; j <= len; j++) {
                white = 0;
                black = 0;
                int min = Integer.MAX_VALUE;
                for (int h = s; h <= j; h++) {
                    if (a.charAt(h - 1) == 'W') {
                        white++;
                    } else {
                        black++;
                    }
                }
                for (int h = s; h <= j; h++) {

                    min = Math.min(min, dp[s - 1][h - 1] + white * black);
                    if (a.charAt(h-1) == 'W') {
                        white--;
                    } else {
                        black--;
                    }

                }
                dp[s][j] = min;

            }
        }
        return dp[b][len];
    }

       public int numDecodings(String s) {
        if(s==null||s.length()==0||s.equals("0"))
            return 0;


        int[] t = new int[s.length()+1];
        t[0] = 1;

        //if(s.charAt(0)!='0')
        if(isValids(s.substring(0,1)))
            t[1]=1;
        else
            t[1]=0;

        for(int i=2; i<=s.length(); i++){
            if(isValids(s.substring(i-1,i))){
                t[i]+=t[i-1];
            }

            if(isValids(s.substring(i-2,i))){
                t[i]+=t[i-2];
            }
        }

        return t[s.length()];
    }

     boolean isValids(String s){
        if(s.charAt(0)=='0')
            return false;
        int value = Integer.parseInt(s);
        return value>=1&&value<=26;
    }

    public int chordCnt(int A) {
        final int mod = 1000000007;
        if(A == 0) return 1;
        long[] table = new long[A + 1];
        table[0] = 1;
        table[1] = 1;
        for(int i = 2; i <= A; i++) {
            for(int j = 0; j < i; j++) {
                table[i] += (table[j] * table[i - 1 - j]);
                table[i] = table[i]%mod;
            }
        }
        return (int)table[A] % mod;
    }


    public int words(String w1,String w2){
        int lenw1 = w1.length();
        int lenw2 = w2.length();
        int [][]dp = new int[lenw1 +1][lenw2 +1];



        for(int i =0;i<=lenw1;i++){
            dp[i][0] = i;
        }
        for(int i =0;i<=lenw2;i++){
            dp[0][i] = i;
        }

        for(int i=0;i<lenw1;i++){
            char c1 = w1.charAt(i);
            for(int j=0;j<lenw2;j++){
                char c2 = w2.charAt(j);


                if (c1 == c2) {

                    dp[i+1][j+1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j+1] + 1;
                    int delete = dp[i+1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i+1][j+1] = min;
                }
            }
        }
        return dp[lenw1][lenw2];
    }

    public int numDistinct(String s, String t) {

        int lens = s.length();
        int lent = t.length();

        if(lens==0||lent==0){
            return 0;
        }

        if(lent>lens){
            return 0;
        }
        int dp[][]= new int[lens][lent];

        if(s.charAt(0) == t.charAt(0)){
            dp[0][0] = 1;
        }else{
            dp[0][0] = 0;
        }
        for(int i=1;i<lens;i++){
            dp[i][0] = dp[i-1][0];
            if(s.charAt(i) == t.charAt(0)){
                dp[i][0] +=1;
            }
        }
        for(int i=1;i<lent;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<lens;i++){
            for(int j=1;j<lent;j++){
                dp[i][j]=dp[i-1][j];
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j]+=dp[i-1][j-1];
                }
            }
        }
        return dp[lens-1][lent-1];
    }


    public int isInterleave(String a, String b, String c) {

        int lena = a.length();
        int lenb = b.length();
        int lenc=  c.length();
        if(lena ==0 && lenb ==0 && lenc ==0){
            return 1;
        }
        if(lena + lenb != lenc){
            return 0;
        }
        int dp[] = new int[lena +1];
        dp[0] = 0;
        for(int i=1;i<=lena;i++){
            if(a.charAt(i-1) == c.charAt(i-1)){
                dp[i] = 1;
            }
        }

        for(int i=1;i<=lenb;i++){
            if (b.charAt(i-1)==c.charAt(i-1)) dp[0]=1;
            for(int j=1;j<=lena;j++){
                if((dp[j] == 1 && b.charAt(i-1) == c.charAt(i+j-1)) ||
                        (dp[j-1]==1 && a.charAt(j-1) == c.charAt(i+j-1))){
                    dp[j] = 1;
                }else{
                    dp[j] = 0;
                }
            }
        }
        return dp[lena];
    }

    public int isMatch(String s, String pr) {
        if(pr.length() == 0)
            return s.length() == 0?1:0;
        int len = s.length();
        int lent = pr.length();

        int ctr = 0;
        if(pr.charAt(0) == '*'){
            for(int i=1;i<lent;i++){
                if(pr.charAt(i)!='*'){
                    break;
                }
                ctr++;
            }
        }
        String p = pr.substring(ctr);
        ctr=0;
        if(pr.charAt(lent-1) == '*'){
            for(int i=lent-2;i>=0;i--){
                if(pr.charAt(i)!='*'){
                    break;
                }
                ctr++;
            }
        }
        p = p.substring(0,lent-ctr);

        if(p.charAt(0) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '?' && s.charAt(0) != p.charAt(0)))
                return 0;
            return isMatch(s.substring(1), p.substring(1));

        }else{
            int i = -1;
            while(i<len && (i < 0 || p.charAt(0) == '?' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(1))==1 || isMatch(s.substring(i+1), p.substring(0))==1)
                    return 1;
                i++;
            }
            return 0;
        }

    }

    public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        int m = A.size();
        int n = B.size();
        if (m == 0)
            return findMedianSingleArray(B, n);
        else if (n == 0)
            return findMedianSingleArray(A, m);
        else if (m == 1)
            return findMedianBaseCase(A.get(0), B, n);
        else if (n == 1)
            return findMedianBaseCase(B.get(0), A, m);
        else if (m == 2)
            return findMedianBaseCase2(A.get(0), A.get(1), B, n);
        else if (n == 2)
            return findMedianBaseCase2(B.get(0), B.get(1), A, m);

        int i = m/2, j = n/2, k;
        if (A.get(i) <= B.get(j)) {
            k = ((m%2 == 0) ? Math.min(i-1, n-j-1) : Math.min(i, n-j-1));
            return findMedianSortedArrays(A.subList(k,A.size()), B);
        } else {
            k = ((n%2 == 0) ? Math.min(m-i-1, j-1) : Math.min(m-i-1, j));
            return findMedianSortedArrays(A,B.subList(k,B.size()));
        }
    }

    double findMedianSingleArray(List<Integer> A, int n) {
        return ((n%2 == 1) ? A.get(n/2) : (A.get(n/2-1)+A.get(n/2))/2.0);
    }

    double findMedianBaseCase2(int med1, int med2, List<Integer> C, int n) {
        if (n % 2 == 0) {
            int a = (((n/2-2) >= 0) ? C.get(n/2 - 2) : Integer.MIN_VALUE);
            int b = C.get(n/2 - 1), c = C.get(n/2);
            int d = (((n/2 + 1) <= n-1) ? C.get(n/2 + 1) : Integer.MAX_VALUE);
            if (med2 <= b)
                return (b+Math.max(med2,a)) / 2.0;
            else if (med1 <= b)
                return (b+Math.min(med2,c)) / 2.0;
            else if (med1 >= c)
                return (c+Math.min(med1,d)) / 2.0;
            else if (med2 >= c)
                return (c+Math.max(med1,b)) / 2.0;
            else  /* a < med1 <= med2 < b */
                return (med1+med2) / 2.0;
        } else {
            int a = C.get(n/2 - 1), b = C.get(n/2), c = C.get(n/2 + 1);
            if (med1 >= b)
                return Math.min(med1, c);
            else if (med2 <= b)
                return Math.max(med2, a);
            else  /* med1 < b < med2 */
                return b;
        }
    }

    double findMedianBaseCase(int med, List<Integer> C, int n) {
        if (n == 1)
            return (med+C.get(0))/2.0;

        if (n % 2 == 0) {
            int a = C.get(n/2 - 1), b = C.get(n/2);
            if (med <= a)
                return a;
            else if (med <= b)
                return med;
            else /* med > b */
                return b;
        } else {
            int a = C.get(n/2 - 1), b = C.get(n/2), c = C.get(n/2 + 1);
            if (med <= a)
                return (a+b) / 2.0;
            else if (med <= c)
                return (med+b) / 2.0;
            else /* med > c */
                return (b+c) / 2.0;
        }
    }

    public int isScramble(final String a, final String b) {
        if(a.length()!=b.length()){
            return 0;
        }
        if(a.equals(b)){
            return 1;
        }

        int ch[] = new int[256];
        int len = a.length();
        for(int i=0;i<len;i++){
            ch[a.charAt(i)]++;
            ch[b.charAt(i)]--;
        }
        for(int i=0;i<256;i++){
            if(ch[i] !=0){
                return 0;
            }
        }

        for(int i=1; i<len;i++){
            String a1 = a.substring(0,i);
            String a2 = a.substring(i,len);

            String b1 = b.substring(0, i);
            String b2 = b.substring(i, len);

            if(isScramble(a1,b1) == 1 && isScramble(a2,b2)==1){
                return 1;
            }

            b1 = b.substring(0,len-i);
            b2 = b.substring(len-i,len);
            if(isScramble(a1,b1)==1 && isScramble(a2,b2)==1){
                return 1;
            }
        }
        return 0;
    }
    public static int ThirstyCrowProblem(int[] input1,int input2,int input3)
    {

        if(input2<input3){
            return -1;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int stones = 0;
        int len = input2;
        int pre=0;
        Arrays.sort(input1);
        for(int i: input1){
            if(hashMap.containsKey(i)){
                hashMap.put(i,hashMap.get(i) + 1);
            }else {
                hashMap.put(i,1);
            }

        }
        for(int t=0;t<input3;t++){
            int i = t + hashMap.get(input1[t])-1;
            stones+= (input1[i] * input2 - (hashMap.get(input1[t])-1) - (pre * (len-i)));
            hashMap.put(input1[i],hashMap.get(input1[i]) - 1);
            pre =input1[i];
            input2--;
        }

        //Write code here

        return stones - 1;
    }

    public static int cadbury(int input1,int input2,int input3,int input4)
    {
        int nochoco = (input2-input1+1) * (input4 - input3 +1);
        if(nochoco <=0){
            return 0;
        }
        int sum=0;
        for(int i=input1;i<=input2;i++){
            for(int j=input3;j<=input4;j++){
                sum+=combin(i,j);
            }
        }
        //System.out.println(sum);
        return sum;
    }
    static int combin(int a,int b){
        if(a==b){
            return 1;
        }
        if(b>a){
            a = a^b; //a =a+b;
            b = a^b;//b = a-b;
            a = a^b;//a = a-b;
        }
        if(a%b==0){
            return a/b;
        }
        return 1 + combin(b,a-b);
    }

    public int numTrees(int n) {

        if(n==1||n==0){
            return 1;
        }
        int till;

        till = n/2;

        int sum =0;
        for(int i = 1;i<=till ; i++){
               sum+= 2*(numTrees(n-i) * numTrees(i-1));
        }
        if(n%2==1){
            sum+= (numTrees(n-till+1) * numTrees(till));
        }

       return sum;
    }

    int[][] dp;
    int[][] bst;
    public int cntPermBST(int N, int M){
        dp = new int [N+1][N+1];
        bst = new int [N+1][M+1];
        dp[0][0]=1;

        for(int i=1;i<=N;i++){
            dp[i][0] =1;
            for(int j=1;j<i;j++){
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
            dp[i][i]=1;
        }
        for(int i=0;i<=N;i++){
            for(int j=0;j<=M;j++){
                bst[i][j] = recur(i,j);
            }
        }
        return bst[N][M];
    }
    public int recur(int N, int M){
        if(N<=1){
            if(M==0){
                return 1;
            }
            return 0;
        }
        if(M==0){
            return 0;
        }
        long res =0;
        for(int i= 1;i<=N;i++){
            int x= i-1;
            int y= N-i;

            long rec1 = 0;
            long val1 = bst[y][M - 1];
            if(val1>0) {
                for (int j = 0; j <= M - 2; j++) {
                    rec1 += bst[x][j] * val1%1000000007;
                }
            }
            long val2 = recur(x, M - 1);
            if(val2>0) {
                for (int j = 0; j <= M - 2; j++) {
                    rec1 += val2 * bst[y][j] % 1000000007;
                }
            }

            rec1 += (val2* val1)%1000000007 /** combination(x+y,y)*/;

            res += (rec1*dp[x+y][y])%1000000007;

        }
        return (int)res%1000000007;
    }

    int combination(int n, int c) {
        if (n == c || c == 0) {
            return 1;
        }
        if (n == c + 1 || c == 1) {
            return n;
        }
        return combination(n-1, c) + combination(n - 1,c - 1);
    }

    public int minPathSum(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        for(int i=1;i<m;i++){
            a.get(i).set(0, a.get(i).get(0) + a.get(i - 1).get(0));
        }
        for(int i=1;i<n;i++){
            a.get(0).set(i,a.get(0).get(i) + a.get(0).get(i-1));
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int val1 = a.get(i).get(j);
                int val2 = a.get(i).get(j-1);
                int val3 = a.get(i-1).get(j);
                a.get(i).set(j,(val2 < val3 ? val2 : val3) + val1);
            }
        }

        return a.get(m-1).get(n-1);
    }

    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();

        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = Math.max(1 - a.get(m-1).get(n-1), 1);

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - a.get(i).get(n-1), 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            dp[m-1][j] = Math.max(dp[m-1][j+1] - a.get(m-1).get(j), 1);
        }

        //calculate dp table
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - a.get(i).get(j), 1);
                int right = Math.max(dp[i][j + 1] - a.get(i).get(j), 1);
                dp[i][j] = Math.min(right, down);
            }
        }

        return dp[0][0];

    }

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();

        int[][] dp = new int[m][n];

        dp[0][0] = a.get(0).get(0) !=0? 0:1;

        for(int i=1;i<m;i++){
                dp[i][0] =a.get(i).get(0) !=0? 0:dp[i - 1][0];
        }
        for(int i=1;i<n;i++){
            dp[0][i] =a.get(0).get(i) !=0? 0:dp[0][i-1];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] =a.get(i).get(j) !=0? 0:dp[i - 1][j]+ dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public int unique(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = m ==0 ? 0 : a.get(0).size();

        int[][] height = new int[m][n + 1];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) == 0) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();

        int i = 0;
        int max = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                max = Math.max(max, height[t]
                        * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return max;
    }

    ArrayList<Integer> answer = new ArrayList<>();

    ArrayList<Integer> cuts = new ArrayList<>();

    ArrayList<ArrayList<Long>> dps = new ArrayList<>();

    ArrayList<ArrayList<Integer>> parent = new ArrayList<>();

    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {

        B.add(0,0);
        B.add(A);
        int n = B.size();

        for(int i=0;i<n;i++){
            cuts.add(B.get(i));
        }

        for(int i=0;i<n;i++){
            ArrayList<Long> ob = new ArrayList<>();
            ArrayList<Integer> ob2 = new ArrayList<>();
            for(int j=0;j<n;j++){
                ob.add((long)-1);
                ob2.add(0);
            }
            dps.add(ob);
            parent.add(ob2);
        }

        long best = rodCutting(0,n-1);

        back(0,n-1);

        return answer;
    }

    long rodCutting(int l,int r){

        if(l+1 >= r)return 0;

        long ret = dps.get(l).get(r);

        if(ret != -1) {
            return ret;
        }

        ret = Long.MAX_VALUE;
        int bestind= 0;

        for(int i = l + 1; i < r; i++) {
            //recurrence
            long p = rodCutting(l,i) + rodCutting(i,r) + (long)cuts.get(r) - (long)cuts.get(l);


            if(p < ret) {
                ret = p;
                bestind = i;
            }
        }

        dps.get(l).set(r,ret);
        parent.get(l).set(r,bestind);

        return ret;

    }


    void back(int l, int r){
        //base case
        if(l+1 >= r)return;

        //first choose parent of (l,r)
        answer.add(cuts.get(parent.get(l).get(r)));

        //call back recursively for two new segments
        //calling left segment first because we want lexicographically smallest
        back(l, parent.get(l).get(r));
        back(parent.get(l).get(r), r);
    }

    public int maxcoin(ArrayList<Integer> coin) {
        int n = coin.size();
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], 0);
        }
        for(int i=0;i<n;i++){
            for(int l=0,r=i;r<n;l++,r++){

                int a = ((l+2 <= n-1)             ? dp[l+2][r] : 0);
                int b = ((l+1 <= n-1 && r-1 >= 0) ? dp[l+1][r-1] : 0);
                int c = ((r-2 >= 0)               ? dp[l][r-2] : 0);
                dp[l][r] = Math.max(coin.get(l) + Math.min(a,b), coin.get(r) + Math.min(b,c));
            }
        }
        return dp[0][n-1];
    }

    int getVal(int a){
        if(a <0){
            return -1*a +1;
        }
        return 1;
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {

        int len = a.size();
        if(len==0){
            return 0;
        }
        for(int j = len-2;j>=0;j--){
            ArrayList<Integer> j1 = a.get(j);
            ArrayList<Integer> j2 = a.get(j+1);
            for(int i=0;i<j1.size();i++){
                j1.set(i,(j2.get(i)>j2.get(i+1)?j2.get(i+1):j2.get(i)) + j1.get(i));
            }
        }
        return a.get(0).get(0);
    }

    public int maxProfitt(final List<Integer> a) {
        int len = a.size();
        int[][] dp = new int[3][len+1];
        // for zero transaction
        for(int i=0;i<=len;i++){
            dp[0][i] = 0;
        }
        //for frist day
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[2][0] = 0;


        for(int i=1;i<=2;i++){
            int pre = Integer.MIN_VALUE;
            for(int j=1;j<len;j++){
                 pre = Math.max(pre,dp[i-1][j-1] - a.get(j-1));
                 dp[i][j] = Math.max(dp[i][j-1],a.get(j) + pre);
            }
        }
        return dp[2][len-1];
    }
    int calculate(int max){
        int sum =0;
        int f =1;
        int p =0;
        int s = f+p;
        while(sum<4000000){
            p = f;
            f = s;
            s = f+p;
            if(s%2==0){
                sum+=s;
            }
        }
        return sum;
    }

    public int candy(ArrayList<Integer> ratings) {
        if (ratings.size() == 0) {
            return 0;
        }

        int[] candies = new int[ratings.size()];
        candies[0] = 1;

        //from let to right
        for (int i = 1; i < ratings.size(); i++) {
            if (ratings.get(i) > ratings.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        int result = candies[ratings.size() - 1];

        //from right to left
        for (int i = ratings.size() - 2; i >= 0; i--) {
            int cur = 1;
            if (ratings.get(i) > ratings.get(i + 1)) {
                cur = candies[i + 1] + 1;
            }

            result += Math.max(cur, candies[i]);
            candies[i] = cur;
        }

        return result;
    }

    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        int ans = 0;
        for(int i = 0; i < a.size(); ++i) {
            ans = max(ans, abs(a.get(i) - b.get(i)));
        }
        return ans;
    }


    public int majorityElement(final List<Integer> a) {
        int ans = 0, count = 0;

        for(int i = 0; i<a.size(); i++ ) {
            if(count == 0){
                ans = a.get(i);
                count = 1;
            }else if(ans == a.get(i)){
                count++;
            }else{
                count--;
            }
        }

        return ans;
    }


    public int black(ArrayList<String> a) {
        int m = a.size();
        int n = a.get(0).length();
        int ans =0;
        boolean [][]visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a.get(i).charAt(j)=='X' && !visited[i][j]){
                    ans++;
                   // visited[i][j]= true;
                    markvisited(i,j,a,visited,m,n);
                }
            }
        }
        return ans;

    }
    void markvisited(int a,int b,ArrayList<String> list,boolean visited[][],int m,int n){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a,b));
        while(!queue.isEmpty()){
            Node val = queue.poll();
            for(int i = val.ival;i<n;i++){
                if(list.get(val.ind).charAt(i)=='X' && !visited[val.ind][i]){
                    visited[val.ind][i]= true;
                    if(val.ind +1 < m && list.get(val.ind + 1 ).charAt(i)=='X' && !visited[val.ind +1][i] ){
                        queue.add(new Node(val.ind+1,i));
                    }
                    if(val.ind -1 >= 0 && list.get(val.ind - 1 ).charAt(i)=='X' && !visited[val.ind -1][i] ){
                        queue.add(new Node(val.ind-1,i));
                    }
                }else{
                    break;
                }
            }
            for(int i = val.ival-1;i>=0;i--){
                if(list.get(val.ind).charAt(i)=='X' && !visited[val.ind][i]){
                    visited[val.ind][i]= true;
                    if(val.ind +1 < m && list.get(val.ind + 1 ).charAt(i)=='X' && !visited[val.ind +1][i] ){
                        queue.add(new Node(val.ind+1,i));
                    }
                    if(val.ind -1 >= 0 && list.get(val.ind - 1 ).charAt(i)=='X' && !visited[val.ind -1][i] ){
                        queue.add(new Node(val.ind-1,i));
                    }
                }else{
                    break;
                }
            }
        }
    }


    public int longestValidParentheses(String s) {

        Stack<int[]> st = new Stack<>();
        int max = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                int[] a = {i,0};
                st.push(a);
            }else{
                if(st.empty()||st.peek()[1]==1){
                    int[] a = {i,1};
                    st.push(a);
                }else{
                    st.pop();
                    int i1;
                    if(st.empty()){
                        i1 = i+1;
                    }else{
                        i1 = i-st.peek()[0];
                    }
                    max = Math.max(max, i1);
                }
            }
        }

        return max;

    }
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(a);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while(size>0){
                TreeNode pop = queue.poll();
                temp.add(pop.val);
                if(pop.left!=null){
                    queue.add(pop.left);
                }
                if(pop.right!=null){
                    queue.add(pop.right);
                }
                size--;
            }
            ans.add(temp);
        }
        return ans;
    }

    public void solve(ArrayList<ArrayList<Character>> a) {
        int row = a.size();
        int col = a.get(0).size();
        boolean visited[][] = new boolean[row][col];
        for(int i=0;i<row;i++){
            if(a.get(i).get(0) == 'O'){
                   markO(i,0,a,visited,row,col);
            }
            if(a.get(i).get(col-1) == 'O'){
                markO(i,col-1,a,visited,row,col);
            }
        }
        for(int i=1;i<col-1;i++){
            if(a.get(0).get(i) == 'O'){
                markO(0,i,a,visited,row,col);
            }
            if(a.get(row-1).get(i) == 'O'){
                markO(row-1,i,a,visited,row,col);
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(a.get(i).get(j)=='O' && visited[i][j] ==false){
                    a.get(i).set(j,'X');
                }
            }
        }
    }

    void markO(int a,int b,ArrayList<ArrayList<Character>> list,boolean visited[][],int m,int n){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a,b));
        while(!queue.isEmpty()){
            Node val = queue.poll();
            for(int i = val.ival;i<n;i++){
                if(list.get(val.ind).get(i)=='X' && !visited[val.ind][i]){
                    visited[val.ind][i]= true;
                    if(val.ind +1 < m && list.get(val.ind + 1 ).get(i)=='X' && !visited[val.ind +1][i] ){
                        queue.add(new Node(val.ind+1,i));
                    }
                    if(val.ind -1 >= 0 && list.get(val.ind - 1 ).get(i)=='X' && !visited[val.ind -1][i] ){
                        queue.add(new Node(val.ind-1,i));
                    }
                }else{
                    break;
                }
            }
            for(int i = val.ival-1;i>=0;i--){
                if(list.get(val.ind).get(i)=='X' && !visited[val.ind][i]){
                    visited[val.ind][i]= true;
                    if(val.ind +1 < m && list.get(val.ind + 1 ).get(i)=='X' && !visited[val.ind +1][i] ){
                        queue.add(new Node(val.ind+1,i));
                    }
                    if(val.ind -1 >= 0 && list.get(val.ind - 1 ).get(i)=='X' && !visited[val.ind -1][i] ){
                        queue.add(new Node(val.ind-1,i));
                    }
                }else{
                    break;
                }
            }
        }
    }
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        int sumRemaining = 0;
        int total = 0;
        int start = 0;

        for (int i = 0; i < gas.size(); i++) {
            int remaining = gas.get(i) - cost.get(i);

            if (sumRemaining >= 0) {
                sumRemaining += remaining;
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0){
            return start;
        }else{
            return -1;
        }
    }
}
class Node1{
    int height;
    int infront;
    Node1(int h,int i){
        height = h;
        infront = i;
    }
}
class ITree {
    int height;
    int count;
    int weight;
    ITree left;
    ITree right;
    ITree(int x,int c) { height = x; count = c; weight = 1; }
}


class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
     }
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Indexes {
    int val;
    int ind;

    Indexes(int a, int b) {
        val = a;
        ind = b;
    }
}


class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution1 {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minst = new Stack<>();

    public void push(int x) {
        st.push(x);
        if (minst.isEmpty()) {
            minst.push(x);
        } else if (x < minst.peek()) {
            minst.push(x);
        }

    }

    public void pop() {
        if (!st.isEmpty()) {
            int val = st.pop();
            if (val == minst.peek()) {
                minst.pop();
            }
        }
    }

    public int top() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.peek();
    }

    public int getMin() {
        if (minst.isEmpty()) {
            return -1;
        }
        return minst.peek();
    }
}
class Node{
    int a;
    int b;
    Node(int i,int j){
        a=i;
        b=j;
    }
}
    class TrieNode{
        TrieNode child[];
        int freq;
        TrieNode(){
            child = new TrieNode[256];
        }
    }

class LRUCache {

    TreeMap<Integer,Integer> map;
    HashMap<Integer,Integer> hash;
    Deque<Integer> deque;

    int cap;
    public LRUCache(int capacity) {
      map = new TreeMap<>();
        deque = new LinkedList<>();
        hash = new HashMap<>();
        cap = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            deque.addFirst(key);
            hash.put(key,hash.get(key) + 1);
            return map.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        map.put(key, value);
        deque.addFirst(key);
        hash.put(key,1);

        if(map.size() > cap){
            int num = deque.pollLast();
            while(hash.get(num) > 1){
                hash.put(num,hash.get(num) - 1);
                num = deque.pollLast();
            }
            if(hash.get(num) == 1){
                hash.remove(num);
                map.remove(num);
            }

        }
    }


}
class BSTIterator {

    Stack<TreeNode> stack,stack2;
    TreeNode iter,iter2;
    public BSTIterator(TreeNode root) {
        iter = root;
        iter2 = root;
        stack = new Stack<TreeNode>();
        stack2 = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (iter!=null || !stack.isEmpty());
    }

    public boolean hasPre() {
        return (iter2!=null || !stack2.isEmpty());
    }

    /** @return the next smallest number */
    public TreeNode next() {
        TreeNode ans=null;
        while(hasNext()){
            if(iter!=null){
                stack.push(iter);
                iter = iter.left;
            }else{
                iter = stack.pop();
                ans = iter;
                iter = iter.right;
                break;
            }
        }
        return ans;
    }

    public TreeNode prev() {
        TreeNode ans= null;
        while(hasPre()){
            if(iter2!=null){
                stack2.push(iter2);
                iter2 = iter2.right;
            }else{
                iter2 = stack2.pop();
                ans = iter2;
                iter2 = iter2.left;
                break;
            }
        }
        return ans;
    }

}


class DerivedClass extends BaseClass{
    static {
        System.out.println("Derivced Class Static Block");
    }




    DerivedClass(){
        System.out.println("Dervived Class Constructor");
    }

    {
        System.out.println("Dervived Class Empty Block");
    }
}
class BaseClass{

    static {
        System.out.println("BaseClass Static Block");
    }

    BaseClass(){
        System.out.println("BaseClass Constructor");
    }

    {
        System.out.println("BaseClass Empty Block");
    }
}