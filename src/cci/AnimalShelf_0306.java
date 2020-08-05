package cci;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class AnimalShelf_0306 {

    LinkedList<Integer> dog_list ;
    LinkedList<Integer> cat_list ;
    LinkedList<Integer> all_list ;


    public AnimalShelf_0306() {
        dog_list = new LinkedList<>();
        cat_list = new LinkedList<>();
        all_list = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 1) {
            dog_list.add(animal[0]);
        } else {
            cat_list.add(animal[0]);
        }
        all_list.add(animal[1]);
    }

    public int[] dequeueAny() {
        if (all_list.size() == 0) {
            return new int[]{-1,-1};
        }
        int t = all_list.poll();
        if (t == 1) {
            return new int[]{dog_list.poll(), 1};
        } else {
            return  new int[]{cat_list.poll(),0};
        }
    }

    public int[] dequeueDog() {
        if (dog_list.size() == 0) {
            return new int[]{-1, -1};
        }
        int pos = all_list.indexOf(1);
        all_list.remove(pos);
        return new int[]{dog_list.poll(),1};
    }

    public int[] dequeueCat() {
        if (cat_list.size() == 0) {
            return new int[]{-1, -1};
        }
        int pos = all_list.indexOf(0);
        all_list.remove(pos);
        return new int[]{cat_list.poll(),0};
    }

    public static void main(String[] args) {
        AnimalShelf_0306 test = new AnimalShelf_0306();
        test.enqueue(new int[]{0,0});
        test.enqueue(new int[]{1,0});
        test.dequeueCat();
        test.dequeueDog();
        test.dequeueAny();
    }
}
