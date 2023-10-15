package university;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Tree myTree=new Tree();
        Scanner scanner=new Scanner(System.in);

        for(int i=0;i<4;i++)
        {
            System.out.println("enter the value: ");
            myTree.add(scanner.nextInt(),i);
            System.out.println(myTree.getRoot());
        }


        System.out.println(myTree.checkKey(0));
    }
}
