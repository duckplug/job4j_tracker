package ru.job4j.ex;

public class FindEl {
     public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;

         for (int i = 0; i < value.length; i++) {
             if (value[i] == key) {
                 rsl = i;
                 break;
             }
         }
         if (rsl == -1) {
             throw new ElementNotFoundException("Элемент не найден");
         }
             return rsl;
    }

    public static void main(String[] args) {
         String[] array = {"1", "2", "3"};
        try {
            indexOf(array, "4");

        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}