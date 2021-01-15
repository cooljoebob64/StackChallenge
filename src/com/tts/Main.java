package com.tts;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        boolean myBool = true;

//        System.out.println(myBool);

        String input = """
                ({}[])
                (({()})))
                ({(){}()})()({(){}()})(){()}
                {}()))(()()({}}{}
                }}}}
                ))))
                {{{
                (((
                []{}(){()}((())){{{}}}{()()}{{}{}}
                [[]][][]
                }{
                """;

        String[] inputList = input.split("\n");
        for (String line:inputList){


            Stack<Character> myStack = new Stack<>();
            boolean balanced = true;

            for(int i=0; i<line.length();i++){
                char currentChar = line.charAt(i);
//                System.out.println("Current char: " + currentChar);
                char prevChar ='a';
                if(currentChar=='{'||currentChar=='('||currentChar=='[')
                    myStack.push(currentChar);
                else if(!(myStack.isEmpty())) prevChar = myStack.pop();
//                System.out.println("Previous char: " + prevChar);

                switch (currentChar){
                    case '}':if (!(prevChar=='{')) balanced=false; break;
                    case ')':if (!(prevChar=='('))balanced=false; break;
                    case ']':if (!(prevChar=='['))balanced=false; break;
//                    default: balanced=false;
                }
            }
            if (!(myStack.isEmpty()))
                balanced = false;

            System.out.println(balanced);
        }    }
}
