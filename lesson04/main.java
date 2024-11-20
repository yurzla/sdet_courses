package lesson04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Runme {
    public static void main(String[] args) {
        /*
         * 2. Создать коллекцию, содержащую объекты класса Student.
         */
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Вася", "Перваки", 1, 
                Arrays.asList(new Mark("физкультура", 2),
                new Mark("история", 4), new Mark("математика", 2))));
        students.add(new Student("Ихорь", "НеПерваки", 2, 
                Arrays.asList(new Mark("физкультура", 5),
                new Mark("история", 5), new Mark("математика", 2))));
        students.add(new Student("Маша", "НеПерваки", 2, 
                Arrays.asList(new Mark("физкультура", 4),
                new Mark("история", 2), new Mark("математика", 2))));
        students.add(new Student("Петя", "Старшеки", 4, 
                Arrays.asList(new Mark("физкультура", 5),
                new Mark("история", 5), new Mark("математика", 2))));

        System.out.println("До изменений");
        System.out.println(
                String.format("[%s]", students.stream().map(Object::toString)
                        .collect(Collectors.joining(", "))));

        System.out.println("\nВызов печати курса 2");
        printStudents(students, 2);

        students = removeOrTtransferToNextCourse(students);

        System.out.println("\nПосле удалений и перевода");
        System.out.println(
                String.format("[%s]", students.stream().map(Object::toString)
                        .collect(Collectors.joining(", "))));
    }

    private static ArrayList<Student> removeOrTtransferToNextCourse
                                                (List<Student> students) {
        /*
         * 3. Написать метод, который удаляет студентов со средним баллом <3.
         */
        return students.stream()
                /* оставили только тех у кого 3+*/
                .filter(x -> x.getAverageMark() >= 3)
                .map(x -> {
                    /*
                     * 4. Если средний балл>=3, 
                     * студент переводится на следующий курс.
                     */
                    x.setCourse(x.getCourse() + 1); 
                    return x;
                })
                /* конвертируем из Stream<Student> в ArrayList<Student> */
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void printStudents(List<Student> students, int course)
    {
        /*
         * 5. Напишите метод printStudents(List<Student> students, int course),
         * который получает список студентов и номер курса.
         * 6. А также печатает на консоль имена тех студентов из списка, 
         * которые обучаются на данном курсе. 
         */
        students.stream().filter(x -> x.getCourse() == course)
                .forEach(x -> System.out.println(x.getName()));
    }
}
