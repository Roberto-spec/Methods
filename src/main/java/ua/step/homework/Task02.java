package ua.step.homework;

/**
 * В массиве хранится n явно заданных текстовых строк.
 * <p>
 * Создать методы:
 * • Возвращает содержимое массива в виде строки через пробел (join)
 * • Возвращает содержимое массива в виде строки через заданный разделитель (перегруженный join)
 * • Сортирующий массив обратном порядке (без учёта регистра) от z до a (sortDesc);
 * • Сортирующий массив по количеству слов в строке (слова разделены пробелами) (sortByWordCount).
 *
 * Примечание: Не использовать методы строк и стандартную сортировку
 */
public class Task02 {
    public static void main(String[] args) {
        // TODO: Проверяйте методы здесь
    }

    /**
     * Соединяет массив строк в одну строку разделенную пробелом
     *
     * @param strings - массив строк
     * @return строка состоящая из элементов массив
     */
    public static String join(String[] strings) {
        // TODO: удалите исключение и пишите здесь код
        String stroka=new String();
        stroka=strings[0];
        for(int i=1;i< strings.length;i++) stroka=stroka+" "+strings[i];
        return stroka;
    }

    /**
     * Соединяет массив строк в одну строку разделенную соединителем glue
     *
     * @param strings - массив строк
     * @param glue    - соединитель
     * @return строка состоящая из элементов массива
     */
    public static String join(String[] strings, String glue) {
        // TODO: удалите исключение и пишите здесь код
        String stroka=new String();
        stroka=strings[0];
        for(int i=1;i< strings.length;i++) stroka=stroka+glue+strings[i];
        return stroka;
    }

    /**
     * Сортирует массив строк в порядке обратном алфавитному
     *
     * @param strings - массив строк для сортировки
     */
    public static void sortDesc(String[] strings) {
        // TODO: удалите исключение и пишите здесь код


        String buf=new String();


        for (int out = strings.length - 1; out >= 1; out--) {  //Внешний цикл
            for (int in = 0; in < out; in++) {       //Внутренний цик
                int result = strings[in].compareTo(strings[in + 1]);
                if (result < 0) {
                    buf = strings[in];
                    strings[in] = strings[in + 1];
                    strings[in + 1] = buf;
                }
            }
        }

    }

    /**
     * Сортирует массив строк по количеству слов в строке
     *
     * @param strings - массив строк для сортировки
     */
    public static void sortByWordCount(String[] strings) {
        // TODO: удалите исключение и пишите здесь код
        String buf=new String();


        for (int out = strings.length - 1; out >= 1; out--) {  //Внешний цикл
            for (int in = 0; in < out; in++) {       //Внутренний цик



                if (strings[in].length()>strings[in + 1].length()) {
                    buf = strings[in];
                    strings[in] = strings[in + 1];
                    strings[in + 1] = buf;
                }
            }
        }
    }
}
