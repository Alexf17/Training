package org.example.Algoritm._2024_03_04;

class Wagon {
    int value;
    Wagon next;

    @Override
    public String toString() {
        return "Wagon{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public Wagon(int value) {
        this.value = value;
        this.next = null;
    }
}

class Train {
    Wagon wagons;

    @Override
    public String toString() {
        return "Train{" +
                "wagons=" + wagons +
                '}';
    }

    public Train(int value) {
        this.wagons = new Wagon(value);
    }

    public void push(int value) {
        Wagon current = this.wagons;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Wagon(value);

    }

    public int counting() {
        int count = 1;
        Wagon current = this.wagons;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        System.out.println("we have: " + count + " wagons");
        return count;
    }
    public void removeLast() {
        if(counting()==1){
            System.out.println("we have only one wagon ");
        }
        Wagon current = this.wagons;
        while (current.next.next != null) {
            current = current.next;
        }
current.next =null;
    }
}

class Main {
    public static void main(String[] args) {
        Train train = new Train(10);
        train.push(20);
        train.push(30);
        train.push(40);

        System.out.println(train);
        train.counting();
        train.removeLast();
        System.out.println(train);
        train.counting();
    }
}
