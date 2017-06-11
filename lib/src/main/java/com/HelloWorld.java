package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Sachin_Chauhan on 2/15/2016.
 */

class Base{
    Base(){

    }
}
class Ext extends Base{
    Ext(){

    }
    void method(){
        System.out.println("Methods");
    }
}
public class HelloWorld {
     HelloWorld(){

     }


     static int add(int a){
         return 0;
     }
    int add(){
        return 0;
    }
    public static void main(String args[] ) throws Exception {


        final int MOD = 1000000000 + 7;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String first[] = line.split(" ");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);
        int know[] = new int[N+1];
        int mat[][] = new int[N+1][N+1];
        Map<Integer,Integer> visited = new HashMap<>();
        Map<Integer,Integer> knolevel = new HashMap<>();

        line = br.readLine();
        int no=1;
        for(String num: line.split(" ")){
            int chc = Integer.parseInt(num);
            know[no] = chc;
            no++;
        }
        int group=0;
        for(int i=0;i<M;i++){
            line = br.readLine();
            first = line.split(" ");
            int from = Integer.parseInt(first[0]);
            int to = Integer.parseInt(first[1]);
            if(visited.containsKey(from)==false && visited.containsKey(to)==false){
                group++;
                mat[to][from]=group;
                mat[from][to]=group;
                visited.put(from,group);
                visited.put(to,group);
            }
            else if(visited.containsKey(from)==true && visited.containsKey(to)==false){
                int gp = visited.get(from);
                mat[to][from]=gp;
                mat[from][to]=gp;
                visited.put(to,gp);
            } else if(visited.containsKey(from)==false && visited.containsKey(to)==true){
                int gp = visited.get(to);
                mat[to][from]=gp;
                mat[from][to]=gp;
                visited.put(from,gp);
            }else{
                if(visited.get(to) != visited.get(from)){
                    int gp1 = visited.get(to);
                    int gp2 = visited.get(from);
                    if(gp1>gp2){
                        gp1=gp2;
                        to = from;
                    }
                    group--;
                    recursive(mat,N,to,gp1,visited);
                }else{
                    mat[to][from]=visited.get(to);
                    mat[from][to]=visited.get(to);
                }
            }
        }
        int gplevel[] = new int[group+1];
        for(int i=1;i<=M;i++){
            if(visited.containsKey(i)){
                int gp = visited.get(i);
                if(!knolevel.containsKey(gp)){
                    knolevel.put(gp,know[i]);
                    gplevel[gp]=1;
                }else{
                    int knowll = knolevel.get(gp);
                    if(knowll < know[i]){
                        knolevel.put(gp,know[i]);
                        gplevel[gp]=1;
                    }else if(knowll == know[i]){
                        gplevel[gp]++;
                    }
                }
            }
        }

        long ans = 1;
        for (int i = 1; i <= group; i++) {
            ans *= gplevel[i];
            ans %= MOD;
        }

        System.out.println(ans);

//        arr.add(0);
//        line = br.readLine();
//        for(String str: line.split(" "))
//            arr.add(Integer.parseInt(str));
//
//        while(q>0){
//            q--;
//            line = br.readLine();
//            String str[] = line.split(" ");
//            if(str[0].charAt(0)=='1'){
//                System.out.println(findgreater(arr, Integer.parseInt(str[1])));
//            }else{
//                arr.set(Integer.parseInt(str[1]), Integer.parseInt(str[2]));
//            }
//        }
    }

    static void recursive(int[][]mat,int N,int to,int gp,Map<Integer,Integer> visited){
        for(int i=1;i<=N;i++){
            if(mat[to][i]!= 0 && mat[to][i]!= gp){
                mat[to][i] = gp;
                visited.put(to,gp);
                visited.put(i,gp);
                recursive(mat,N,i,gp,visited);
            }
        }
    }
    static int printBox(List list,int boxes,int ch){
        return 0;
    }
//
//    static int findgreater(ArrayList<Integer> arr, int num){
//        for(int i=1;i<arr.size();i++){
//            if(arr.get(i)>=num){
//                return i;
//            }
//        }
//        return -1;
//    }
//
//
//    static void replace(ArrayList<Integer> arr, int ind,int val){
//
//    }
//    static int calculate(String str,char a,char b){
//        int len = str.length();
//        int ctr=0;
//        ArrayList<Integer> aa = new ArrayList<Integer>();
//        ArrayList<Integer> bb = new ArrayList<Integer>();
//        int ca=0;
//        int cb =0;
//        for(int i=0;i<len;i++){
//            aa.add(0);
//            bb.add(0);
//        }
//        for(int i=len-1;i>=0;i--){
//            if(str.charAt(i)==a){
//                ca++;
//            }
//            if(str.charAt(i)==b){
//                cb++;
//            }
//            aa.set(i, ca);
//            bb.set(i, cb);
//        }
//        for(int i=0;i<len-1;i++){
//            if(str.charAt(i)==a){
//                        ctr+=bb.get(i+1);
//
//            }else if(str.charAt(i)==b){
//                        ctr+=aa.get(i+1);
//            }
//        }
//        return ctr;
//
//    }


    public static void mainn(String args[]){

       Solution sol = new Solution();
       // sol.prettyPrint(4);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      //  203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43
        try {
            Scanner s = new Scanner(new File("C:\\Users\\sachin_chauhan\\Desktop\\read.txt"));
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            ArrayList<Integer> list2 = new ArrayList<Integer>();
            ArrayList<Integer> list3 = new ArrayList<Integer>();
            ArrayList<ArrayList<Character>> arrl = new ArrayList<>();

            list1.add(1);
            list1.add(2);
//            list1.add(3);
//            list1.add(3);
//            list1.add(3);
            list .add(list1);
            list2.add(2);
            list2.add(1);
//            list2.add(1);
//            list.add(list2);
            list3.add(1);
            list3.add(1);
            list3.add(1);
            list.add(list3);
//            list1.add(49);
//            list1.add(21);
//            list1.add(62);
//            list1.add(27);
//            list1.add(90);
//            list1.add(59);
//
//            list2.add(2);
//            list2.add(0);
//            list2.add(0);
//            list2.add(2);
//            list2.add(0);
//            list2.add(2);
//            list2.add(1);
//            list2.add(3);

//            String line = s.nextLine();
//            for(String str: line.split(", ")){
//                int ch = Integer.parseInt(str);
//                list1.add(ch);
//            }
//             line = s.nextLine();
//            for(String str: line.split(", ")){
//                int ch = Integer.parseInt(str);
//                list2.add(ch);
//            }

//            int num=0;
//            int field;
//            int classes=0;
//            long totalmethods = 0;
//            while(s.hasNextLine()) {
//                int ctr=0;
//                String line = s.nextLine();
//                for (String i : line.split(" ")) {
//                    if(!i.trim().equals("")) {
//                        switch (ctr) {
//                            case 0:
//                                num = Integer.parseInt(i);
//                                break;
//                            case 1:
//                                if(i.contains("com.symantec.feature.messagecenter.R")){
//                                    totalmethods+=num;
//                                    classes++;
//                                    System.out.println(line);
//                                }
//                                break;
//                        }
//                        ctr++;
//
//                    }
//
//                }
//            }
//            System.out.println("Classes :" + classes + " Methods :" +totalmethods);
           //     Scanner scanner = new Scanner(line);
//                scanner.useDelimiter(", ");
//                while (scanner.hasNextInt()) {
//                    list1.add(scanner.nextInt());
//                }
//                line = s.nextLine();
//                scanner = new Scanner(line);
//                scanner.useDelimiter(", ");
//                while (scanner.hasNextInt()) {
//                    list2.add(scanner.nextInt());
//                }
//                scanner.close();
//
//
//            }
        ArrayList<String> num = new ArrayList<>();
        num.add("bababbbb");
        num.add("bbbabaa");
        num.add("abbb");
        num.add("a");
            num.add("aabbaab");
            num.add("b");
            num.add("babaabbbb");
            num.add("aa");
            num.add("bb");
//            num.add("*");

//        num.add(42);
//        num.add(43);
//
//        list.add(num);
            RandomListNode rm = new RandomListNode(1);
            rm.next = new RandomListNode(2);
            rm.next.next = new RandomListNode(3);
            rm.next.next.next = null;
            rm.random = rm.next.next;
            rm.next.random = rm;
            rm.next.next.random = rm;
        ArrayList<String> num1 = new ArrayList<>();
        num1.add("X00X");
        num1.add("XXXX");
        num1.add("X0X0");
//            num1.add("zebra");
//            num1.add("mat");
//            num1.add("tam");
//            num1.add(1);
//            num1.add(2);
//            num1.add(3);
//            num1.add(4);
//            num1.add(5);
//            num1.add(9);
//            num1.add(8);
//            num1.add(0);
//            num1.add(-2);
//            num1.add(4);
//            num1.add(-4);
//            num1.add(1);
//            num1.add(-1);
//            num1.add(-4);
//            num1.add(3);
//            num1.add(4);
//            num1.add(-1);
//            num1.add(-1);
//            num1.add(-3);

//            num1.add(7);
//            num1.add(7);
//        list.add(num1);

        ArrayList<Integer> num2 = new ArrayList<>();
            num2.add(-2);
        num2.add(-2);
//        num2.add(9);
//        list.add(num2);

//       list.add(2);
//        list.add(5);
//        list.add(3);

        TreeNode head = new TreeNode(1);
            head.left = new TreeNode(2);
            head.right = new TreeNode(4);
            head.left.left = new TreeNode(7);
            head.left.right = new TreeNode(3);
//            TreeLinkNode tree = new TreeLinkNode(3);
//            tree.right = new TreeLinkNode(5);
//            tree.left = new TreeLinkNode(1);
        PrintWriter pt = new PrintWriter(System.out);
//        sol.arrange(num);
//        sol.printpermutationrecursion(num);
//       sol.restoreIpAddresses("0100100");
//            sol.merge(num1,num2);
            String str1 = "xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh";
            String str2 =  "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h";
            String words[] = {"foo","bar"};
          //  sol.connect(tree);
            int arr[] = {1,2,3,3,4};
            new DerivedClass();
            ArrayList<String> dict = new ArrayList<>();
            dict.add("hot");
            dict.add("cog");
            dict.add("dog");
            dict.add("tog");
            dict.add("hog");
            dict.add("hop");
            dict.add("pot");
            dict.add("dot");

          //  System.out.println(Arrays.toString("\u0041".getBytes()));
            pt.println(sol.findLadders("hot","dog",dict));
//            pt.println(sol.fractionToDecimal(-1,-2));
//            pt.println(sol.fractionToDecimal(2,3));
//            pt.println(sol.fractionToDecimal(3,2));
//            pt.println(sol.fractionToDecimal(87,22));
//            pt.println(sol.fractionToDecimal(22,7));
//            pt.println(sol.fractionToDecimal(100,3));
//            pt.println(sol.fractionToDecimal(-1,-2147483648));
//            pt.println(sol.diffPossiblee(list2, 53));  //16777214
            pt.close();
//            new TICTAC().play_TIC_TAC_TOE_Game();

            s.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public String palindromString(String a){
        Solution sol = new Solution();
        String ans =sol.longestPalindrome(a);
        return ans;
    }

    static {
        System.out.println("static block");
    }

}
