package org.example._2024_01_11_morning;

import java.util.ArrayList;
import java.util.EmptyStackException;

public interface MyStackInterface<E> {
    /**
     * Pushes an item onto the top of this stack. This has exactly
     * the same effect as:
     * <blockquote><pre>
     * addElement(item)</pre></blockquote>
     *
     * @param item the item to be pushed onto this stack.
     * @return the {@code item} argument.
     * @see java.util.Vector#addElement
     */
    public E push(E item) ;

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack (the last item
     * of the {@code Vector} object).
     * @throws EmptyStackException if this stack is empty.
     */
//    public synchronized E pop() {
//        E obj;
//        int len = size();
//
//        obj = peek();
//        removeElementAt(len - 1);
//
//        return obj;
//    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack (the last item
     * of the {@code Vector} object).
     * @throws EmptyStackException if this stack is empty.
     */
//    public synchronized E peek() {
//        int len = size();
//
//        if (len == 0) {
//            throw new EmptyStackException();
//        }
//        return elementAt(len - 1);
//    }

    /**
     * Tests if this stack is empty.
     *
     * @return {@code true} if and only if this stack contains
     * no items; {@code false} otherwise.
     */
    public boolean empty();
public boolean pop (E e);


    class MyStack<E> implements MyStackInterface<E>{
        private ArrayList<E> list = new ArrayList<E>();
        @Override
        public E push(E item) {
list.add(item);
            return item;

        }

//        @Override
//        public synchronized E pop() {
//            return null;
//        }

//        @Override
//        public synchronized E peek() {
//            return null;
//        }

        @Override
        public boolean empty() {
            return list.isEmpty();
        }

        @Override
        public boolean pop(E e) {

            return list.add(e);
        }

//        @Override
//        public synchronized int search(Object o) {
//            return 0;
//        }
    }
}
