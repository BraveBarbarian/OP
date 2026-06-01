package Exercise;

public class Test {




    public void add(int[] numbers) {
        for(int add : numbers) {
            add += add;
            System.out.println(add);
        }

    }

    public void main(String[] args) {
        int[] numbers = {1,2,3};

        add(numbers);
    }

}
