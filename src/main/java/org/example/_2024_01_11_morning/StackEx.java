package org.example._2024_01_11_morning;

import java.util.Stack;

public class StackEx {
    private Stack<String> browserHistory = new Stack<String>();

    public StackEx() {
    }

    public StackEx(Stack<String> browserHistory) {
        this.browserHistory = browserHistory;
    }
    public void visitPage(String page){
        browserHistory.push(page);
        System.out.println("last page is "+page);
    }
    public void goBack() {
        if(!browserHistory.empty()) {
            browserHistory.pop();
        if(!browserHistory.empty()) {
            System.out.println("Back to "+ browserHistory.peek());
        }else {
            System.out.println("History empty");
        }
        }else{
            System.out.println("Cant back");
        }


    }

    public static void main(String[] args) {
        StackEx stackEx = new StackEx();
        stackEx.visitPage("1");
        stackEx.visitPage("12");
    }
}
