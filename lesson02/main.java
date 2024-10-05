package lesson02;
// Домашнее задание 2:
//  - Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
// - Login должен содержать только латинские буквы, цифры и знак подчеркивания.
// - Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
// - Password должен содержать только латинские буквы, цифры и знак подчеркивания. Длина password должна быть меньше 20 символов.
// Также password и confirmPassword должны быть равны. Если password не соответствует этим требованиям, необходимо выбросить
// WrongPasswordException.
// - WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по
// умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
// - Обработка исключений проводится внутри метода.
// - Используем multi-catch block.
// - Метод возвращает true, если значения верны или false в другом случае.

class lesson2 {
    public static void main(String[] args){
        System.out.println(check(null, "123", "123"));
        System.out.println(check("qweqwe", "1234", "123"));
        System.out.println(check("qweqwe ", "123", "123"));
    }

    public static Boolean check(String login, String password, String confirmPassword) {
        try {
            if (login == null || password == null || confirmPassword == null)
                throw new IllegalArgumentException("параметр не должен быть null");

            if (login.length() >= 20 || !login.matches("^[a-zA-Z0-9_]+$"))
                throw new WrongLoginException("Беда с логином");
            if (password.length() >= 20 || !password.matches("^[a-zA-Z0-9_]+$"))
                throw new WrongPasswordException("Беда с паролем");
            if (!password.equals(confirmPassword))
                throw new Exception("Не совпало");
            return true;
        } 
        catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        }
        catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}